package dev.groupone.services;

import java.util.List;

import dev.groupone.beans.Post;

public interface PostService {

	
	public Post addPost(Post post);
	public Post getPost(int id);
	//add special get methods here
	public List<Post> getAllPosts();
	public boolean deletePost(int id);
}
