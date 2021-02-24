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
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;

import dev.groupone.beans.Comment;
import dev.groupone.services.CommentService;

@AutoConfigureMockMvc
@SpringBootTest(classes = dev.mayers.SpringMVC.PetSocialMediaApplication.class)
public class CommentControllerTests {
	
	@MockBean
	CommentService cs;
	
	@Autowired
	MockMvc mvc;
	
	public static Gson gson = new Gson();
	
	@Test
	public void getAllComments() throws Exception {
		Comment my = new Comment();
		Comment test = new Comment();
		List<Comment> comments = new ArrayList<>();
		comments.add(my);
		comments.add(test);
		Mockito.when(cs.getAllComment()).thenReturn(comments);
		mvc.perform(get("/comments")).andExpect(status().isOk());
	}
	
	@Test
	public void getComment() throws Exception {
		Comment testComment = new Comment();
		Mockito.when(cs.deleteComment(1)).thenReturn(true);
		mvc.perform(delete("/comments/1")).andExpect(status().isOk());
	}

}
