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
@Table(name = "pets")
public class Pet {

	@Id
	@Column(updatable = false)
	@SequenceGenerator(name = "PET_SEQ", sequenceName = "PET_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "PET_SEQ", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(nullable = false, name = "pet_name")
	private String name;
	
	@Column(nullable = false, name = "pet_tag", unique = true)
	private String tag;
	
	@Column(nullable = true, name = "bio")
	private String bio;
	
	@ManyToOne
	@JoinColumn(name = "pet_profile_picture")
	private Image profilePicture;
	
	
	//@Column(nullable = false, name = "pet_owner")
	@ManyToOne
	@JoinColumn(name = "pet_owner")
	private User owner;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "pet_followers", joinColumns = @JoinColumn(name = "pet_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> followers;

	
	 @ManyToMany(fetch = FetchType.LAZY, mappedBy = "pets")
	 private List<Post> posts;
	
	
	public Pet(int id, String name, String tag, String bio, Image profilePicture, User owner,
			List<User> followers) {
		super();
		this.id = id;
		this.name = name;
		this.tag = tag;
		this.bio = bio;
		this.profilePicture = profilePicture;
		this.owner = owner;
		this.followers = followers;
	}

	public Pet(String name, String tag, String bio, Image profilePicture, User pet_owner, List<User> followers) {
		super();
		this.name = name;
		this.tag = tag;
		this.bio = bio;
		this.profilePicture = profilePicture;
		this.owner = pet_owner;
		this.followers = followers;
	}
	
	
	

	public Pet(String name, String tag, User pet_owner) {
		super();
		this.name = name;
		this.tag = tag;
		this.owner = pet_owner;
	}

	public Pet() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Image getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(Image profilePicture) {
		this.profilePicture = profilePicture;
	}

	public User getOwner() {
		return owner;
	}

	public void setPet_owner(User owner) {
		this.owner = owner;
	}

	public List<User> getFollowers() {
		return followers;
	}

	public void setFollowers(List<User> followers) {
		this.followers = followers;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", tag=" + tag + ", bio=" + bio + ", profilePicture="
				+ profilePicture + ", owner=" + owner + ", followers=" + followers + "]";
	}
	
	
	
	
	
}
