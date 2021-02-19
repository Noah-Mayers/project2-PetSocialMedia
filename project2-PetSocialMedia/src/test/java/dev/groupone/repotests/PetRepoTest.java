package dev.groupone.repotests;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import dev.groupone.beans.Pet;
import dev.groupone.beans.User;
import dev.groupone.repositories.PetRepo;
import dev.groupone.repositories.UserRepo;

@SpringBootTest(classes = dev.mayers.SpringMVC.PetSocialMediaApplication.class)
@Transactional
class PetRepoTest {
	@Autowired
	PetRepo pr;
	
	@Autowired 
	UserRepo ur;
	
	@Test
	void getAllPets() {
		List<Pet> pets = (List<Pet>) pr.findAll(); 
		System.out.println(pets);
	}
	
	@Test
	@Rollback
	void addPet() {
		User b = ur.findById(4).get();
		Pet a = new Pet("Dog", "dog", b);
		
		a = pr.save(a);
		System.out.println(a);
		Assertions.assertNotEquals(0, a.getId());
		
	}
	
	
	@Test
	@Rollback
	void findByPetId() {
		User b = ur.findById(4).get();
		Pet a = new Pet("Dog", "dog", b);
		
		a = pr.save(a);
		
		Pet c = pr.findById(a.getId()).get();
		
		Assertions.assertEquals(a, c);
	}

}
