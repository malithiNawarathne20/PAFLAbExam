package com.example.demo;


import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company") 
public class UserController {
	
	@Autowired
	 UserDAO userDAO; 
	
	
	 @PostMapping("/customers")
	 public UserClass createUser(@Valid @RequestBody UserClass customer) {
	 return userDAO.save(customer);
	 } 
	 
	
	 @GetMapping("/customers")
	 public List<UserClass> getAllEmployees(){
	 return userDAO.findAll();
	 }

	 @GetMapping("/customers/{id}")
	 public ResponseEntity<UserClass> getEmployeeById(@PathVariable(value="id") Integer
	id){


	 UserClass customer=userDAO.findOne(id);
	 
	 if(customer==null) {
	 return ResponseEntity.notFound().build();
	 }
	 return ResponseEntity.ok().body(customer);
	 }
	 
	@PutMapping("/customers/{id}")
	 public ResponseEntity<UserClass> updateCustomer(@PathVariable(value="id") Integer id,
	@Valid @RequestBody UserClass cusDetails){


	 UserClass cus=userDAO.findOne(id);
	 if(cus==null) {
	 return ResponseEntity.notFound().build();
	 }
	 cus.setName(cusDetails.getName());
	// cus.setUsername(cusDetails.getUsername());
	 cus.setaddress(cusDetails.getaddress());
	 cus.setPhoneNum(cusDetails.getPhoneNum());
	 cus.setaddress(cusDetails.getaddress());
	// cus.setConfirmpwd(cusDetails.getConfirmpwd());
	// cus.setPwd(cusDetails.getPwd());
	 cus.setEmail(cusDetails.getEmail());

	
	 UserClass cusdet=userDAO.save(cus);
	 return ResponseEntity.ok().body(cusdet);
	 } 

	 @DeleteMapping("/customers/{id}")
	 public ResponseEntity<UserClass> deletecustomer(@PathVariable(value="id") Integer id){

		 UserClass cus=userDAO.findOne(id);
	 if(cus==null) {
	 return ResponseEntity.notFound().build();
	 }
	
	 userDAO.delete(cus);
	 return ResponseEntity.ok().build();
	 }
	 
	 
	} 
	 
	 


