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

import dev.groupone.beans.Pet;
import dev.groupone.beans.User;

@RestController
public class PetController {
	
	
	
	
	/**
	 * gets all pets in DB in a list
	 * @return
	 */
	@GetMapping(value = "/pets", produces = "application/json")
	public List<Pet> getAllPets() {
		return null;
	}
	
	@PostMapping(value = "/pets", consumes = "application/json", produces = "application/json")
	public Pet createUser(@RequestBody Pet newPet) {
		//creates the user with the given parameters 
		
		return null;
	}
	
	
	
	
	
	@GetMapping(value = "/pets/{id}", produces = "application/json")
	public Pet getPet(@PathVariable("id") String id) {
		//gets the user with the given id
		return null;
	}
	
	@PutMapping(value = "/pets/{id}", consumes = "application/json", produces = "application/json")
	public Pet updatePet( @PathVariable("id") int id, @RequestBody Pet updatedPet) {
		
		
		return null;
	}
	
	@DeleteMapping(value = "/pets/{id}")
	public boolean deletePet(@PathVariable("id") int id) {
		System.out.println("Executing Delete");
		
		return false;
	}
	
	
	@GetMapping(value = "/pets/search", produces = "application/json")
	public List<Pet> getUserByUsername(@RequestParam(required = false) String name, @RequestParam(required = false) String tag, 
										@RequestParam(required = false) String ownerName, @RequestParam(required = false) String ownerId ) {
		//returns the user with the given username
		return null;
	}
	
	
	@PostMapping(value = "/pets/{id}/follow", consumes = "application/json", produces = "application/json")
	public User followPet(@RequestBody Pet petToFollow) {
		//will be the path called when user wants to follow a pet
		// user making the request = logged in user, pet the loggin in user  wants to follow has id = {id}
		// not implemented yet
		return null;
	}
	
	@PostMapping(value = "/pets/{id}/unfollow", consumes = "application/json", produces = "application/json")
	public User unfollowPet(@RequestBody Pet petToUnfollow) {
		//will be the path called when user wants to unfollow a pet
		// user making the request = logged in user, pet the loggin in user  wants to unfollow has id = {id}
		// not implemented yet
		return null;
	}

}
