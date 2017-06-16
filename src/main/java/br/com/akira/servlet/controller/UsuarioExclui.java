package br.com.akira.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.akira.bean.model.Usuario;
import br.com.akira.dao.jdbc.UsuarioDAO;

/**
 * Servlet implementation class UsuarioExclui
 */
public class UsuarioExclui extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioExclui() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Usuario u = new Usuario();
		u.setId(id);
		
		UsuarioDAO dao = new UsuarioDAO();
		dao.exclui(u);
		
		request.getRequestDispatcher("/UsuarioLista").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
