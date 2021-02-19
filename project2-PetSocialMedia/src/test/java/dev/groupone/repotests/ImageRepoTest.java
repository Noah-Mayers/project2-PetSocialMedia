package dev.groupone.repotests;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import dev.groupone.beans.Image;
import dev.groupone.repositories.ImageRepo;

@SpringBootTest(classes = dev.mayers.SpringMVC.PetSocialMediaApplication.class)
@Transactional
class ImageRepoTest {

	@Autowired
	ImageRepo ir;

	@Test
	void getAllImages() {
		List<Image> images = (List<Image>) ir.findAll();
		System.out.println(images);
	}

	@Test
	@Rollback
	void addImage() {
		Image a = new Image("url");

		a = ir.save(a);
		System.out.println("Image ID: " + a.getId());
		
		Assertions.assertNotEquals(0, a.getId());
	}
	
	@Test
	@Rollback
	void findByUserId() {
		Image a = new Image("url");
		a = ir.save(a);
		
		Image b = ir.findById(a.getId()).get();
		Assertions.assertEquals(a, b);
	}

}
