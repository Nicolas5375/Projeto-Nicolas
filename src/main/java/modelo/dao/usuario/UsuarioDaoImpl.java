package modelo.dao.usuario;

import modelo.entidade.usuario.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDaoImpl implements UsuarioDao{
	
	public void inserirUsuario(Usuario usuario) {
		
		Connection conexao = null;
		PreparedStatement insert = null;
		

		
		
		try { 
			
		    
			
			conexao = conectarBanco();
			insert = conexao.prepareStatement("INSERT INTO usuario (nome_usuario, sobrenome_usuario, email_usuario, senha_usuario) VALUES (?,?,?,?)");
		
			insert.setString(1, usuario.getNome());
			insert.setString(2, usuario.getSobrenome());
			insert.setString(3, usuario.getEmail());
			insert.setString(4, usuario.getSenha());
			System.out.println("Usuário salvo!");
			insert.execute();
		} catch (SQLException erro) {
			erro.printStackTrace();
		}
		finally {

			try {

				if (insert != null)
					insert.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}
	}
	
public void deletarUsuario(Usuario usuario) {
		
		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM usuario WHERE id_usuario = ?");

			delete.setLong(1, usuario.getId());

			delete.execute();

		} catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

			try {

				if (delete != null)
					delete.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}
	}
	
public void atualizarNomeUsuario(Usuario usuario, String novoNome) {
	
	Connection conexao = null;
	PreparedStatement update = null;

	try {

		conexao = conectarBanco();
		update = conexao.prepareStatement("UPDATE usuario SET nome_usuario = ? WHERE id_usuario = ?");
		
		update.setString(1, novoNome);
		update.setLong(2, usuario.getId());

		update.execute();

	} catch (SQLException erro) {
		erro.printStackTrace();
	}

	finally {

		try {

			if (update != null)
				update.close();

			if (conexao != null)
				conexao.close();

		} catch (SQLException erro) {

			erro.printStackTrace();
		}
	}
}

public void atualizarEmailUsuario(Usuario usuario, String novoEmail) {
	
	Connection conexao = null;
	PreparedStatement update = null;

	try {

		conexao = conectarBanco();
		update = conexao.prepareStatement("UPDATE usuario SET email_usuario = ? WHERE id_usuario = ?");
		
		update.setString(1, novoEmail);
		update.setLong(2, usuario.getId());

		update.execute();

	} catch (SQLException erro) {
		erro.printStackTrace();
	}

	finally {

		try {

			if (update != null)
				update.close();

			if (conexao != null)
				conexao.close();

		} catch (SQLException erro) {

			erro.printStackTrace();
		}
	}
}

public void atualizarSobrenomeUsuario(Usuario usuario, String novoSobrenome) {
	
	Connection conexao = null;
	PreparedStatement update = null;

	try {

		conexao = conectarBanco();
		update = conexao.prepareStatement("UPDATE usuario SET sobrenome_usuario = ? WHERE id_usuario = ?");
		
		update.setString(1, novoSobrenome);
		update.setLong(2, usuario.getId());

		update.execute();

	} catch (SQLException erro) {
		erro.printStackTrace();
	}

	finally {

		try {

			if (update != null)
				update.close();

			if (conexao != null)
				conexao.close();

		} catch (SQLException erro) {

			erro.printStackTrace();
		}
	}
}

public void atualizarSenhaUsuario(Usuario usuario, String novaSenha) {
	
	Connection conexao = null;
	PreparedStatement update = null;

	try {

		conexao = conectarBanco();
		update = conexao.prepareStatement("UPDATE usuario SET senha_usuario = ? WHERE id_usuario = ?");
		
		update.setString(1, novaSenha);
		update.setLong(2, usuario.getId());

		update.execute();

	} catch (SQLException erro) {
		erro.printStackTrace();
	}

	finally {

		try {

			if (update != null)
				update.close();

			if (conexao != null)
				conexao.close();

		} catch (SQLException erro) {

			erro.printStackTrace();
		}
	}
}

private Connection conectarBanco() throws SQLException {
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
	return DriverManager.getConnection("jdbc:mysql://localhost/projeto?user=root&password=root&serverTimezone=America/Sao_Paulo");
}

	}