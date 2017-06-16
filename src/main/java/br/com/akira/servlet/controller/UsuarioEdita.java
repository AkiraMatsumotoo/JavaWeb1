package br.com.akira.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.akira.bean.model.Usuario;
import br.com.akira.dao.jdbc.UsuarioDAO;

/**
 * Servlet implementation class UsuarioEdita
 */
public class UsuarioEdita extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioEdita() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String nivel = request.getParameter("nivel");

		Usuario u = new Usuario();
		u.setId(id);
		u.setNome(nome);
		u.setLogin(login);
		u.setSenha(senha);
		u.setSenha(nivel);
		
		UsuarioDAO dao = new UsuarioDAO();
		dao.edita(u);
		
		request.getRequestDispatcher("/Usuarioaltera.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
