package dev.groupone.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.groupone.beans.Comment;
import dev.groupone.beans.Post;


@Repository
public interface CommentRepo extends CrudRepository<Comment, Integer>{
	
	List<Comment> findByPost(Post post);

}
