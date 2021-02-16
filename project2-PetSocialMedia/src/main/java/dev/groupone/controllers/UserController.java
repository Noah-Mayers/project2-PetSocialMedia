package dev.groupone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.groupone.beans.User;
import dev.groupone.services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService as;

	/**
	 * returns a list of all users in the db
	 * 
	 * @return
	 */
	@GetMapping(value = "/users", produces = "application/json")
	public List<User> getAllUsers() {
		return as.getAllUsers();
	}

	/**
	 * creates the user defined in the body. returns the created user
	 * 
	 * @param newUser
	 * @return
	 */
	@PostMapping(value = "/users", consumes = "application/json", produces = "application/json")
	public User createUser(@RequestBody User newUser) {
		// creates the user with the given parameters

		return as.addUser(newUser);
	}

	/**
	 * returns a user object with the given id that is in the path, return 400 if it
	 * does not exist
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/users/{id}", produces = "application/json")
	public User getUser(@PathVariable("id") String id) {
		// gets the user with the given id
		return null;
	}

	/**
	 * updates the user with the given id in path with the User in the request body
	 * 
	 * @param id
	 * @param updatedUser
	 * @return
	 */
	@PutMapping(value = "/users/{id}", consumes = "application/json", produces = "application/json")
	public User updateUser(@PathVariable("id") int id, @RequestBody User updatedUser) {
		updatedUser.setId(id);
		return as.updateUser(updatedUser);
	}

	/**
	 * deletes user with the Id in the path
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/users/{id}")
	public boolean deleteUser(@PathVariable("id") int id) {
		System.out.println("Executing Delete");

		return as.deleteUser(id);
	}

	/**
	 * searches user based on the name, can add more searching parameters
	 * 
	 * @param username
	 * @return
	 */
	@GetMapping(value = "/users/search", produces = "application/json")
	public User getUserByUsername(@RequestParam(required = true) String username) {
		// returns the user with the given username
		return null;
	}

	/**
	 * Would be how one user the logged in user (found in the login bean) follows
	 * the user found in the body of the request
	 * 
	 * @param userToFollow
	 * @return
	 */
	@PostMapping(value = "/users/{id}/follow", consumes = "application/json", produces = "application/json")
	public User followUser(@RequestBody User userToFollow) {
		// will be the path called when user wants to follow another user
		// user making the request = logged in user, user the loggin in user is
		// following has id = {id}
		// not implemented yet
		return null;
	}

}
