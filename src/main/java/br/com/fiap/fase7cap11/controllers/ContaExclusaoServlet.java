package br.com.fiap.fase7cap11.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fase7cap11.services.ContaService;

/**
 * Servlet implementation class ContaEdicaoServlet
 */
@WebServlet("/conta/excluir/*")
public class ContaExclusaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ContaService contaService = new ContaService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		String[] pathParts = pathInfo.split("/");
		Long idConta = Long.parseLong(pathParts[1]);
		
		contaService.delete(idConta);
		resp.sendRedirect(req.getContextPath() + "/conta");
	}
}
