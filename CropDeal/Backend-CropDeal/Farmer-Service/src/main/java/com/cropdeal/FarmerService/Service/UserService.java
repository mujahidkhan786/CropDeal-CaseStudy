package com.cropdeal.FarmerService.Service;

import java.util.ArrayList;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.cropdeal.FarmerService.models.Farmer;
import com.cropdeal.FarmerService.models.UserModel;
import com.cropdeal.FarmerService.repository.UserRepository;





@Service
public class UserService implements UserDetailsService {
	@Autowired
	UserRepository repository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel userFounded=repository.findByUsername(username);
		if (userFounded == null) {
			return null;
		}
		String name = userFounded.getUsername();
		String pwd = userFounded.getPassword();
		//String role = userFounded.getRole();
		return new User(name, pwd, new ArrayList<>());
	}
	
	@Autowired
	RestTemplate restTemplate;
	 public UserService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate=restTemplateBuilder.build();
	}

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
//---------------User Operation On Service------------------------	
	//------------------Viewing all the available Trains
//		public List<Farmer> callForDisplaying() {
//			return restTemplate.exchange("http://farmer-service/api/findfarmer", HttpMethod.GET,null,List.class).getBody();
//		}
	 
	
}