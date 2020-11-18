package com.app.dao;

import com.app.pojos.User;

public interface IUserDao {

	public String addUser(User u);
	User authenticateUser(String email,String pass);
	public User userSelected(int id);
}
