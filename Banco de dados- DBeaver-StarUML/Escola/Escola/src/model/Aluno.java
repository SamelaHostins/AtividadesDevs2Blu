package model;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import controller.Conexao;


public class Aluno {
	
	Scanner ler = new Scanner(System.in);

	private int codAluno;
	private String nomAluno;
	private String nomMae;
	private String nomPai;
	private Date dataNasc;
	private double medAluno;
	private String sitAluno;
	
	
	public int getCodAluno() {
		return codAluno;
	}

	public void setCodAluno(int codAluno) {
		this.codAluno = codAluno;
	}

	public String getNomAluno() {
		return nomAluno;
	}

	public void setNomAluno(String nomAluno) {
		this.nomAluno = nomAluno;
	}

	public String getNomMae() {
		return nomMae;
	}

	public void setNomMae(String nomMae) {
		this.nomMae = nomMae;
	}

	public String getNomPai() {
		return nomPai;
	}

	public void setNomPai(String nomPai) {
		this.nomPai = nomPai;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public double getMedAluno() {
		return medAluno;
	}

	public void setMedAluno(double medAluno) {
		this.medAluno = medAluno;
	}

	public String getSitAluno() {
		return sitAluno;
	}

	public void setSitAluno(String sitAluno) {
		this.sitAluno = sitAluno;
	}
	
	//Criando o arraylist do banco
		public List<Aluno> consultaTodos() {
			List<Aluno> alunos = new ArrayList<>();
			String sql = "select * from aluno";
			try {
				PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
				//Resultset retorna os dados do banco
				ResultSet rs = stm.executeQuery();
				while(rs.next()) {
					Aluno aluno = new Aluno();
					aluno.setCodAluno(rs.getInt("codAluno"));	
					aluno.setNomAluno(rs.getString("nomaluno"));
					aluno.setNomMae(rs.getString("nommae"));
					aluno.setNomPai(rs.getString("nompai"));
					aluno.setDataNasc(rs.getDate("datanasc"));
					alunos.add(aluno);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}		
			return alunos;
		}
		
		public void incluirAluno() {
			Aluno alu = new Aluno();
			
			String nome = JOptionPane.showInputDialog("Qual o nome do aluno?");
			alu.setNomAluno(nome);

			String nomeMae = JOptionPane.showInputDialog("Qual o nome de sua mãe?");
			alu.setNomMae(nomeMae);
			
			String nomePai = JOptionPane.showInputDialog("Informe o nome do pai");
			alu.setNomPai(nomePai);
			
			String data = JOptionPane.showInputDialog("Informe a data de nascimento");
			alu.setDataNasc(Date.valueOf(data));				
			
			if(alu.salvarAluno()) {
				System.out.println("Aluno salvo com sucesso");
			}
		}	
		
		public boolean salvarAluno() {
			Connection con = Conexao.conectar();	
			String sql = "insert into aluno(nomaluno, nommae, nompai, datanasc) values(?,?,?,?)";
			
			try {
				PreparedStatement stm = con.prepareStatement(sql);
				stm.setString(1, this.getNomAluno());
				stm.setString(2, this.getNomMae());
				stm.setString(3, this.getNomPai());
				stm.setDate(4, this.getDataNasc());
				stm.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				Conexao.fecharConexao();
			}
			return true;
		}
	
		//Método que altera(edita) no banco
		public boolean alterarAluno() {
			Connection con = Conexao.conectar();	
			String sql = "update aluno set nomaluno=?, nommae =?, nompai =?, , datanasc =?";
			sql += "where codaluno = ?";
			try {
				PreparedStatement stm = con.prepareStatement(sql);
				stm.setString(1, this.getNomAluno());
				stm.setString(2, this.getNomMae());
				stm.setString(3, this.getNomPai());
				stm.setDate(4, this.getDataNasc());
				stm.setInt(5, this.getCodAluno());//Agora estará alterando o id, fzd com que ele mude por isso precisa adicioná-lo
				stm.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				Conexao.fecharConexao();
			}
			return true;
		}
	
	public void excluirAluno() {
	
	}
	
	//Consulta se o carro existe no banco
		public Aluno consultaPeloId(int codaluno) {
			Aluno aluno = new Aluno();
			String sql = "select * from aluno where codaluno = " + codaluno;
			try {
				PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
				ResultSet rs = stm.executeQuery();
				
				if(rs.next()) {
					aluno.setCodAluno(rs.getInt("codAluno"));	
					aluno.setNomAluno(rs.getString("nomaluno"));
					aluno.setNomMae(rs.getString("nommae"));
					aluno.setNomPai(rs.getString("nompai"));
					aluno.setDataNasc(rs.getDate("datanasc"));
					aluno.setMedAluno(rs.getInt("medaluno"));
					aluno.setSitAluno(rs.getString("sql"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				Conexao.fecharConexao();
			}
			return aluno;		
		}
		
	
	public void listarAlunos() {
		
	}

	public String mostrarData() {
		return "Aluno [dataNasc=" + dataNasc + "]";
	}
	
	
}
