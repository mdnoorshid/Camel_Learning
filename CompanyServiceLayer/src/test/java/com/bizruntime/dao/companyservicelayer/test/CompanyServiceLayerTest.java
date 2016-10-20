package com.bizruntime.dao.companyservicelayer.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.*;

import com.bizruntime.dao.persistence.Address;
import com.bizruntime.dao.persistence.Employee;
import com.bizruntime.dao.persistence.impl.CompanyManagementDaoServiceImpl;
import com.bizruntime.dao.persistence.impl.EmployeeDaoImpl;
import com.bizruntime.dao.persistence.impl.SqlExceptionFound;
import com.bizruntime.util.DatabaseConnection;

public class CompanyServiceLayerTest 
{
	static Logger log=Logger.getLogger(CompanyServiceLayerTest.class);
	Connection conn;
	/*PreparedStatement presPreparedStatement;*/
	@Before
	public void connectionSetup() throws Exception{
    try{
	conn=DatabaseConnection.getConnection();
	Assert.assertNotNull("Not Null",conn);
    log.debug("Connection established!!");
    }catch(Exception e){
    	throw new ConnectionFail("Connection Error!!",e);
    }
	}
	@After
	public void closeResources() throws SQLException, ConnectionCloseException{
		try{
			conn.close();
		}catch(Exception e){
		  throw new ConnectionCloseException("Connection Close Exception!!");
		}
	}
	/**
	 * This method is responsible for adding Employees
	 * @throws InsertionFailedException
	 */
	//Running Successfully
	/*@Test
	public void addEmployees() throws Exception{
		CompanyManagementDaoServiceImpl companyManagementDaoServiceImpl=new CompanyManagementDaoServiceImpl();
		Address address1=new Address("MP","Indor", "na", "India");
		Address address2=new Address("Maharastra","Mumbai", "Bandra", "India");
		List<Address>addressList=new ArrayList<Address>();
			addressList.add(address1);
			addressList.add(address2);
			try{
		companyManagementDaoServiceImpl.insertEmployee(new Employee("Salman","Khan",50, addressList, 2),conn);
			}catch(Exception e){
				throw new InsertionFailedException("Insertion Failed!!",e);
			}
	}*/
	/**
	 * This method is responsible for fetching the Employees
	 * @throws FetchingErrorException
	 */
	//Running successfully
/*	@Test
	public void getEmployee() throws SQLException, SqlExceptionFound, FetchingErrorException{
		try{
		CompanyManagementDaoServiceImpl companyManagementDaoServiceImpl=new CompanyManagementDaoServiceImpl();
		
		Employee emp=companyManagementDaoServiceImpl.getEmployeewithAddress(23, conn);
		Assert.assertNotNull("Employee object should not be null",emp);
		log.debug("Employee First Name: "+emp.getFirstName());
		log.debug("Employee Last Name: "+emp.getLastName());
		log.debug("Employee age: "+emp.getAge());
		log.debug("Employee Department Id: "+emp.getDepartmentId());
		log.debug(emp.getAddresses());
		}catch (Exception e) {
			throw new FetchingErrorException("Fetching Problem",e);
		}
	}
	*/
	/**
	 * This method is responsible for fetching all employees from the Employee table
	 * @throws FetchingErrorException
	 */
	@Test
	public void getAllEmployees() throws FetchingErrorException{
		try{
		List<Employee>employeesList=new CompanyManagementDaoServiceImpl().getAllEmployees(conn);
		Assert.assertNotNull("Employee List object should not be null", employeesList);
		for(Employee emp:employeesList){
			log.debug(employeesList);
		}
		}
		catch(Exception e){
			throw new FetchingErrorException("Fetching problem!!",e);
		}
	}	
}
