package br.com.fiap.fase7cap11.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fase7cap11.services.TipoInvestimentoService;

/**
 * Servlet implementation class ContaEdicaoServlet
 */
@WebServlet("/tipo-investimento/excluir/*")
public class TipoInvestimentoExclusaoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	TipoInvestimentoService tipoInvestimentoService = new TipoInvestimentoService();


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		String[] pathParts = pathInfo.split("/");
		Long idTipoInvestimento = Long.parseLong(pathParts[1]);
		
		tipoInvestimentoService.delete(idTipoInvestimento);
		resp.sendRedirect(req.getContextPath() + "/tipo-investimento");
	}
}
