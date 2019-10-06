<!DOCTYPE html>
<html>
    <head>
        <title>Test</title>
    </head>

    <body>
    
        <p>Ceci est une page générée depuis une JSP.</p>
         <p>Attribute que dis-tu ? ${ empty test ? 'rien à dire' : test }</p>
       
        
         <taglib:set var="pseudo" value="Mathieu" />
         
		<p><taglib:out value="${auteur}" /></p>
		
    </body>
    
</html>
         