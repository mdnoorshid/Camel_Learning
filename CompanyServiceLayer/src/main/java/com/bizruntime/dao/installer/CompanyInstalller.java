package com.bizruntime.dao.installer;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.bizruntime.dao.persistence.Address;
import com.bizruntime.dao.persistence.Employee;
import com.bizruntime.dao.persistence.impl.AchievmentImpl;
import com.bizruntime.dao.persistence.impl.AddressDaoImpl;
import com.bizruntime.dao.persistence.impl.CompanyManagementDaoServiceImpl;
import com.bizruntime.dao.persistence.impl.EmployeeDaoImpl;
public class CompanyInstalller 
{
	static Logger log=Logger.getLogger(CompanyInstalller.class);
public static void main(String[] args) throws Exception
{
BasicConfigurator.configure();
//Inserting Employee
/*CompanyManagementDaoServiceImpl companyManagementDaoServiceImpl=new CompanyManagementDaoServiceImpl();
Address address1=new Address("MP","Indor", "na", "India");
Address address2=new Address("Maharastra","Mumbai", "Bandra", "India");
List<Address>addressList=new ArrayList<Address>();
	addressList.add(address1);
	addressList.add(address2);
companyManagementDaoServiceImpl.insertEmployee(new Employee("Salman","Khan",50, addressList, 2));*/
/**--------------------------------------------------------------------------------------------**/
//Get Employee
/*Employee emp=new EmployeeDaoImpl().getEmployee(9);
log.debug("Employee First Name: "+emp.getFirstName());
log.debug("Employee Last Name: "+emp.getLastName());
log.debug("Employee age: "+emp.getAge());
log.debug("Employee Department Id: "+emp.getDepartmentId());*/

/**-----------------------------Get Single Employee With Corresponding Address-------------------------------------------------------**/
//Get the employee with addresses
/*Employee emp=new CompanyManagementDaoServiceImpl().getEmployeewithAddress(20);
log.debug("Employee First Name: "+emp.getFirstName());
log.debug("Employee Last Name: "+emp.getLastName());
log.debug("Employee age: "+emp.getAge());
log.debug("Employee Department Id: "+emp.getDepartmentId());
log.debug(emp.getAddresses().get(0));
log.debug(emp.getAddresses().get(1));*/

/**------------------------Getting All the Employees with corresponding addresses----------------------------------------------------------**/
//Get all the employee with address;
/*List<Employee>employeesList=new CompanyManagementDaoServiceImpl().getAllEmployees();
for(Employee emp:employeesList){
	log.debug(employeesList);
}*/
/**------------------------------Deleting Employee------------------------------------------------------**/
//Delete the employee
/*new CompanyManagementDaoServiceImpl().deleteEmployee(29, 2);*/

/**---------------------------Getting Achievement----------------------------------------------**/
/*new AchievmentImpl().getAchievement("Md","Noorshid",1);*/

/**---------------------------------------------------------------------------------------------**/


}
}
