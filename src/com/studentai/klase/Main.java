package com.studentai.klase;

import com.student.database.Student;
import com.student.database.StudentDao;
import com.studentai.gui.UserForm;

public class Main {

    public static void main(String[] args) {
        /*Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = (Transaction) session.beginTransaction();



        StudentDao studentDao = new StudentDao();
        //Student petras = new Student(9,"Petras2", "2Petraitis", "KCS2");

        //studentDao.addStudent(petras);
        //studentDao.updateStudent(petras);
        //studentDao.deleteStudent(9);
        //int i = 0;
        /*for (Student student : studentDao.getAllStudents()) {
            System.out.println(++i + " " + student.getName());
        } */
        /*for (Student student : studentDao.getStudentsByName("Testas")) {
            System.out.println(++i + " " + student.getName());
        } */
        
        //studentDao.addStudent(petras);

        //System.out.println(studentDao.getStudentById(1).getName());

        //session.persist(student);
        //transaction.commit();
        //session.close();
        
        UserForm forma = new UserForm();
        
        

    }
}
