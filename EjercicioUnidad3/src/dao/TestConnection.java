package dao;

import java.util.List;

import model.Student;

public class TestConnection {
	public static void main(String[] args) {
		StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
		studentDAOImpl.createStudent(new Student(6L, "Lira",20,1216100769,"masculino","GSI1342"));
		
		List<Student> students = studentDAOImpl.readAllStudents();
		for (Student student : students) {
			System.out.println(student);
			
		}
	}

}
