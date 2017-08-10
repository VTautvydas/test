package com.studentai.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.student.database.Student;
import com.student.database.StudentDao;

public class UserForm extends JFrame{

    JTextArea textArea = new JTextArea(4,10); 	// registration info

    JPanel panelId = new JPanel(); 				// id
    JPanel panelFirstName = new JPanel(); 		// name
    JPanel panelLastName = new JPanel();
    JPanel panelGruopId = new JPanel();
    JPanel panelSubmit = new JPanel(); 			// submit record

    TextField id, name, surname, group_id;

    JButton add, update, delete, search;
    
    public UserForm() {
        create();
        setTitle("Student form");
        setVisible(true);
        pack();
    }

    public void create() {

        Container container = getContentPane();
        container.setLayout(new GridLayout(6, 1, 10, 10));
        container.setBackground(Color.lightGray);
        
        textArea.setEditable(false);
        textArea.setBackground(Color.lightGray);
        textArea.setForeground(Color.black);
    
        // id
        panelId.setBorder(new TitledBorder("ID:"));
        id = new TextField("", 20);
        panelId.add(id);
        container.add(panelId);
        
        // username
        panelFirstName.setBorder(new TitledBorder("Firstname:"));
        name = new TextField("", 20);
        panelFirstName.add(name);
        container.add(panelFirstName);

        // surname
        panelLastName.setBorder(new TitledBorder("Lastname:"));
        surname = new TextField("", 20);
        panelLastName.add(surname);
        container.add(panelLastName);

        // groupId
        panelGruopId.setBorder(new TitledBorder("Group ID:"));
        group_id = new TextField("", 20);
        panelGruopId.add(group_id);
        container.add(panelGruopId);

        // buttons
        panelSubmit.setBorder(new TitledBorder("Actions:"));
        add 	= new JButton ("Add");
        update 	= new JButton ("Update");
        delete 	= new JButton ("Delete");
        search 	= new JButton ("Search");
        panelSubmit.add(add);
        panelSubmit.add(update);
        panelSubmit.add(delete);
        panelSubmit.add(search);
        container.add(panelSubmit);
        
        // Create table for display results from db
        JTable table = new JTable(new DefaultTableModel(new Object[]{"Number", "ID", "Name", "Surname", "Group ID"}, 0));
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        JScrollPane scrollPane = JTable.createScrollPaneForTable(table);
	    scrollPane.setPreferredSize(new Dimension(400, 100));
	    container.add(scrollPane);
	    
        StudentDao dao = new StudentDao();
        
        add.addActionListener(new ActionListener(){
        	  public void actionPerformed(ActionEvent e)
        	  {
        		  Student student = new Student();
        		  String firstName = name.getText().toString();
        		  student.setName(firstName);
        		  student.setSurname(surname.getText().toString());
        		  student.setGroup_id(group_id.getText().toString());
        		  
        	      dao.addStudent(student);
        		  JOptionPane.showMessageDialog(container, "New user added successfully", "Info" , JOptionPane.INFORMATION_MESSAGE);

        		  cleanfields();

        	  }
        	
        });

        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student student = new Student(Integer.valueOf(id.getText()), name.getText(), surname.getText(), group_id.getText());
                dao.updateStudent(student);
                cleanfields();
            }
        });

        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dao.deleteStudent(Integer.valueOf(id.getText()));
                cleanfields();
            }
        });

        search.addActionListener(new ActionListener() {
        	  public void actionPerformed(ActionEvent e)
        	  {
        		  // on new search - deletes all earlier rows with old results
        		  model.setRowCount(0);
        		  
        		  // do search in db
        		  java.util.List<Student> students;
        		  if (name.getText().toString().equals("")) {
        			  students = dao.getAllStudents();
        		  } else {
        			  students = dao.getStudentsByName(name.getText().toString());
        		  }
        		  
        		  // add rows from list to table
        		  Object[] data;
        		  int rowNumber = 0;
        		  for (Student student : students) {
        			  if(!students.isEmpty()) {// list with results
        				  data = new Object[5];
        				  data[0] = ++rowNumber;
        				  data[1] = student.getId();
        				  data[2] = student.getName();
        				  data[3] = student.getSurname();
        				  data[4] = student.getGroup_id();
        				  model.addRow(data);
        			  } else { // empty list
        				  model.setRowCount(0);
        			  }
        		  }
      	    
        	  }

        });


    }//create

    private void cleanfields() {
        id.setText("");
        name.setText("");
        surname.setText("");
        group_id.setText("");
    }

}//class
