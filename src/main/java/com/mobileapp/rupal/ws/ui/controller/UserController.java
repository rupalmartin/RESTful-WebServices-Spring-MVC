package com.mobileapp.rupal.ws.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mobileapp.rupal.ws.ui.model.request.UpdateUserDetailRequestModel;
import com.mobileapp.rupal.ws.ui.model.request.UserDetailRequestModel;
import com.mobileapp.rupal.ws.ui.model.response.UserRest;



//this will register this class as rest controller
@RestController
@RequestMapping("users")
//create user, update,delete, this controller will be responsible for all operations
//http://localhost:8080/users
public class UserController {

	Map<String,UserRest> users;
	
	// to bind with https get request
	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		
		if(users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

//		UserRest returnvalue = new UserRest();
//		returnvalue.setFirstname("Rupal");
//		returnvalue.setLastname("Martin");
//		returnvalue.setEmail("rupal.martin@gmail.com");
//		returnvalue.setPassword("password");
//
//		return new ResponseEntity<UserRest>(returnvalue, HttpStatus.OK);
//		// return value is the body u get in postman and httpstatus is 200 ok
	}

	@GetMapping()
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", defaultValue = "Sortingtest", required = false) String sort) {
		return "Hello Rupal Martin page and limit " + page + "limit " + limit + "sort " + sort;
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailRequestModel userdetails) {
		UserRest returnvalue = new UserRest();
		returnvalue.setFirstname(userdetails.getFirstname());
		returnvalue.setLastname(userdetails.getLastname());
		returnvalue.setEmail(userdetails.getEmail());
		returnvalue.setPassword(userdetails.getPassword());
		
		String userId =UUID.randomUUID().toString();
		returnvalue.setUserId(userId);
		
		if(users==null) users = new HashMap<>();
		users.put(userId, returnvalue);

		return new ResponseEntity<UserRest>(returnvalue, HttpStatus.OK);
		// return value is the body u get in postman and httpstatus is 200 ok
	}

	@PutMapping(path = "/{userId}",consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public UserRest updateUser(@PathVariable String userId,@Valid @RequestBody UpdateUserDetailRequestModel userdetails) {
		
		UserRest storedetails =users.get(userId);
		storedetails.setFirstname(userdetails.getFirstname());
		storedetails.setLastname(userdetails.getLastname());
		users.put(userId,storedetails);
	
		return storedetails;
	}

	@DeleteMapping(path = "/{Id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String Id) {
		users.remove(Id);
		return ResponseEntity.noContent().build();
		
	}
	
//	@DeleteMapping(path = "/{Id}")
//	public String deleteUser(@PathVariable String Id) {
//		users.remove(Id);
//		
//	}

}
