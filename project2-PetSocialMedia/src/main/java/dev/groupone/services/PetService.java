package dev.groupone.services;

import java.util.List;

import dev.groupone.beans.Pet;

public interface PetService {
	
	public Pet addPet(Pet pet);
	public Pet getPet(int id);
	public Pet getPet(String tag);
	//add special get methods here
	public List<Pet> getAllPets();
	public boolean deletePet(int id);
	public Pet updatePet(Pet change);

}
