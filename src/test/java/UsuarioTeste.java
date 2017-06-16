import java.util.List;

import br.com.akira.bean.model.Usuario;
import br.com.akira.dao.jdbc.UsuarioDAO;

public class UsuarioTeste {

	public static void main(String[] args) {

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
