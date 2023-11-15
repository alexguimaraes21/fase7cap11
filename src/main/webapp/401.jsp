<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="./template/header.jsp" />


	<div class="container text-center">
		<div class="row justify-content-md-center">
			<div class="col col-xs-12 col-sm-8 col-md-6 col-lg-4">
				<div class="alert alert-danger" role="alert">
					<p>
						<strong>Erro 401</strong><br />
						Você não tem permissão para acessar essa página!
					</p>
				</div>
			</div>
		</div>
	</div>


<jsp:include page="./template/footer.jsp" />