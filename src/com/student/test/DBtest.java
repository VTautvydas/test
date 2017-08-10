package com.student.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.student.database.Student;
import com.student.database.StudentDao;

public class DBtest {

	@Test
	public void testSearchingSingleStudentByID() {
		
		Student student = new Student(10, "Jonas", "Jonaitis", "KCS");
		StudentDao dao = new StudentDao();
		dao.addStudent(student);
		
		Student student2 = dao.getStudentById(10);
		
		//assertStudentEqual(student, student2);
		
		
		
	}
	
	private void assertStudentEqual(Student student, Student student2){
		
		assertEquals(student.getId(), student2.getId());
		assertEquals(student.getName(), student2.getName());
		assertEquals(student.getSurname(), student2.getSurname());
		assertEquals(student.getGroup_id(), student2.getGroup_id());
	}
	
	@Test
	public void testSearchingSingleStudentByName(){
		
		Student student = new Student(1, "Petras", "Petraitis", "KCS");
		StudentDao dao = new StudentDao();
		dao.addStudent(student);
		
		List<Student> student2 = dao.getStudentsByName("Petras");
		assertStudentEqual(student, student2.get(0));
		assertEquals(1, student2.size());
		
		
		
	}

}
