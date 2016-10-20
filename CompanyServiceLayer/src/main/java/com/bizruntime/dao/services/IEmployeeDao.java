package com.bizruntime.dao.services;
import java.sql.Connection;
import java.util.List;

import com.bizruntime.dao.persistence.Address;
import com.bizruntime.dao.persistence.Employee;

public interface IEmployeeDao
{
public List<Employee> getAllEmployees(Connection conn) throws Exception;
public Employee getEmployee(int empId,Connection conn) throws Exception;
public void insertEmployee(Employee emp,Connection conn) throws Exception;
public void updateEmployee(int EmployeeId) throws Exception;	
public void deleteEmployee(int EmployeeId,Connection conn) throws Exception;	
}
