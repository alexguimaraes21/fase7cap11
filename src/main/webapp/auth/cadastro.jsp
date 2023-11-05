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
				    <input type="nome" class="form-control ${ msgs.containsKey('nome') ? 'is-invalid' : '' }" id="nome" name="nome" placeholder="Digite seu Nome" minlength="10" maxlength="150" required="required">
				    <c:if test="${msgs != null && not empty msgs.nome}">
				    	<div class="invalid-feedback">
					    	${ msgs.nome }
					    </div>
				    </c:if>
				</div>
				<div class="col-md-12">
				    <label for="login">CPF</label>
				    <input type="text" class="form-control cpf ${ msgs.containsKey('cpf') ? 'is-invalid' : '' }" id="cpf" name="cpf" placeholder="Digite seu CPF (apenas números)" required="required">
				    <c:if test="${msgs != null && not empty msgs.cpf}">
				    	<div class="invalid-feedback">
					    	${ msgs.cpf }
					    </div>
				    </c:if>
				</div>
				<div class="col-md-12">
				    <label for="login">E-mail</label>
				    <input type="email" class="form-control ${ msgs.containsKey('email') ? 'is-invalid' : '' }" id="email" name="email" placeholder="Digite seu E-mail" required="required">
				    <c:if test="${msgs != null && not empty msgs.email}">
				    	<div class="invalid-feedback">
					    	${ msgs.email }
					    </div>
				    </c:if>
				</div>
				<div class="col-md-12">
				    <label for="password">Senha</label>
				    <input type="password" class="form-control ${ msgs.containsKey('password') ? 'is-invalid' : '' }" id="password" name="password" placeholder="Senha" minlength="6" maxlength="20" required="required">
				    <c:if test="${msgs != null && not empty msgs.password}">
				    	<div class="invalid-feedback">
					    	${ msgs.password }
					    </div>
				    </c:if>
				</div>
				<c:if test="${ msgs != null && msgs.containsKey('exception') }">
					<div class="alert alert-danger alert-dismissible fade show" role="alert">
						${ msgs.exception }
						<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
					</div>
				</c:if>
				<c:if test="${ msgs != null && msgs.containsKey('success') }">
					<div class="alert alert-success alert-dismissible fade show" role="alert">
						${ msgs.success }
						<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
					</div>
				</c:if>
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
<script src="<%= request.getContextPath() %>/assets/js/jquery.mask.min.js"></script>
<script>
	$(document).ready(function(){
		$('.cpf').mask('000.000.000-00', {reverse: true});
	})
</script>
</body>
</html>