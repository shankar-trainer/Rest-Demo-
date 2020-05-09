package org.com.onlinetest.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.com.onlinetest.exception.*;
import org.com.onlinetest.dao.TestDao;
import org.com.onlinetest.dao.UserDao;
import org.com.onlinetest.model.Question;
import org.com.onlinetest.model.Test;
import org.com.onlinetest.model.Users;
import org.com.onlinetest.service.TestService;
import org.com.onlinetest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
@CrossOrigin("http://localhost:4200")
public class UserController {
	@Autowired
	UserDao dao;
	UserService service;
	//@Autowired
	//TestDao dao1;
	
	@PostMapping("/addUser")
	public Users addUser(@RequestBody Users user) {
		return service.addUser(user);
			
	}
	
	@GetMapping("/showUsers")
	public List<Users> getAllUser() {
		return service.getAllUser();
	}
	/*
	@GetMapping("/viewAllTests")
	public List<Test> viewAllTests() {
		return dao1.findAll();
	}
	*/

	@PutMapping("/updateUser/")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Users> updateUser(@Valid @RequestBody Users user) {	   	 
			   	return service.updateUser(user);
			   

		}

		
    @GetMapping("/getResult")
	public int getResult(Test test) {
		return service.getResult(test);
	}

    
    
    
    
  //login
    @GetMapping("/login/{id}")
    public boolean loginId(@PathVariable("id") Long loginId)
    {
 	   return service.validloginId(loginId);
    }
   
}
