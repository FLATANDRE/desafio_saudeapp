<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <title>Saúde App - Solicita Autorização</title>

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

  <c:if test = "${erro != null && erro != '' }">
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
      <c:out value="${erro}" />
      <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
      </button>
    </div>
  </c:if>

  <form method="post" action="${contextPath}/solicitacao-autorizacao">
    <div class="form-group">
      <label for="idProcedimento">Número do procedimento</label>
      <input type="number" class="form-control" id="idProcedimento" name="idProcedimento"  placeholder="Informe o número do procedimento">
    </div>
    <div class="form-group">
      <label for="idade">Idade</label>
      <input type="number" class="form-control" id="idade" name="idade" placeholder="Informe a idade">
    </div>
    <div class="form-group">
        <label for="sexo">Sexo</label>
        <select class="form-control" id="sexo" name="sexo">
          <option value="M">Masculino</option>
          <option value="F">Feminino</option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Solicitar</button>
  </form>
</div>
</body>
</html>
