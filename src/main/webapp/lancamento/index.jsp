<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./../template/header.jsp" />
<div class="p-3 pb-md-4 mx-auto">
	<h1>Lançamentos</h1>
</div>
<div class="card">
    <div class="card-header">
        Lançamentos Cadastrados<a href="<%= request.getContextPath() %>/lancamento/cadastro" class="btn btn-outline-primary btn-sm float-end">Cadastrar</a>
    </div>
    <div class="card-body">
        <table class="table table-hover">
            <thead>
               <th>#</th>
               <th>Descrição</th>
               <th>Valor</th>
               <th>Tipo</th>
               <th>
               	Agência<br />
               	Conta
               </th>
               <th>
               	Data<br /> 
               	Lançamento
               </th>
               <th></th>
            </thead>
            <tbody>
                <c:forEach items="${ lancamentos }" var="lancamento">
                    <tr>
                        <td>${ lancamento.id }</td>
                        <td>${ lancamento.dsLancamento }</td>
                        <fmt:setLocale value = "pt_BR"/>
                        <td><fmt:formatNumber value="${ lancamento.vlLancamento }" type="currency" /></td>
                        <c:if test="${ lancamento.tipoLancamento.dsTipo != 'Investimento' }">
                        	<td>${ lancamento.tipoLancamento.dsTipo }</td>
                        </c:if>
                        <c:if test="${ lancamento.tipoLancamento.dsTipo == 'Investimento' }">
                        	<td>
                        		${ lancamento.tipoLancamento.dsTipo }<br /> 
                        		${ lancamento.tipoInvestimento.dsTipoInvestimento }
                        	</td>
                        </c:if>
                        <td>
                        	${ lancamento.conta.vlAgencia }<br /> 
							${ lancamento.conta.vlConta }
                        </td>
                        <td><fmt:formatDate value="${ lancamento.dtLancamento }" pattern="dd/MM/yyyy" /></td>
                        <td>
                            <div class="btn-group" role="group" aria-label="Basic example">
                                <a class="btn btn-danger btn-sm" href="<%= request.getContextPath() %>/lancamento/excluir/${ lancamento.id }"><i class="fa-solid fa-xmark"></i></a>
                                <a class="btn btn-info btn-sm" href="<%= request.getContextPath() %>/lancamento/editar/${ lancamento.id }"><i class="fa-solid fa-pencil"></i></a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="./../template/footer.jsp" />