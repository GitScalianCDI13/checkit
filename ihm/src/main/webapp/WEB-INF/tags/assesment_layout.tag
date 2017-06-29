<!DOCTYPE html>
<%@tag description="Simple Template" pageEncoding="UTF-8"%>
 
<%@attribute name="title"%>

<%@attribute name="page_wrapper" fragment="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="root" value="/" context="/CheckIt"/>

<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>CheckIT | ${title}</title>

    <!-- Bootstrap Core CSS -->
    <link href="${root}vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${root}vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${root}dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${root}vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- CheckIT css -->
    <link href="${root}css/checkit.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <a class="navbar-brand" href="${root}home"><img src="${root}image/logo_scalian-1.png" alt="Scalian" height="25px"></a>
            </div>
            <!-- /.navbar-header -->
        </nav>
        
        <jsp:invoke fragment="page_wrapper"/>

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="${root}vendor/jquery/jquery.min.js"></script>
    
    <!-- Metis Menu Plugin JavaScript -->
    <script src="${root}vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${root}vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${root}dist/js/sb-admin-2.js"></script>
</body>

</html>
