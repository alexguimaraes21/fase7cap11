<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./../template/header.jsp" />

	<div class="p-3 pb-md-4 mx-auto">
		<h1>Cadastro de Conta</h1>
	</div>
	<div class="card">
		<div class="card-header">Cadastro de Conta</div>
		<div class="card-body">
			<form action="${pageContext.request.contextPath}/conta/cadastro" method="post" class="row g-3 needs-validation" novalidate>
				<div class="col-md-12">
				    <label for="agencia">Agência</label>
				    <input type="text" class="form-control ${ msgs.containsKey('agencia') ? 'is-invalid' : '' }" id="agencia" name="agencia" placeholder="Digite o número da agência" minlength="1" maxlength="10" required="required">
				    <c:if test="${msgs != null && not empty msgs.agencia}">
				    	<div class="invalid-feedback">
					    	${ msgs.agencia }
					    </div>
				    </c:if>
				</div>
				<div class="col-md-12">
				    <label for="conta">Conta</label>
				    <input type="text" class="form-control cpf ${ msgs.containsKey('conta') ? 'is-invalid' : '' }" id="conta" name="conta" placeholder="Digite o número da Conta" required="required">
				    <c:if test="${msgs != null && not empty msgs.conta}">
				    	<div class="invalid-feedback">
					    	${ msgs.conta }
					    </div>
				    </c:if>
				</div>
				<div class="col-md-12">
				    <label for="banco">Número do Banco</label>
				    <input type="text" class="form-control ${ msgs.containsKey('banco') ? 'is-invalid' : '' }" id="banco" name="banco" placeholder="Digite o número do Banco" minlength="4" maxlength="4" required="required">
				    <c:if test="${msgs != null && not empty msgs.banco}">
				    	<div class="invalid-feedback">
					    	${ msgs.banco }
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
				<button type="submit" class="btn btn-primary">Cadastrar</button>
			</form>
		</div>
	</div>
<jsp:include page="./../template/footer.jsp" />