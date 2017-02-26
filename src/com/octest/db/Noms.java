package com.octest.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.User;

public class Noms {

	private Connection connection = null; 
	
	public List<User> getUsers(){
		
		List<User> users = new ArrayList<User>();
	    
		loadDataBase();	    	
		
		// Data base connection:
		Statement statement = null;
		ResultSet result = null;
		
		try {
			
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT * FROM noms;"); 
			
			while(result.next()){
				String nom = result.getString("nom");
				String prenom = result.getString("prenom");
				User user = new User();
				user.setNom(nom);
				user.setPrenom(prenom);
				users.add(user);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
			try{
				if (result != null) result.close();
				if (statement != null) statement.close();
				if (connection != null) connection.close();
			}catch(SQLException ignore){			
			}	
		}
		return users;	
	}
	
	public void addUser(User user){
		loadDataBase();
		try{
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO noms(nom, prenom) VALUES (?, ?);");
			preparedStatement.setString(1, user.getNom());
			preparedStatement.setString(2, user.getPrenom());
			preparedStatement.executeUpdate();
		}catch(SQLException e){
		} 
	}
	
	private void loadDataBase(){
		
		// Load the driver:
				try{
					Class.forName("com.mysql.jdbc.Driver");
				}catch(ClassNotFoundException e){			
				}
				try{
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee","root","1234");		
				}catch(SQLException e){
					
				}
	}

	
}
