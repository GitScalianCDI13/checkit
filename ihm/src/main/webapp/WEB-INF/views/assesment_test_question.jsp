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
                    <li class="active">Question ${index + 1}</li>
                </ol>
            </div>
            <!-- /Breadcrumb -->

            <!-- Question -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">${test.testLabel}</h1>
                    <h2>Question ${index + 1} / ${tot_question}</h2>
                    <h3><c:out value="${question.questionLabel}"/></h3>
                    <h4><c:out value="${question.questionContent}"/></h4>

                    <!-- Form -->
                    <form action="${root}assesment/response/save" method="post">
                        <input type="hidden" name="id_test" value="${test.testId}"/>
                        <input type="hidden" name="id_next_question" value="${id_next_question}"/>
                        <input type="hidden" name="id_previous_question" value="${id_previous_question}"/>
                        <input type="hidden" name="question_id" value="${question.questionId}"/>

                        <!-- Possible responses -->
                        <c:choose>
                          <c:when test="${question.questionType == false}">
                            <!-- Possibles responses Radio -->
                            <c:forEach items="${possible_responses}" var="item">
                                <c:choose>
                                    <c:when test="${user_response_id_list.contains(item.possibleResponseId)}"><c:set var="checked" value="checked" /></c:when>
                                    <c:otherwise><c:set var="checked" value="" /></c:otherwise>
                                </c:choose>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="possible_response_id" value="${item.possibleResponseId}" ${checked} /> <c:out value="${item.possibleResponseLabel}"/>
                                    </label>
                                </div>
                            </c:forEach>
                          </c:when>
                          <c:otherwise>
                            <!-- Possibles responses Checkbox -->
                            <c:forEach items="${possible_responses}" var="item">
                                <c:choose>
                                    <c:when test="${user_response_id_list.contains(item.possibleResponseId)}"><c:set var="checked" value="checked" /></c:when>
                                    <c:otherwise><c:set var="checked" value="" /></c:otherwise>
                                </c:choose>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" name="possible_response_id" value="${item.possibleResponseId}" ${checked} /> <c:out value="${item.possibleResponseLabel}"/>
                                    </label>
                                </div>
                            </c:forEach>
                          </c:otherwise>
                        </c:choose>

                        <br/>

                        <!-- Previous button -->
                        <c:if test = "${id_previous_question > 0 }">
                            <%--<a href="${root}assesment/test/${test.testId}/question/${id_previous_question}" class="btn btn-success">Question Précédente</a>--%>
                            <button type="submit" value="previous" name="submit" class="btn btn-success">Question Précédente</button>
                        </c:if>

                        <!-- Questions list button -->
                        <button type="submit" value="list" name="submit" class="btn btn-success">Afficher la liste des questions</button>

                        <!-- Next/End button -->
                        <c:choose>
                          <c:when test="${id_next_question > 0 }">
                            <button type="submit" value="next" name="submit" class="btn btn-success">Question Suivante</button>
                          </c:when>
                          <c:otherwise>
                            <button type="submit" value="end" name="submit" class="btn btn-success">Terminer le test</button>
                          </c:otherwise>
                        </c:choose>
                    </form>
                    <!-- /Form -->

                </div>
            </div>
            <!-- /Question -->
        </div>
        <!-- /#page-wrapper -->

</jsp:attribute>

</t:assesment_layout>
