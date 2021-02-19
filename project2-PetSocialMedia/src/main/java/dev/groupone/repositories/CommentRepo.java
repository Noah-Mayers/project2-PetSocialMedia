package dev.groupone.repositories;

import org.springframework.data.repository.CrudRepository;

import dev.groupone.beans.Comment;

public interface CommentRepo extends CrudRepository<Comment, Integer>{

}
