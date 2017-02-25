package com.octest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sessionTest")
public class sessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public sessionTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//this.getServletContext().getRequestDispatcher("/WEB-INF/sessionTest.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
//		String name = (String) request.getAttribute("name");
//		String lastName = (String) request.getAttribute("lastName");
//        
//		HttpSession session = request.getSession();
//		session.setAttribute(name, "name");
//		session.setAttribute(lastName, "lastName");
//		
		
		//this.getServletContext().getRequestDispatcher("/WEB-INF/sessionTest.jsp").forward(request, response);
		
	}

}
