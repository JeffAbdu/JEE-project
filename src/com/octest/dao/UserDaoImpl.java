package com.octest.dao;

import java.util.ArrayList;
import java.util.List;

import com.octest.beans.User;

public class UserDaoImpl implements UserDao{
	private DaoFactory daoFactory;
	
	UserDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	public void addUser(){
		
	}
	
	public List<User> getUsers(){
		
		List<User> users = new ArrayList<User>();
		
		return users;
	}

	
}
