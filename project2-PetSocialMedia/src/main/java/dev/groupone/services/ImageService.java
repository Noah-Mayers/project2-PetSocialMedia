package dev.groupone.services;

import java.util.List;

import dev.groupone.beans.Image;

public interface ImageService {
	
	public Image addImage(Image image);
	public Image getImage(int id);
	//add special get methods here
	public List<Image> getAllImages();
	public boolean deleteImage(int id);
	public Image updateImage(Image change);

}
