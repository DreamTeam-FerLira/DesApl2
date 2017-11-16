package model;

import java.io.Serializable;

public class Student implements Serializable {
	private Long id;
	private String name;
	private int age;
	private int num_control;
	private String sex;
	private String group_student;

	public Student(Long id, String name, int age, int num_control, String sex, String group_student) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.num_control = num_control;
		this.sex = sex;
		this.group_student = group_student;
	}

	public Student() {
		this(0L, "", 0, 0, "", "");
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNum_control() {
		return num_control;
	}

	public void setNum_control(int num_control) {
		this.num_control = num_control;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getGroup_student() {
		return group_student;
	}

	public void setGroup_student(String group_student) {
		this.group_student = group_student;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", num_control=" + num_control + ", sex=" + sex
				+ ", group_student=" + group_student + "]";
	}
	
	
	

}// End
