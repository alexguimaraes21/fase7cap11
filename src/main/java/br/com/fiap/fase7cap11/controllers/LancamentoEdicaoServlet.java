package br.com.fiap.fase7cap11.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fase7cap11.models.Conta;
import br.com.fiap.fase7cap11.models.Lancamento;
import br.com.fiap.fase7cap11.models.TipoInvestimento;
import br.com.fiap.fase7cap11.models.TipoLancamento;
import br.com.fiap.fase7cap11.models.Usuario;
import br.com.fiap.fase7cap11.services.AuthenticationService;
import br.com.fiap.fase7cap11.services.ContaService;
import br.com.fiap.fase7cap11.services.LancamentoService;
import br.com.fiap.fase7cap11.services.TipoInvestimentoService;
import br.com.fiap.fase7cap11.services.TipoLancamentoService;

/**
 * Servlet implementation class ContaEdicaoServlet
 */
@WebServlet("/lancamento/editar/*")
public class LancamentoEdicaoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	LancamentoService lancamentoService = new LancamentoService();
	TipoLancamentoService tipoLancamentoService = new TipoLancamentoService();
	TipoInvestimentoService tipoInvestimentoService = new TipoInvestimentoService();
	AuthenticationService authService = new AuthenticationService();
	ContaService contaService = new ContaService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		String[] pathParts = pathInfo.split("/");
		Long id = Long.parseLong(pathParts[1]);
		
		Lancamento lancamento = lancamentoService.getById(id);
		req.setAttribute("lancamento", lancamento);
		List<Conta> contas = contaService.getAll();
		List<TipoLancamento> tiposLancamento = tipoLancamentoService.getAll();
		List<TipoInvestimento> tiposInvestimento = tipoInvestimentoService.getAll();
		req.setAttribute("contas", contas);
		req.setAttribute("tiposLancamento", tiposLancamento);
		req.setAttribute("tiposInvestimento", tiposInvestimento);
		getServletContext().getRequestDispatcher("/lancamento/editar.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		String dsLancamento = req.getParameter("dsLancamento");
		Usuario usuario = authService.getUsuario(req);		
		
		Map<String, String> msgs = new HashMap<>();
		
		Double vlLancamento = null;
		if(!req.getParameter("vlLancamento").isBlank()) {
			vlLancamento = Double.parseDouble(req.getParameter("vlLancamento").replace(".", "").replace(",", "."));
		} else {
			msgs.put("vlLancamento", "Campo obrigatório");
		}
		
		Long cdTipoLancamento = null;
		if(!req.getParameter("cdTipoLancamento").isBlank()) {
			cdTipoLancamento = Long.parseLong(req.getParameter("cdTipoLancamento"));
		} else {
			msgs.put("cdTipoLancamento", "Campo obrigatório");
		}
		
		Long cdConta = null;
		if(!req.getParameter("cdConta").isBlank()) {
			cdConta = Long.parseLong(req.getParameter("cdConta"));
		} else {
			msgs.put("cdConta", "Campo obrigatório");
		}
		
		Long cdTipoInvestimento = null;
		if(!req.getParameter("cdTipoInvestimento").isBlank()) {
			cdTipoInvestimento = Long.parseLong(req.getParameter("cdTipoInvestimento"));
		}
		
		if(req.getParameter("cdTipoLancamento") == "3" && req.getParameter("cdTipoInvestimento").isBlank()) {
			msgs.put("cdTipoInvestimento", "Tipo Investimento é obrigatório quando o Tipo de Lançamento for Investimento");
		}	
		
		if(dsLancamento.isBlank()) {
			msgs.put("dsLancamento", "Campo obrigatório");
		}
		
		if(dsLancamento.length() < 3 || dsLancamento.length() > 50) {
			msgs.put("dsLancamento", "O campo deve conter entre 3 e 50 caracteres");
		}

		if(msgs.isEmpty()) {
			try {
				lancamentoService.save(vlLancamento, dsLancamento, cdTipoLancamento, cdConta, cdTipoInvestimento, usuario, id);
				msgs.put("success", "Dados salvos com sucesso."); 
			} catch (Exception e) {
				msgs.put("exception", "Erro ao salvar o tipo de lançamento. Tente novamente mais tarde!");
			}
		}
		
		req.setAttribute("msgs", msgs);
		List<Conta> contas = contaService.getAll();
		List<TipoLancamento> tiposLancamento = tipoLancamentoService.getAll();
		List<TipoInvestimento> tiposInvestimento = tipoInvestimentoService.getAll();
		req.setAttribute("contas", contas);
		req.setAttribute("tiposLancamento", tiposLancamento);
		req.setAttribute("tiposInvestimento", tiposInvestimento);
		getServletContext().getRequestDispatcher("/lancamento/cadastro.jsp").forward(req, resp);
	}

}
