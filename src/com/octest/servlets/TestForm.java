package com.octest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.octest.beans.BeanException;
import com.octest.beans.User;
import com.octest.dao.DaoException;
import com.octest.dao.DaoFactory;
import com.octest.dao.UserDao;
import com.octest.db.Noms;
import com.octest.forms.ConnectionForm;

@WebServlet("/TestForm")
public class TestForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao userDao;
	
	public TestForm() {
		super();
	}
	
	public void init() throws ServletException{
		DaoFactory doaFactory = DaoFactory.getInstance();
	    this.userDao = doaFactory.getUserDao();  // Equivalent to: this.userDao = new UserDaoImpl(daoFactory); 
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*  To get session from the servlet
		HttpSession session = request.getSession(); // don't create a session, just assign the session that comes with the request
		String prenom = (String) session.getAttribute("prenom");
		// we can delete a session by: 
		     session.invalidate();
		  */   
		
		Cookie[] cookies = request.getCookies();
	    
		if(cookies != null){
			for(Cookie cookie: cookies){
				if(cookie.getName().equals("prenom")){
					request.setAttribute("prenom", cookie.getValue());
				}
			}
		}
		    
		try{
           request.setAttribute("users", userDao.getUsers());
		}catch(DaoException e){
		   request.setAttribute("error", e.getMessage());
		}       
		this.getServletContext().getRequestDispatcher("/WEB-INF/BonjourForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Password checking:
		ConnectionForm form = new ConnectionForm();
		form.verifierIdentifiants(request);
		request.setAttribute("form", form);		
		
		// Setting a session:
			String nom, prenom;
			HttpSession session = request.getSession();
			
			nom = request.getParameter("nom");
			session.setAttribute("nom", nom);
		
			prenom = request.getParameter("prenom");
			session.setAttribute("prenom", prenom);
 
		
		// Cookie creation:
			Cookie cookie = new Cookie("prenom", prenom);
			cookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookie);
            
          // Add a user:
           try{
            User user = new User();
            user.setNom(request.getParameter("nom"));
            user.setPrenom(request.getParameter("prenom"));
            userDao.addUser(user);
            request.setAttribute("users", userDao.getUsers());
           }catch(BeanException e1){
        	   request.setAttribute("error", e1.getMessage());
           }catch(DaoException e2){
        	   request.setAttribute("error", e2.getMessage());
           }
           
		this.getServletContext().getRequestDispatcher("/WEB-INF/BonjourForm.jsp").forward(request, response);
	}

}
