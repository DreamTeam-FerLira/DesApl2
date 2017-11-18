package lflg_model;

import java.io.Serializable;

public class Employee implements Serializable{
	private Long id;
	private String name;
	private String firstname;
	private String lastname;
	private String salary;
	private String gender;
	private String attention;
	
	
	public Employee(Long id, String name, String firstname, String lastname, String salary, String gender,
			String attention) {
		super();
		this.id = id;
		this.name = name;
		this.firstname = firstname;
		this.lastname = lastname;
		this.salary = salary;
		this.gender = gender;
		this.attention = attention;
	}
	
	public Employee() {
		this(0L, "", "", "", "", "", "");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAttention() {
		return attention;
	}

	public void setAttention(String attention) {
		this.attention = attention;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", salary=" + salary + ", gender=" + gender + ", attention=" + attention + "]";
	}
	
	
	
	
	
	
	
}//End
