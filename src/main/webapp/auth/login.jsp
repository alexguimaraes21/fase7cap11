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
		<h5 class="card-title">Login</h5>
			<form action="${pageContext.request.contextPath}/auth/login" method="post">
				<div class="form-group">
				    <label for="login">CPF ou E-mail do usuário</label>
				    <input type="text" class="form-control" id="login" name="login" placeholder="Digite seu CPF(números) ou e-mail" minlength="4" maxlength="20" required="required">
				    <c:if test="${errors != null && not empty errors.username}">
				    	<div class="invalid-feedback">
					    	${ errors.username }
					    </div>
				    </c:if>
				</div>
				<div class="form-group">
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
					<a href="${pageContext.request.contextPath}/auth/cadastro">Cadastre-se aqui</a>
					<br />
					<a href="${pageContext.request.contextPath}/auth/esqueci-senha">Esqueci a Senha</a>
				</p>
				<button type="submit" class="btn btn-primary">Login</button>
			</form>
		</div>
	</div>
</div>
<script src="<%= request.getContextPath() %>/assets/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</body>
</html>