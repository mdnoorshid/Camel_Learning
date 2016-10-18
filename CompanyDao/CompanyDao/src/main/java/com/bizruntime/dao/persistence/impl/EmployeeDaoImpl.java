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
import com.bizruntime.dao.services.IEmployeeDao;
import com.bizruntime.util.Config;
import com.bizruntime.util.DatabaseConnection;

/**
 *This is the implement class which is implementing the 
 *IEmployeeDao Service 
 */
public class EmployeeDaoImpl implements IEmployeeDao {
	static Logger log = Logger.getLogger(EmployeeDaoImpl.class);
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	Statement statement;
	int auto_id;
	Employee emp;

	/**
	 * This method is to get all the Employees from the database
	 * @return List:It returns the List of Employee
	 * @throws SqlExceptionFound
	 */
	public List<Employee> getAllEmployees() throws Exception {
		List<Employee>employeeList=new ArrayList<Employee>();
		try {
			int employee_id = 0;
			String firstName = null;
			String lastName = null;
			int age = 0;
			int addressId=0;
			int departmentId = 0;
			String location = null;
			String town = null;
			String street = null;
			String country = null;

			connection = DatabaseConnection.getConnection();
			String sql ="SELECT employee.employee_id,employee.firstName,employee.lastName,employee.age,employee.department_id,address.address_id,"
					+"address.location,address.town,address.street,address.country"
					+" FROM employee"
					+" INNER JOIN address ON employee.employee_id=address.employee_id";

			preparedStatement = connection.prepareStatement(sql);
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
			}
			Address address = new Address(location, town, street, country);
			List<Address> addresses = new ArrayList<Address>();
			addresses.add(address);
			emp = new Employee(firstName, lastName, age, addresses,
					departmentId);
			employeeList.add(emp);
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
		return employeeList;
			}
	/**
	 * This method is to get the particular Employee Object
	 * @param empId:Id of the particular Employee in the Database
	 * @return Employee :return type is Employee Object
	 * @throws SqlExceptionFound
	 */
	public Employee getEmployee(int empId) throws SQLException,
			SqlExceptionFound {
		try {
			String firstName = null;
			String lastName = null;
			int age = 0;
			int departmentId = 0;
			List<Address> addresses = new ArrayList<Address>();
			connection = DatabaseConnection.getConnection();
			String sql = "SELECT * FROM employee WHERE employee_id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, empId);
			resultSet = preparedStatement.executeQuery();
			// Initializing the parameters of Employee Object after getting
			// values from the database
			while (resultSet.next()) {
				firstName = resultSet.getString(2);
				lastName = resultSet.getString(3);
				age = resultSet.getInt(4);
				departmentId = resultSet.getInt(5);
			}
			/*
			 * emp.setFirstName(firstName); emp.setLastName(lastName);
			 * emp.setAge(age); emp.setDepartmentId(departmentId);
			 */
			emp = new Employee(firstName, lastName, age, addresses,
					departmentId);
		} catch (Exception e) {
			throw new SQLException("Sql Exception Interrupted!!", e);
		} finally {
			try {
				if (connection != null) {

					// cleanup resources, once after processing
					resultSet.close();
					preparedStatement.close();

					// and then finally close connection
					connection.close();
				}
			} catch (SQLException e) {
				throw new SqlExceptionFound("Sql Exception Interrupted!!", e);
			}
		}
		return emp;
	}

	/**
	 * This method is used to insert the Employee details in the Database
	 * 
	 * @param Employeeobject
	 *            :This object will hold the details of the Employee
	 * @throws SqlExceptionFound
	 */
	public void insertEmployee(Employee emp) throws Exception {
		try {
			connection = DatabaseConnection.getConnection();
			String sql = "insert into employee(firstName,lastName,age,department_id) values(?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql,
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
				new AddressDaoImpl().insertAddress(address1, auto_id);
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
				if (connection != null) {
					// cleanup resources, once after processing
					preparedStatement.close();
					// and then finally close connection
					connection.close();
				}
			} catch (SQLException e) {
				throw new SqlExceptionFound("Sql Exception Interrupted!!", e);
			}
		}
	}

	/**
	 * This method is to update the particular employee
	 * @param EmployeeId:Id of the Employee as Integer Value
	 * @throws SqlExceptionFound
	 */
	public void updateEmployee(int EmployeeId) throws Exception {
		try {
			connection = DatabaseConnection.getConnection();
			String sql = "update employee set firstName = ?,lastName=?,age=?,department_id=? where employee_id = ?";
			preparedStatement = connection.prepareStatement(sql);
			/*
			 * emp.setFirstName(new Config().getPropValues("firstName1"));
			 * emp.setLastName(new Config().getPropValues("lastName1"));
			 * emp.setAge(Integer.parseInt(new Config().getPropValues("age1")));
			 * emp.setDepartmentId(Integer.parseInt(new
			 * Config().getPropValues("departmentId1"))); String firstName =
			 * emp.getFirstName(); String lastName = emp.getLastName(); int age
			 * = emp.getAge(); int departmentId = emp.getDepartmentId();
			 */
			/*
			 * preparedStatement.setString(1, firstName);
			 * preparedStatement.setString(2, lastName);
			 * preparedStatement.setInt(3, age); preparedStatement.setInt(4,
			 * departmentId); preparedStatement.setInt(5,EmployeeId); int
			 * i=preparedStatement.executeUpdate();
			 */
			/*
			 * if(i>0){ log.debug("Employ Updated Successfully...."); }
			 */
			/*
			 * else{ log.error("Employee Update failed"); }
			 */
		} catch (SQLException e) {
			throw new SqlExceptionFound("Sql Exception Interrupted!!", e);
		} finally {
			try {
				if (connection != null) {
					// cleanup resources, once after processing
					preparedStatement.close();
					// and then finally close connection
					connection.close();
				}
			} catch (SQLException e) {
				throw new SqlExceptionFound("Sql Exception Interrupted!!", e);
			}
		}
	}

	/**
	 * This method is to delete the entry of particular Employee from the
	 * Database
	 * @param EmployeeId:This is the id of the Employee
	 */
	public void deleteEmployee(int EmployeeId) throws Exception {
		try {
			connection = DatabaseConnection.getConnection();
			String sql = "DELETE FROM employee WHERE employee_id = ?";
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

	/**
	 * This is the method to get the employment where we can get the
	 * corresponding address too with employeeId
	 * @param empId:This is the id of the Employee and type is int
	 * @return Employee:Return type is Employee Object
	 * @throws SqlExceptionFound
	 * @throws SQLException 
	 */
	public Employee getEmployeewithAddress(int empId) throws Exception{
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

			connection = DatabaseConnection.getConnection();
			String sql ="SELECT employee.employee_id,employee.firstName,employee.lastName,employee.age,employee.department_id,address.address_id,"
					+"address.location,address.town,address.street,address.country"
					+" FROM employee"
					+" INNER JOIN address ON employee.employee_id=address.employee_id where employee.employee_id=?";

			preparedStatement = connection.prepareStatement(sql);
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
			}
			Address address = new Address(location, town, street, country);
			List<Address> addresses = new ArrayList<Address>();
			addresses.add(address);
			emp = new Employee(firstName, lastName, age, addresses,
					departmentId);
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

}
