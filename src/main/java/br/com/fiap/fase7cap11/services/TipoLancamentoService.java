package br.com.fiap.fase7cap11.services;

import java.util.List;

import br.com.fiap.fase7cap11.daos.TipoLancamentoDao;
import br.com.fiap.fase7cap11.models.TipoLancamento;

public class TipoLancamentoService {
	
	TipoLancamentoDao dao = new TipoLancamentoDao();

	public List<TipoLancamento> getAll() {
		return dao.getAll();
	}

	public TipoLancamento getById(long id) {
		return dao.getById(id);
	}

	public void save(String dsTipo, Long id) {
		TipoLancamento tipoLancamento = new TipoLancamento();
		if(id != null && id > 0) {
			tipoLancamento.setId(id);
		}
		tipoLancamento.setDsTipo(dsTipo);
		dao.save(tipoLancamento);
	}

	public void delete(long id) {
		dao.delete(id);		
	}

}
