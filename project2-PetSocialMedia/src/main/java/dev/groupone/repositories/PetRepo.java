package dev.groupone.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.groupone.beans.Pet;
import dev.groupone.beans.User;

@Repository
public interface PetRepo extends CrudRepository<Pet, Integer> {
	Pet findByTag(String tag);
	
	List<Pet> findByOwner(User owner);
}
