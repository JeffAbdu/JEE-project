<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login form</title>
</head>
<body>

  <p>From Cookie : </p><c:out value="${prenom}"></c:out>

 <c:if test="${ !empty form.resultat }"><p><c:out value="${form.resultat}"/></p></c:if> 

  <form method="post" action="testForm">
     <p>
      <label for="login">login : </label>
      <input type="text" name="login" id="login"/>
     </p>
     
     <p>
      <label for="pass">pass : </label>
      <input type="password" name="pass" id="pass"/>
     </p>
           
     
      
      <hr size="2" width="2"
			align="center" style="width: 723px; ">
			
	  <c:if test="${ !empty sessionScope.prenom && !empty sessionScope.nom }"><p>You are ${ sessionScope.prenom } ${ sessionScope.nom }</p></c:if>	
			
      <p>
          <label for="name">Nom: </label>
          <input type="text" name="nom" id="nom"/> 
      </p>	
      <p>
          <label for="prenom">Prenom: </label>
          <input type="text" name="prenom" id="prenom"/>         
      </p>
			
		  <input type="submit"/>
		  <p>list of the names:</p>
		  
		<ul>  
		  <c:forEach var="user" items="${ users }">
		      <li><c:out value="${ user.prenom }"/><c:out value="${ user.nom}"/></li>
		  </c:forEach>
		</ul>  
	</form>

</body>
</html>