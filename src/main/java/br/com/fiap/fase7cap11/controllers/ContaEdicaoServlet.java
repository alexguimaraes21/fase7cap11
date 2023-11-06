package br.com.fiap.fase7cap11.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fase7cap11.models.Conta;
import br.com.fiap.fase7cap11.models.Usuario;
import br.com.fiap.fase7cap11.services.AuthenticationService;
import br.com.fiap.fase7cap11.services.ContaService;

/**
 * Servlet implementation class ContaEdicaoServlet
 */
@WebServlet("/conta/editar/*")
public class ContaEdicaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ContaService contaService = new ContaService();
	AuthenticationService authService = new AuthenticationService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		String[] pathParts = pathInfo.split("/");
		Long idConta = Long.parseLong(pathParts[1]);

		Conta conta = contaService.getById(idConta);
		req.setAttribute("conta", conta);
		getServletContext().getRequestDispatcher("/conta/editar.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		String agencia = req.getParameter("agencia");
		String conta = req.getParameter("conta");
		String banco = req.getParameter("banco");
		
		Map<String, String> msgs = new HashMap<>();
		
		if(agencia.isBlank()) {
			msgs.put("agencia", "Campo obrigatório");
		}
		
		if(conta.isBlank()) {
			msgs.put("conta", "Campo obrigatório");
		}
		
		if(banco.isBlank()) {
			msgs.put("banco", "Campo obrigatório");
		}
		
		if(msgs.isEmpty()) {
			try {
				Usuario usuario = authService.getUsuario(req);
				contaService.save(agencia, conta, banco, usuario, id);
				msgs.put("success", "Dados salvos com sucesso.");
			} catch (Exception e) {
				msgs.put("exception", "Erro ao salvar a conta. Tente novamente mais tarde!");
			}
		}
		
		req.setAttribute("msgs", msgs);
		getServletContext().getRequestDispatcher("/conta/editar.jsp").forward(req, resp);
	}

}
