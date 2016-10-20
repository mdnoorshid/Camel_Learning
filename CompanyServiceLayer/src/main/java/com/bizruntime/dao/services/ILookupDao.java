package com.bizruntime.dao.services;
public interface ILookupDao
{
public void addDepartment( int departmentId,String department);
public void getDepartment(int departmentId);
public void updateDepartment(int departmentId);
public void deleteDepartment(int departmentId);
}
