<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>

<c:url var="root" value="/" context="/CheckIt"/>

<t:assesment_layout title="Evaluation">

<jsp:attribute name="page_wrapper">

        <div id="page-wrapper">
            <div class="row">
                <ol class="breadcrumb">
                    <lil><a href="${root}assesment">Evaluation</a></lil>
                    <li class="active"><a href="${root}assesment/test/">Test <c:out value="${test.testLabel}"/> </a></li>
                </ol>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header"><c:out value="${test.testLabel}"/></h1>
                    <p>
                        <c:out value="${test.testDescription}"/>
                    </p>
                    <a href="${root}assesment/test/${test.testId}/start" class="btn btn-success">Démarrer le test</a>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

</jsp:attribute>

</t:assesment_layout>
