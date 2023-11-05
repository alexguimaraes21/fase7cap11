package br.com.fiap.fase7cap11.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fase7cap11.services.AuthenticationService;

@WebServlet("/auth/login")
public class AuthLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/auth/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("login");
		String password = req.getParameter("password");
		
		AuthenticationService authService = new AuthenticationService();
		
		Map<String, String> errors = new HashMap<>();

		if (username.length() <= 3) {
			errors.put("login", "Login deve conter no mínimo 4 caracteres");
		}
		
		if (username.isBlank()) {
			errors.put("login", "Campo obrigatório");
		}
		
		if (password.length() <= 5) {
			errors.put("password", "Senha deve conter no mínimo 6 caracteres");
		}
		
		if (password.isBlank()) {
			errors.put("password", "Campo obrigatório");
		}
		
		if (errors.isEmpty()) {
			try {
				Boolean userIsAuthenticated = authService.authUser(username, password, req);
				if (!userIsAuthenticated) {
					errors.put("authentication", "Usuário ou senha inválidos");
				} else {
					resp.sendRedirect(req.getContextPath() + "/");
					return;
				}
			} catch (Exception e) {
				errors.put("exception", "Erro na autenticação do usuário. Tente novamente mais tarde!");
			}
		}
		req.setAttribute("errors", errors);
		getServletContext().getRequestDispatcher("/auth/login.jsp").forward(req, resp);
	}

}
