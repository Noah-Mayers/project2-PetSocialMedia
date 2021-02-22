package dev.groupone.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.groupone.beans.Comment;
import dev.groupone.beans.Post;
import dev.groupone.repositories.CommentRepo;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentRepo cr;
	
	@Override
	public Comment addComment(Comment comment) {
		comment.setPosted(new java.sql.Timestamp(new java.util.Date().getTime()));
		return cr.save(comment);
	}

	@Override
	public Comment getComment(int id) {
		return cr.findById(id).get();
	}
	
	@Override
	public List<Comment> getAllCommentsForPost(Post post) {
		return (List<Comment>)cr.findByPost(post);
	}

	@Override
	public List<Comment> getAllComment() {
		return (List<Comment>) cr.findAll();
	}

	@Override
	public Comment updateComment(Comment change) {
		return cr.save(change);
	}

	@Override
	public boolean deleteComment(int id) {
		try {
			cr.delete(cr.findById(id).get());
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

	

}
