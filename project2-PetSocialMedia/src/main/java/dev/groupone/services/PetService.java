package dev.groupone.services;
import java.util.List;

import dev.groupone.beans.Pet;
import dev.groupone.beans.User;

public interface PetService {
	
	public Pet addPet(Pet pet);
	public Pet getPet(int id);
	public Pet getPet(String tag);
	//add special get methods here
	public List<Pet> getAllUserPets(User user);
	public List<Pet> getAllPets();
	public boolean deletePet(int id);
	public Pet updatePet(Pet change);

}