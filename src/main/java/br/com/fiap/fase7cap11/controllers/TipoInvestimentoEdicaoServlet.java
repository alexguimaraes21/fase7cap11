package br.com.fiap.fase7cap11.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fase7cap11.models.TipoInvestimento;
import br.com.fiap.fase7cap11.services.TipoInvestimentoService;

/**
 * Servlet implementation class ContaEdicaoServlet
 */
@WebServlet("/tipo-investimento/editar/*")
public class TipoInvestimentoEdicaoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	TipoInvestimentoService tipoInvestimentoService = new TipoInvestimentoService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		String[] pathParts = pathInfo.split("/");
		Long id = Long.parseLong(pathParts[1]);

		TipoInvestimento tipoInvestimento = tipoInvestimentoService.getById(id);
		req.setAttribute("tipoInvestimento", tipoInvestimento);
		getServletContext().getRequestDispatcher("/tipo-investimento/editar.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));		
		String dsTipoInvestimento = req.getParameter("dsTipoInvestimento");
		Double vlRendimentoMensal = Double.parseDouble(req.getParameter("vlRendimentoMensal").replace(".", "").replace(",", "."));
		Integer prazoMinimoInvestimento = Integer.parseInt(req.getParameter("prazoMinimoInvestimento"));
		
		
		Map<String, String> msgs = new HashMap<>();
		
		if(dsTipoInvestimento.isBlank()) {
			msgs.put("dsTipoInvestimento", "Campo obrigatório");
		}
		
		if(vlRendimentoMensal == null) {
			msgs.put("vlRendimentoMensal", "Campo obrigatório");
		}
		
		if(vlRendimentoMensal <= 0.0) {
			msgs.put("vlRendimentoMensal", "O valor deve ser maior que zero");
		}
		
		if(prazoMinimoInvestimento == null) {
			msgs.put("prazoMinimoInvestimento", "Campo obrigatório");
		}
		
		if(prazoMinimoInvestimento <= 0) {
			msgs.put("prazoMinimoInvestimento", "O valor deve ser maior que zero");
		}

		
		if(msgs.isEmpty()) {
			try {
				tipoInvestimentoService.save(dsTipoInvestimento, vlRendimentoMensal, prazoMinimoInvestimento, id);
				msgs.put("success", "Dados salvos com sucesso.");
			} catch (Exception e) {
				msgs.put("exception", "Erro ao salvar o tipo de investimento. Tente novamente mais tarde!");
			}
		}
		
		req.setAttribute("msgs", msgs);
		getServletContext().getRequestDispatcher("/tipo-investimento/editar.jsp").forward(req, resp);
	}
}
