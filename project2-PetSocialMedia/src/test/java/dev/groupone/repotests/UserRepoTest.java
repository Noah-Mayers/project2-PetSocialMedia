package dev.groupone.repotests;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import dev.groupone.beans.User;
import dev.groupone.repositories.UserRepo;

@SpringBootTest(classes = dev.mayers.SpringMVC.PetSocialMediaApplication.class)
@Transactional
class UserRepoTest {

	@Autowired
	UserRepo ur;

	@Test
	void getAllUsers() {
		List<User> users = (List<User>) ur.findAll();
		System.out.println(users);
	}

	@Test
	@Rollback
	void addUser() {
		User a = new User("email@email.com", "Mike", "password");
		a = ur.save(a);

		System.out.println("User ID:" + a.getId());

		Assertions.assertNotEquals(0, a.getId());
	}

	@Test
	@Rollback
	void findByUserID() {
		User a = new User("email@email.com", "Mike", "password");
		a = ur.save(a);

		User b = ur.findById(a.getId()).get();
		Assertions.assertEquals(a, b);
	}

}
