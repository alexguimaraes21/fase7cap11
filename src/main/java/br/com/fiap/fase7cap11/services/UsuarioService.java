package br.com.fiap.fase7cap11.services;

import java.util.List;

import br.com.fiap.fase7cap11.daos.UsuarioDao;
import br.com.fiap.fase7cap11.models.Usuario;
import br.com.fiap.fase7cap11.utils.PasswordEncryption;

public class UsuarioService {
	
	UsuarioDao dao = new UsuarioDao();

	public List<Usuario> getAll() {
		return dao.getAll();
	}

	public Usuario getById(long id) {
		return dao.getById(id);
	}
	
	public Usuario getByCpfOrEmail(String login) {
		return dao.getByCpfOrEmail(login);
	}

	public void save(String vlCpf, String dsSenha, String nmUsuario, String dsEmail, Boolean ckUsuarioAtivo, Long id) {
		Usuario usuario = new Usuario();
		if(id != null && id > 0) {
			usuario.setId(id);
		}
		usuario.setVlCpf(vlCpf);
		usuario.setNmUsuario(nmUsuario);
		usuario.setDsSenha(PasswordEncryption.hashPassword(dsSenha));
		usuario.setDsEmail(dsEmail);
		usuario.setCkUsuarioAtivo(ckUsuarioAtivo);
		dao.save(usuario);
	}

	public void delete(long id) {
		dao.delete(id);		
	}

}
