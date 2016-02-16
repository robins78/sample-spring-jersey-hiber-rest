package com.org.robin.Messaging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.org.robin.dao.AddressDao;
import com.org.robin.dto.Address;

@Configuration
public class ApplicationConfiguration {
	@Bean
	  AddressDao addr () {
	    return new AddressDao();
	  }
	@Bean
	 Address address(){
		return new Address();
	}
}
