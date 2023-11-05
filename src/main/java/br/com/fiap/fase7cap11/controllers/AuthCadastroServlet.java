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
	
	private UsuarioService usuarioService = new UsuarioService();
       
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
		String senha = req.getParameter("password");
		
		cpf = cpf.replace(".", "");
		cpf = cpf.replace("-", "");
		
		Map<String, String> msgs = new HashMap<>();
		
		if(nome.length() < 10) {
			msgs.put("nome", "O campo deve conter no mínimo 10 caracteres");
		}
		
		if(nome.length() > 150) {
			msgs.put("nome", "O campo deve conter no máximo 150 caracteres");
		}
		
		if(nome.isBlank()) {
			msgs.put("nome", "Campo obrigatório");
		}
		
		if(cpf.length() < 11) {
			msgs.put("cpf", "O campo deve conter 14 caracteres");
		}
		
		if(cpf.isBlank()) {
			msgs.put("cpf", "Campo obrigatório");
		}
		
		if(!email.contains("@") && !email.contains(".") && email.length() < 6) {
			msgs.put("email", "E-mail inválido");
		}
		
		if(email.isBlank()) {
			msgs.put("email", "Campo obrigatório");
		}
		
		if(senha.length() < 6) {
			msgs.put("password", "A senha deve conter no mínimo 6 caracteres");
		}
		
		if(senha.length() > 20) {
			msgs.put("password", "A senha deve conter no máximo 20 caracteres");
		}
		
		if(senha.isBlank()) {
			msgs.put("password", "Campo obrigatório");
		}
		
		if (msgs.isEmpty()) {
			try {
				usuarioService.save(cpf, senha, nome, email, true, null);
				msgs.put("success", "Dados salvos com sucesso. Clique no link 'Login' para realizar login no sistema!");
			} catch (Exception e) {
				msgs.put("exception", "Erro ao salvar os dados. Tente novamente mais tarde!");
			}
		}
		
		req.setAttribute("msgs", msgs);
		getServletContext().getRequestDispatcher("/auth/cadastro.jsp").forward(req, resp);
	}

}
