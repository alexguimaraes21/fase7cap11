<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./../template/header.jsp" />


<div class="p-3 pb-md-4 mx-auto">
	<h1>Cadastro de Tipo de Investimento</h1>
</div>
<div class="card">
    <div class="card-header">Cadastro de Tipo de Investimento</div>
    <div class="card-body">
        <form action="${pageContext.request.contextPath}/tipo-investimento/cadastro" method="post" class="row g-3 needs-validation" novalidate>
            <div class="col-md-12">
                <label for="dsTipoInvestimento">Tipo de Investimento</label>
                <input type="text" class="form-control ${ msgs.containsKey('dsTipoInvestimento') ? 'is-invalid' : '' }" id="dsTipoInvestimento" name="dsTipoInvestimento" placeholder="Digite a descrição do tipo de investimento" minlength="1" maxlength="20" required="required">
                <c:if test="${msgs != null && not empty msgs.dsTipoInvestimento}">
                    <div class="invalid-feedback">
                        ${ msgs.dsTipoInvestimento }
                    </div>
                </c:if>
            </div>
            
            <div class="col-md-12">
                <label for="vlRendimentoMensal">% do Rendimento Mensal</label>
                <input type="text" class="form-control money2 ${ msgs.containsKey('vlRendimentoMensal') ? 'is-invalid' : '' }" id="vlRendimentoMensal" name="vlRendimentoMensal" placeholder="Digite a % do rendimento mensal" minlength="1" maxlength="20" required="required">
                <c:if test="${msgs != null && not empty msgs.vlRendimentoMensal}">
                    <div class="invalid-feedback">
                        ${ msgs.vlRendimentoMensal }
                    </div>
                </c:if>
            </div>
            
            <div class="col-md-12">
                <label for="prazoMinimoInvestimento">Tempo mínimo do investimento em meses</label>
                <input type="number" class="form-control ${ msgs.containsKey('prazoMinimoInvestimento') ? 'is-invalid' : '' }" id="prazoMinimoInvestimento" name="prazoMinimoInvestimento" placeholder="Digite o tempo mínimo do investimento em meses" required="required">
                <c:if test="${msgs != null && not empty msgs.prazoMinimoInvestimento}">
                    <div class="invalid-feedback">
                        ${ msgs.prazoMinimoInvestimento }
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
		$('#vlRendimentoMensal').mask("#.##0,00", {reverse: true});
	})
</script>

<jsp:include page="./../template/footer.jsp" />