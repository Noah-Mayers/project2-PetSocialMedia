package dev.groupone.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import dev.groupone.beans.User;

@RestController
public class UserController {
	
	
	
	
	@GetMapping(value = "/users", produces = "application/json")
	public List<User> getAllUsers() {
		return null;
	}
	
	@PostMapping(value = "/users", consumes = "application/json", produces = "application/json")
	public User createUser(@RequestBody User newUser) {
		//creates the user with the given parameters 
		
		return null;
	}
	
	
	
	
	
	@GetMapping(value = "/users/{id}", produces = "application/json")
	public User getUser(@PathVariable("id") String id) {
		//gets the user with the given id
		return null;
	}
	
	@PutMapping(value = "/users/{id}", consumes = "application/json", produces = "application/json")
	public User updateUser( @PathVariable("id") int id, @RequestBody User updatedUser) {
		
		
		return null;
	}
	
	@DeleteMapping(value = "/users/{id}")
	public boolean deleteUser(@PathVariable("id") int id) {
		System.out.println("Executing Delete");
		
		return false;
	}
	
	
	@GetMapping(value = "/users/search", produces = "application/json")
	public User getUserByUsername(@RequestParam(required = true) String username) {
		//returns the user with the given username
		return null;
	}
	
	
	@PostMapping(value = "/users/{id}/follow", consumes = "application/json", produces = "application/json")
	public User followUser(@RequestBody User userToFollow) {
		//will be the path called when user wants to follow another user
		// user making the request = logged in user, user the loggin in user is following has id = {id}
		// not implemented yet
		return null;
	}

}
