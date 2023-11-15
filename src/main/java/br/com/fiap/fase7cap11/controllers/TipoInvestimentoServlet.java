package br.com.fiap.fase7cap11.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fase7cap11.models.TipoInvestimento;
import br.com.fiap.fase7cap11.services.TipoInvestimentoService;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ContaServlet
 */
@WebServlet("/tipo-investimento")
public class TipoInvestimentoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	TipoInvestimentoService tipoInvestimentoService = new TipoInvestimentoService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TipoInvestimento> tipoInvestimento = tipoInvestimentoService.getAll();
		
		request.setAttribute("tiposInvestimento", tipoInvestimento);
		getServletContext().getRequestDispatcher("/tipo-investimento/index.jsp").forward(request, response);
	}
}
