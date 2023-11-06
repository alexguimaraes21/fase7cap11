package br.com.fiap.fase7cap11.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fase7cap11.models.Usuario;
import br.com.fiap.fase7cap11.services.AuthenticationService;

@WebFilter({ "/index.jsp", "/conta/*", "/tipo-investimento/*", "/tipo-lancamento/*", "/lancamento/*" })
public class LoginFilter implements Filter {

	AuthenticationService authService = new AuthenticationService();
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Usuario usuario = this.authService.getUsuario((HttpServletRequest) request);
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse)response;
		if(usuario != null) {
			chain.doFilter(request, response);
		} else {
			resp.sendRedirect(req.getContextPath() + "/auth/login");
			return;
		}
	}
}
