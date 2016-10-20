package com.bizruntime.dao.services;
import java.sql.Connection;
import java.util.List;
import com.bizruntime.dao.persistence.Employee;
/**
 * This is the interface which contains all signature methods of IEmployeeBackup
 * @author bizruntime
 *
 */
public interface IEmployeeBackupDao
{
	public List<Employee> getAllEmployees() throws Exception;
	public Employee getEmployee(int empId,Connection conn) throws Exception;
	public void insertEmployee(Employee emp,Connection conn) throws Exception;
	public void updateEmployee(int EmployeeId) throws Exception;	
	public void deleteEmployee(int EmployeeId) throws Exception;
}
