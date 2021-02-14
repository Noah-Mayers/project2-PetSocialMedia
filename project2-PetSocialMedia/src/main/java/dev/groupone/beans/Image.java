package dev.groupone.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity 
@Table(name = "images")
public class Image {

	@Id
	@Column(updatable = false)
	@SequenceGenerator(name = "IMAGE_SEQ", sequenceName = "IMAGE_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "IMAGE_SEQ", strategy = GenerationType.SEQUENCE)
	private int id;
	
	private String image_url;

	public Image() {
		super();
	}

	public Image(int id, String image_url) {
		super();
		this.id = id;
		this.image_url = image_url;
	}

	public Image(String image_url) {
		super();
		this.image_url = image_url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", image_url=" + image_url + "]";
	}
	
}
