package lflg_dao;

import java.util.List;

import lflg_model.Employee;

public interface EmployeeDAO {
	void createEmployee(Employee employee);
	Employee readEmployee(Long id);
	List<Employee> readAllEmployees();
	void updateEmployee(Employee employee);
	void deleteEmployee(Long id);
	
}
