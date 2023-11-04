<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
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
			<form>
				<div class="form-group">
				    <label for="email">Email address</label>
				    <input type="email" class="form-control" id="email" placeholder="Digite seu e-mail">
				</div>
				<div class="form-group">
				    <label for="password">Senha</label>
				    <input type="password" class="form-control" id="password" placeholder="Senha">
				</div>
				<br />
				<button type="submit" class="btn btn-primary">Login</button>
			</form>
		</div>
	</div>
</div>
<script src="<%= request.getContextPath() %>/assets/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</body>
</html>