package dev.groupone.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(updatable = false)
	@SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "USER_SEQ", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(nullable = false, name = "email", unique = true)
	private String email;
	
	@Column(nullable = false, name = "username", unique = true)
	private String username;
	
	@Column(nullable = false, name = "account_password", unique = false)
	private String password;
	
	
	private String bio;

	@ManyToOne
	@JoinColumn(name = "profile_picture")
	private Image profilePicture;

	public User() {
		super();
	}

	public User(int id, String email, String username, String account_password, String bio, Image profile_picture) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = account_password;
		this.bio = bio;
		this.profilePicture = profile_picture;
	}

	public User(String email, String username, String account_password, String bio, Image profile_picture) {
		super();
		this.email = email;
		this.username = username;
		this.password = account_password;
		this.bio = bio;
		this.profilePicture = profile_picture;
	}

	public User(String email, String username, String account_password) {
		super();
		this.email = email;
		this.username = username;
		this.password = account_password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Image getProfile_picture() {
		return profilePicture;
	}

	public void setProfile_picture(Image profilePicture) {
		this.profilePicture = profilePicture;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", username=" + username + ", password="
				+ password + ", bio=" + bio + ", profilePicture=" + profilePicture + "]";
	}

}
