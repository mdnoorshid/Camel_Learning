package com.bizruntime.dao.persistence;

public class Achievement {
	private String firstName;
	private String lastName;
	private int departmentId;
	private String achievements;

	public Achievement(String firstName, String lastName, int departmentId,
			String achievements) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.departmentId = departmentId;
		this.achievements = achievements;
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

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getAchievements() {
		return achievements;
	}

	public void setAchievements(String achievements) {
		this.achievements = achievements;
	}
}
