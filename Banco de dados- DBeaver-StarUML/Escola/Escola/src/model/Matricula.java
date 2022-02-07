package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.Conexao;

public class Matricula {

	private int codAluno;
	private int codDisciplina;
	private Date dtMatricula;
	private String statusMatricula;
	
	
	public int getCodAluno() {
		return codAluno;
	}

	public void setCodAluno(int codAluno) {
		this.codAluno = codAluno;
	}

	public int getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(int codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public Date getDtMatricula() {
		return dtMatricula;
	}

	public void setDtMatricula(Date dtMatricula) {
		this.dtMatricula = dtMatricula;
	}

	public String getStatusMatricula() {
		return statusMatricula;
	}

	public void setStatusMatricula(String statusMatricula) {
		this.statusMatricula = statusMatricula;
	}

	//Testa a conexão no main
	public void testeConexao() {
		if(Conexao.conectar() != null) {
			System.out.println("conectado");
		}else {
			System.out.println("erro ao conectar ao banco");
		}
 }
	
	
	//Metodo que salva uma Matricula no banco
	public boolean salvarMatricula() {
		Connection con = Conexao.conectar();	
		String sql = "insert into matricula(codaluno, coddisciplina, dtmatricula, statusmatricula) values(?,?,?,?)";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, this.getCodAluno());
			stm.setInt(2, this.getCodDisciplina());
			stm.setDate(3, this.getDtMatricula());
			stm.setString(4, String.valueOf(this.getStatusMatricula()));
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			Conexao.fecharConexao();
		}
		return true;
	}		
	
	//Metodo para incluir uma matricula que salvará no main
	public void incluirMatricula() {
		Matricula ma = new Matricula();		

		String codAlu = JOptionPane.showInputDialog("Qual o código do Aluno?");
		ma.setCodAluno(Integer.valueOf(codAlu));
		
		String codDis = JOptionPane.showInputDialog("Qual o código da Disciplina?");
		ma.setCodDisciplina(Integer.valueOf(codDis));
		
		String dtMat = JOptionPane.showInputDialog("Informe a data da matrícula");
		ma.setDtMatricula(Date.valueOf(dtMat));
		
		String stMat = JOptionPane.showInputDialog("Informe o status da matrícula");
		ma.setStatusMatricula(stMat);

		if(ma.salvarMatricula()) {
			System.out.println("Matricula salva com sucesso");
		}
	}
	
	//Consulta se a matricula existe no banco
			public Matricula consultaPeloCodigo(int pcod, int pcod2) {
				Matricula di = new Matricula();
				String sql = "SELECT * FROM MATRICULA WHERE coddisciplina = " + pcod + 
						" AND CODALUNO = " + pcod2;
				try {
					PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
					ResultSet rs = stm.executeQuery();
					
					if(rs.next()) {
						di.setCodDisciplina(rs.getInt("coddisciplina"));	
						di.setCodAluno(rs.getInt("codaluno"));
						di.setDtMatricula(rs.getDate("dtmatricula"));
						di.setStatusMatricula(rs.getString("statusmatricula"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				finally {
					Conexao.fecharConexao();
				}
				return di;		
			}
			
			//Para consultar uma disciplina no main
			public void consultarMatricula() {
				Matricula ma = new Matricula().consultaPeloCodigo(2,3);
				System.out.println(ma.getCodDisciplina());
				System.out.println(ma.getCodAluno());
				System.out.println(ma.getDtMatricula());
				System.out.println(ma.getStatusMatricula());
				System.out.println("");
			}				

			//Criando o arraylist do banco
			public List<Matricula> consultaTodos() {
				List<Matricula> matriculas = new ArrayList<>();
				String sql = "select * from matricula";
				try {
					PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
					//Resultset retorna os dados do banco
					ResultSet rs = stm.executeQuery();
					while(rs.next()) {
						Matricula di = new Matricula();	
						di.setCodAluno(rs.getInt("codaluno"));
						di.setCodDisciplina(rs.getInt("coddisciplina"));
						di.setDtMatricula(rs.getDate("dtmatricula"));
						di.setStatusMatricula(rs.getString("statusmatricula"));
						matriculas.add(di);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}	
				finally {
					Conexao.fecharConexao();
				}
				return matriculas;
			}	
			
			//Método para ler a lista no main
			public void lerTodosMatri() { 
			List<Matricula> listaMatricula = new Matricula().consultaTodos();
			for(Matricula c : listaMatricula) {
				System.out.println(c.getCodAluno());
				System.out.println(c.getCodDisciplina());
				System.out.println(c.getDtMatricula());
				System.out.println(c.getStatusMatricula());
				System.out.println("");
			}
		}
			
			
	//Método que altera(edita) no banco
	public boolean alterarMatricula() {
		Connection con = Conexao.conectar();	
		String sql = "update matricula set codaluno=?, coddisciplina =?, dtmatricula =?, statusmatricula =?";
		sql += " where codaluno =? and coddisciplina =?";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, this.getCodAluno());
			stm.setInt(2, this.getCodDisciplina());
			stm.setDate(3, this.getDtMatricula());
			stm.setString(4, this.getStatusMatricula());
			stm.setInt(5, this.getCodDisciplina());
			stm.setInt(6, this.getCodAluno());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			Conexao.fecharConexao();
		}
		return true;
	}
	
	//Metodo para alterar uma matricfula a partir de uma nova variável no main
	public void alterandoMatricula() {
		Matricula di = new Matricula();
		di = di.consultaPeloCodigo(2,3);
		
		di.setStatusMatricula("B");
		if(di.alterarMatricula()) {
			System.out.println("Matricula alterada com sucesso");
		}else {
			System.out.println("Matricula ao alterar a Disciplina");
		}
	}

	//Metodo que exclui uma matricula no banco
	public boolean excluirMatricula(int codaluno, int coddisciplina) {
		String sql = "delete from matricula where codaluno = ? and coddisciplina =?";
		try {
			PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
			stm.setInt(1,codaluno);
			stm.setInt(2,coddisciplina);
			stm.execute();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			Conexao.fecharConexao();
		}
		return true;		
	}
	
	//Metodo para excluir no main
	public void chamaExcluir() {
		Matricula ma = new Matricula();
		if(ma.excluirMatricula(3,0)) {
			System.out.println("excluído com sucesso");
		}
	}	

}
