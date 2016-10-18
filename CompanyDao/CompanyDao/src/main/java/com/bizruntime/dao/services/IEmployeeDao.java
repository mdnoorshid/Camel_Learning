package com.bizruntime.dao.services;
import java.util.List;

import com.bizruntime.dao.persistence.Address;
import com.bizruntime.dao.persistence.Employee;

public interface IEmployeeDao
{
public List<Employee> getAllEmployees() throws Exception;
public Employee getEmployee(int empId) throws Exception;
public void insertEmployee(Employee emp) throws Exception;
public void updateEmployee(int EmployeeId) throws Exception;	
public void deleteEmployee(int EmployeeId) throws Exception;	
}
