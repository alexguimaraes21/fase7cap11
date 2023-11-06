package br.com.fiap.fase7cap11.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ContaServlet
 */
@WebServlet("/tipo-investimento")
public class TipoInvestimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TipoInvestimentoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher("/tipo-investimento/index.jsp").forward(request, response);
	}
}
