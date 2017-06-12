package br.com.akira.bean.model;

public class Usuario {

	private int id;
	private String login;
	private String nome;
	private String senha;
	private int nivel;

	// teste para login
	public boolean UsuarioValido(String login, String senha) {
		if (login.equalsIgnoreCase("akira") && senha.equalsIgnoreCase("123")) {
			return true;
		} else {
			return false;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

}
