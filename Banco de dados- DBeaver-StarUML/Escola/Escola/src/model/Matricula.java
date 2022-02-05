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
		String sql = "insert into matricula(coddisciplina. codaluno, dtmatricula, statusmatricula) values(?,?,?,?)";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, this.getCodDisciplina());
			stm.setInt(2, this.getCodAluno());
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
		
		String codDis = JOptionPane.showInputDialog("Qual o código da Disciplina?");
		ma.setCodDisciplina(Integer.valueOf(codDis));

		String codAlu = JOptionPane.showInputDialog("Qual o código do Aluno?");
		ma.setCodDisciplina(Integer.valueOf(codAlu));
		
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
			public void consultarDisciplina() {
				Matricula ma = new Matricula();.consultaPeloCodigo(1);
				System.out.println(a.getCodDisciplina());
				System.out.println(a.getNomDisciplina());
				System.out.println(a.getNomProfessor());
				System.out.println(a.getQtdAvaliacoes());
				System.out.println("");
			}				

			//Criando o arraylist do banco
			public List<Disciplina> consultaTodos() {
				List<Disciplina> disciplinas = new ArrayList<>();
				String sql = "select * from disciplina";
				try {
					PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
					//Resultset retorna os dados do banco
					ResultSet rs = stm.executeQuery();
					while(rs.next()) {
						Disciplina di = new Disciplina();
						di.setCodDisciplina(rs.getInt("coddisciplina"));	
						di.setNomDisciplina(rs.getString("nomdisciplina"));
						di.setNomProfessor(rs.getString("nomprofessor"));
						di.setQtdAvaliacoes(rs.getInt("qtdavaliacoes"));
						disciplinas.add(di);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}	
				finally {
					Conexao.fecharConexao();
				}
				return disciplinas;
			}	
			
			//Método para ler a lista no main
			public void lerTodosDisc() { 
			List<Disciplina> listaDisciplina = new Disciplina().consultaTodos();
			for(Disciplina c : listaDisciplina) {
				System.out.println(c.getCodDisciplina());
				System.out.println(c.getNomDisciplina());
				System.out.println(c.getNomProfessor());
				System.out.println(c.getQtdAvaliacoes());
				System.out.println("");
			}
		}
			
			
	//Método que altera(edita) no banco
	public boolean alterarDisciplina() {
		Connection con = Conexao.conectar();	
		String sql = "update disciplina set nomdisciplina=?, nomprofessor =?, qtdavaliacoes =?";
		sql += " where coddisciplina = ?";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, this.getNomDisciplina());
			stm.setString(2, this.getNomProfessor());
			stm.setInt(3, this.getQtdAvaliacoes());
			stm.setInt(4, this.getCodDisciplina());//Agora estará alterando o codigo, fzd com que ele mude por isso precisa adicioná-lo
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			Conexao.fecharConexao();
		}
		return true;
	}
	
	//Metodo para alterar um aluno a partir de uma nova variável no main
	public void alterandoDisciplina() {
		Matricula ma = new Matricula();
		di = di.consultaPeloCodigo(2);
		
		di.setNomProfessor("Ana Beatriz");
		if(di.alterarDisciplina()) {
			System.out.println("Disciplina alterada com sucesso");
		}else {
			System.out.println("Problema ao alterar a Disciplina");
		}
	}

	//Metodo que exclui um Auno no banco
	public boolean excluirMatricula(int coddisciplina) {
		String sql = "delete from disciplina where coddisciplina = ?";
		try {
			PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
			stm.setInt(1,coddisciplina);
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
		if(ma.excluirMatricula(1)) {
			System.out.println("excluído com sucesso");
		}
	}	

}
