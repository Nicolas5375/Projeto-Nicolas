package modelo.dao.animal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.entidade.animal.Animal;

public class AnimalDaoImpl implements AnimalDao {

	public void inserirAnimal(Animal animal) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {
			conexao = conectarBanco();
			insert = conexao.prepareStatement("INSERT INTO animal (raca_animal, cor_animal) VALUES (?,?)");

			insert.setString(1, animal.getRaca());
			insert.setString(2, animal.getCor());

			insert.execute();
			System.out.println("Animal salvo!");

		} catch (SQLException erro) {
			erro.printStackTrace();
		} finally {

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

	public void deletarAnimal(Animal animal) {

		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM animal WHERE id_animal = ?");

			delete.setLong(1, animal.getId());

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

	public void atualizarRacaAnimal(Animal animal, String novaRaca) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE animal SET raca_animal = ? WHERE id_animal = ?");

			update.setString(1, novaRaca);
			update.setLong(2, animal.getId());

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

	public void atualizarCorAnimal(Animal animal, String novaCor) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE animal SET cor_animal = ? WHERE id_animal = ?");

			update.setString(1, novaCor);
			update.setLong(2, animal.getId());

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

	public List<Animal> recuperarAnimal() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Animal> animal = new ArrayList<Animal>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM animal");

			while (resultado.next()) {

				Long id = resultado.getLong("id_animal");

				String raca = resultado.getString("raca_animal");
				String cor = resultado.getString("cor_animal");

				animal.add(new Animal(id, raca, cor));
			}

		} catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

			try {

				if (resultado != null)
					resultado.close();

				if (consulta != null)
					consulta.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}
		return animal;

	}

	private Connection conectarBanco() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(
				"jdbc:mysql://localhost/projeto?user=root&password=root&serverTimezone=America/Sao_Paulo");
	}

}
