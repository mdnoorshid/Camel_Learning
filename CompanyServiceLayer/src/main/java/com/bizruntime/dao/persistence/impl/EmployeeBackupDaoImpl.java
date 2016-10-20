package com.bizruntime.dao.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bizruntime.dao.persistence.Address;
import com.bizruntime.dao.persistence.Employee;
import com.bizruntime.dao.services.IEmployeeBackupDao;
import com.bizruntime.util.DatabaseConnection;

/**
 * This is the Implementation class of IEmployeeBackupDao Interface
 * @author bizruntime
 *
 */
public class EmployeeBackupDaoImpl implements IEmployeeBackupDao {
	static Logger log = Logger.getLogger(EmployeeDaoImpl.class);
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	Statement statement;
	int auto_id;
	Employee emp;

	public List<Employee> getAllEmployees() throws Exception {
		return null;
	}

	public Employee getEmployee(int empId,Connection conn) throws Exception {
		try {
			int employee_id = empId;
			String firstName = null;
			String lastName = null;
			int age = 0;
			int addressId=0;
			int departmentId = 0;
			String location = null;
			String town = null;
			String street = null;
			String country = null;
			Address address;
			List<Address> addresses = new ArrayList<Address>();

			/*connection = DatabaseConnection.getConnection();*/
			String sql ="SELECT CompanyBackUp.employee.employee_id,CompanyBackUp.employee.firstName,CompanyBackUp.employee.lastName,CompanyBackUp.employee.age,CompanyBackUp.employee.department_id,address.address_id,"
					+"CompanyBackUp.address.location,CompanyBackUp.address.town,CompanyBackUp.address.street,CompanyBackUp.address.country"
					+" FROM CompanyBackUp.employee"
					+" INNER JOIN address ON CompanyBackUp.employee.employee_id=CompanyBackUp.address.employee_id where employee.employee_id=?";

			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, empId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				employee_id = resultSet.getInt(1);
				firstName = resultSet.getString(2);
				lastName = resultSet.getString(3);
				age = resultSet.getInt(4);
				departmentId = resultSet.getInt(5);
				addressId=resultSet.getInt(6);
				location = resultSet.getString(7);
				town=resultSet.getString(8);
				street=resultSet.getString(9);
				country = resultSet.getString(10);
				 address= new Address(location, town, street, country);
				 addresses.add(address);
				emp = new Employee(firstName, lastName, age, addresses,
						departmentId);
			}
			
		} catch (Exception e) {
			throw new SqlExceptionFound("Sql Exception Interrupted!!", e);
		}
		finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				throw new SqlExceptionFound("Sql Exception Interrupted!!", e);
			}
			try{
			if(preparedStatement !=null){
				preparedStatement.close();
			}
			}catch(Exception e){
				throw new SqlExceptionFound("Sql Exception Interrupted!!", e);
			}
			try{
				if(connection !=null){
				 	connection.close();
				}
			}catch(Exception e){
				throw new SqlExceptionFound("Sql Exception Interrupted!!", e);
			}
		}
		return emp;
	}

	/**
	 * This is the method responsible for inserting the employee and its address in CompanyBackUp.employee and 
	 * CompanyBackUp.address
	 * @param Employee:Parameter is Employee Object type
	 * @throws SqlExceptionFound
	 */ 
	public void insertEmployee(Employee emp,Connection conn) throws Exception {
		try {
			connection = DatabaseConnection.getConnection();
			String sql = "insert into CompanyBackUp.employee(firstName,lastName,age,department_id) values(?,?,?,?)";
			preparedStatement = conn.prepareStatement(sql,
					preparedStatement.RETURN_GENERATED_KEYS);

			List<Address> addresses = emp.getAddresses();
			String firstName = emp.getFirstName();
			String lastName = emp.getLastName();
			int age = emp.getAge();
			int departmentId = emp.getDepartmentId();

			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setInt(3, age);
			preparedStatement.setInt(4, departmentId);

			int i = preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			while (resultSet.next()) {
				auto_id = resultSet.getInt(1);
				log.debug("Incremented Key:: " + auto_id);
			}
			for (Address address1 : addresses) {
				new AddressBackupDaoImpl().insertAddress(address1, auto_id);
				log.debug("Address Inserted Successfully!!");
			}
			if (i > 0) {
				log.debug("Employee Addedd Succefully...");
			} else {
				log.error("Employee not Added...");
			}
		} catch (SQLException e) {
			throw new SqlExceptionFound("Sql Exception interrupted!!", e);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				throw new SqlExceptionFound("Sql Exception Interrupted!!", e);
			}
			try{
			if(preparedStatement !=null){
				preparedStatement.close();
			}
			}catch(Exception e){
				throw new SqlExceptionFound("Sql Exception Interrupted!!", e);
			}
			}
		
	}

	public void updateEmployee(int EmployeeId) throws Exception {
	}

	/**
	 * This is the method responsible for deleting employee from the CompanyBackUp.emplpoyee table
	 * @param EmployeeId:This is the employee id and data type is Integer
	 * @throws SqlExceptionFound
	 */
	public void deleteEmployee(int EmployeeId) throws Exception {
		try {
			connection = DatabaseConnection.getConnection();
			String sql = "DELETE FROM CompanyBackUp.employee WHERE employee_id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, EmployeeId);
			// execute delete SQL stetement
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				log.debug("Employee of EmployeeId " + EmployeeId
						+ " deleted successfully...");
			} else {
				log.error("Deletion failed!!");
			}

		} catch (SQLException e) {
			throw new SqlExceptionFound("Sql Exception Interrupted!!", e);
		} 	finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				throw new SqlExceptionFound("Sql Exception Interrupted!!", e);
			}
			try{
			if(preparedStatement !=null){
				preparedStatement.close();
			}
			}catch(Exception e){
				throw new SqlExceptionFound("Sql Exception Interrupted!!", e);
			}
			try{
				if(connection !=null){
				 	connection.close();
				}
			}catch(Exception e){
				throw new SqlExceptionFound("Sql Exception Interrupted!!", e);
			}
	}

		
	}

}
