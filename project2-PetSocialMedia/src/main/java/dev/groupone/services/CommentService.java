package dev.groupone.services;

import java.util.List;

import dev.groupone.beans.Comment;
import dev.groupone.beans.Post;

public interface CommentService {

	
	public Comment addComment(Comment post);
	public Post getComment(int id);
	//add special get methods here
	public List<Comment> getAllComment();
	public Comment updateComment(Comment change);
	public boolean deleteComment(int id);
}
