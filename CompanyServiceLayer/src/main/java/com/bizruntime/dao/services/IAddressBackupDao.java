package com.bizruntime.dao.services;

import com.bizruntime.dao.persistence.Address;
import com.bizruntime.dao.persistence.impl.SqlExceptionFound;

public interface IAddressBackupDao {
	public Address getAddress(int empId);
	public void insertAddress(Address address,int empId) throws SqlExceptionFound;
	public void updateAddress(int empId);
	public void deleteAddress(int empId);
}
