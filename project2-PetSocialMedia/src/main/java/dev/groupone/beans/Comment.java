package dev.groupone.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {
	
	@Id
	@Column(updatable = false)
	@SequenceGenerator(name = "COMMENT_SEQ", sequenceName = "COMMENT_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "COMMENT_SEQ", strategy = GenerationType.SEQUENCE)
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name = "post")
	private Post post;
	
	
	@ManyToOne
	@JoinColumn(name = "author")
	private User author;
	
	
	private String body;
	
	private java.sql.Timestamp posted;
	
	

}