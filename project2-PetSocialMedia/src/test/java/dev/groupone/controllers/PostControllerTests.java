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

import dev.groupone.beans.Post;
import dev.groupone.beans.User;
import dev.groupone.services.PostService;

@AutoConfigureMockMvc
@SpringBootTest(classes = dev.mayers.SpringMVC.PetSocialMediaApplication.class)
public class PostControllerTests {

	@MockBean
	PostService ps;
	
	@Autowired
	MockMvc mvc;
	
	public static Gson gson = new Gson();
	
	@Test
	public void getAllPosts() throws Exception {
		Post my = new Post();
		Post test = new Post();
		List<Post> posts = new ArrayList<>();
		posts.add(my);
		posts.add(test);
		Mockito.when(ps.getAllPosts()).thenReturn(posts);
		mvc.perform(get("/posts")).andExpect(status().isOk());
	}
	
	@Test
	public void createPost() throws Exception {
		User testUser = new User(-9, "test@test.com", "test", "testpass", "testbio", null);
		Post testPost = new Post(testUser);
		Mockito.when(ps.addPost(testPost)).thenReturn(testPost);
		mvc.perform(post("/posts").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(testPost))).andExpect(status().isOk());
	}
	
	@Test
	public void getPost() throws Exception {
		Post testPost = new Post();
		Mockito.when(ps.getPost(1)).thenReturn(testPost);
		mvc.perform(post("/posts/1")).andExpect(status().isOk());
	}
	
	@Test
	public void updatePost() throws Exception {
		Post testPost = new Post();
		Mockito.when(ps.updatePost(testPost)).thenReturn(testPost);
		mvc.perform(put("/posts/1").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(testPost))).andExpect(status().isOk());
	}
	
	@Test
	public void deletePost() throws Exception {
		Post testPost = new Post();
		Mockito.when(ps.deletePost(1)).thenReturn(true);
		mvc.perform(delete("/posts/1")).andExpect(status().isOk());
	}
	
}
