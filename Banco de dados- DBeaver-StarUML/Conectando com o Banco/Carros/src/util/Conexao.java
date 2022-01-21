package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	static final String url = "jdbc:postgresql://localhost:5432/postgres"; //Caminho ao banco de dados
	static final String user = "postgres"; //Nome do usuário que quer acessar
	static final String password = "admin";//Senha do usuário

	public static Connection conectar() {
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return con;
	}
}