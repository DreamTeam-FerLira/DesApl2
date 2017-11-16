package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Student;

public class StudentDAOImpl implements StudentDAO {
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public StudentDAOImpl() {
		getConnetion();
	}
	
	public Connection getConnetion() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/testdb", "lira", "lira");
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public void createStudent(Student student) {
		try {
		if(connection != null) {
			preparedStatement = connection.prepareStatement("INSERT INTO students (name, age, num_control, sex," 
							+ "group_student)values (?,?,?,?,?);");
			preparedStatement.setString(1,student.getName() );
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setInt(3, student.getNum_control());
			preparedStatement.setString(4, student.getSex());
			preparedStatement.setString(5,student.getGroup_student() );
			
			preparedStatement.execute();
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Student readStudent(Long id) {
		Student student = null;
		try {
			if(connection != null) {
				preparedStatement = connection.prepareStatement("SELECT * FROM students WHERE id=?");
				
				preparedStatement.setLong(1, id);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					student = new Student(resultSet.getLong(1), resultSet.getString(2), resultSet.getInt(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6));
				}
				
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return student;
	}

	@Override
	public List<Student> readAllStudents() {
		List<Student> students = new ArrayList<Student>();
		try {
		
				preparedStatement = connection.prepareStatement("SELECT * FROM students");
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					Student student = new Student(
									resultSet.getLong(1), 
									resultSet.getString(2), 
									resultSet.getInt(3),
									resultSet.getInt(4),
									resultSet.getString(5),
									resultSet.getString(6));
					students.add(student);
				}
				
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return students;
	}

	@Override
	public void updateStudent(Student student) {
		try {
			if(connection != null) {
				preparedStatement = connection.prepareStatement("UPDATE students SET name=?, "
											+ "age=?,"
										+ "num_control=? "
										+ "sex=? "
										+ "group_student=? "
										+ "WHERE id=?;");
				preparedStatement.setString(1,student.getName() );
				preparedStatement.setInt(2, student.getAge());
				preparedStatement.setInt(3, student.getNum_control());
				preparedStatement.setString(4, student.getSex());
				preparedStatement.setString(5,student.getGroup_student() );
				preparedStatement.setLong(6, student.getId());
				preparedStatement.execute();
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public void deleteStudent(Long id) {
		if(connection!=null) {
			try {
				preparedStatement = connection.prepareStatement("DELETE FROM students WHERE id=?;");
				preparedStatement.setLong(1, id);
				preparedStatement.execute();
				
			}catch(SQLException e){
				e.printStackTrace();
				
			}
		}
		
	}
	
	

}
