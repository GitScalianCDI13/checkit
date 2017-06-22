<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>

<c:url var="root" value="/" context="/CheckIt"/>

<t:main_layout title="Accueil">

<jsp:attribute name="page_wrapper">

        <div id="page-wrapper">
            <div class="row">
                <ol class="breadcrumb">
                    <li class="active"><a href="${root}home">Accueil</a></li>
                </ol>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Accueil</h1>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
</jsp:attribute>

</t:main_layout>