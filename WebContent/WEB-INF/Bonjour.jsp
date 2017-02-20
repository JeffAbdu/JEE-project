
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Test</title>
    </head>
    <body>
    

    
    
    <!--  Loops -->
    <c:forEach var="i" begin="0" end="2" step="1">
      <p> a message n# <c:out value="${i}"></c:out>!</p>
    </c:forEach>
    
    <c:forEach items="${titles}" var="title" begin="0" end="1" varStatus="status">
       <p> index: <c:out value="${status.index}"/> , count: <c:out value="${status.count}"/>, value : <c:out value="${ title }"/> ! </p>
    </c:forEach>
    
       <!-- loop for chars  -->
        <c:forTokens var="piece" items="piece1 piece11/piece2 piece22/piece3 piece33" delims="/ ">
            <p>${ piece }</p>
        </c:forTokens>
       
       
    <!-- Conditions with JSTL -->    
    <c:if test="${ 10 > 5 }" var="var1" scope="application"> condition is true </c:if>
    <br/>
    <c:choose>
        <c:when test="${ 10 > 5 }">10</c:when>
        <c:when test="${ 5 > 3}">3</c:when>
        <c:when test="${ 6 > 8}">6</c:when>
        <c:otherwise></c:otherwise>
    </c:choose>    

    <!--   Using Java beans with JSTL: -->
    <c:set target="${ auteur }" property="prenom" value="Todds"></c:set>
    <p><c:out value ="${ auteur.prenom }"></c:out></p>
    
    <!-- desplay the default value when the variable is empty: -->
    <p><c:out value="${ noms[10] }" escapeXml="false">default value</c:out></p>
    
    <!-- set and remove variables within JSTL: -->
    <c:set var="pseudo" value="Amar" scope="page"></c:set>
    <p><c:out value="${ pseudo }"></c:out></p>
    <c:set var="pseudo" scope="page">CRB</c:set>
    <p>again<c:out value="${ pseudo }"></c:out></p> 
    <c:remove var="pseudo" scope="page"/> 
    <p>removed<c:out value="${ pseudo }"></c:out></p>
    
    <!-- Using JSTL: -->
    <p><c:out value="Bonjour JSTL !" /></p>
    
    <!-- Including another jsp page: -->
    <%@ include file="menu.jsp"%>
    
    <!-- Java within HTML: -->
    <p>Bonjour ${ !empty name? name : ''}</p>
    <p>${ noms[3] }</p>
    <p> Auteur: ${ auteur.nom } ${ auteur.prenom }</p>
    <p> ${ auteur.actif? 'Vous etes tres actif !' : 'Vous etes inactif !' }</p>
    </body>
</html>