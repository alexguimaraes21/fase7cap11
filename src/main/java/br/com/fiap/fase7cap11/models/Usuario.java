package br.com.fiap.fase7cap11.models;

public class Usuario {
	
	private Long id;
	private String vlCpf;
	private String dsSenha;
	private String nmUsuario;
	private String dsEmail;
	private boolean ckUsuarioAtivo;
	
	public Usuario() { }

	public Usuario(Long id, String vlCpf, String dsSenha, String nmUsuario, String dsEmail, boolean ckUsuarioAtivo) {
		this.id = id;
		this.vlCpf = vlCpf;
		this.dsSenha = dsSenha;
		this.nmUsuario = nmUsuario;
		this.dsEmail = dsEmail;
		this.ckUsuarioAtivo = ckUsuarioAtivo;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getVlCpf() {
		return vlCpf;
	}
	
	public void setVlCpf(String vlCpf) {
		this.vlCpf = vlCpf;
	}
	
	public String getDsSenha() {
		return dsSenha;
	}
	
	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
	}
	
	public String getNmUsuario() {
		return nmUsuario;
	}
	
	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}
	
	public String getDsEmail() {
		return dsEmail;
	}
	
	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}
	
	public boolean isCkUsuarioAtivo() {
		return ckUsuarioAtivo;
	}
	
	public void setCkUsuarioAtivo(boolean ckUsuarioAtivo) {
		this.ckUsuarioAtivo = ckUsuarioAtivo;
	}
}
