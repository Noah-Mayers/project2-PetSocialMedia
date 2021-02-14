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
	
	private String caption;
	
	@ManyToOne
	@JoinColumn(name = "picture")
	private Image picture;
	
	@ManyToOne
	@JoinColumn(name = "author")
	private User author;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "pets_tagged_in_posts", joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "pet_id"))
	private List<Pet> pets;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "post_likes", joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> likes;
	
	public Post() {
		super();
	}

	public Post(int id, String caption, Image picture, User author) {
		super();
		this.id = id;
		this.caption = caption;
		this.picture = picture;
		this.author = author;
	}

	public Post(String caption, Image picture, User author) {
		super();
		this.caption = caption;
		this.picture = picture;
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

	public Image getpicture() {
		return picture;
	}

	public void setpicture(Image picture) {
		this.picture = picture;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", caption=" + caption + ", picture=" + picture + ", author="
				+ author + "]";
	}

}
