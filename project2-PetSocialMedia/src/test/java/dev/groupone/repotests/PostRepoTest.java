package dev.groupone.repotests;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import dev.groupone.beans.Post;
import dev.groupone.beans.User;
import dev.groupone.repositories.PostRepo;
import dev.groupone.repositories.UserRepo;

@SpringBootTest(classes = dev.mayers.SpringMVC.PetSocialMediaApplication.class)
@Transactional
class PostRepoTest {

	@Autowired
	PostRepo postr;

	@Autowired
	UserRepo ur;

	@Test
	void getAllPosts() {
		List<Post> posts = (List<Post>) postr.findAll();
		System.out.println(posts);
	}

	@Test
	@Rollback
	void addPost() {
		User b = ur.findById(4).get();
		Post a = new Post(b);

		a = postr.save(a);
		
		System.out.println("Pet ID: " + a.getId());
		
		Assertions.assertNotEquals(0, a.getId());
	}

	@Test
	@Rollback
	void findByPostId() {
		User b = ur.findById(4).get();

		Post a = new Post(b);

		a = postr.save(a);

		Post c = postr.findById(a.getId()).get();
		Assertions.assertEquals(a, c);

	}

}
