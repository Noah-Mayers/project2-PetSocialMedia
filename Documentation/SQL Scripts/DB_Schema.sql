-- starting script 
--dropping entangling constraints
ALTER TABLE users  					DROP CONSTRAINT profile_picture_fk;
ALTER TABLE pets 					DROP CONSTRAINT pet_owner_fk;
ALTER TABLE pets 					DROP CONSTRAINT pet_profile_picture_fk;
ALTER TABLE pet_followers 			DROP CONSTRAINT user_id_fk;
ALTER TABLE pet_followers			DROP CONSTRAINT pet_id_fk;
ALTER TABLE posts 		 			DROP CONSTRAINT author_fk;
ALTER TABLE posts 					DROP CONSTRAINT picture_fk;
ALTER TABLE pets_tagged_in_posts	DROP CONSTRAINT pet_id_fk;
ALTER TABLE pets_tagged_in_posts 	DROP CONSTRAINT post_id_fk;
ALTER TABLE post_likes 				DROP CONSTRAINT user_id_fk;
ALTER TABLE post_likes 				DROP CONSTRAINT post_id_fk;
ALTER TABLE comments 				DROP CONSTRAINT author_fk;
ALTER TABLE comments 				DROP CONSTRAINT post_fk;
-- constraints dropped 

-- droping tables
DROP TABLE images;
DROP TABLE users;
DROP TABLE pets;
DROP TABLE pet_followers;
DROP TABLE posts;
DROP TABLE pets_tagged_in_posts;
DROP TABLE post_likes;
DROP TABLE comments;
-- tables dropped 


-- dropping sequences
DROP SEQUENCE user_seq;
DROP SEQUENCE pet_seq;
DROP SEQUENCE post_seq;
DROP SEQUENCE image_seq;
DROP SEQUENCE comment_seq;
-- sequences dropped



-- making tables


CREATE TABLE images (
	id  		INT PRIMARY KEY,
	image_url	varchar(100) NOT NULL UNIQUE
);

CREATE TABLE users (
	id  				INT PRIMARY KEY,
	email 				VARCHAR(50) NOT NULL UNIQUE, 
	username 			VARCHAR(50) NOT NULL UNIQUE,
	account_password 	VARCHAR(30) NOT NULL,
	bio					VARCHAR(280),
	profile_picture		INT
);




CREATE TABLE pets (
	id  				INT PRIMARY KEY,
	pet_name 			VARCHAR(50) NOT NULL,
	pet_tag 			VARCHAR(20) NOT NULL UNIQUE,
	pet_owner			INT NOT NULL,
	bio					VARCHAR(280),
	pet_profile_picture	INT
);





CREATE TABLE pet_followers (
	user_id		INT NOT NULL,
	pet_id		INT NOT NULL
);



CREATE TABLE posts (
	id  				INT PRIMARY KEY,
	author				INT NOT NULL,
	caption				VARCHAR(280),
	picture				INT,
	posted				TimeStamp
);

CREATE TABLE comments (
	id		INT PRIMARY KEY,
	post	INT NOT NULL,
	author 	INT NOT NULL,
	body 	VARCHAR(280),
	posted	TimeStamp
);



CREATE TABLE pets_tagged_in_posts (
	pet_id INT NOT NULL, 
	post_id INT NOT NULL
);




CREATE TABLE post_likes (
	user_id		INT NOT NULL,
	post_id		INT NOT NULL
);


-- tables made

-- adding fk constraints
ALTER TABLE users 	ADD CONSTRAINT profile_picture_fk FOREIGN KEY (profile_picture) REFERENCES images (id)
																					ON DELETE SET NULL;

ALTER TABLE pets 					ADD CONSTRAINT pet_owner_fk FOREIGN KEY (pet_owner) REFERENCES users (id)
																					ON DELETE CASCADE;
ALTER TABLE pets 					ADD CONSTRAINT pet_profile_picture_fk FOREIGN KEY (pet_profile_picture) REFERENCES images (id)
																					ON DELETE SET NULL;

ALTER TABLE pet_followers 			ADD CONSTRAINT user_id_fk FOREIGN KEY (user_id) REFERENCES users (id)
																					ON DELETE CASCADE;
ALTER TABLE pet_followers 			ADD CONSTRAINT pet_id_fk FOREIGN KEY (pet_id) REFERENCES pets (id)
																					ON DELETE CASCADE;

ALTER TABLE posts 					ADD CONSTRAINT author_fk FOREIGN KEY (author) REFERENCES users (id)
																					ON DELETE CASCADE;
ALTER TABLE posts 					ADD CONSTRAINT picture_fk FOREIGN KEY (picture) REFERENCES images (id)
																					ON DELETE SET NULL;

ALTER TABLE pets_tagged_in_posts	ADD CONSTRAINT pet_id_fk FOREIGN KEY (pet_id) REFERENCES pets (id)
																					ON DELETE CASCADE;
ALTER TABLE pets_tagged_in_posts	ADD CONSTRAINT post_id_fk FOREIGN KEY (post_id) REFERENCES posts (id)
																					ON DELETE CASCADE;

ALTER TABLE post_likes 				ADD CONSTRAINT user_id_fk FOREIGN KEY (user_id) REFERENCES users (id)
																					ON DELETE CASCADE;
ALTER TABLE post_likes 				ADD CONSTRAINT post_id_fk FOREIGN KEY (post_id) REFERENCES posts (id)
																					ON DELETE CASCADE;
																				
ALTER TABLE comments 				ADD CONSTRAINT author_fk FOREIGN KEY (author) REFERENCES users (id)
																					ON DELETE CASCADE;
ALTER TABLE comments 				ADD CONSTRAINT post_fk FOREIGN KEY (post) REFERENCES posts (id)
																					ON DELETE CASCADE;
																				
																				
																				
																				
-- finished Fk's 
-- making sequences
CREATE SEQUENCE user_seq
	INCREMENT 1
	START 1;
CREATE SEQUENCE pet_seq
	INCREMENT 1
	START 1;
CREATE SEQUENCE post_seq
	INCREMENT 1
	START 1;
CREATE SEQUENCE image_seq
	INCREMENT 1
	START 1;
CREATE SEQUENCE comment_seq
	INCREMENT 1
	START 1;
--made sequences 

-- end of script