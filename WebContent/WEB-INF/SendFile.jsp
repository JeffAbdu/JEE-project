<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sending a file</title>
</head>
<body>

     <c:if test="${ !empty file }"><p><c:out value = "the file ${ file } (${ description }) had been uploaded "/></p></c:if>
     <form method="post" action="SendFile" enctype="multipart/form-data">
        
         <p>
             <label for="FileDescription"> File Description:</label> 
             <input type="text" name="FileDescription" id="FileDescription" />
         </p>
         <p>
             <lable for="FileUpload">Upload the file: </lable>
             <input type="file" name="FileUpload" id="FileUpload" /> 
         </p> 
           
         <input type="submit" value="Submit uploading"/>  
     </form>
      
  

</body>
</html>