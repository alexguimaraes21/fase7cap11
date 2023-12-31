package br.com.fiap.fase7cap11.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fase7cap11.models.Conta;
import br.com.fiap.fase7cap11.services.ContaService;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ContaServlet
 */
@WebServlet("/conta")
public class ContaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ContaService contaService = new ContaService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Conta> contas = contaService.getAll();
		
		request.setAttribute("contas", contas);
		getServletContext().getRequestDispatcher("/conta/index.jsp").forward(request, response);
	}
}
