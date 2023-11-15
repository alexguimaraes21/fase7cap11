<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>${title}</title>
<link href="<%= request.getContextPath() %>/assets/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="<%= request.getContextPath() %>/assets/js/bootstrap.bundle.min.js"></script>
<script src="<%= request.getContextPath() %>/assets/js/jquery.mask.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container">
			<a class="navbar-brand" href="#">Fintech</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item">
						<a class="nav-link <%= (request.getServletPath().equals("/index.jsp") ? "active" : "") %>" aria-current="page" href="${pageContext.request.contextPath}">
							Home
						</a>
					</li>
					<li class="nav-item">
						<a class="nav-link <%= (request.getServletPath().equals("/conta/index.jsp") ? "active" : "") %>" href="${pageContext.request.contextPath}/conta">
							Conta
						</a>
					</li>
					<li class="nav-item">
						<a class="nav-link <%= (request.getServletPath().equals("/lancamento/index.jsp") ? "active" : "") %>" href="${pageContext.request.contextPath}/lancamento">
							Lançamentos
						</a>
					</li>
					<li class="nav-item">
						<a class="nav-link <%= (request.getServletPath().equals(" /tipo-lancamento/index.jsp") ? "active" : "" ) %>" href="${pageContext.request.contextPath}/tipo-lancamento">
							Tipos de Lançamento
						</a>
					</li>
					<li class="nav-item">
						<a class="nav-link <%= (request.getServletPath().equals(" /tipo-investimento/index.jsp") ? "active" : "" ) %>" href="${pageContext.request.contextPath}/tipo-investimento">
							Tipos de Investimento
						</a>
					</li>
				</ul>
				<li class="nav-item dropdown d-flex">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
							${sessionScope.usuario != null? sessionScope.usuario.getNmUsuario(): "Conta"}
					</a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li>
							<a class="dropdown-item" href="${pageContext.request.contextPath}/auth/${not empty sessionScope.username? "logout": "login"}">
								${not empty sessionScope.usuario? "Logout": "Login"} 
							</a>
						</li>
					</ul>
				</li>
			</div>
		</div>
	</nav>
	<div class="container">