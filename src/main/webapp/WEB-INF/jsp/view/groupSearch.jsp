
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <title>search</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
            crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">


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

    <c:if test="${infoMsg!=null}">
        <div class="alert alert-primary"  role="alert">${infoMsg}</div>
    </c:if>
    <c:if test="${errorMsg!=null}">
        <div class="alert alert-danger" role="alert">${errorMsg}</div>
    </c:if>
    <form action="searchgrp" method="GET" >
        <div class="row">
            <div class="col">

                <label> Group Name
                    <input  type="text" class="form-control" name="grpname"
                            placeholder="Group Name" />
                </label>
            </div>
        </div>
        <div class="text-right">
            <button type="submit" class="btn btn-outline-primary">Search</button>
        </div>
    </form>

    <c:if test="${info!=null}">
        <div class="alert alert-success" role="alert">${info}</div>
    </c:if>
    <h1> research result </h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>group name</th>
            <th>List of contacts </th>

        </tr>
        </thead>
        <tbody>
        <tr>


            <td>${grpres.gname}</td>
            <td>
                <c:forEach items="${grpres.contacts}" var="contact">
                    { ${contact.lastName} ${contact.firstName} }
                </c:forEach>
            </td>
        </tr>


        </tbody>

    </table>




</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>

