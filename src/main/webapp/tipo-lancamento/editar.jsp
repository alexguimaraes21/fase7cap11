<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./../template/header.jsp" />

<div class="p-3 pb-md-4 mx-auto">
	<h1>Edição de Tipo de Lançamento: ${ tipoLancamento.getDsTipo() }</h1>
</div>
<div class="card">
    <div class="card-header">Edição do Tipo de Lançamento: ${ tipoLancamento.getDsTipo() }</div>
    <div class="card-body">
        <form action="${pageContext.request.contextPath}/tipo-lancamento/editar" method="post" class="row g-3 needs-validation" novalidate>
            <input type="hidden" name="id" value="${ tipoLancamento.getId() }">
            <div class="col-md-12">
                <label for="dsTipo">Descrição</label>
                <input type="text" class="form-control ${ msgs.containsKey('dsTipo') ? 'is-invalid' : '' }" id="dsTipo" name="dsTipo" 
                    placeholder="Digite a descrição do tipo de lançamento" minlength="1" maxlength="20" required="required" value="${ tipoLancamento.getDsTipo() }">
                <c:if test="${msgs != null && not empty msgs.dsTipo}">
                    <div class="invalid-feedback">
                        ${ msgs.dsTipo }
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