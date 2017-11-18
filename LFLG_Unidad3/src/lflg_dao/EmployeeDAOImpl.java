package lflg_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lflg_model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	public EmployeeDAOImpl() {
		getConnetion();
	}

	public Connection getConnetion() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/testdb", "lira", "lira");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	
	public void createEmployee(Employee employee) {
		try {
			if (connection != null) {
				preparedStatement = connection.prepareStatement(
						"INSERT INTO employees (name, firstname, lastname, salary, gender, attention)values (?,?,?,?,?,?);");
				preparedStatement.setString(1, employee.getName());
				preparedStatement.setString(2, employee.getFirstname());
				preparedStatement.setString(3, employee.getLastname());
				preparedStatement.setString(4, employee.getSalary());
				preparedStatement.setString(5, employee.getGender());
				preparedStatement.setString(6, employee.getAttention());
				
				preparedStatement.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public Employee readEmployee(Long id) {
		Employee employee = null;
		try {
			if (connection != null) {
				preparedStatement = connection.prepareStatement("SELECT * FROM employees WHERE id=?");

				preparedStatement.setLong(1, id);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					employee = new Employee(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3),
							resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public List<Employee> readAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		try {

			preparedStatement = connection.prepareStatement("SELECT * FROM employees");
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Employee employee = new Employee(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
				employees.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public void updateEmployee(Employee employee) {
		try {
			if (connection != null) {
				preparedStatement = connection.prepareStatement("UPDATE employees SET name=?, firstname = ?, lastname = ?, salary = ?, gender = ?, attention = ? WHERE id=?;");
				preparedStatement.setString(1, employee.getName());
				preparedStatement.setString(2, employee.getFirstname());
				preparedStatement.setString(3, employee.getLastname());
				preparedStatement.setString(4, employee.getSalary());
				preparedStatement.setString(5, employee.getGender());
				preparedStatement.setString(6, employee.getAttention());
				preparedStatement.setLong(7, employee.getId());
				preparedStatement.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteEmployee(Long id) {
		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement("DELETE FROM employees WHERE id=?;");
				preparedStatement.setLong(1, id);
				preparedStatement.execute();

			} catch (SQLException e) {
				e.printStackTrace();

			}
		}

	}



}// End
