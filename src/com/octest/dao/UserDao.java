package com.octest.dao;

import java.util.List;

import com.octest.beans.User;

public interface UserDao {

	public void addUser();
	
	List<User> getUsers();
	
}
