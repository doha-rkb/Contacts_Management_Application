
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

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
        <h3>Registration Form</h3>
    </div>
    <div>
        <c:if test="${infoMsg!=null}">
        <div class="alert alert-success" role="alert">${infoMsg}</div>
        </c:if>
        <c:if test="${errorMsg!=null}">
            <div class="alert alert-danger" role="alert">${errorMsg}</div>
        </c:if>

        <f:form action="addContact" method="POST" modelAttribute="contactModel">

            <div class="row">
                <div class="col">
                    <label>First Name</label>
                    <f:input path="firstName" type="text" class="form-control"
                             placeholder="First Name" />
                    <f:errors path="firstName" class="text-danger" />
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <label>Last Name</label>
                    <f:input path="lastName" type="text" class="form-control"
                             placeholder="Last Name" />
                    <f:errors path="lastName" class="text-danger" />
                </div>

                <div class="col">
                    <label>personnal number</label>
                    <f:input path="perNum" type="text" class="form-control"
                             placeholder="personnal number" />
                    <f:errors path="perNum" class="text-danger" />
                </div>
                <div class="col">
                    <label>professional number</label>
                    <f:input path="proNum" type="text" class="form-control"
                             placeholder="professional number" />
                    <f:errors path="proNum" class="text-danger" />
                </div>
            </div>


            <div class="row">
                <div class="col">
                    <label>personnal Email</label>
                    <f:input path="perEmail" class="form-control" placeholder="personnal Email" />
                    <f:errors path="perEmail" class="text-danger" />
                </div>
                <div class="col">
                    <label>profesionnal Email</label>
                    <f:input path="proEmail" class="form-control" placeholder="Professional Email" />
                    <f:errors path="proEmail" class="text-danger" />
                </div>


            </div>



            <div class="row">
                <div class="col">
                    <label>Address</label>
                    <f:input path="adresse" type="text" class="form-control" placeholder="...., Morocco" />
                    <f:errors path="adresse" class="text-danger" />
                </div>

            </div>

            <div class="row">
                <div class="col">
                    <legend class="col-form-label col-sm-2 pt-0">Gender</legend>
                    <div class="form-check">
                        <f:radiobutton path="gender" class="form-check-input"
                                       value="Female" />
                        <label class="form-check-label">Female </label>
                    </div>
                    <div class="form-check">
                        <f:radiobutton path="gender" class="form-check-input"
                                       value="Male " />
                        <label class="form-check-label">Male </label>
                    </div>
                    <f:errors path="gender" class="text-danger" />

                </div>

            </div>
            <div style="text-align: right">
                <button type="submit" class="btn btn-primary">Register</button>
                <button type="reset" class="btn btn-secondary">Rest</button>
            </div>

        </f:form>



</body>
</html>