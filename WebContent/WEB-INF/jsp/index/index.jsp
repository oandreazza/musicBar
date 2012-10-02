<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
    <title>Music Bar</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="<c:url value="/assets/css/bootstrap.css"/>" rel="stylesheet" />
    <link href="<c:url value="/assets/css/bootstrap-responsive.css"/>" rel="stylesheet" />

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <style type="text/css">
    	.list{
	    	width: 90%;
			border: 1px solid red;
			border-radius: 7px;
			margin-left: 2%;
			height: 350px;
			overflow-y: auto;
    	}
    	
    	.list ul{
    		list-style: none;
border: 1px solid black;
padding: 5px;

    	}
    </style>
 </head>
<body>
<div class='row-fluid'>
	<div class="span6">
		<div class='row-fluid show-grid'>
			<div class="list">
				<ul>
					<li>
						Musica 1
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="span6">
		<div class='row-fluid show-grid'>
			<div class="list">
				<ul>
					<li>
						Musica 2
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>
</body>
</html>