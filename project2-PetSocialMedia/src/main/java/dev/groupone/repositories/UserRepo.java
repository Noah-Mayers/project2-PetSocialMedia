package dev.groupone.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



import dev.groupone.beans.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
	
	User findByUsername(String username);

}
