<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="./../template/header.jsp" />

	<div class="p-3 pb-md-4 mx-auto">
		<h1>Contas</h1>
	</div>
	<div class="card">
		<div class="card-header">
			Contas Cadastradas<a href="<%= request.getContextPath() %>/conta/cadastro" class="btn btn-outline-primary btn-sm float-end">Cadastrar</a>
		</div>
		<div class="card-body">
			<table class="table table-hover">
				<thead>
					<th>#</th>
					<th>Agência</th>
					<th>Conta</th>
					<th>Banco</th>
					<th></th>
				</thead>
				<tbody>
					<c:forEach items="${ contas }" var="conta">
						<tr>
							<td>${ conta.id }</td>
							<td>${ conta.vlAgencia }</td>
							<td>${ conta.vlConta }</td>
							<td>${ conta.vlBanco }</td>
							<td>
								<div class="btn-group" role="group" aria-label="Basic example">
									<a class="btn btn-danger btn-sm" href="<%= request.getContextPath() %>/conta/excluir/${ conta.id }"><i class="fa-solid fa-xmark"></i></a>
									<a class="btn btn-info btn-sm" href="<%= request.getContextPath() %>/conta/editar/${ conta.id }"><i class="fa-solid fa-pencil"></i></a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>


<jsp:include page="./../template/footer.jsp" />