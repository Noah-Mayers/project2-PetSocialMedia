package dev.groupone.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dev.groupone.beans.Comment;
import dev.groupone.beans.Post;

public interface CommentRepo extends CrudRepository<Comment, Integer>{
	
	List<Comment> findByPost(Post post);

}
