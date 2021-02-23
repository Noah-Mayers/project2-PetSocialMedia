package dev.groupone.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import dev.groupone.beans.Image;
import dev.groupone.beans.User;
import dev.groupone.repositories.UserRepo;

@SpringBootTest(classes = dev.mayers.SpringMVC.PetSocialMediaApplication.class)
class UserServiceTests {

	@MockBean
	UserRepo ur;
	
	@Autowired
	UserService us;
	
	@Test
	void addUser() {
		Image image = new Image();
		User u = new User(1, "user@email.com", "username", "password", "bio", image);
		Mockito.when(ur.save(u)).thenReturn(new User(u.getId(), u.getEmail(), u.getUsername(), u.getPassword(), u.getBio(), u.getProfilePicture()));
		
		u = us.addUser(u);
		Assertions.assertEquals(1, u.getId());
		Assertions.assertEquals("user@email.com", u.getEmail());
		Assertions.assertEquals("username", u.getUsername());
		Assertions.assertEquals("password", u.getPassword());
		Assertions.assertEquals("bio", u.getBio());
		Assertions.assertEquals(image, u.getProfilePicture());
	}
	
	@Test
	void getUserByID() {
		Image image = new Image();
		User u = new User(1, "user@email.com", "username", "password", "bio", image);
		Mockito.when(us.getUser("username")).thenReturn(u);
		
		u = us.getUser("username");
		Assertions.assertEquals(1, u.getId());
		Assertions.assertEquals("user@email.com", u.getEmail());
		Assertions.assertEquals("username", u.getUsername());
		Assertions.assertEquals("password", u.getPassword());
		Assertions.assertEquals("bio", u.getBio());
		Assertions.assertEquals(image, u.getProfilePicture());
	}
	
	@Test
	void getUserByUsername() {
		Image image = new Image();
		User u = new User(1, "user@email.com", "username", "password", "bio", image);
		Mockito.when(us.getUser("username")).thenReturn(u);
		
		u = us.getUser("username");
		Assertions.assertEquals(1, u.getId());
		Assertions.assertEquals("user@email.com", u.getEmail());
		Assertions.assertEquals("username", u.getUsername());
		Assertions.assertEquals("password", u.getPassword());
		Assertions.assertEquals("bio", u.getBio());
		Assertions.assertEquals(image, u.getProfilePicture());
	}
	
	@Test
	void getAllUsers() {
		Image image = new Image();
		User u = new User(1, "user@email.com", "username", "password", "bio",  image);
		User v = new User(2, "user2@email.com", "username2", "password2", "bio2", image);
		List<User> userList = new ArrayList();
		userList.add(u);
		userList.add(v);
		
		Mockito.when(us.getAllUsers()).thenReturn(userList);
		
		u = userList.get(0);
		Assertions.assertEquals(1, u.getId());
		Assertions.assertEquals("user@email.com", u.getEmail());
		Assertions.assertEquals("username", u.getUsername());
		Assertions.assertEquals("password", u.getPassword());
		Assertions.assertEquals("bio", u.getBio());
		Assertions.assertEquals(image, u.getProfilePicture());
		
		v = userList.get(1);
		Assertions.assertEquals(1, u.getId());
		Assertions.assertEquals("user@email.com", u.getEmail());
		Assertions.assertEquals("username", u.getUsername());
		Assertions.assertEquals("password", u.getPassword());
		Assertions.assertEquals("bio", u.getBio());
		Assertions.assertEquals(image, u.getProfilePicture());
	}
	
	@Test
	void deleteUser() {
		Image image = new Image();
		User u = new User(1, "user@email.com", "username", "password", "bio",  image);
		Mockito.when(us.updateUser(u)).thenReturn(u);
	}
	
	@Test
	void updateUser() {
		Image image = new Image();
		User u = new User(1, "user@email.com", "username", "password", "bio",  image);
		Mockito.when(us.updateUser(u)).thenReturn(u);
		
		u = us.updateUser(u);
		Assertions.assertEquals(1, u.getId());
		Assertions.assertEquals("user@email.com", u.getEmail());
		Assertions.assertEquals("username", u.getUsername());
		Assertions.assertEquals("password", u.getPassword());
		Assertions.assertEquals("bio", u.getBio());
		Assertions.assertEquals(image, u.getProfilePicture());
	}

}
