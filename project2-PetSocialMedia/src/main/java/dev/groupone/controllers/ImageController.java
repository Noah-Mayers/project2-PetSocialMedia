package dev.groupone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	ImageUploadService uploadService;
	
	@PostMapping("/images")
    public Image uploadFile(@RequestBody ImageUpload upload) {

		MultipartFile mpf = upload.getFile();
		
		
	
	
//        fileService.uploadFile(file);
//
//        redirectAttributes.addFlashAttribute("message",
//            "You successfully uploaded " + file.getOriginalFilename() + "!");

        return null;
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
	 * creates the image in the db
	 * @param newImage
	 * @return the image object
	 */
	@PostMapping(value = "/images", consumes = "application/json", produces = "application/json")
	public Image createImage(@RequestBody Image newImage) {
		//creates the user with the given parameters 
		
		return null;
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
	
	/**
	 * deletes image with the given id in the path
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/images/{id}")
	public boolean deleteImage(@PathVariable("id") int id) {
		System.out.println("Executing Delete");
		
		return is.deleteImage(id);
	}
	
	
	
	

}
