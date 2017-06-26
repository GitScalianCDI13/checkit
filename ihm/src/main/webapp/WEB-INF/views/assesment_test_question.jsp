<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>

<c:url var="root" value="/" context="/CheckIt"/>

<t:assesment_layout title="Evaluation">

<jsp:attribute name="page_wrapper">

        <div id="page-wrapper">
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="${root}assesment">Evaluation</a></li>
                    <li><a href="${root}assesment/test/"><c:out value="${test.testLabel}"/> </a></li>
                    <li class="active"><a href="${root}assesment/test/<c:out value="${test.testId}"/>/question/<c:out value="${question.questionId}"/>">Question <c:out value="${index + 1}"/> </a></li>
                </ol>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header"><c:out value="${test.testLabel}"/></h1>
                    <h2>Question <c:out value="${index + 1}"/></h2>
                    <h3><c:out value="${question.questionLabel}"/></h3>
                    réponse possible
                    <br/>
                    <button class="btn btn-success">Question Précédente</button>
                    <button class="btn btn-success">Afficher la liste des questions</button>
                    <button class="btn btn-success">Question Suivante</button>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

</jsp:attribute>

</t:assesment_layout>
