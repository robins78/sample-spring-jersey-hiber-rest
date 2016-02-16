package com.org.robin.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.robin.dto.Address;
import com.org.robin.interfaces.MyInterfaces;
import com.org.robin.utils.HibernateUtil;
@Component
public class AddressDao implements MyInterfaces{
	
	
	@Autowired
	Address addr;
	
	@Autowired
	Map<String, Address> adress;
	
	SessionFactory sessionFactory;
	Session session;
	
	public List<Address> getData()
	{
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		Query qery = session.createQuery("from Address");
		
		List<Address> returnData = qery.list();
		return returnData;
	}
	
	public List<Address> getAddress(){
		List<Address> addrList = new ArrayList<Address>();
		for (Map.Entry<String, Address> entry : adress.entrySet()) {
			addr = entry.getValue();
			addrList.add((Address) entry.getValue());
		}
		return addrList;
	}
	
	public String addAddress(Address data){
		String key = String.valueOf(adress.size() + 1);
		adress.put(key, data);
		return key;
	}
	
	public String saveData(Address data)
	{
		String msg="Value saved successfully";
		session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			session.beginTransaction();
			session.save(data);
		}catch (Exception e){
			msg = e.toString();
		}finally{
			session.getTransaction().commit();
			session.flush();
			session.close();
		}
		return msg;
	}

}
