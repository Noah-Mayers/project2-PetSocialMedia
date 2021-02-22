package dev.groupone.controllers;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.ObjectMetadata;

import dev.groupone.beans.Image;
import dev.groupone.beans.ImageUpload;
import dev.groupone.beans.Pet;
import dev.groupone.services.ImageService;
import dev.groupone.services.ImageUploadService;

@RestController
public class ImageController {
	
	
	
	@Autowired
	ImageService is;
	
	@Autowired
	ImageUploadService us;
	
	
	@RequestMapping(value = "/images",  method = RequestMethod.POST)
    public Image uploadFile(@RequestBody MultipartFile file) {
		System.out.println("boom made it to the post methods");
		System.out.println(file.getContentType());
		
		System.out.println(file.getName());
		
//step 1: create an image in the image database
		Image newImage = new Image();
		newImage.setUrl("INITALURL"+ System.currentTimeMillis());
		newImage = is.addImage(newImage);
		System.out.println("image created in DB");
		System.out.println(newImage);
//step 2: call the image upload service that should return the right url
		String path = us.uploadFileToBucket(file, newImage.getId());
		if(path == null) {
			System.out.println("upoad failed");
			Image out = new Image();
			out.setId(0);
	        return out;
		}
		System.out.println("image put in bucket");
		System.out.println("path to the image is " + path);
		newImage.setUrl(path);
		is.updateImage(newImage);
		
		
		System.out.println("made and upadated the file");
		
		return newImage;
	
		
    }
	
	/**
	 * gets all images in DB in a list
	 * @return
	 */
	@GetMapping(value = "/images", produces = "application/json")
	public List<Image> getAllImages() {
		return is.getAllImages();
	}
	

	
	/**
	 * gets the image with the given id
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/images/{id}", produces = "application/json")
	public Image getImage(@PathVariable("id") String id) {
		//gets the user with the given id
		return is.getImage(Integer.parseInt(id));
	}
//	
//	/**
//	 * deletes image with the given id in the path
//	 * @param id
//	 * @return
//	 */
	@DeleteMapping(value = "/images/{id}")
	public boolean deleteImage(@PathVariable("id") int id) {
		System.out.println("Executing Delete");
		
		return is.deleteImage(id);
	}
	
	
	
	

}
