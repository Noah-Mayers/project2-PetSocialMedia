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

import dev.groupone.beans.Pet;
import dev.groupone.services.PetService;


@RestController
public class PetController {
	
	@Autowired
	PetService ps;
	
	
	/**
	 * gets all pets in DB in a list
	 * @return
	 */
	@GetMapping(value = "/pets", produces = "application/json")
	public List<Pet> getAllPets() {
		return ps.getAllPets();
	}
	
	/**
	 * creates a pet with the values given in the body 
	 * @param newPet
	 * @return
	 */
	@PostMapping(value = "/pets", consumes = "application/json", produces = "application/json")
	public Pet createUser(@RequestBody Pet newPet) {
		//creates the user with the given parameters 
		
		return ps.addPet(newPet);
	}
	
	
	
	
	/**
	 * returns a pet object with the given id in the path. 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/pets/{id}", produces = "application/json")
	public Pet getPet(@PathVariable("id") String id) {
		//gets the user with the given id
		return ps.getPet(Integer.parseInt(id));
	}
	
	/**
	 * updates the pet wit the given id in the path with the pet object in the body of the request
	 * @param id
	 * @param updatedPet
	 * @return
	 */
	@PutMapping(value = "/pets/{id}", consumes = "application/json", produces = "application/json")
	public Pet updatePet( @PathVariable("id") int id, @RequestBody Pet updatedPet) {
		
		updatedPet.setId(id);
		return ps.updatePet(updatedPet);
	}
	
	
	/**
	 * deletes the pet with the given id in the path variable
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/pets/{id}")
	public boolean deletePet(@PathVariable("id") int id) {
		System.out.println("Executing Delete");
		
		return ps.deletePet(id);
	}
	
	/**
	 * searches the db for pets with the matching parameters
	 * @param name
	 * @param tag
	 * @param ownerName
	 * @param ownerId
	 * @return
	 */
	@GetMapping(value = "/pets/search", produces = "application/json")
	public List<Pet> getUserByUsername(@RequestParam(required = false) String name, @RequestParam(required = false) String tag, 
										@RequestParam(required = false) String ownerName, @RequestParam(required = false) String ownerId ) {
		//returns the user with the given username
		return null;
	}
	
	
	/**
	 * the logged in user found in the logged in session bean will follow the pet with the given id and pet found in the body of the request
	 * @param petToFollow
	 * @return
	 */
	@PostMapping(value = "/pets/{id}/follow", consumes = "application/json", produces = "application/json")
	public Pet followPet(@RequestBody Pet petToFollow) {
		//will be the path called when user wants to follow a pet
		// user making the request = logged in user, pet the loggin in user  wants to follow has id = {id}
		// not implemented yet
		return null;
	}
	
	/**
	 * the logged in user found in the logged in session bean will unfollow the pet with the given id in the path and pet found in the body of the request.
	 * @param petToUnfollow
	 * @return
	 */
	@PostMapping(value = "/pets/{id}/unfollow", consumes = "application/json", produces = "application/json")
	public Pet unfollowPet(@RequestBody Pet petToUnfollow) {
		//will be the path called when user wants to unfollow a pet
		// user making the request = logged in user, pet the loggin in user  wants to unfollow has id = {id}
		// not implemented yet
		return null;
	}

}
