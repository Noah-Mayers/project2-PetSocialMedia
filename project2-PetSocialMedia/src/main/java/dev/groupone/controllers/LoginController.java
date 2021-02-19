package dev.groupone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.groupone.beans.User;
import dev.groupone.services.UserService;

@Controller
@Scope("session")
public class LoginController {
	
	
	private User loggedInUser = null;
	
	
	@Autowired
	private UserService us;
	
	
	/**
	 * returns a loginSession bean, User bean will be in place for now
	 * @return
	 */
	@GetMapping(value = "/login", produces = "application/json")
	public User getLogin() {
		if(this.loggedInUser == null) {
			this.loggedInUser = new User();
			this.loggedInUser.setId(0);
		}
		return this.loggedInUser;
	}
	
	
	/**
	 * attempts to login with the given user credentials. 
	 * will return a login bean with Id of 0 if it correct it will have the user id
	 * @param newPet
	 * @return
	 */
	@PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
	public User attemptLogin(@RequestBody User user) {
		
		System.out.println("in the login controller in the post recieved : " + user);
		if(user.getUsername() == null || user.getPassword() == null) {
			this.loggedInUser = new User();
			this.loggedInUser.setId(0);
			System.out.println("User sent a user Object with a null username or password maybe throw illegal argument instead");
			return this.loggedInUser;
		}
		User userFromDB = us.getUser(user.getUsername());
		if(userFromDB == null) {
			System.out.println("User with that username did not exist");
			this.loggedInUser = new User();
			this.loggedInUser.setId(-1);
			return this.loggedInUser;
		}
		if(userFromDB.getPassword().equals(user.getPassword())) {
			System.out.println("sucessful login returning " + userFromDB);
			this.loggedInUser = userFromDB;
		}
		else {
			System.out.println("unsucessful login");
			this.loggedInUser = new User();
			this.loggedInUser.setId(0);
		}
		return this.loggedInUser;
	}
	
	/**
	 * will logout, just clears the values of the loggin bean. 
	 * @param 
	 * @return
	 */
	@PostMapping(value = "/logout", consumes = "application/json", produces = "application/json")
	public User Logout() {
		this.loggedInUser = new User();
		this.loggedInUser.setId(0);
		return this.loggedInUser;
	}
	
	
	public User getLoggedInUser() {
		if(this.loggedInUser == null) {
			this.loggedInUser = new User();
			this.loggedInUser.setId(0);
		}
		return this.loggedInUser;
	}

}
