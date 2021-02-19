package dev.groupone.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.groupone.beans.Pet;

@Repository
public interface PetRepo extends CrudRepository<Pet, Integer> {
	Pet findByTag(String tag);
}
