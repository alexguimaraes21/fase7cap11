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
@WebServlet("/conta")
public class ContaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/conta/index.jsp").forward(request, response);
	}
}
