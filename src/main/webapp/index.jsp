<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="./template/header.jsp" />

<div class="p-3 pb-md-4 mx-auto">
	<h1><small>Bem vindo sr(a):</small> ${ sessionScope.usuario.nmUsuario }</h1>
	<hr>
</div>

<jsp:include page="./template/footer.jsp" />