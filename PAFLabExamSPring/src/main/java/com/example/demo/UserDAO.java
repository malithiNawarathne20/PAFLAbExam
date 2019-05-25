package com.example.demo;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service 
public class UserDAO {
	
	@Autowired
	 UserRepo userRepository; 	

	 @Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)
	 public UserClass save(UserClass emp) {
	 return userRepository.save(emp);
	 } 

	 public List<UserClass> findAll(){
	 return userRepository.findAll();
	 }

	 public UserClass findOne(int id) {
	 Optional<UserClass> op = userRepository.findById(id);
	 if(op.isPresent()) {
	 return op.get();
	 }
	 else {
	 return null;
	 }
	 }

	 @Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)
	 public void delete(UserClass customer) {
	 userRepository.delete(customer);
	 } 



}

