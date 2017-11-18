package lflg_dao;

import java.util.List;

import lflg_model.Employee;



public class TestConnection {
	public static void main(String[] args) {
		EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();
		employeeDAOImpl.createEmployee(new Employee(6L, "Lira","Lira","Garcia", "2","masculino","si"));
		
		List<Employee> students = employeeDAOImpl.readAllEmployees();
		for (Employee student : students) {
			System.out.println(student);
			
		}
	}

}
