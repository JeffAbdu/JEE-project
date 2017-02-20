<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login form</title>
</head>
<body>

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
           
      <input type="submit" value="Submit name" />
  </form>

</body>
</html>