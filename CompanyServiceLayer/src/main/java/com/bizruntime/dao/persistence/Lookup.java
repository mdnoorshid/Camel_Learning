package com.bizruntime.dao.persistence;

public class Lookup {
	private int departmentId;
	private String department;

	public Lookup(int departmentId, String department) {
		this.departmentId = departmentId;
		this.department = department;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
