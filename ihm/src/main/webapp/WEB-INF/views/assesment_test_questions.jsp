<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>

<c:url var="root" value="/" context="/CheckIt"/>

<t:assesment_layout title="Evaluation">

<jsp:attribute name="page_wrapper">

        <div id="page-wrapper">
            <!-- Breadcrumb -->
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="#">Evaluation</a></li>
                    <li><a href="#">${test.testLabel}</a></li>
                    <li class="active">Liste des questions</li>
                </ol>
            </div>
            <!-- /Breadcrumb -->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">${test.testLabel}</h1>
                    <h2>Liste des questions</h2>
                    <ul class="no-style">
                        <c:forEach items="${questions}" var="item">
                            <c:choose>
                                <c:when test="${questionsOk.contains(item.questionId)}"><c:set var="icon" value="glyphicon glyphicon-check glyphicon-check-green" /></c:when>
                                <c:otherwise><c:set var="icon" value="glyphicon glyphicon-unchecked glyphicon-unchecked-red" /></c:otherwise>
                            </c:choose>
                            <li><span class="${icon}"></span> <a href="" >${item.questionLabel}</a></li>
                        </c:forEach>
                    </ul>
                    <a href="${root}assesment/test/${test.testId}/save" class="btn btn-success">Terminer le test</a>
                </div>
            </div>

        </div>
        <!-- /#page-wrapper -->

</jsp:attribute>

</t:assesment_layout>
