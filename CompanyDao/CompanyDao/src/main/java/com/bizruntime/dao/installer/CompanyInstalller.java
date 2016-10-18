package com.bizruntime.dao.installer;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.bizruntime.dao.persistence.Address;
import com.bizruntime.dao.persistence.Employee;
import com.bizruntime.dao.persistence.impl.AddressDaoImpl;
import com.bizruntime.dao.persistence.impl.EmployeeDaoImpl;
public class CompanyInstalller 
{
	static Logger log=Logger.getLogger(CompanyInstalller.class);
public static void main(String[] args) throws Exception
{
BasicConfigurator.configure();
//Inserting Employee
/*EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
Address address1=new Address("Bihar","Purnia", "na", "India");
Address address2=new Address("Karnataka","Bangalore", "Sarjapur", "India");
List<Address>addressList=new ArrayList<Address>();
System.out.println("addresslist: "+addressList.size());
	addressList.add(address1);
	addressList.add(address2);
employeeDaoImpl.insertEmployee(new Employee("Raj","Khanna",25, addressList, 1));*/
/**--------------------------------------------------------------------------------------------**/
//Get Employee
/*Employee emp=new EmployeeDaoImpl().getEmployee(9);
log.debug("Employee First Name: "+emp.getFirstName());
log.debug("Employee Last Name: "+emp.getLastName());
log.debug("Employee age: "+emp.getAge());
log.debug("Employee Department Id: "+emp.getDepartmentId());*/

/**-------------------------------------------------------------------------------------------**/
//Get the employee with addresses
/*Employee emp=new EmployeeDaoImpl().getEmployeewithAddress(15);
log.debug("Employee First Name: "+emp.getFirstName());
log.debug("Employee Last Name: "+emp.getLastName());
log.debug("Employee age: "+emp.getAge());
log.debug("Employee Department Id: "+emp.getDepartmentId());
log.debug(emp.getAddresses().get(0));*/
/*log.debug(emp.getAddresses().get(1));*/
/*List<Address>addressList=emp.getAddresses();
for(Address address:addressList){
}*/

/**--------------------------------------------------------------------------------------------**/
//Get all the employee with address;
/*List<Employee>employeesList=new EmployeeDaoImpl().getAllEmployees();
for(Employee emp:employeesList){
	log.debug(employeesList);
}*/

/**--------------------------------------------------------------------------------------------**/
//Delete the employee
/*new EmployeeDaoImpl().deleteEmployee(17);*/

/**--------------------------------------------------------------------------------------------**/
}
}
