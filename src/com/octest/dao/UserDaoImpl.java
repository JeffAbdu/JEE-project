package com.octest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.BeanException;
import com.octest.beans.User;

public class UserDaoImpl implements UserDao{
	private DaoFactory daoFactory;
	
	UserDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	public void addUser(User user) throws DaoException{
		Connection connection = null;
        PreparedStatement preparedStatement = null;
		
		try{
			connection = daoFactory.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO noms(nom, prenom) VALUES (?, ?);");
			preparedStatement.setString(1, user.getNom());
			preparedStatement.setString(2, user.getPrenom());
			preparedStatement.executeUpdate();
			connection.commit();
			
		}catch(SQLException e1){
			try{
				if(connection != null){
					connection.rollback();
				}
			}catch(SQLException e2){
				   throw new DaoException("Connection issue with data base!");
			}			
		}finally{
				try{
					if(connection != null){
						connection.close();
					}
				}catch(SQLException e){
				   throw new DaoException("Connection issue with data base!");	
				}
		}
	}
	
	public List<User> getUsers() throws DaoException{
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		List<User> users = new ArrayList<User>();
		
		try {
			connection = daoFactory.getConnection();
	        statement = connection.createStatement();
	        result = statement.executeQuery("SELECT * FROM noms");
	        
			while(result.next()){
				String nom = result.getString("nom");
				String prenom = result.getString("prenom");
				User user = new User();
				user.setNom(nom);
				user.setPrenom(prenom);
				users.add(user);
			}
	        
		} catch (SQLException e) {
			 throw new DaoException("Connection issue with data base!");
		}catch(BeanException e2){
			 throw new DaoException(e2.getMessage());
		}finally{
			try{
				if (result != null) result.close();
				if (statement != null) statement.close();
				if (connection != null) connection.close();				
			}catch(SQLException ignore){	
			   throw new DaoException("Connection issue with data base!");
			}
		}
		return users;
	}

	
}
