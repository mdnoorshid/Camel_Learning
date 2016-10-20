package com.bizruntime.dao.persistence.impl;
import java.sql.Connection;
import java.util.List;

import com.bizruntime.dao.persistence.Employee;
import com.bizruntime.dao.services.ICompanyManagementDaoService;
/**
 * This is the implementation class of ICompanyManagementDaoService 
 * @author Md Noorshid
 */
public class CompanyManagementDaoServiceImpl implements ICompanyManagementDaoService{
    /**
     * This method is for inserting the Employee both in Company and CompanyBackUp tables
     * @param Employee:Parameter is Employee object
     * @throws Exception
     */
	public void insertEmployee(Employee employee,Connection conn) throws Exception {
     EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
     EmployeeBackupDaoImpl employeeBackupDaoImpl=new EmployeeBackupDaoImpl();
     employeeDaoImpl.insertEmployee(employee,conn);
     employeeBackupDaoImpl.insertEmployee(employee,conn);
	}

	/**
	 * This method is responsible for getting all Employees from the table Company.Employee
	 * @param empId:This is the employee id parameter passing which is of int type
	 * @throws UnableToFetch
	 */
	public Employee getEmployeewithAddress(int empId,Connection conn) throws UnableToFetch {
		Employee employee=null;
		try{
			employee=new EmployeeDaoImpl().getEmployeewithAddress(empId, conn);
		}catch(Exception e){
			throw new UnableToFetch("Unable to fetch!!",e);
		}
		return employee;
	}

	/**
	 * This method is to delete the Employee from both in Company and CompanyBackUp tables
	 * @param empId:This is the id of the of the Employee in the Company.employee table and data type is integer
	 * @param empBackupId:This is the id of the of the Employee in the CompanyBackUp.employee table and data type is integer
	 */
	public void deleteEmployee(int empId,int empBackupId,Connection conn) throws Exception {
		EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
		EmployeeBackupDaoImpl employeeBackupDaoImpl=new EmployeeBackupDaoImpl();
		employeeDaoImpl.deleteEmployee(empId,conn);
		employeeBackupDaoImpl.deleteEmployee(empBackupId,conn);
	}

	public List<Employee> getAllEmployees(Connection conn) throws Exception {
		List<Employee>employeeLis;
		try{
			employeeLis=new EmployeeDaoImpl().getAllEmployees(conn);
		}catch(Exception e){
			throw new UnableToFetch("Unable to fetch!!",e);
		}
		return employeeLis;
	}

}
