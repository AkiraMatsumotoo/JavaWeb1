package br.com.akira.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.akira.bean.model.Usuario;

public class UsuarioDAO {

	Connection conn = ConnectionFactory.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;

	public Usuario UsuarioValido(String login, String senha) {
		String sql = "SELECT * FROM usuario WHERE login=? AND senha=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, login);
			ps.setString(2, senha);
			rs = ps.executeQuery();

			if (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
				u.setNivel(rs.getInt("nivel"));
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	public void adiciona(Usuario u) {
		String sql = "INSERT INTO usuario(nome,login,senha,nivel)VALUES(?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getNome());
			ps.setString(2, u.getLogin());
			ps.setString(3, u.getSenha());
			ps.setInt(4, u.getNivel());
			ps.execute();
			System.out.println("Adicionado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void exclui(Usuario u) {
		String sql = "DELETE FROM usuario WHERE id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getId());
			ps.execute();
			System.out.println("Excluido com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public void edita(Usuario u) {
		String sql = "UPDATE usuario SET nome=? login=? senha=? nivel=? WHERE id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getNome());
			ps.setString(2, u.getLogin());
			ps.setString(3, u.getSenha());
			ps.setInt(4, u.getNivel());
			ps.setInt(5, u.getId());
			ps.execute();
			System.out.println("Editado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public Usuario buscarPorId(int id) {
		String sql = "SELECT * FROM usuario WHERE id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
				u.setNivel(rs.getInt("nivel"));
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	public Usuario buscarPorNome(String nome) {
		String sql = "SELECT * FROM usuario WHERE nome=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, nome);
			rs = ps.executeQuery();

			if (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
				u.setNivel(rs.getInt("nivel"));
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	public List<Usuario> buscarTodos() {
		String sql = "SELECT * FROM usuario";
		ArrayList<Usuario> lista = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
				u.setNivel(rs.getInt("nivel"));
				lista.add(u);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
