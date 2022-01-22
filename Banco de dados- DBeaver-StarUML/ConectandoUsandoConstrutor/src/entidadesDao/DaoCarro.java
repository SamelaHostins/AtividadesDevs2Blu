package entidadesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Carro;
import interfaces.InterfacesDao;
import util.Conexao;

public class DaoCarro implements InterfacesDao<Carro> {
	
	/**Classe que implementa a interface, tem por objetivo 
	 * organizar os códigos que serão necessário para mexer 
	 * no banco.
	 */

	//Método salvar, devido ao parâmetro passado a partir de agora se usa o getter para chamar os atributos
	@Override
	public boolean salvar(Carro t) {
		Connection con = Conexao.conectar();	
		String sql = "insert into carro(placa, marca, modelo) values(?,?,?)";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, t.getPlaca());
			stm.setString(2, t.getMarca());
			stm.setString(3, t.getModelo());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//Finally é um bloco que sempre é executado independente se der um erro ou não.
		//Ele tb precisa de um try catch, usamos isso para que o banco sempre tenha sua 
		//conexão fechada não importa o que houver
		finally {
			Conexao.fecharConexao();
		}
		return true;
	}

	@Override
	public boolean update(Carro t) {
		Connection con = Conexao.conectar();	
		String sql = "update carro set placa=?, marca =?, modelo =?";
		sql += "where id = ?";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, t.getPlaca());
			stm.setString(2, t.getMarca());
			stm.setString(3, t.getModelo());
			stm.setInt(4, t.getId());//Agora estará alterando o id, fzd com que ele mude por isso precisa adicioná-lo
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			Conexao.fecharConexao();
		}
		return true;
	}

	@Override
	public boolean excluir(int id) {
		String sql = "delete from carro where id = ?";
		try {
			PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
			stm.setInt(1,id);
			stm.execute();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			Conexao.fecharConexao();
		}
		return true;		
	}
	
	@Override
	public boolean excluir(Carro t) {
		String sql = "delete from carro where id = ?";
		try {
			PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
			stm.setInt(1,t.getId());
			stm.execute();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			Conexao.fecharConexao();
		}
		return true;		
	}


	@Override
	public Carro retornarUm(int id) {
		Carro carro = null;
		String sql = "select * from carro where id = " + id;
		try {
			PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()) {
				carro = new Carro(rs.getInt("id"), 
				rs.getString("placa"),
				rs.getString("marca"),
				rs.getString("modelo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			Conexao.fecharConexao();
		}
		return carro;		
	}

	@Override
	public List<Carro> retornarTodos() {
		List<Carro> carros = new ArrayList<>();
		String sql = "select * from carro";
		try {
			PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
			//Resultset retorna os dados do banco
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				carros.add(new Carro(rs.getInt("id"), rs.getString("placa"),rs.getString("marca"), 
						rs.getString("modelo")));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		finally {
			Conexao.fecharConexao();
		}
		return carros;
	}

}
