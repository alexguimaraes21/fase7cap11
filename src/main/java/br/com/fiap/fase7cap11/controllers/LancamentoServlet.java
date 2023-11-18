package br.com.fiap.fase7cap11.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fase7cap11.models.Lancamento;
import br.com.fiap.fase7cap11.services.LancamentoService;

/**
 * Servlet implementation class LancamentoServlet
 */
@WebServlet("/lancamento")
public class LancamentoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;	
	LancamentoService lancamentoService = new LancamentoService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Lancamento> lancamentos = lancamentoService.getAll();
		
		request.setAttribute("lancamentos", lancamentos);
		getServletContext().getRequestDispatcher("/lancamento/index.jsp").forward(request, response);
	}
}
