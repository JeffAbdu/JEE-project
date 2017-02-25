<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Accueil</title>
    </head>
    <body>
    <%@ include file="menu.jsp"%>
 
     <p>Bienvenu sure mon site !</p>
 
 	  <c:if test="${ !empty sessionScope.prenom && !empty sessionScope.nom }"><p>You are ${ sessionScope.prenom } ${ sessionScope.nom }</p></c:if>	
		
 
    </body>
</html>