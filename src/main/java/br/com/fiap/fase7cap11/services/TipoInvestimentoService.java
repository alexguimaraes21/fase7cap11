package br.com.fiap.fase7cap11.services;

import java.util.List;

import br.com.fiap.fase7cap11.daos.TipoInvestimentoDao;
import br.com.fiap.fase7cap11.models.TipoInvestimento;

public class TipoInvestimentoService {
	
	TipoInvestimentoDao dao = new TipoInvestimentoDao();

	public List<TipoInvestimento> getAll() {
		return dao.getAll();
	}

	public TipoInvestimento getById(long id) {
		return dao.getById(id);
	}

	public void save(String dsTipoInvestimento, double vlRendimentoMensal, int prazoMinimoInvestimento, Long id) {
		TipoInvestimento tipoInvestimento = new TipoInvestimento();
		if(id != null && id > 0) {
			tipoInvestimento.setId(id);
		}
		tipoInvestimento.setDsTipoInvestimento(dsTipoInvestimento);
		tipoInvestimento.setVlRendimentoMensal(vlRendimentoMensal);
		tipoInvestimento.setPrazoMinimoInvestimento(prazoMinimoInvestimento);
		dao.save(tipoInvestimento);
	}

	public void delete(long id) {
		dao.delete(id);		
	}

}
