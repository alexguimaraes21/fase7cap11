package br.com.fiap.fase7cap11.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fase7cap11.services.UsuarioService;

/**
 * Servlet implementation class EsqueciSenhaServlet
 */
@WebServlet("/auth/cadastro")
public class AuthCadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/auth/cadastro.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String cpf = req.getParameter("cpf");
		String senha = req.getParameter("senha");
		
		Map<String, String> errors = new HashMap<>();
		if(nome.isBlank()) {
			errors.put("nome", "Campo obrigatório");
		}
		
		UsuarioService usuarioService = new UsuarioService();
		
		doGet(req, resp);
	}

}
