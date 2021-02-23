package dev.groupone.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import dev.groupone.beans.Comment;
import dev.groupone.beans.Post;
import dev.groupone.beans.User;
import dev.groupone.repositories.CommentRepo;

@SpringBootTest(classes = dev.mayers.SpringMVC.PetSocialMediaApplication.class)
class CommentServiceTests {

	@MockBean
	CommentRepo cr;
	
	@Autowired
	CommentService cs;
	
	@Test
	void addComment() {
		Post post = new Post();
		User author = new User();
		Timestamp timestamp = new Timestamp(0);
		Comment c = new Comment(1, post, author, "body",  timestamp);
		Mockito.when(cr.save(c)).thenReturn(new Comment(c.getId(), c.getPost(), c.getAuthor(), c.getBody(), c.getPosted()));
		
		c = cs.addComment(c);
		Assertions.assertEquals(1, c.getId());
		Assertions.assertEquals(post, c.getPost());
		Assertions.assertEquals(author, c.getAuthor());
		Assertions.assertEquals("body", c.getBody());
		Assertions.assertEquals(timestamp, c.getPosted());
	}
	
	@Test
	void getComment() {
		Post post = new Post();
		User author = new User();
		Timestamp timestamp = new Timestamp(0);
		Comment c = new Comment(1, post, author, "body",  timestamp);
		Mockito.when(cr.save(c)).thenReturn(new Comment(c.getId(), c.getPost(), c.getAuthor(), c.getBody(), c.getPosted()));
			
		c = cs.addComment(c);
		Assertions.assertEquals(1, c.getId());
		Assertions.assertEquals(post, c.getPost());
		Assertions.assertEquals(author, c.getAuthor());
		Assertions.assertEquals("body", c.getBody());
		Assertions.assertEquals(timestamp, c.getPosted());
	}
	
	@Test
	void getAllComments() {
		Post post = new Post();
		User author = new User();
		Timestamp timestamp = new Timestamp(0);
		Comment c = new Comment(1, post, author, "body",  timestamp);
		Comment d = new Comment(2, post, author, "body2",  timestamp);
		List<Comment> commentList = new ArrayList<Comment>();
		commentList.add(c);
		commentList.add(d);
		
		Mockito.when(cs.getAllComment()).thenReturn(commentList);
		
		c = commentList.get(0);
		Assertions.assertEquals(1, c.getId());
		Assertions.assertEquals(post, c.getPost());
		Assertions.assertEquals(author, c.getAuthor());
		Assertions.assertEquals("body", c.getBody());
		Assertions.assertEquals(timestamp, c.getPosted());
		
		d = commentList.get(1);
		Assertions.assertEquals(2, d.getId());
		Assertions.assertEquals(post, d.getPost());
		Assertions.assertEquals(author, d.getAuthor());
		Assertions.assertEquals("body2", d.getBody());
		Assertions.assertEquals(timestamp, d.getPosted());
	}
	
	@Test
	void getAllCommentsByPost() {
		Post post = new Post();
		User author = new User();
		Timestamp timestamp = new Timestamp(0);
		Comment c = new Comment(1, post, author, "body",  timestamp);
		Comment d = new Comment(2, post, author, "body2",  timestamp);
		List<Comment> commentList = new ArrayList<Comment>();
		commentList.add(c);
		commentList.add(d);
		
		Mockito.when(cs.getAllComment()).thenReturn(commentList);
		
		c = commentList.get(0);
		Assertions.assertEquals(1, c.getId());
		Assertions.assertEquals(post, c.getPost());
		Assertions.assertEquals(author, c.getAuthor());
		Assertions.assertEquals("body", c.getBody());
		Assertions.assertEquals(timestamp, c.getPosted());
		
		d = commentList.get(1);
		Assertions.assertEquals(2, d.getId());
		Assertions.assertEquals(post, d.getPost());
		Assertions.assertEquals(author, d.getAuthor());
		Assertions.assertEquals("body2", d.getBody());
		Assertions.assertEquals(timestamp, d.getPosted());
	}
	
	@Test
	void deleteComment() {
		Post post = new Post();
		User author = new User();
		Timestamp timestamp = new Timestamp(0);
		Comment c = new Comment(1, post, author, "body",  timestamp);
		
		Mockito.when(cs.updateComment(c)).thenReturn(c);
	}
	
	@Test
	void updateComment() {
		Post post = new Post();
		User author = new User();
		Timestamp timestamp = new Timestamp(0);
		Comment c = new Comment(1, post, author, "body",  timestamp);
		Mockito.when(cs.updateComment(c)).thenReturn(c);
		
		c = cs.updateComment(c);
		Assertions.assertEquals(1, c.getId());
		Assertions.assertEquals(post, c.getPost());
		Assertions.assertEquals(author, c.getAuthor());
		Assertions.assertEquals("body", c.getBody());
		Assertions.assertEquals(timestamp, c.getPosted());
	}
}
