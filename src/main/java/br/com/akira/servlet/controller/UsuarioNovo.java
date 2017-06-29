package br.com.akira.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.akira.bean.model.Usuario;
import br.com.akira.dao.jdbc.UsuarioDAO;

public class UsuarioNovo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioNovo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		int nivel = Integer.parseInt(request.getParameter("nivel"));

		Usuario u = new Usuario();
		u.setNome(nome);
		u.setLogin(login);
		u.setSenha(senha);
		u.setNivel(nivel);

		UsuarioDAO dao = new UsuarioDAO();
		dao.adiciona(u);

//		request.getRequestDispatcher("/UsuarioLista").forward(request, response);
		response.sendRedirect("UsuarioLista");
	}

}
