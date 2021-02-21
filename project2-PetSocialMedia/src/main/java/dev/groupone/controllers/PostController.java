package dev.groupone.controllers;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.groupone.beans.Comment;
import dev.groupone.beans.Pet;
import dev.groupone.beans.Post;
import dev.groupone.beans.User;
import dev.groupone.services.CommentService;
import dev.groupone.services.PetService;
import dev.groupone.services.PostService;


@RestController
@Scope("session")
public class PostController {
	
	@Autowired
	LoginController lc;
	
	@Autowired
	private PostService ps;
	
	@Autowired
	private CommentService cs;
	
	@Autowired
	private PetService petService;
	
	
	/**
	 * gets all posts in DB in a list
	 * @return
	 */
	@GetMapping(value = "/posts", produces = "application/json")
	public List<Post> getAllPosts() {
		return ps.getAllPosts(); 
	}
	
	/**
	 * Create a post. the poster will be the logged in user
	 * @param newPost
	 * @return
	 */
	@PostMapping(value = "/posts", consumes = "application/json", produces = "application/json")
	public Post createPost(@RequestBody Post newPost) {
		List<Pet> attachedPets = newPost.getPets();
		newPost.setPets(null);
		Post postedPost = ps.addPost(newPost);
		postedPost.setPets(attachedPets);
		ps.updatePost(postedPost);
		return postedPost;
	}
	
	
	
	
	/**
	 * gets post with the given id
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/posts/{id}", produces = "application/json")
	public Post getPost(@PathVariable("id") String id) {
		//gets the user with the given id
		return ps.getPost(Integer.parseInt(id));
	}
	
	/**
	 * edits or updates the post with the given id to the values given in the updatedPost in the put body
	 * @param id
	 * @param updatedPost
	 * @return
	 */
	@PutMapping(value = "/posts/{id}", consumes = "application/json", produces = "application/json")
	public Post updatePost( @PathVariable("id") int id, @RequestBody Post updatedPost) {
		updatedPost.setId(id);
		return ps.updatePost(updatedPost);
	}
	
	/**
	 * deletes the post with the given id in the path
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/posts/{id}")
	public boolean deletePost(@PathVariable("id") int id) {
		System.out.println("Executing Delete");
		
		return ps.deletePost(id);
	}
	
	/**
	 * Logged in user likes the post in the body / id given in path
	 * @param likedPost
	 * @return
	 */
	@PostMapping(value = "/posts/{id}/like", consumes = "application/json", produces = "application/json")
	public Post likePost(@RequestBody Post likedPost) {
		User loggedInUser = lc.getLoggedInUser();
		if(loggedInUser.getId() == 0) {
			return likedPost;
		}
		if(likedPost.getLikes().contains(loggedInUser)) {
			return likedPost;
		}
		likedPost.addUserLike(loggedInUser);
		return ps.updatePost(likedPost);
	}
	
	/**
	 * Logged in user unlikes the post in the body / id given in the path
	 * @param likedPost
	 * @return
	 */
	@DeleteMapping(value = "/posts/{id}/like", consumes = "application/json", produces = "application/json")
	public Post unlikePost(@RequestBody Post likedPost) {
		User loggedInUser = lc.getLoggedInUser();
		if(loggedInUser.getId() == 0) {
			return likedPost;
		}
		likedPost.removeUserLike(loggedInUser);
		return ps.updatePost(likedPost);
	}
	
	
	
	
	/**
	 * a search get request change variables when we get the variables we wnat to search by 
	 * @param name
	 * @param tag
	 * @param ownerName
	 * @param ownerId
	 * @return
	 */
	@GetMapping(value = "/posts/search", produces = "application/json")
	public List<Post> getUserByUsername(@RequestParam(required = false) String name, @RequestParam(required = false) String tag, 
										@RequestParam(required = false) String ownerName, @RequestParam(required = false) String ownerId ) {
		//returns the user with the given username
		return null;
	}
	
	

}
