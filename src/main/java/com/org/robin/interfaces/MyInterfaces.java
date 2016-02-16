package com.org.robin.interfaces;

import java.util.List;

import com.org.robin.dto.Address;

public interface MyInterfaces {
	
	
	public List<Address> getAddress();
	public String addAddress(Address data);
	public String saveData(Address data);
	public List<Address> getData();

}
