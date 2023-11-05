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
			<form action="${pageContext.request.contextPath}/auth/login" method="post" class="row g-3 needs-validation" novalidate>
				<div class="col-md-12">
				    <label for="login">CPF ou E-mail do usuário</label>
				    <input type="text" class="form-control ${ errors.containsKey('login') ? 'is-invalid' : '' }" id="login" name="login" placeholder="Digite seu CPF(números) ou e-mail" minlength="4" maxlength="150" required="required">
				    <c:if test="${errors != null && errors.containsKey('login') }">
				    	<div class="invalid-feedback">
					    	${ errors.login }
					    </div>
				    </c:if>
				</div>
				<div class="col-md-12">
				    <label for="password">Senha</label>
				    <input type="password" class="form-control ${ errors.containsKey('password') ? 'is-invalid' : '' }" id="password" name="password" placeholder="Senha" minlength="6" maxlength="20" required="required">
				    <c:if test="${errors != null && errors.containsKey('password')}">
				    	<div class="invalid-feedback">
					    	${ errors.password }
					    </div>
				    </c:if>
				</div>
				<c:if test="${ errors != null && errors.containsKey('authentication') }">
					<div class="alert alert-danger alert-dismissible fade show" role="alert">
						${ errors.authentication }
						<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
					</div>
				</c:if>
				<br />
				<p>
					<a href="${pageContext.request.contextPath}/auth/cadastro">Cadastre-se aqui</a>
					<br />
					<a href="${pageContext.request.contextPath}/auth/esqueci-senha">Esqueci a Senha</a>
				</p>
				<button type="submit" class="btn btn-primary btn-block">Login</button>
			</form>
		</div>
	</div>
</div>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="<%= request.getContextPath() %>/assets/js/bootstrap.bundle.min.js"></script>
</body>
</html>