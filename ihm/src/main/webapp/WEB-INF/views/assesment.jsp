<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>

<c:url var="root" value="/" context="/CheckIt"/>

<t:assesment_layout title="Evaluation">

<jsp:attribute name="page_wrapper">

        <div id="page-wrapper">
            <div class="row">
                <ol class="breadcrumb">
                    <li class="active"><a href="#">Evaluation</a></li>
                </ol>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header"><c:out value="${evaluation.evaluationLabel}"/></h1>
                    <p class="text-16">
                        Bonjour <c:out value="${userFirstname}"/> <c:out value="${userLastname}"/>,
                        <br/>
                        Bienvenue sur CheckIT, l'application d'évaluation des connaissances techniques des candidats de Scalian.
                    </p>
                </div>
            </div>
            <!-- /.row -->
            <br/><br/><br/>
            <div class="row">
                <c:forEach items="${tests}" var="item">
                    <div class="col-md-3">
                        <div class="panel panel-checkit">
                            <div class="panel-heading">
                                ${item.testLabel}
                            </div>
                            <div class="panel-body">
                                 <c:choose>
                                    <c:when test="${testsOk.contains(item.testId)}">
                                        <div class="img-test">
                                            <img class="image-transparent" src="${root}image/test/${item.testImage}" alt="${item.testLabel}" width="100px" data-toggle="tooltip" data-placement="bottom" title="Test déja réalisé"/>
                                        </div>
                                        <div>
                                            ${item.testSynopsis}
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div style="display: table-row">
                                            <div style="display: table-cell; padding-right: 8px;">
                                                <a href="${root}assesment/test/<c:out value="${item.testId}" />">
                                                    <img src="${root}image/test/${item.testImage}" alt="${item.testLabel}" width="100px"/>
                                                </a>
                                            </div>
                                            <div style="display: table-cell; vertical-align: middle">
                                                ${item.testSynopsis}
                                            </div>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div class="panel-footer">
                                <c:choose>
                                    <c:when test="${testsOk.contains(item.testId)}">
                                        Fait
                                    </c:when>
                                    <c:otherwise>
                                        A faire
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

</jsp:attribute>

</t:assesment_layout>
