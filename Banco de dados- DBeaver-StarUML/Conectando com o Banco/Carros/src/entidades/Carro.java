package entidades;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Conexao;

public class Carro {

	int id;
	String placa;
	String modelo;
	String marca;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	//Método que salva no banco
	public boolean salvar() {
		Connection con = Conexao.conectar();	
		String sql = "insert into carro(placa, marca, modelo) values(?,?,?)";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, this.placa);
			stm.setString(2, this.marca);
			stm.setString(3, this.modelo);
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	//Consulta se o carro existe no banco
	public Carro consultaPeloId(int id) {
		Carro carro = new Carro();
		String sql = "select * from carro where id = " + id;
		try {
			PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()) {
				carro.setId(rs.getInt("id"));
				carro.setPlaca(rs.getString("placa"));
				carro.setMarca(rs.getString("marca"));
				carro.setModelo(rs.getString("modelo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carro;		
	}
	
	//Criando o arraylist do banco
	public List<Carro> consultaTodos() {
		List<Carro> carros = new ArrayList<>();
		String sql = "select * from carro";
		try {
			PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Carro carro = new Carro();
				carro.setId(rs.getInt("id"));	
				carro.setPlaca(rs.getString("placa"));
				carro.setMarca(rs.getString("marca"));
				carro.setModelo(rs.getString("modelo"));
				carros.add(carro);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return carros;
	}
}


