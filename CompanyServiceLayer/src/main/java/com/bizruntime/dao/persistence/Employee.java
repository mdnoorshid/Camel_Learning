package com.bizruntime.dao.persistence;

import java.util.List;

public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private int age;
	private int departmentId;
	List<Address> addresses;

	public Employee( String firstName, String lastName, int age,List<Address>addresses,
			int departmentId) {
		this.firstName = firstName;
		this.lastName=lastName;
		this.age = age;
		this.departmentId = departmentId;
		this.addresses=addresses;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", age=" + age
				+ ", departmentId=" + departmentId + ", addresses=" + addresses
				+ "]";
	}
}
