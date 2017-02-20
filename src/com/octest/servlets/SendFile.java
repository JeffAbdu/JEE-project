package com.octest.servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/SendFile")
public class SendFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public static final int TAILLE_TAMPON = 10240;
    public static final String FILE_PATH = "C:/Users/Abdu Jeff/Documents/Job/JAVA/MuleSoft/Middleware Fundamentals/XQuery/XQuery projects/JEETutorial/WebContent/Files";  // to be changed
    
	
    public SendFile() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/SendFile.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the description from the request:
		String description = request.getParameter("description");
		request.setAttribute("description", description);
		
		// Get the field of the file: 
		Part part = request.getPart("FileUpload");
		
		// Check that the file was well received: (Get the file name from the HTTP header)
		String fileName = getNomFichier(part);		
		
		// If we received the file:  
		    if( fileName != null && !fileName.isEmpty()){
		    	String fieldName = part.getName();
		    	
		    	// correct a bug of Internet explorer functioning
		    	fileName = fileName.substring(fileName.lastIndexOf('/') + 1)
	                    .substring(fileName.lastIndexOf('\\') + 1);
		    	
		    	// We write the file on the disk:
		    	ecrireFichier( part, fileName, FILE_PATH);
		        
		    	request.setAttribute(fieldName, fileName);
		    }
		this.getServletContext().getRequestDispatcher("/WEB-INF/SendFile.jsp").forward(request, response);
		
	}

	// Writing the file into the target path by going through a temporary location:
    private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
            entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
            sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);
            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur;
            while ((longueur = entree.read(tampon)) > 0) {
                sortie.write(tampon, 0, longueur);
            }
        } finally {
            try {
                sortie.close();
            } catch (IOException ignore) {
            }
            try {
                entree.close();
            } catch (IOException ignore) {
            }
        }
    }	
	
	// get the name of the file:
    private static String getNomFichier( Part part ) {
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( contentDisposition.trim().startsWith( "filename" ) ) {
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        return null;
    }   
    
}
