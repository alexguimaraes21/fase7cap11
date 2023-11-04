<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link href="<%= request.getContextPath() %>/assets/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Fintech</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link <%= (request.getServletPath().equals("/index.jsp") ? "active" : "") %>" aria-current="page" href="${pageContext.request.contextPath}">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link <%= (request.getServletPath().equals("/conta/index.jsp") ? "active" : "") %>" href="${pageContext.request.contextPath}/conta">Conta</a>
        </li>
        <li class="nav-item">
          <a class="nav-link <%= (request.getServletPath().equals("/lancamentosindex.jsp") ? "active" : "") %>" href="${pageContext.request.contextPath}/productos">Lançamentos</a>
        </li>
        
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            ${not empty sessionScope.username? sessionScope.username: "Conta"}
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li>
            <a class="dropdown-item"
            href="${pageContext.request.contextPath}/${not empty sessionScope.username? "logout": "login"}">
            ${not empty sessionScope.username? "Logout": "Login"}
            </a>
            </li>
          </ul>
        </li>
      </ul>

    </div>
  </div>
</nav>
<div class="container">