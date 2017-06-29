package br.com.akira.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.akira.bean.model.Usuario;
import br.com.akira.dao.jdbc.UsuarioDAO;

/**
 * Servlet implementation class UsuarioAltera
 */
public class UsuarioAltera extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioAltera() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		int nivel = Integer.parseInt(request.getParameter("nivel"));

		Usuario u = new Usuario();
		u.setId(id);
		u.setNome(nome);
		u.setLogin(login);
		u.setSenha(senha);
		u.setNivel(nivel);

		UsuarioDAO dao = new UsuarioDAO();
		dao.edita(u);

		request.getRequestDispatcher("/UsuarioLista2").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
