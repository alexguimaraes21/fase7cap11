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
import br.com.fiap.fase7cap11.services.TipoLancamentoService;

/**
 * Servlet implementation class ContaCadastroServlet
 */
@WebServlet("/tipo-lancamento/cadastro")
public class TipoLancamentoCadastroServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	TipoLancamentoService tipoLancamentoService = new TipoLancamentoService();
	AuthenticationService authService = new AuthenticationService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		getServletContext().getRequestDispatcher("/tipo-lancamento/cadastro.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String dsTipo = req.getParameter("dsTipo");
		
		Map<String, String> msgs = new HashMap<>();
		
		if(dsTipo.isBlank()) {
			msgs.put("dsTipo", "Campo obrigatório");
		}

		
		if(msgs.isEmpty()) {
			try {
				tipoLancamentoService.save(dsTipo, null);
				msgs.put("success", "Dados salvos com sucesso.");
			} catch (Exception e) {
				msgs.put("exception", "Erro ao salvar o tipo de lançamento. Tente novamente mais tarde!");
			}
		}
		
		req.setAttribute("msgs", msgs);
		getServletContext().getRequestDispatcher("/tipo-lancamento/cadastro.jsp").forward(req, resp);
	}

}
