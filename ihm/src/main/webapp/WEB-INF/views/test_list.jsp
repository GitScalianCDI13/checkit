<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="root" value="/" context="/CheckIt"/>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>

<t:main_layout title="Liste des tests">

<jsp:attribute name="page_wrapper">

        <div id="page-wrapper">
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="${root}home">Accueil</a></li>
                    <li class="active">Tests</li>
                </ol>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Liste des tests</h1>
                </div>
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Label</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="item">
	 						            <tr>
                                            <td><c:out value="${item.testId}"></c:out></td>
                                            <td><c:out value="${item.testLabel}"></c:out></td>
                                            <td class="text-center" data-id="${item.testId}"><span class="fa fa-edit"></span>&nbsp;&nbsp;&nbsp;&nbsp;<span class="fa fa-trash-o"></span></td>
                                        </tr>
						            </c:forEach>
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-8 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
</jsp:attribute>

</t:main_layout>