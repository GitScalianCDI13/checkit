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
    
    <!-- DataTables CSS -->
    <link href="${root}vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="${root}vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${root}dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <%--<link href="${root}vendor/morrisjs/morris.css" rel="stylesheet">--%>

    <!-- Custom Fonts -->
    <link href="${root}vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

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
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${root}home"><img src="${root}image/logo_scalian-1.png" alt="Scalian" height="25px"></a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> Mon compte</a></li>
                        <li class="divider"></li>
                        <li><a href="${root}logout"><i class="fa fa-sign-out fa-fw"></i> Déconnexion</a></li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="${root}home"><i class="fa fa-home fa-fw"></i> Accueil</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-user fa-fw"></i> Gestion des utilisateurs<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level collapse">
                                <li>
                                    <a href="${root}user/list">Liste des utilisateurs</a>
                                </li>
                                <li>
                                    <a href="${root}user/add">Créer un utilisateur</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-edit fa-fw"></i> Gestion des évaluations<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level collapse">
                                <li>
                                    <a href="${root}evaluation/list">Liste des évaluations</a>
                                </li>
                                <li>
                                    <a href="${root}evaluation/add">Créer une évaluation</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-check-square-o fa-fw"></i> Gestion des tests<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level collapse">
                                <li>
                                    <a href="${root}test/list">Liste des tests</a>
                                </li>
                                <li>
                                    <a href="${root}test/add">Créer un test</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-question-circle-o fa-fw"></i> Gestion des questions<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level collapse">
                                <li>
                                    <a href="${root}question/list">Liste des questions</a>
                                </li>
                                <li>
                                    <a href="${root}question/add">Créer une question</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> Gestion des rôles<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level collapse">
                                <li>
                                    <a href="${root}role/list">Liste des rôles</a>
                                </li>
                                <li>
                                    <a href="${root}role/add">Créer un rôle</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-list-alt fa-fw"></i> Gestion des thèmes<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level collapse">
                                <li>
                                    <a href="${root}theme/list">Liste des thèmes</a>
                                </li>
                                <li>
                                    <a href="${root}theme/add">Créer un thème</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="${root}evaluation/result/list"><i class="fa fa-graduation-cap fa-fw"></i> Visualiser les résultats</a>
                            <%--<ul class="nav nav-second-level collapse">
                                <li>
                                    <a href="${root}theme/list">Liste des thèmes</a>
                                </li>
                                <li>
                                    <a href="${root}theme/add">Créer un thème</a>
                                </li>
                            </ul>--%>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
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

    <!-- Morris Charts JavaScript -->
    <%--<script src="${root}vendor/raphael/raphael.min.js"></script>--%>
    <%--<script src="${root}vendor/morrisjs/morris.min.js"></script>--%>
    <%--<script src="${root}data/morris-data.js"></script>--%>
    
    <!-- DataTables JavaScript -->
    <script src="${root}vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="${root}vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="${root}vendor/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${root}dist/js/sb-admin-2.js"></script>
    
    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true,
            "language": {
                processing:     "Traitement en cours...",
                search:         "Rechercher&nbsp;:",
                lengthMenu:    "Afficher _MENU_ &eacute;l&eacute;ments",
                info:           "Affichage de l'&eacute;lement _START_ &agrave; _END_ sur _TOTAL_ &eacute;l&eacute;ments",
                infoEmpty:      "Affichage de l'&eacute;lement 0 &agrave; 0 sur 0 &eacute;l&eacute;ments",
                infoFiltered:   "(filtr&eacute; de _MAX_ &eacute;l&eacute;ments au total)",
                infoPostFix:    "",
                loadingRecords: "Chargement en cours...",
                zeroRecords:    "Aucun &eacute;l&eacute;ment &agrave; afficher",
                emptyTable:     "Aucune donnée disponible dans le tableau",
                paginate: {
                    first:      "Premier",
                    previous:   "Pr&eacute;c&eacute;dent",
                    next:       "Suivant",
                    last:       "Dernier"
                },
                aria: {
                    sortAscending:  ": activer pour trier la colonne par ordre croissant",
                    sortDescending: ": activer pour trier la colonne par ordre décroissant"
                }
            }
        });
    });
    </script>

</body>

</html>
