package br.com.fiap.fase7cap11.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fase7cap11.services.TipoLancamentoService;

/**
 * Servlet implementation class ContaEdicaoServlet
 */
@WebServlet("/tipo-lancamento/excluir/*")
public class TipoLancamentoExclusaoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;	
	TipoLancamentoService tipoLancamentoService = new TipoLancamentoService();


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		String[] pathParts = pathInfo.split("/");
		Long idTipoLancamento = Long.parseLong(pathParts[1]);
		
		tipoLancamentoService.delete(idTipoLancamento);
		resp.sendRedirect(req.getContextPath() + "/tipo-lancamento");
	}
}
