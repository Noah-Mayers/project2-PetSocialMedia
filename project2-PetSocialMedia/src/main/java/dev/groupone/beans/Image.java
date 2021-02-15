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
	
	
	@Column(nullable = false, name = "image_url", unique = true)
	private String url;


	public Image(int id, String url) {
		super();
		this.id = id;
		this.url = url;
	}


	public Image(String url) {
		super();
		this.url = url;
	}


	public Image() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	@Override
	public String toString() {
		return "Image [id=" + id + ", url=" + url + "]";
	}

	
	
	
}
