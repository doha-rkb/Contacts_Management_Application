<%@ page import="com.ensah.bo.Contact" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>contact form</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
            crossorigin="anonymous">

    <style>
        form {
            margin-bottom: 60px;
            margin-top: 10px;
            padding: 10px;
        }

        h3 {
            margin-top: 20px;
        }
    </style>


</head>
<body>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link active"
                                            aria-current="page"
                                            href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li class="nav-item"><a class="nav-link"
                                            href="${pageContext.request.contextPath}/showForm">Add Contact</a></li>
                    <li class="nav-item"><a class="nav-link"
                                            href="${pageContext.request.contextPath}/showAllContacts">List of contacts</a></li>
                    <li class="nav-item"><a class="nav-link"
                                            href="${pageContext.request.contextPath}/search?option=0&&searchterm=">search</a></li>
                    <li class="nav-item"><a class="nav-link"
                                            href="${pageContext.request.contextPath}/delete?option=0&&deleteterm=">delete</a></li>
                    <li class="nav-item"><a class="nav-link"
                                            href="${pageContext.request.contextPath}/groupes">Groupes</a></li>
                    <li class="nav-item"><a class="nav-link"
                                            href="${pageContext.request.contextPath}/phonetique?phonetiqueName=">Recherche phonetique</a></li>

                </ul>
            </div>

        </div>
    </nav>


    <div>
        <h3>Create a group</h3>
    </div>
    <div>
        <c:if test="${infoMsg!=null}">
        <div class="alert alert-success" role="alert">${infoMsg}</div>
        </c:if>
        <c:if test="${errorMsg!=null}">
        <div class="alert alert-danger" role="alert">${errorMsg}</div>
        </c:if>

        <f:form action="creategrp" method="POST" modelAttribute="groupemodel">

        <div class="row">
            <div class="col">
                <f:input path="Gname" type="text" class="form-control"
                         placeholder="Group Name"/>
                <f:errors path="Gname" class="text-danger"/>
            </div>
        </div>


        <h3>Select Contacts:</h3>
        <c:forEach var="contact" items="${AllContact}">
        <div class="row">
            <div class="col">
                <f:checkbox path="contacts" value="${contact}"
                            class="form-check-input"/>
                <label class="form-check-label"> ${contact.firstName} ${contact.lastName}</label>


            </div>

        </div>
        </c:forEach>


            <div class="text-right">
                <button type="submit" class="btn btn-outline-primary">Add</button>
            </div>

        </f:form>


</body>
</html>