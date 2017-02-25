<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Session Test</title>
</head>
<body>

 <!--
      <c:if test="${ !empty sessionScope.name && !empty sessionScope.lastName }">
           <p>You are ${ sessionScope.name } ${ sessionScope.lastName }</p>
      </c:if>
 -->    
      <form method="post" action="sessionTest" >        
         <p>
            <label for="name">Name:</label>
            <input type="text" name="name" id="name"/>
         </p>
         <p>
            <label for="lastName">Last name:</label>
            <input type="text" name="lastName" id="lastName"/>
         </p>
        
        <input type="submit" />
      </form>

</body>
</html>