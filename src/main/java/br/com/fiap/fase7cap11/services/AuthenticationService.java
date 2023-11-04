package br.com.fiap.fase7cap11.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.fiap.fase7cap11.models.Usuario;
import br.com.fiap.fase7cap11.utils.PasswordEncryption;

public class AuthenticationService {
	
	UsuarioService usuarioService = new UsuarioService();
	
	public boolean authUser(String login, String password, HttpServletRequest req) {
		Usuario usuario = usuarioService.getByCpfOrEmail(login);
		if (usuario != null) {
			String encryptedPassword = PasswordEncryption.hashPassword(password);
			if(encryptedPassword.equals(usuario.getDsSenha())) {
				this.setSession(null, usuario);
				return true;
			}
			return false;
		}
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
	
	public void setSession(HttpServletRequest req, Usuario usuario) {
		HttpSession session = req.getSession();
		session.setAttribute("usuario", usuario);
	}
}
