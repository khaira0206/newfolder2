package rev.model;

import java.sql.Date;

public class Employee {
	
	Integer id;
	String name;
	String passwd;
	Date birthday;
	double salary;
	
	public Employee(Integer id, String name, String passwd, Date birthday, double salary){
		this.id = id;
		this.name = name;
		this.passwd = passwd;
		this.birthday = birthday;
		this.salary = salary;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
