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
@Table(name = "pets")
public class Pet {

	@Id
	@Column(updatable = false)
	@SequenceGenerator(name = "PET_SEQ", sequenceName = "PET_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "PET_SEQ", strategy = GenerationType.SEQUENCE)
	private int id;
	
	private String pet_name;
	private String pet_tag;
	private String bio;
	
	@ManyToOne
	@JoinColumn(name = "pet_profile_picture")
	private Image pet_profile_picture;
	
	@ManyToOne
	@JoinColumn(name = "pet_owner")
	private User pet_owner;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "pet_followers", joinColumns = @JoinColumn(name = "pet_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> followers;
	
	public Pet() {
		super();
	}

	public Pet(int id, String pet_name, String pet_tag, String bio, Image pet_profile_picture, User pet_owner) {
		super();
		this.id = id;
		this.pet_name = pet_name;
		this.pet_tag = pet_tag;
		this.bio = bio;
		this.pet_profile_picture = pet_profile_picture;
		this.pet_owner = pet_owner;
	}

	public Pet(String pet_name, String pet_tag, String bio, Image pet_profile_picture, User pet_owner) {
		super();
		this.pet_name = pet_name;
		this.pet_tag = pet_tag;
		this.bio = bio;
		this.pet_profile_picture = pet_profile_picture;
		this.pet_owner = pet_owner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPet_name() {
		return pet_name;
	}

	public void setPet_name(String pet_name) {
		this.pet_name = pet_name;
	}

	public String getPet_tag() {
		return pet_tag;
	}

	public void setPet_tag(String pet_tag) {
		this.pet_tag = pet_tag;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Image getPet_profile_picture() {
		return pet_profile_picture;
	}

	public void setPet_profile_picture(Image pet_profile_picture) {
		this.pet_profile_picture = pet_profile_picture;
	}

	public User getpet_owner() {
		return pet_owner;
	}

	public void setpet_owner(User pet_owner) {
		this.pet_owner = pet_owner;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", pet_name=" + pet_name + ", pet_tag=" + pet_tag + ", bio=" + bio
				+ ", pet_profile_picture=" + pet_profile_picture + ", pet_owner=" + pet_owner + "]";
	}
	
}
