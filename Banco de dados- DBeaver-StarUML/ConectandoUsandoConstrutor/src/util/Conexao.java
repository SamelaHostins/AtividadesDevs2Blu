package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	//Classe que far? a conex?o com o banco de dados
	
	static final String url = "jdbc:postgresql://localhost:5432/postgres"; //Caminho ao banco de dados
	static final String user = "postgres"; //Nome do usu?rio que quer acessar
	static final String password = "admin";//Senha do usu?rio
	static Connection con = null;
	public static Connection conectar() {		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//Metodo que fecha a conex?o
	public static Connection fecharConexao() {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return con;
		}
	}
