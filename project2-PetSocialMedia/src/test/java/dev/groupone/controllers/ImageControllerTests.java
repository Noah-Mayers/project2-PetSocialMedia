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

import dev.groupone.beans.Image;
import dev.groupone.services.ImageService;

@AutoConfigureMockMvc
@SpringBootTest(classes = dev.mayers.SpringMVC.PetSocialMediaApplication.class)
public class ImageControllerTests {
	
	@MockBean
	ImageService is;
	
	@Autowired
	MockMvc mvc;
	
	public static Gson gson = new Gson();
	
	@Test
	public void getAllImages() throws Exception {
		Image my = new Image(1, "testurl");
		Image test = new Image(2, "testurl");
		List<Image> images = new ArrayList<>();
		images.add(my);
		images.add(test);
		Mockito.when(is.getAllImages()).thenReturn(images);
		mvc.perform(get("/images")).andExpect(status().isOk());
	}
	
	@Test
	public void getImageById() throws Exception {
		Image testImage = new Image(1, "testurl");
		Mockito.when(is.getImage(1)).thenReturn(testImage);
		mvc.perform(get("/images/1")).andExpect(status().isOk());
	}
	
	@Test
	public void deleteImage() throws Exception {
		Image testImage = new Image(1, "testurl");
		Mockito.when(is.deleteImage(1)).thenReturn(true);
		mvc.perform(delete("/images/1")).andExpect(status().isOk());
	}

}
