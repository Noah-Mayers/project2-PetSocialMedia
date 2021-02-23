package dev.groupone.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;

import dev.groupone.beans.User;
import dev.groupone.services.UserService;

@AutoConfigureMockMvc
@SpringBootTest(classes = dev.mayers.SpringMVC.PetSocialMediaApplication.class)
public class UserControllerTests {

	@MockBean
	UserService us;
	
	@Autowired
	MockMvc mvc;
	
	public static Gson gson = new Gson();
	
	@Test
	public void getAllUsers() throws Exception {
		User my = new User();
		User test = new User();
		List<User> users = new ArrayList<>();
		users.add(my);
		users.add(test);
		Mockito.when(us.getAllUsers()).thenReturn(users);
		mvc.perform(get("/users")).andExpect(status().isOk());
	}
	
	@Test
	public void getUserById() throws Exception {
		User testUser = new User(-9, "test@test.com", "test", "testpass", "testbio", null);
		Mockito.when(us.getUser(-9)).thenReturn(testUser);
		mvc.perform(get("/users/-10")).andExpect(status().isOk());
	}
	
	@Test
	public void getUserByUsername() throws Exception {
		User testUser = new User(-9, "test@test.com", "testusername", "testpass", "testbio", null);
		Mockito.when(us.getUser("testusername")).thenReturn(testUser);
		mvc.perform(get("/users/search").param("username", "gregpauloski")).andExpect(status().isOk());
	}
	
	@Test
	public void createUser() throws Exception {
		User testUser = new User(-9, "test@test.com", "testusername", "testpass", "testbio", null);
		Mockito.when(us.addUser(testUser)).thenReturn(testUser);
		mvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(testUser))).andExpect(status().isOk());
	}
	
	@Test
	public void updateUser() throws Exception {
		User testUser = new User(-9, "test@test.com", "testusername", "testpass", "testbio", null);
		Mockito.when(us.updateUser(testUser)).thenReturn(testUser);
		mvc.perform(put("/users/-9").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(testUser))).andExpect(status().isOk());
	}
	
	@Test
	public void deleteUser() throws Exception {
		User testUser = new User(-9, "test@test.com", "testusername", "testpass", "testbio", null);
		Mockito.when(us.deleteUser(-9)).thenReturn(true);
		mvc.perform(delete("/users/-9")).andExpect(status().isOk());
	}
	
}
