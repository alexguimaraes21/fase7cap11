package br.com.fiap.fase7cap11.services;

import java.util.Date;
import java.util.List;

import br.com.fiap.fase7cap11.daos.LancamentoDao;
import br.com.fiap.fase7cap11.models.Conta;
import br.com.fiap.fase7cap11.models.Lancamento;
import br.com.fiap.fase7cap11.models.TipoInvestimento;
import br.com.fiap.fase7cap11.models.TipoLancamento;
import br.com.fiap.fase7cap11.models.Usuario;

public class LancamentoService {
	
	LancamentoDao dao = new LancamentoDao();

	public List<Lancamento> getAll() {
		return dao.getAll();
	}

	public Lancamento getById(Long id) {
		return dao.getById(id);
	}

	public void save(double vlLancamento, String dsLancamento, Long cdTipoLancamento, Long cdConta, Long cdTipoInvestimento, Usuario usuario, Long id) {
		TipoLancamento tipoLancamento = new TipoLancamento();
		tipoLancamento.setId(cdTipoLancamento);
		
		TipoInvestimento tipoInvestimento = new TipoInvestimento();
		tipoInvestimento.setId(cdTipoInvestimento);
		
		Conta conta = new Conta();
		conta.setId(cdConta);
		
		Lancamento lancamento = new Lancamento();
		if(id != null && id > 0) {
			lancamento.setId(id);
		}
		try {
			Date dataLancamento = new Date();
			lancamento.setVlLancamento(vlLancamento);
			lancamento.setDtLancamento(dataLancamento);
			lancamento.setDsLancamento(dsLancamento);
			lancamento.setTipoLancamento(tipoLancamento);
			if(tipoLancamento.getId() == 3) {
				lancamento.setTipoInvestimento(tipoInvestimento);
			}
			lancamento.setConta(conta);
			lancamento.setUsuario(usuario);
			dao.save(lancamento);
		} catch (Exception e) {
			System.out.println("Erro na data do Lançamento. Formato de data aceito: dd/mm/yyyy");
			System.out.println(e.getMessage());
		}
	}

	public void delete(Long id) {
		dao.delete(id);		
	}

}
