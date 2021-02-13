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
	private int pet_profile_picture;
	
	@ManyToOne
	@JoinColumn(name = "OWNER")
	private User owner;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Follower", joinColumns = @JoinColumn(name = "pet"), inverseJoinColumns = @JoinColumn(name = "userid"))
	private List<User> followers;
	
	public Pet() {
		super();
	}

	public Pet(int id, String pet_name, String pet_tag, String bio, int pet_profile_picture, User owner) {
		super();
		this.id = id;
		this.pet_name = pet_name;
		this.pet_tag = pet_tag;
		this.bio = bio;
		this.pet_profile_picture = pet_profile_picture;
		this.owner = owner;
	}

	public Pet(String pet_name, String pet_tag, String bio, int pet_profile_picture, User owner) {
		super();
		this.pet_name = pet_name;
		this.pet_tag = pet_tag;
		this.bio = bio;
		this.pet_profile_picture = pet_profile_picture;
		this.owner = owner;
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

	public int getPet_profile_picture() {
		return pet_profile_picture;
	}

	public void setPet_profile_picture(int pet_profile_picture) {
		this.pet_profile_picture = pet_profile_picture;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", pet_name=" + pet_name + ", pet_tag=" + pet_tag + ", bio=" + bio
				+ ", pet_profile_picture=" + pet_profile_picture + ", owner=" + owner + "]";
	}
	
}
