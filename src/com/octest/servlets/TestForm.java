package com.octest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.forms.ConnectionForm;


@WebServlet("/TestForm")
public class TestForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TestForm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/BonjourForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		 ConnectionForm form = new ConnectionForm();
		 form.verifierIdentifiants(request); 		
		request.setAttribute("form", form);
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/BonjourForm.jsp").forward(request, response);
	}

}
