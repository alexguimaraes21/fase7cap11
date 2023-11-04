package br.com.fiap.fase7cap11.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthenticationService {
	
	UsuarioService usuarioService = new UsuarioService();
	
	public boolean authUser(String login, String password) {
		
		return false;
	}
	
	public boolean isAuthenticated(HttpServletRequest req) {
		HttpSession session = req.getSession();
		if(session != null) {
			return true;
		}
		return false;
	}
	
	public HttpSession getSession(HttpServletRequest req) {
		HttpSession session = req.getSession();
		if(session != null) {
			return session;
		}
		return null;
	}
}
