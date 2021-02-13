package dev.groupone.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {
	
	@Id
	@Column(updatable = false)
	@SequenceGenerator(name = "POST_SEQ", sequenceName = "POST_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "POST_SEQ", strategy = GenerationType.SEQUENCE)
	private int id;
	
	private int likes;
	private String caption;
	private int image;
	
	@ManyToOne
	@JoinColumn(name = "author")
	private int author;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "PetPost", joinColumns = @JoinColumn(name = "postid"), inverseJoinColumns = @JoinColumn(name = "petid"))
	private List<Pet> pets;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Likes", joinColumns = @JoinColumn(name = "userid"), inverseJoinColumns = @JoinColumn(name = "postid"))
	private List<User> users;
	
	public Post() {
		super();
	}

	public Post(int id, int likes, String caption, int image, int author) {
		super();
		this.id = id;
		this.likes = likes;
		this.caption = caption;
		this.image = image;
		this.author = author;
	}

	public Post(int likes, String caption, int image, int author) {
		super();
		this.likes = likes;
		this.caption = caption;
		this.image = image;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", likes=" + likes + ", caption=" + caption + ", image=" + image + ", author="
				+ author + "]";
	}

}
