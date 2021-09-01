<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <title>Saúde App - Lista Solicitação</title>

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
      <li class="breadcrumb-item active" aria-current="page">Solicitação Autorização</li>
    </ol>
  </nav>

  <br>
  <a class="btn btn-primary" href="${contextPath}/solicitacao-autorizacao/new" role="button">Cadastrar Solicitação</a>

  <c:if test = "${sucesso != null && sucesso != '' }">
    <br>
    <br>
    <div class="alert alert-success alert-dismissible fade show" role="alert">
      <c:out value="${sucesso}" />
      <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
      </button>
    </div>

  </c:if>

  <br>
  <br>
  <table class="table">
    <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Id Procedimento</th>
      <th scope="col">Idade</th>
      <th scope="col">Sexo</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="solicitacao" items="${listaSolicitacao}">
      <tr>
        <th scope="row"><c:out value="${solicitacao.idSolicitacao}" /></th>
        <td><c:out value="${solicitacao.idProcedimento}" /></td>
        <td><c:out value="${solicitacao.idade}" /></td>
        <td><c:out value="${solicitacao.sexo}" /></td>
      </tr>
    </c:forEach>

    </tbody>
  </table>
</div>
</body>
</html>