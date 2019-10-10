<!DOCTYPE html>
<html>
    <head>

<script src="js/app-ajax.js" type="text/javascript"></script>
        <title>Test</title>
                <title>SO question 4112686</title>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script>
                
        $(document).on("click", "#somebutton", function() {  // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
            $.get("someservlet", function(responseJson) {    // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
                var $ul = $("<ul>").appendTo($("#somediv")); // Create HTML <ul> element and append it to HTML DOM element with ID "somediv".
                $.each(responseJson, function(index, item) { // Iterate over the JSON array.
                    $("<li>").text(item).appendTo($ul);      // Create HTML <li> element, set its text content with currently iterated item and append it to the <ul>.
                });
            });
        });
        
        
        
        
        
        $(document).ready(function() {
        $('#userName').blur(function(event) {
                var name = $('#userName').val();
                $.get('connexion', {
                        userName : name
                }, function(responseText) {
                        $('#ajaxWebAppGetConnexionResponse').text(responseText);
                });
        });
});
        
        </script>
    </head>

    <body>
    <button id="somebutton">press here</button>
        <div id="somediv"></div>
        <p>Ceci est une page générée depuis une JSP.</p>
         <p>Attribute que dis-tu ? ${ empty test ? 'rien à dire' : test }</p>
       
        
         <taglib:set var="pseudo" value="Mathieu" />
         
		<p><taglib:out value="${auteur}" /></p>
		
		
	<form>
		Enter Your Name: <input type="text" id="userName" />
	</form>
	<br>
	<br>

	<strong>Ajax Response</strong>:<div id="ajaxWebAppGetConnexionResponse"></div>
	
		
    </body>
    <script src="/Application-training/front/javascript/jquery.min.js"></script>
	<script src="/Application-training/front/javascript/ajaxValidator.js"></script>
    <footer>
    </footer>
</html>
         