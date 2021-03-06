package dev.groupone.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.groupone.beans.Post;
import dev.groupone.repositories.PostRepo;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	PostRepo postr;

	@Override
	public Post addPost(Post post) {
		post.setPosted(new java.sql.Timestamp(new java.util.Date().getTime()));
		return postr.save(post);
	}

	@Override
	public Post getPost(int id) {
		return postr.findById(id).get();
	}

	@Override
	public List<Post> getAllPosts() {
		return (List<Post>) postr.findAll();
	}

	@Override
	public boolean deletePost(int id) {
		try {
			postr.delete(postr.findById(id).get());
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Post updatePost(Post change) {
		return postr.save(change);
	}
	
	

}
