package dev.groupone.services;

import java.util.List;

import dev.groupone.beans.User;

public interface UserService {
	
	public User addUser(User user);
	public User getUser(int id);
	//add special get methods here
	public User getUser(String username);
	public List<User> getAllUsers();
	public boolean deleteUser(int id);
	public User updateUser(User change);


}
