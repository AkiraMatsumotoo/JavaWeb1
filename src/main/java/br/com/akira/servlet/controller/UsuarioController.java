package br.com.akira.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.akira.bean.model.Usuario;
import br.com.akira.dao.jdbc.UsuarioDAO;

@WebServlet("/usuController")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuarioValido = dao.UsuarioValido(login, senha);

		if (usuarioValido != null) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuValido", usuarioValido.getNome());
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "Login/Senha Invalidos");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}

}
