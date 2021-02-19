package dev.groupone.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.groupone.beans.User;
import dev.groupone.repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo urep;
	
	@Override
	public User addUser(User user) {
		return urep.save(user);
	}

	@Override
	public User getUser(int id) {
		return urep.findById(id).get();
	}
	
	@Override
	public User getUser(String username) {
		return urep.findByUsername(username);
	}


	@Override
	public List<User> getAllUsers() {

		return (List<User>)urep.findAll();
	}

	@Override 
	public User updateUser(User change) {
		return urep.save(change);
	}
	@Override
	public boolean deleteUser(int id) {
		try {
			urep.delete(urep.findById(id).get());
			return true;
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

	
}
