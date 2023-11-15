<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./../template/header.jsp" />

<div class="p-3 pb-md-4 mx-auto">
	<h1>Tipos de Investimento</h1>
</div>
<div class="card">
    <div class="card-header">
        Tipos de Investimento Cadastrados<a href="<%= request.getContextPath() %>/tipo-investimento/cadastro" class="btn btn-outline-primary btn-sm float-end">Cadastrar</a>
    </div>
    <div class="card-body">
        <table class="table table-hover">
            <thead>
               <th>#</th>
               <th>Tipo de investimento</th>
               <th>Rendimento mensal</th>
               <th>Tempo mínimo de investimento</th>
               <th></th>
            </thead>
            <tbody>
                <c:forEach items="${ tiposInvestimento }" var="tipo">
                    <tr>
                        <td>${ tipo.id }</td>
                        <td>${ tipo.dsTipoInvestimento }</td>
                        <fmt:setLocale value = "pt_BR"/>
                        <td><fmt:formatNumber value="${ tipo.vlRendimentoMensal }" type="number" minIntegerDigits="1" maxIntegerDigits="3" minFractionDigits="2" /></td>
                        <td>${ tipo.prazoMinimoInvestimento }</td>
                        <td>
                            <div class="btn-group" role="group" aria-label="Basic example">
                                <a class="btn btn-danger btn-sm" href="<%= request.getContextPath() %>/tipo-investimento/excluir/${ tipo.id }"><i class="fa-solid fa-xmark"></i></a>
                                <a class="btn btn-info btn-sm" href="<%= request.getContextPath() %>/tipo-investimento/editar/${ tipo.id }"><i class="fa-solid fa-pencil"></i></a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="./../template/footer.jsp" />