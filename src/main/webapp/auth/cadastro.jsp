<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Fintech - Login</title>
    <link href="<%= request.getContextPath() %>/assets/css/bootstrap.min.css" rel="stylesheet">
    <style>
    	body{
	    	height: 100vh;
	    	background-color: grey;
		} 
		.container{
		    height: 100%;
		}
    </style>
</head>
<body>
<div class="container d-flex align-items-center justify-content-center">
	<div class="card" style="width: 25rem;">
		<div class="card-body">
		<h5 class="card-title">Cadastro de Usuário</h5>
			<form action="${pageContext.request.contextPath}/auth/cadastro" method="post" class="row g-3 needs-validation" novalidate>
				<div class="col-md-12">
				    <label for="nome">Nome</label>
				    <input type="nome" class="form-control" id="nome" name="nome" placeholder="Digite seu Nome" minlength="13" maxlength="150" required="required">
				    <c:if test="${errors != null && not empty errors.nome}">
				    	<div class="invalid-feedback">
					    	${ errors.nome }
					    </div>
				    </c:if>
				</div>
				<div class="col-md-12">
				    <label for="login">CPF</label>
				    <input type="text" class="form-control" id="cpf" name="cpf" placeholder="Digite seu CPF (apenas números)" minlength="11" maxlength="11" required="required">
				    <c:if test="${errors != null && not empty errors.cpf}">
				    	<div class="invalid-feedback">
					    	${ errors.cpf }
					    </div>
				    </c:if>
				</div>
				<div class="col-md-12">
				    <label for="login">E-mail</label>
				    <input type="email" class="form-control" id="email" name="email" placeholder="Digite seu E-mail" required="required">
				    <c:if test="${errors != null && not empty errors.email}">
				    	<div class="invalid-feedback">
					    	${ errors.email }
					    </div>
				    </c:if>
				</div>
				<div class="col-md-12">
				    <label for="password">Senha</label>
				    <input type="password" class="form-control" id="password" name="password" placeholder="Senha" minlength="6" maxlength="20" required="required">
				    <c:if test="${errors != null && not empty errors.password}">
				    	<div class="invalid-feedback">
					    	${ errors.password }
					    </div>
				    </c:if>
				</div>
				<br />
				<p>
					<a href="${pageContext.request.contextPath}/auth/login">Login</a>
					<br />
					<a href="${pageContext.request.contextPath}/auth/esqueci-senha">Esqueci a Senha</a>
				</p>
				<button type="submit" class="btn btn-primary">Cadastrar</button>
			</form>
		</div>
	</div>
</div>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="<%= request.getContextPath() %>/assets/js/bootstrap.bundle.min.js"></script>
</body>
</html>