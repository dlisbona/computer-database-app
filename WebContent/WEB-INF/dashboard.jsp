<!DOCTYPE html>

<html>
<head>


<title>Computer Database</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<!-- Bootstrap -->
    <link href="/Application-training/front/CSS/bootstrap.css" rel="stylesheet" media="screen">
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
            <h1 id="homeTitle">
            <taglib:out value="${computerListTotalLenght}"></taglib:out>
            <a > Ordinateurs </a>
            </h1>
            <div id="actions" class="form-horizontal">
                <div class="pull-left">
                    <form id="searchForm" action="#" method="GET" class="form-inline" >

                        <input type="search" id="searchbox" name="search" class="form-control" placeholder="Search name" />
                       
                        <input type="submit" id="searchsubmit" value="Filter by name"
                        
                        class="btn btn-primary" />
                    </form>
                </div>
                <div class="pull-right">
                    <a class="btn btn-success" id="addComputer" href="/Application-training/addcomputer">Add Computer</a> 
                    <a class="btn btn-default" id="editComputer" href="#" onclick="$.fn.toggleEditMode();">Edit</a>
                </div>
            </div>
        </div>
        
        <form id="deleteForm" action="#" method="GET" >
            <input type="hidden" name="selection" value="">
        </form>
        

        <div class="container" style="margin-top: 10px;">
        
            <table class="table table-striped table-bordered" pagesize="3">
                <thead>
                    <tr>
                        <!-- Variable declarations for passing labels as parameters -->
                        <!-- Table header for Computer Name -->

                        <th class="editMode" style="width: 60px; height: 22px;">
                            <input type="checkbox" id="selectall" /> 
                            <span style="vertical-align: top;">
                                 -  <a href="#" id="deleteSelected" onclick="$.fn.deleteSelected();">
                                        <i class="fa fa-trash-o fa-lg"></i>
                                    </a>
                            </span>
                        </th>
         
                        <th>
							<form id="Computer name" action="#" method="POST">
								<input type="button" class="btn-none" name="Computer name"  value ="Sort">
							</form>
						</th>
						
                        <th>
                        	<form id="Introduced date" action="#" method="POST">
								<input type="button" class="btn-none" name="Introduced date"  value ="Introduced date">
							</form> 
                        </th>

                        <th>
                        	<form id="Discontinued date" action="#" method="POST">
								<input type="button" class="btn-none" name="Discontinued date"  value ="Discontinued date">
							</form>
                        </th>
                        <!-- Table header for Company -->
                        <th>
                        <form id="Company" action="#" method="POST">
								<input type="button" class="btn-none" name="Company"  value ="Company">
							</form>
                            
                        </th>

                    </tr>
                </thead>
                <!-- Browse attribute computers -->
                
                <tbody id="results">
				
				
				<taglib:forEach items="${computerListTotal}" var="computer">
                   
                    <tr>
                        <td class="editMode">
                            <input type="checkbox" name="cb" class="cb" value="${computer.getId()}">
                        </td>
                        <td>
                            <a href="/Application-training/editcomputer?computerId=${computer.getId()}&computerName=${computer.getName()}" onclick="">${computer.getName()}</a>
                        </td>
    					
                        <td>${computer.getIntroduced()}</td>
                        <td>${computer.getDiscontinued()}</td>
                        <td>${computer.getCompanyName()}</td>
                    </tr>
                    </taglib:forEach>
                    
                    
                  
                    
                </tbody>
            </table>
        </div>
    </section>
    

    <footer class="navbar-fixed-bottom">

        <div class="container text-center">
            <ul class="pagination">
                <li>
                    <a href="/Application-training/dashboard?page=previous" aria-label="Previous">
                     <taglib:remove var="computerListTotal" scope="session" />
                      <span aria-hidden="true">&laquo;</span>
                  </a>
                 
              </li>
              <li><a href="#">1</a></li>
              <li><a href="#">2</a></li>
              <li><a href="#">3</a></li>
              <li><a href="#">4</a></li>
              <li><a href="#">5</a></li>
              <li>
										
 					<a href="/Application-training/dashboard?page=next" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>

        <div class="btn-group btn-group-sm pull-right" role="group" >
   
        	<a href="/Application-training/dashboard?pageLenght=10" class="btn btn-default" > 10 </a>
        	<a href="/Application-training/dashboard?pageLenght=50" class="btn btn-default" > 50 </a>
        	<a href="/Application-training/dashboard?pageLenght=100" class="btn btn-default" > 100 </a>
        	
<!--         	<button href="/Application-training/dashboard?pageLenght=10" type="button" class="btn btn-default">10</button> -->
<!--             <button href="/Application-training/dashboard?pageLenght=10" type="button" class="btn btn-default">10</button> -->
<!--             <button href="/Application-training/dashboard?pageLenght=50" type="button" class="btn btn-default">50</button> -->
<!--             <button href="/Application-training/dashboard?pageLenght=50" type="button" class="btn btn-default">100</button> -->
        </div>

    </footer>
<script src="/Application-training/front/javascript/jquery.min.js"></script>
<script src="/Application-training/front/javascript/bootstrap.min.js"></script>
<script src="/Application-training/front/javascript/dashboard.js"></script>

</body>
</html>