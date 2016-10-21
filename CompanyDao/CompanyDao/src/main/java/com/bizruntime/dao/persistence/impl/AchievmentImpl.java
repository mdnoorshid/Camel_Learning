package com.bizruntime.dao.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.bizruntime.dao.persistence.Employee;
import com.bizruntime.dao.services.IAchievementDao;
import com.bizruntime.util.DatabaseConnection;

public class AchievmentImpl implements IAchievementDao {
	static Logger log = Logger.getLogger(EmployeeDaoImpl.class);
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	Statement statement;
	int auto_id;
	Employee emp;

	public void getAchievement(String firstName, String lastName,
			int departmentId) throws SQLException, SqlExceptionFound {
		try {
			connection = DatabaseConnection.getConnection();
			String sql = " select achievements FROM achievement where firstName=? and lastName=? and department_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setInt(3, departmentId);
			resultSet = preparedStatement.executeQuery();
			// Initializing the parameters of Employee Object after getting
			// values from the database
			while (resultSet.next()) {
				String achievments = resultSet.getString(1);
				log.debug(firstName+" "+lastName+"'s "+"Achievements----> " + achievments);
			}

		} catch (Exception e) {
			throw new SQLException("Sql Exception Interrupted!!", e);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				throw new SqlExceptionFound("Sql Exception Interrupted!!", e);
			}
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (Exception e) {
				throw new SqlExceptionFound("Sql Exception Interrupted!!", e);
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				throw new SqlExceptionFound("Sql Exception Interrupted!!", e);
			}
		}
	}

	public void addAchievement(String firstName, String lastName,
			int departmentId, String achievements) {
	}

	public void updateAchievement(String firstName, String lastName,
			int departmentId) {
	}

	public void deleteAchievement(String firstName, String lastName,
			int departmentId) {
	}

}
