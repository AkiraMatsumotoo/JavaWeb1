package br.com.akira.servlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.akira.bean.model.Usuario;
import br.com.akira.dao.jdbc.UsuarioDAO;

public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String nivel = request.getParameter("nivel");

		UsuarioDAO dao = new UsuarioDAO();

		Usuario u = new Usuario();

		if (acao == null) {
			acao = "listar";
		}

		if (acao.equals("alterar")) {
			u.setId(Integer.parseInt(id));
			u.setNivel(Integer.parseInt(nivel));
			u.setNome(nome);
			u.setLogin(login);
			u.setSenha(senha);

			dao.edita(u);
			// request.getRequestDispatcher("/UsuarioLista2").forward(request,response);
			response.sendRedirect("UsuarioServlet");

		}

		else if (acao.equals("excluir")) {
			u.setId(Integer.parseInt(id));
			dao.exclui(u);
			// request.getRequestDispatcher("/UsuarioServlet?acao=listar").forward(request,
			// response);
			response.sendRedirect("UsuarioServlet");

		}

		else if (acao.equals("pesquisar")) {
			String numeropagina = request.getParameter("numeroPagina");
			
			// Inicia a lista na pagina 1 caso não passe nenhum parametro
			if (numeropagina == null) {
				numeropagina = "1";
			}

			// Quantidade de usuarios mostrar na lista =16 por pagina
			int limit = 16;

			// numero da pagina * limite=16 ....Resultado - limite
			int offset = (Integer.parseInt(numeropagina) * limit) - limit;

			// instacio DAO
			// Passo o limite 16
			// o resultado da conta que eh o offset
			List<Usuario> lista = dao.limitOffset(limit, offset);
			
			String nome1 = request.getParameter("nome");
			u.setNome(nome1);

			// mostra o total de registro de usuarios no banco
			int totalDeRegistro = dao.qtdUsuarios(nome1);

			int totalDePaginas = (totalDeRegistro / limit);

			// Se o total de registro divido pelo limit for diferente de 0(zero)
			// adiciona uma pagina
			if (totalDeRegistro % limit != 0) {
				totalDePaginas++;
			}

			List<Usuario> pesquisa = dao.buscarPorNome(u, limit, offset);

			request.setAttribute("pesquisa", pesquisa);
			request.setAttribute("totalDeRegistro", totalDeRegistro);
			request.setAttribute("totalDePaginas", totalDePaginas);
			request.getRequestDispatcher("usuarioPesquisa.jsp").forward(request, response);
		}

		else if (acao.equals("listar")) {
			String numeropagina = request.getParameter("numeroPagina");
			String nome1 = request.getParameter("nome");
			u.setNome(nome1);

			// Inicia a lista na pagina 1 caso não passe nenhum parametro
			if (numeropagina == null) {
				numeropagina = "1";
			}
			// Quantidade de usuarios mostrar na lista =16 por pagina
			int limit = 16;

			// numero da pagina * limite=16 ....Resultado - limite
			int offset = (Integer.parseInt(numeropagina) * limit) - limit;

			// instacio DAO
			// Passo o limite 16
			// o resultado da conta que eh o offset
			List<Usuario> lista = dao.limitOffset(limit, offset);

			// mostra o total de registro de usuarios no banco
			int totalDeRegistro = dao.qtdUsuarios(nome1);

			int totalDePaginas = (totalDeRegistro / limit);

			// Se o total de registro divido pelo limit for diferente de 0(zero)
			// adiciona uma pagina
			if (totalDeRegistro % limit != 0) {
				totalDePaginas++;
			}

			request.setAttribute("lista", lista);
			request.setAttribute("totalDeRegistro", totalDeRegistro);
			request.setAttribute("totalDePaginas", totalDePaginas);
			request.getRequestDispatcher("usuarioLista2.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String nivel = request.getParameter("nivel");

		Usuario u = new Usuario();

		u.setNome(nome);
		u.setLogin(login);
		u.setSenha(senha);
		u.setNivel(Integer.parseInt(nivel));

		UsuarioDAO dao = new UsuarioDAO();
		dao.adiciona(u);

		response.sendRedirect("UsuarioServlet");
	}

}
