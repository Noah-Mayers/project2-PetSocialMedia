package dev.groupone.services;

import java.util.List;

import dev.groupone.beans.Comment;


public interface CommentService {

	
	public Comment addComment(Comment comment);
	public Comment getComment(int id);
	//add special get methods here
	public List<Comment> getAllComment();
	public Comment updateComment(Comment change);
	public boolean deleteComment(int id);
}
