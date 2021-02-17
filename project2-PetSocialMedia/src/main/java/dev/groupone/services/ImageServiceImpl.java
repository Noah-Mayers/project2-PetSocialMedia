 package dev.groupone.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.groupone.beans.Image;
import dev.groupone.repositories.ImageRepo;
@Service
public class ImageServiceImpl implements ImageService {
	@Autowired
	ImageRepo ir;
	
	@Override
	public Image addImage(Image image) {
		return ir.save(image);
	}

	@Override
	public Image getImage(int id) {
		return ir.findById(id).get();
	}

	@Override
	public List<Image> getAllImages() {
		return (List<Image>) ir.findAll();
	}

	@Override
	public boolean deleteImage(int id) {
		try {
			ir.delete(ir.findById(id).get());
			return true;
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Image updateImage(Image change) {
		return ir.save(change);
	}

}
