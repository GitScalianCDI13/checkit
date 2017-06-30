<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="root" value="/" context="/CheckIt"/>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>

<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>CheckIT | ${title}</title>

    <!-- Bootstrap Core CSS -->
    <link href="${root}vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

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
    <div id="btn-admin">
        <a class="btn btn-sm btn-scalian" href="${root}auth">Administration</a>
    </div>
    <div id="logo">
        <img src="${root}image/logo_scalian-1.png" alt="Scalian" class="logo-scalian">
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-checkit">
                    <div class="panel-heading">
                        <h3 class="panel-title">Inscription</h3>
                    </div>
                    <div class="panel-body">
                        <c:if test="${error_email != null}">
                            <div class="alert alert-danger" role="alert">${error_email}</div>
                        </c:if>
                        <form role="form" action="subscribe" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Prénom" name="firstname" value="" autofocus />
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Nom" name="lastname" value="" />
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="E-mail" name="email" type="email" value="" />
                                </div>

                                <!-- Change this to a button or input when using this as a form -->
                                <button type="submit" class="btn btn-lg btn-scalian btn-block">S'inscrire</button>
                            </fieldset>
                        </form>
                    </div>
                    <div class="panel-footer">
                      <div style="text-align: right"><a href=" ">Déja inscrit ></a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="${root}vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${root}vendor/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>
