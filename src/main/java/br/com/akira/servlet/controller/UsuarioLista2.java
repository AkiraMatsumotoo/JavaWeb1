package br.com.akira.servlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.akira.bean.model.Usuario;
import br.com.akira.dao.jdbc.UsuarioDAO;

/**
 * Servlet implementation class UsuarioLista2
 */
public class UsuarioLista2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioLista2() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

		String numeropagina = request.getParameter("numeroPagina");

		// Inicia a lista na pagina 1 caso não passe nenhum parametro
		if (numeropagina == null) {
			numeropagina = "1";
		}
		// Quantidade de usuarios mostrar na lista =16 por pagina
		int limit = 16;

		//numero da pagina * limite=16 ....Resultado - limite
		int offset = (Integer.parseInt(numeropagina) * limit) - limit;
		
		//instacio DAO 
		//Passo o limite 16
		//o resultado da conta que eh o offset
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> lista = dao.limitOffset(limit, offset);

		String nome1 = request.getParameter("nome");
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
