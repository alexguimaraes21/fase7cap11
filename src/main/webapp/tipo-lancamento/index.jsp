<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./../template/header.jsp" />

<div class="p-3 pb-md-4 mx-auto">
	<h1>Tipos de Lançamento</h1>
</div>
<div class="card">
    <div class="card-header">
        Tipos de Lançamentos Cadastrados<a href="<%= request.getContextPath() %>/tipo-lancamento/cadastro" class="btn btn-outline-primary btn-sm float-end">Cadastrar</a>
    </div>
    <div class="card-body">
        <table class="table table-hover">
            <thead>
               <th>#</th>
               <th>Tipo de Lançamento</th>
               <th></th>
            </thead>
            <tbody>
                <c:forEach items="${ tiposLancamento }" var="tipo">
                    <tr>
                        <td>${ tipo.id }</td>
                        <td>${ tipo.dsTipo }</td>
                        <td>
                            <div class="btn-group" role="group" aria-label="Basic example">
                                <a class="btn btn-danger btn-sm" href="<%= request.getContextPath() %>/tipo-lancamento/excluir/${ tipo.id }"><i class="fa-solid fa-xmark"></i></a>
                                <a class="btn btn-info btn-sm" href="<%= request.getContextPath() %>/tipo-lancamento/editar/${ tipo.id }"><i class="fa-solid fa-pencil"></i></a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="./../template/footer.jsp" />