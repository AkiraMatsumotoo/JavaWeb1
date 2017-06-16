package br.com.akira.servlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.akira.bean.model.Usuario;
import br.com.akira.dao.jdbc.UsuarioDAO;

public class UsuarioLista extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioLista() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> lista = dao.buscarTodos();
		request.setAttribute("sessaolista", lista);
		request.getRequestDispatcher("/usuariolista.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
