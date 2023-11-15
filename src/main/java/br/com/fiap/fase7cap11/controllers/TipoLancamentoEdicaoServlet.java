package br.com.fiap.fase7cap11.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fase7cap11.models.TipoLancamento;
import br.com.fiap.fase7cap11.services.TipoLancamentoService;

/**
 * Servlet implementation class ContaEdicaoServlet
 */
@WebServlet("/tipo-lancamento/editar/*")
public class TipoLancamentoEdicaoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	TipoLancamentoService tipoLancamentoService = new TipoLancamentoService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		String[] pathParts = pathInfo.split("/");
		Long id = Long.parseLong(pathParts[1]);

		TipoLancamento tipoLancamento = tipoLancamentoService.getById(id);
		req.setAttribute("tipoLancamento", tipoLancamento);
		getServletContext().getRequestDispatcher("/tipo-lancamento/editar.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		String dsTipo = req.getParameter("dsTipo");
		
		Map<String, String> msgs = new HashMap<>();
		
		if(dsTipo.isBlank()) {
			msgs.put("dsTipo", "Campo obrigatório");
		}
		
		if(msgs.isEmpty()) {
			try {
				tipoLancamentoService.save(dsTipo, id);
				msgs.put("success", "Dados salvos com sucesso.");
			} catch (Exception e) {
				msgs.put("exception", "Erro ao salvar o Tipo de Lançamento. Tente novamente mais tarde!");
			}
		}
		
		req.setAttribute("msgs", msgs);
		getServletContext().getRequestDispatcher("/tipo-lancamento/editar.jsp").forward(req, resp);
	}
}
