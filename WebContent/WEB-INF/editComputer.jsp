
<!DOCTYPE html>
<html>
<head>
<title>Computer Database</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
    <link href="/Application-training/front/CSS/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="/Application-training/front/CSS/font-awesome.css" rel="stylesheet" media="screen">
	<link href="/Application-training/front/CSS/main.css" rel="stylesheet" media="screen">
</head>
<body>
    <header class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <a class="navbar-brand" href="/Application-training/dashboard"> Application - Computer Database </a>
        </div>
    </header>
    <section id="main">
        <div class="container">
            <div class="row">
                <div class="col-xs-8 col-xs-offset-2 box">
                    <div class="label label-default pull-right">
                    </div>
                    <h1>Edit Computer ${computerDTO.getName()}</h1>

                        <input type="hidden" value="0" id="id"/> <!-- TODO: Change this value with the computer id -->
         
                        
                    <form action="/Application-training/editcomputer" method="POST">
                      
                        <fieldset>
                            <div class="form-group">
                                <label for="computerName">Computer name</label>
                                <input type="text" class="form-control" id="computerName" name="NameComputer" placeholder="Name computer" value="${computerDTOList.get(0).getName()}">
                            </div>
                            <div class="form-group">
                            
                            
                                <label for="introduced">Introduced date</label>
                                <input type="date" class="form-control" id="introduced" name="introducedDate" placeholder="Date introduced" value="${computerDTOList.get(0).getIntroduced()}">
                            </div>
                            
                            <div class="form-group">
                                <label for="discontinued">Discontinued date</label>
                                <input type="date" class="form-control" id="discontinued"  name="discontinuedDate" placeholder="Date discontinued" value="${computerDTOList.get(0).getDiscontinued()}">
                            </div>
                           
                            <div class="form-group">
                                <label for="companyId">Company</label>
                                <select class="form-control" id="companyId"  name="companyComputerName">
                                    <option selected="selected">${companyName}</option>
                                    <taglib:forEach items="${companyNames}" var="company">
 							  	    <option value="${company}">${company}</option>
                    			    </taglib:forEach>
                   				 
                                    
                                </select>
                            </div>            
                        </fieldset>
                        <div class="actions pull-right">
                            <input type="submit" value="edit" class="btn btn-primary">
                            or
                            <a href="dashboard.html" class="btn btn-default">Cancel</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
</body>
</html>