package com.bizruntime.dao.persistence;

public class Address {
	private String location;
	private String town;
	private String street;
	private String country;

	public Address(){}
	public Address( String location, String town, String street,
			String country) {
		this.location = location;
		this.town = town;
		this.street = street;
		this.country = country;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [location=" + location + ", town=" + town + ", street="
				+ street + ", country=" + country + "]";
	}
	
}
