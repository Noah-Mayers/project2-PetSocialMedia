package dev.groupone.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.groupone.beans.Image;
import dev.groupone.beans.Pet;

@RestController
public class ImageController {
	
	/**
	 * gets all images in DB in a list
	 * @return
	 */
	@GetMapping(value = "/images", produces = "application/json")
	public List<Image> getAllPets() {
		return null;
	}
	
	/**
	 * creates the image in the db
	 * @param newImage
	 * @return the image object
	 */
	@PostMapping(value = "/images", consumes = "application/json", produces = "application/json")
	public Image createUser(@RequestBody Image newImage) {
		//creates the user with the given parameters 
		
		return null;
	}
	
	/**
	 * gets the image with the given id
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/images/{id}", produces = "application/json")
	public Pet getImage(@PathVariable("id") String id) {
		//gets the user with the given id
		return null;
	}
	
	/**
	 * deletes image with the given id in the path
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/images/{id}")
	public boolean deletePet(@PathVariable("id") int id) {
		System.out.println("Executing Delete");
		
		return false;
	}
	
	
	
	

}
