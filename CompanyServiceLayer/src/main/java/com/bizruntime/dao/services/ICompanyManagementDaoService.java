package com.bizruntime.dao.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.bizruntime.dao.persistence.Employee;
import com.bizruntime.dao.persistence.impl.EmployeeBackupDaoImpl;
import com.bizruntime.dao.persistence.impl.EmployeeDaoImpl;
import com.bizruntime.dao.persistence.impl.SqlExceptionFound;

public interface ICompanyManagementDaoService
{
 public void insertEmployee(Employee employee,Connection conn) throws Exception;
 public Employee getEmployeewithAddress(int empId,Connection conn) throws Exception;
 public List<Employee> getAllEmployees(Connection conn) throws Exception;
 public void deleteEmployee(int empId,int empBackupId,Connection conn) throws Exception;
}
