package dev.groupone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.groupone.beans.Comment;
import dev.groupone.beans.Post;
import dev.groupone.beans.User;
import dev.groupone.services.CommentService;
import dev.groupone.services.PostService;

@RestController
@Scope("session")
public class CommentController {

	
	@Autowired
	private PostService ps;
	
	@Autowired
	private CommentService cs;
	
	@Autowired
	LoginController lc;
	
	
	
	
	
	
	/**
	 * gets post with the given id
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/comments/{id}", produces = "application/json")
	public Comment getComment(@PathVariable("id") String id) {
		//gets the user with the given id
		return cs.getComment(Integer.parseInt(id));
	}
	
	/**
	 * gets all comments in the system
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/comments", produces = "application/json")
	public List<Comment> getAllComments(@PathVariable("id") String id) {
		//gets the user with the given id
		return cs.getAllComment();
	}
	
	
	@GetMapping(value = "/comments/post/{id}", produces = "application/json")
	public List<Comment> getPostsComments(@PathVariable("id") String id) {
		//gets the user with the given id
		Post post = ps.getPost(Integer.parseInt(id));
		return cs.getAllCommentsForPost(post);
	}
	
	
	
	/**
	 * in the body, at least attach the correct post id to the comment
	 * nothing else required will be overwritten anyway. 
	 * @param newComment
	 * @param id the id of the post the comment will be posted to
	 * @return
	 */
	@PostMapping(value = "/comments", consumes = "application/json", produces = "application/json")
	public Comment addCommentToPost(@RequestBody Comment newComment) { //@PathVariable("id") int id, 
		System.out.println("in the adding a  comment post method..");
		System.out.println(newComment);
		User loggedInUser = lc.getLoggedInUser();
		newComment.setAuthor(loggedInUser);
		if(loggedInUser.getId() == 0) {
			return newComment;
		}
		Post commentPost = ps.getPost(newComment.getPost().getId());
		newComment.setPost(commentPost);
		return cs.addComment(newComment);
	}
	
	
	
	
	@DeleteMapping(value = "/comments/{id}", consumes = "application/json", produces = "application/json")
	public Comment deleteComment(@PathVariable("id") int id) {
		Comment out = cs.getComment(id);
		cs.deleteComment(id);
		return out;
	}
	
}
