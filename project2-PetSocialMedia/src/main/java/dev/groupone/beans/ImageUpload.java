package dev.groupone.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Component
public class ImageUpload {
	
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}
	

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "ImageUpload [file=" + file + "]";
	} 
	
	

}
