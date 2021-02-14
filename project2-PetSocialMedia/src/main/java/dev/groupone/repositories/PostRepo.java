package dev.groupone.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.groupone.beans.Post;

@Repository
public interface PostRepo extends CrudRepository<Post, Integer> {

}
