
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Test</title>
    </head>
    <body>
    <p><c:out value="Bonjour JSTL !" /></p>
    <%@ include file="menu.jsp"%>
    <p>Bonjour ${ !empty name? name : ''}</p>
    <p>${ noms[3] }</p>
    <p> Auteur: ${ auteur.nom } ${ auteur.prenom }</p>
    <p> ${ auteur.actif? 'Vous etes tres actif !' : 'Vous etes inactif !' }</p>
    </body>
</html>