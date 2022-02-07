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

public class Avaliacao {

	private int codDisciplina;
	private int codAluno;
	private int nrAvaliacao;
	private double vlrNota;
	
	
	public int getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(int codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public int getCodAluno() {
		return codAluno;
	}

	public void setCodAluno(int codAluno) {
		this.codAluno = codAluno;
	}

	public int getNrAvaliacao() {
		return nrAvaliacao;
	}

	public void setNrAvaliacao(int nrAvaliacao) {
		this.nrAvaliacao = nrAvaliacao;
	}

	public double getVlrNota() {
		return vlrNota;
	}

	public void setVlrNota(double vlrNota) {
		this.vlrNota = vlrNota;
	}

	//Testa a conexão no main
		public void testeConexao() {
			if(Conexao.conectar() != null) {
				System.out.println("conectado");
			}else {
				System.out.println("erro ao conectar ao banco");
			}
	 }
		
		
		//Metodo que salva uma Avaliação no banco
		public boolean salvarAvaliacao() {
			Connection con = Conexao.conectar();	
			String sql = "insert into avaliacao(codaluno, coddisciplina, nravaliacao, vlrnota) values(?,?,?,?)";
			
			try {
				PreparedStatement stm = con.prepareStatement(sql);
				stm.setInt(1, this.getCodAluno());
				stm.setInt(2, this.getCodDisciplina());
				stm.setInt(3, this.getNrAvaliacao());
				stm.setDouble(4, this.getVlrNota());
				stm.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				Conexao.fecharConexao();
			}
			return true;
		}		
		
		//Metodo para incluir uma avaliação que salvará no main
		public void incluirAvaliacao() {
			Avaliacao ma = new Avaliacao();			

			String codAlu = JOptionPane.showInputDialog("Qual o código do Aluno?");
			ma.setCodAluno(Integer.valueOf(codAlu));
			
			String codDis = JOptionPane.showInputDialog("Qual o código da Disciplina?");
			ma.setCodDisciplina(Integer.valueOf(codDis));
			
			String nrAva = JOptionPane.showInputDialog("Informe o número da avaliação");
			ma.setNrAvaliacao(Integer.valueOf(nrAva));
			
			String vlNota = JOptionPane.showInputDialog("Informe o valor da nota");
			ma.setVlrNota(Double.valueOf(vlNota));
		
			
			if(ma.salvarAvaliacao()) {
				System.out.println("Avaliação salva com sucesso");
			}
		}
		
		//Consulta se a avaliação existe no banco
				public Avaliacao consultaPeloCodigo(int pcod, int pcod2, int pcod3) {
					Avaliacao di = new Avaliacao();
					String sql = "SELECT * FROM AVALIACAO WHERE codaluno = " + pcod + 
							" AND coddisciplina = " + pcod2 + " AND nravaliacao = " + pcod3;
					try {
						PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
						ResultSet rs = stm.executeQuery();
						
						if(rs.next()) {
							di.setCodAluno(rs.getInt("codaluno"));
							di.setCodDisciplina(rs.getInt("coddisciplina"));	
							di.setNrAvaliacao(rs.getInt("nravaliacao"));
							di.setVlrNota(rs.getDouble("vlrnota"));
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
				public void consultarAvaliacao() {
					Avaliacao ma = new Avaliacao().consultaPeloCodigo(0,2,1);
					System.out.println(ma.getCodAluno());
					System.out.println(ma.getCodDisciplina());					
					System.out.println(ma.getNrAvaliacao());
					System.out.println(ma.getVlrNota());
					System.out.println("");
				}				

				//Criando o arraylist do banco
				public List<Avaliacao> consultaTodos() {
					List<Avaliacao> avaliacoes = new ArrayList<>();
					String sql = "select * from avaliacao";
					try {
						PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
						//Resultset retorna os dados do banco
						ResultSet rs = stm.executeQuery();
						while(rs.next()) {
							Avaliacao di = new Avaliacao();								
							di.setCodAluno(rs.getInt("codaluno"));
							di.setCodDisciplina(rs.getInt("coddisciplina"));
							di.setNrAvaliacao(rs.getInt("nravaliacao"));
							di.setVlrNota(rs.getDouble("vlrnota"));
							avaliacoes.add(di);
						}
						
					} catch (SQLException e) {
						e.printStackTrace();
					}	
					finally {
						Conexao.fecharConexao();
					}
					return avaliacoes;
				}	
				
				//Método para ler a lista no main
				public void lerTodosAva() { 
				List<Avaliacao> listaAvaliacao = new Avaliacao().consultaTodos();
				for(Avaliacao c : listaAvaliacao) {
					System.out.println(c.getCodAluno());
					System.out.println(c.getCodDisciplina());
					System.out.println(c.getNrAvaliacao());
					System.out.println(c.getVlrNota());
					System.out.println("");
				}
			}
				
				
		//Método que altera(edita) no banco
		public boolean alterarAvaliacao() {
			Connection con = Conexao.conectar();	
			String sql = "update avaliacao set codaluno =?, coddisciplina=?, nravaliacao =?, vlrnota =?";
			sql += " where codaluno =? and coddisciplina =? and nravaliacao =?";
			try {
				PreparedStatement stm = con.prepareStatement(sql);
				stm.setInt(1, this.getCodAluno());
				stm.setInt(2, this.getCodDisciplina());
				stm.setInt(3, this.getNrAvaliacao());
				stm.setDouble(4, this.getVlrNota());
				stm.setInt(5, this.getCodAluno());
				stm.setInt(6, this.getCodDisciplina());
				stm.setInt(7, this.getNrAvaliacao());
				stm.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				Conexao.fecharConexao();
			}
			return true;
		}
		
		//Metodo para alterar uma avaliacao a partir de uma nova variável no main
		public void alterandoAvaliacao() {
			Avaliacao di = new Avaliacao();
			di = di.consultaPeloCodigo(0,2,1);
			
			di.setVlrNota(7.2);
			if(di.alterarAvaliacao()) {
				System.out.println("Avaliação alterada com sucesso");
			}else {
				System.out.println("Avaliação ao alterar a Disciplina");
			}
		}

		//Metodo que exclui uma matricula no banco
		public boolean excluirAvaliacao( int codaluno, int coddisciplina, int nravaliacao) {
			String sql = "delete from avaliacao where codaluno =? and coddisciplina = ? and nravaliacao =?";
			try {
				PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
				stm.setInt(1,codaluno);
				stm.setInt(2,coddisciplina);
				stm.setInt(3,nravaliacao);
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
			Avaliacao ma = new Avaliacao();
			if(ma.excluirAvaliacao(0,2,1)) {
				System.out.println("excluído com sucesso");
			}
		}	

	}
