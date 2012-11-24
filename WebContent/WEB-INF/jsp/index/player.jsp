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
    <script type="text/javascript" src="<c:url value="/assets/js/jquery-1.7.2.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/bootstrap-modal.js"/>"></script>
        <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
 </head>
<body>
	<audio src="<c:url value="/musics/setepego.mp3"/>" controls="controls"></audio>
</body>
</html>