package dev.groupone.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.groupone.beans.User;

@RestController
public class LoginController {
	
	
	
	/**
	 * returns a loginSession bean, User bean will be in place for now
	 * @return
	 */
	@GetMapping(value = "/login", produces = "application/json")
	public User getLogin() {
		return null;
	}
	
	
	/**
	 * attempts to login with the given user credentials. 
	 * will return a login bean with Id of 0 if it correct it will have the user id
	 * @param newPet
	 * @return
	 */
	@PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
	public User attemptLogin(@RequestBody User user) {
		//creates the user with the given parameters 
		System.out.println("Accessed Login Post");
		return null;
	}
	
	/**
	 * will logout, just clears the values of the loggin bean. 
	 * @param 
	 * @return
	 */
	@PostMapping(value = "/logout", consumes = "application/json", produces = "application/json")
	public User Logout() {
		//creates the user with the given parameters 
		
		return null;
	}
	

}
