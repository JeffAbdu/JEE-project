package com.octest.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.beans.Auteur;


@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = (String) request.getParameter("name");
		request.setAttribute("name", name);
		String[] noms = {"Todd","Mike","Jeff"};
		request.setAttribute("noms", noms);
		
		
		Auteur auteur = new Auteur();
		auteur.setNom("Bozniak");
		auteur.setPrenom("Todd");
		auteur.setActif(true);
		request.setAttribute("auteur", auteur);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Bonjour.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
