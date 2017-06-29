package br.com.akira.servlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.akira.bean.model.Usuario;
import br.com.akira.dao.jdbc.UsuarioDAO;

public class UsuarioServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioServlet2() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		if (acao == null) {
			acao = "listar";
		}

		if (acao.equals("listar")) {
			String numPagina = request.getParameter("numPagina");

			String nome = request.getParameter("nome");
			String ordem = request.getParameter("ordem");

			int limit = Integer.parseInt(request.getParameter("limit"));
			
			if (numPagina == null) {
				numPagina = "1";
			}
			limit = 10;
			nome ="akira";
			ordem = "nome";
			
			int offset = (Integer.parseInt(numPagina) * limit) - (limit);

			UsuarioDAO dao = new UsuarioDAO();
			List<Usuario> listacompleta = dao.listacompleta(nome, ordem, limit, offset);

			request.setAttribute("listaCompleta", listacompleta);
			request.getRequestDispatcher("usuarioListaCompleta1.jsp").forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
