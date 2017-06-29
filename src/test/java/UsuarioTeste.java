import java.util.List;

import br.com.akira.bean.model.Usuario;
import br.com.akira.dao.jdbc.UsuarioDAO;

public class UsuarioTeste {

	public static void main(String[] args) {

		// BuscaTodos();
		// TotalUsuario();

		int limit = 5;
		int numeroPagina = 5;
		int offset = (numeroPagina * limit)-limit;
		
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> lista = dao.limitOffset(limit, offset);

		for (Usuario u : lista) {
			System.out.println("[ID : " + u.getId() + "]  [Nome : " + u.getNome() + "]");
		}

		System.out.println("Offset : " + offset);
		System.out.println("limit : " + limit);


		System.out.println("PAgina : " + numeroPagina);

	}

	private static void TotalUsuario() {
		UsuarioDAO dao = new UsuarioDAO();
//		int qtdUsuarios = dao.qtdUsuarios();
//		System.out.println("Total de USuarios : " + qtdUsuarios);
	}

	private static void BuscaTodos() {
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> lista = dao.buscarTodos();

		for (Usuario u : lista) {
			System.out.println("ID : " + u.getId());
			System.out.println("ID : " + u.getNome());
			System.out.println("ID : " + u.getLogin());
			System.out.println("ID : " + u.getSenha());
			System.out.println("ID : " + u.getNivel());
			System.out.println("##########################");
		}
	}
}
