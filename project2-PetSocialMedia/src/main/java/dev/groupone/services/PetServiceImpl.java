package dev.groupone.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.groupone.beans.Pet;
import dev.groupone.beans.User;
import dev.groupone.repositories.PetRepo;

@Service
public class PetServiceImpl implements PetService {
	@Autowired
	PetRepo pr;
	@Override
	public Pet addPet(Pet pet) {
		return pr.save(pet);
	}

	@Override
	public Pet getPet(int id) {
		return pr.findById(id).get();
	}
	
	@Override
	public Pet getPet(String tag) {
		return pr.findByTag(tag);
	}

	@Override
	public List<Pet> getAllPets() {
		return (List<Pet>) pr.findAll();
	}

	@Override
	public boolean deletePet(int id) {
		try {
			pr.delete(pr.findById(id).get());
			return true;
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Pet updatePet(Pet change) {
		return pr.save(change);
	}

	@Override
	public List<Pet> getAllUserPets(User user) {
<<<<<<< HEAD
		return (List<Pet>) pr.findByOwner(user.getId());
	}

}
=======
		return (List<Pet>) pr.findByOwner(user);
	}

}
>>>>>>> 166788e9504ad4c30c19692b710495c2681aef39
