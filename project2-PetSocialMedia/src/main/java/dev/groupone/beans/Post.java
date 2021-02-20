package dev.groupone.beans;

import java.util.List;

import javax.persistence.CascadeType;
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
	

	private String caption;
	
	
	@ManyToOne
	@JoinColumn(name = "picture")
	private Image picture;
	
	@ManyToOne
	@JoinColumn(name = "author", nullable = false)
	private User author;
	
	@ManyToMany(fetch =  FetchType.LAZY, cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST})
	@JoinTable(name = "pets_tagged_in_posts", joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "pet_id"))
	private List<Pet> pets;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name = "post_likes", joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> likes;
	
	private java.sql.Timestamp posted;

	
	
	public void addUserLike(User user) {
		this.likes.add(user);
	}
	
	public void removeUserLike(User user) {
		this.likes.remove(user);
	}
	
	
	public Post() {
		super();
	}
	
	

	public Post(User author) {
		super();
		this.author = author;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public Image getPicture() {
		return picture;
	}

	public void setPicture(Image picture) {
		this.picture = picture;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public List<User> getLikes() {
		return likes;
	}

	public void setLikes(List<User> likes) {
		this.likes = likes;
	}

	public java.sql.Timestamp getPosted() {
		return posted;
	}

	public void setPosted(java.sql.Timestamp posted) {
		this.posted = posted;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", caption=" + caption + ", picture=" + picture + ", author=" + author + ", pets="
				+ pets + ", likes=" + likes + ", posted=" + posted + "]";
	}
	
	

}
