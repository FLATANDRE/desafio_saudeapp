<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <title>Saúde App - Lista Regra</title>

    <link href="${contextPath}/bootstrap-4.1.3-dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Saúde App</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${contextPath}">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${contextPath}/regra-autorizacao">Regras Autorização</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${contextPath}/solicitacao-autorizacao">Solicitação Autorização</a>
            </li>
        </ul>
    </div>
</nav>

<br><br>
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item">Home</li>
        <li class="breadcrumb-item active" aria-current="page">Regras Autorização</li>
    </ol>
</nav>

<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Id Procedimento</th>
        <th scope="col">Idade</th>
        <th scope="col">Sexo</th>
        <th scope="col">Permitido</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="regra" items="${listaRegras}">
        <tr>
            <th scope="row"><c:out value="${regra.idRegra}" /></th>
            <td><c:out value="${regra.idProcedimento}" /></td>
            <td><c:out value="${regra.idade}" /></td>
            <td><c:out value="${regra.sexo}" /></td>
            <td><c:out value="${regra.permitido}" /></td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</div>
</body>
</html>