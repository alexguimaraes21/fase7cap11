<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./../template/header.jsp" />
<div class="p-3 pb-md-4 mx-auto">
	<h1>Cadastro de Lançamento</h1>
</div>
<div class="card">
    <div class="card-header">Cadastro de Lancamento</div>
    <div class="card-body">
        <form action="${pageContext.request.contextPath}/lancamento/editar" method="post" class="row g-3 needs-validation" novalidate>
            <input type="hidden" name="id" value="${ lancamento.id }">
            <div class="col-md-12">
                <label for="dsLancamento">Descrição do Lançamento</label>
                <input type="text" class="form-control ${ msgs.containsKey('dsLancamento') ? 'is-invalid' : '' }" id="dsLancamento" name="dsLancamento" placeholder="Digite a descrição do lançamento" minlength="3" maxlength="50" required="required" value="${ lancamento.dsLancamento }">
                <c:if test="${msgs != null && not empty msgs.dsLancamento}">
                    <div class="invalid-feedback">
                        ${ msgs.dsLancamento }
                    </div>
                </c:if>
            </div>
            <fmt:setLocale value = "pt_BR"/>
            <fmt:formatNumber value="${ lancamento.vlLancamento }" type="number" minFractionDigits="2" maxFractionDigits="2" var="valorLancamentoFormatado" />
            <div class="col-md-12">
                <label for="vlLancamento">Valor do Lançamento</label>
                <input type="text" class="form-control money2 ${ msgs.containsKey('vlLancamento') ? 'is-invalid' : '' }" id="vlLancamento" name="vlLancamento" placeholder="Digite a descrição do lançamento" minlength="1" maxlength="50" required="required"  value="${ valorLancamentoFormatado }">
                <c:if test="${msgs != null && not empty msgs.dsLancamento}">
                    <div class="invalid-feedback">
                        ${ msgs.dsLancamento }
                    </div>
                </c:if>
            </div>
            
            <div class="col-md-12">
                <label for="cdConta">Conta</label>
                <select class="form-select ${ msgs.containsKey('cdConta') ? 'is-invalid' : '' }" aria-label="Select Conta" id="cdConta" name="cdConta" required>
	                <option value="">Selecione</option>
	                <c:forEach items="${ contas }" var="conta">
	                	<option value="${ conta.id }" ${ lancamento.conta.id == conta.id ? "selected" : "" }>Ag: ${ conta.vlAgencia } - Conta: ${ conta.vlConta }</option>
	                </c:forEach>
                </select>
                <c:if test="${msgs != null && not empty msgs.cdConta}">
                    <div class="invalid-feedback">
                        ${ msgs.cdConta }
                    </div>
                </c:if>
            </div>
            
            <div class="col-md-12">
                <label for="cdTipoLancamento">Tipo do Lançamento</label>
                <select class="form-select ${ msgs.containsKey('cdTipoLancamento') ? 'is-invalid' : '' }" aria-label="Select Tipo Lancamento" id="cdTipoLancamento" name="cdTipoLancamento" required>
	                <option value="">Selecione</option>
	                <c:forEach items="${ tiposLancamento }" var="tipoLancamento">
	                	<option value="${ tipoLancamento.id }" ${ lancamento.tipoLancamento.id == tipoLancamento.id ? "selected" : "" }>${ tipoLancamento.dsTipo }</option>
	                </c:forEach>
                </select>
                <c:if test="${msgs != null && not empty msgs.cdTipoLancamento}">
                    <div class="invalid-feedback">
                        ${ msgs.cdTipoLancamento }
                    </div>
                </c:if>
            </div>
            
            <div class="col-md-12" id="divTipoInvestimento">
                <label for="cdTipoInvestimento">Tipo Investimento</label>
                <select class="form-select ${ msgs.containsKey('cdTipoInvestimento') ? 'is-invalid' : '' }" aria-label="Select Tipo Investimento" id="cdTipoInvestimento" name="cdTipoInvestimento" required>
	                <option value="">Selecione</option>
	                <c:forEach items="${ tiposInvestimento }" var="tipoInvestimento">
	                	<option value="${ tipoInvestimento.id }" ${ lancamento.tipoInvestimento.id == tipoInvestimento.id ? "selected" : "" }>${ tipoInvestimento.dsTipoInvestimento }</option>
	                </c:forEach>
                </select>
                <c:if test="${msgs != null && not empty msgs.cdTipoInvestimento}">
                    <div class="invalid-feedback">
                        ${ msgs.cdTipoInvestimento }
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
<script>
	$(document).ready(function(){
		$('#vlLancamento').mask("#.##0,00", {reverse: true});
		if($('#cdTipoLancamento').val() == 3) {
			$('#divTipoInvestimento').show();
		} else {
			$('#divTipoInvestimento').hide();
		}
		$('#cdTipoLancamento').change(function() {
			if($(this).val() == 3) {
				$('#divTipoInvestimento').show();
			} else {
				$('#divTipoInvestimento').hide();
			}
		});
	})
</script>
<jsp:include page="./../template/footer.jsp" />