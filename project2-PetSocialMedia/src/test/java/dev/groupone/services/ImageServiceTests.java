package dev.groupone.services;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import dev.groupone.beans.Image;
import dev.groupone.repositories.ImageRepo;

@SpringBootTest(classes = dev.mayers.SpringMVC.PetSocialMediaApplication.class)
class ImageServiceTests {

	@MockBean
	ImageRepo ir;
	
	@Autowired
	ImageService is;
	
	@Test
	void addImage() {
		Image i = new Image(1,"test.png");
		Mockito.when(ir.save(i)).thenReturn(new Image(i.getId(), i.getUrl()));
		
		i = is.addImage(i);
		Assertions.assertEquals(1, i.getId());
		Assertions.assertEquals("test.png", i.getUrl());
	}
	
	@Test
	void getImage() {
		Image i = new Image(1,"test.png");
		Mockito.when(ir.save(i)).thenReturn(new Image(i.getId(), i.getUrl()));
			
		i = is.addImage(i);
		Assertions.assertEquals(1, i.getId());
		Assertions.assertEquals("test.png", i.getUrl());
	}
	
	@Test
	void getAllImages() {
		Image i = new Image(1,"test.png");
		Image j = new Image(2,"test2.png");
		List<Image> imageList = new ArrayList<Image>();
		imageList.add(i);
		imageList.add(j);
		
		Mockito.when(is.getAllImages()).thenReturn(imageList);
		
		i = imageList.get(0);
		Assertions.assertEquals(1, i.getId());
		Assertions.assertEquals("test.png", i.getUrl());
		
		j = imageList.get(1);
		Assertions.assertEquals(2, j.getId());
		Assertions.assertEquals("test2.png", j.getUrl());
	}
	
	@Test
	void deleteImage() {
		Image i = new Image(1,"test.png");
		Mockito.when(is.updateImage(i)).thenReturn(i);
	}
	
	@Test
	void updateImage() {
		Image i = new Image(1,"test.png");
		Mockito.when(is.updateImage(i)).thenReturn(i);
		
		Assertions.assertEquals(1, i.getId());
		Assertions.assertEquals("test.png", i.getUrl());
	}
}
