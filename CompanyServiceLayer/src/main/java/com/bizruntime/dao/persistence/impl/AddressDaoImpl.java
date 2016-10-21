package com.bizruntime.dao.persistence.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.bizruntime.dao.persistence.Address;
import com.bizruntime.dao.services.IAddressDao;
import com.bizruntime.util.DatabaseConnection;
public class AddressDaoImpl implements IAddressDao 
{
	static Logger log = Logger.getLogger(EmployeeDaoImpl.class);
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	Statement statement;

	public Address getAddress(int empId) {
		return null;
	}
   /**
    * This method is to insert the Address of a Employee
    * @param Address:It will take Address Object as a first parameter
    * @param emplId: This id belongs to Employee and it is the second parameter as int
    * @throws SqlExceptionFound
    */
	public void insertAddress(Address address,int empId) throws SqlExceptionFound {
		try{
			connection=DatabaseConnection.getConnection();
			String sql="insert into Company.address( location ,town,street,country,employee_id) values(?,?,?,?,?)";
			preparedStatement=connection.prepareStatement(sql);

			String location=address.getLocation();
			String town=address.getTown();
			String street=address.getStreet();
			String country=address.getCountry();
			
			preparedStatement.setString(1,location);
			preparedStatement.setString(2,town);
			preparedStatement.setString(3,street);
			preparedStatement.setString(4,country);
			preparedStatement.setInt(5, empId);
			
			int i=preparedStatement.executeUpdate();
			if(i>0){
				log.debug("Address inserted successfully for the Employee having EmployeeId: "+empId);
			}else{
				log.error("Address Insertion failed!!");
			}
		}catch(Exception e){
			throw new SqlExceptionFound("Sql Exception Interrupted!!",e);
		}
		
	}

	public void updateAddress(int empId) {
		
	}

	public void deleteAddress(int empId) {
		
	}

}
