package com.octest.beans;

public class User {

	 private String nom;
	 private String prenom;
	 
	public String getNom(){
		// commented code would be added only if we want to check if the field nom is not empty
//		if(nom.length()==0){
//			throw new BeanException("The nom filed is empty!!");
//		}else		
	 	   return nom;
	}
	public void setNom(String nom) throws BeanException{
		if(nom.length()>10){  
		    throw new BeanException("The name is too big! (10 characters maximum)");	
		}else{
			this.nom = nom;	
		}		
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	 
	 
}
