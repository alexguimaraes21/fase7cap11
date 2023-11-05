package br.com.fiap.fase7cap11.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fase7cap11.services.AuthenticationService;

/**
 * Servlet implementation class AuthLogoutServlet
 */
@WebServlet("/auth/logout")
public class AuthLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AuthenticationService authService = new AuthenticationService();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		authService.destroySession(req);
		resp.sendRedirect(req.getContextPath() + "/auth/login");
	}
}
