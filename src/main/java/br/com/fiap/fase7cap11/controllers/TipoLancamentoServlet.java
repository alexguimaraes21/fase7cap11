package br.com.fiap.fase7cap11.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fase7cap11.models.TipoLancamento;
import br.com.fiap.fase7cap11.services.TipoLancamentoService;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ContaServlet
 */
@WebServlet("/tipo-lancamento")
public class TipoLancamentoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;	
	TipoLancamentoService tipoLancamentoService = new TipoLancamentoService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TipoLancamento> tipoLancamento = tipoLancamentoService.getAll();
		
		request.setAttribute("tiposLancamento", tipoLancamento);
		getServletContext().getRequestDispatcher("/tipo-lancamento/index.jsp").forward(request, response);
	}
}
