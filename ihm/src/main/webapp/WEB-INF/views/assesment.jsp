<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>

<c:url var="root" value="/" context="/CheckIt"/>

<t:assesment_layout title="Evaluation">

<jsp:attribute name="page_wrapper">

        <div id="page-wrapper">
            <div class="row">
                <ol class="breadcrumb">
                    <li class="active"><a href="${root}home">Evaluation</a></li>
                </ol>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Evaluation</h1>
                    <p>
                        Bonjour <c:out value="${sessionScope.user.userFirstname}"/> <c:out value="${sessionScope.user.userLastname}"/>,
                        <br/>
                        Bienvenue sur CheckIT, l'application d'évaluation des connaissances techniques des candidats de Scalian.
                    </p>
                </div>
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <h2>Passer un test :</h2>
                </div>
                <div class="col-lg-12">
                    <c:forEach items="${tests}" var="item">
    		            <a href="#"><img src="image/<c:out value="${item.testImage}"></c:out>" alt="<c:out value="${item.testLabel}"></c:out>"/></a>
		            </c:forEach>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

</jsp:attribute>

</t:assesment_layout>
