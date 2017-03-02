package com.octest.dao;

import java.util.List;

import com.octest.beans.BeanException;
import com.octest.beans.User;

public interface UserDao {

	public void addUser(User user) throws DaoException, BeanException;
	
	List<User> getUsers() throws DaoException;
	
}
