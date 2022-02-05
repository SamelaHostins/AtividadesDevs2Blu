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

	private int codAvaliacao;
	private int codAluno;
	private int nrAvaliacao;
	private double vlrNota;
	
	
	
	public int getCodAvaliacao() {
		return codAvaliacao;
	}

	public void setCodAvaliacao(int codAvaliacao) {
		this.codAvaliacao = codAvaliacao;
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
			
	/*
	//Metodo que salva um aluno no banco
			public boolean salvarAvaliacao() {
				Connection con = Conexao.conectar();	
				String sql = "insert into avaliacao(nomaluno, nommae, nompai, datanasc) values(?,?,?,?)";
				
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
			
			//Metodo para incluir um aluno que salvará no main
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
			
			//Consulta se o aluno existe no banco
					public Aluno consultaPeloCodigo(int pcodaluno) {
						Aluno aluno = new Aluno();
						String sql = "SELECT * FROM ALUNO WHERE codaluno = " + pcodaluno;
						try {
							PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
							ResultSet rs = stm.executeQuery();
							
							if(rs.next()) {
								aluno.setCodAluno(rs.getInt("codaluno"));	
								aluno.setNomAluno(rs.getString("nomaluno"));
								aluno.setNomMae(rs.getString("nommae"));
								aluno.setNomPai(rs.getString("nompai"));
								aluno.setDataNasc(rs.getDate("datanasc"));
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						finally {
							Conexao.fecharConexao();
						}
						return aluno;		
					}
					
					//Para consultar um aluno no main
					public void consultarAluno() {
						Aluno a = new Aluno().consultaPeloCodigo(3);
						System.out.println(a.getCodAluno());
						System.out.println(a.getNomAluno());
						System.out.println(a.getNomMae());
						System.out.println(a.getNomPai());
						System.out.println(a.getDataNasc());
						System.out.println("");
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
					
					//Método para ler a lista no main
					public void lerTodos() {
					List<Aluno> listaAluno = new Aluno().consultaTodos();
					for(Aluno c : listaAluno) {
						System.out.println(c.getCodAluno());
						System.out.println(c.getNomAluno());
						System.out.println(c.getNomMae());
						System.out.println(c.getNomPai());
						System.out.println(c.getDataNasc());
						System.out.println("");
					}
				}
					
					
			//Método que altera(edita) no banco
			public boolean alterarAluno() {
				Connection con = Conexao.conectar();	
				String sql = "update aluno set nomaluno=?, nommae =?, nompai =?, datanasc =?";
				sql += " where codaluno = ?";
				try {
					PreparedStatement stm = con.prepareStatement(sql);
					stm.setString(1, this.getNomAluno());
					stm.setString(2, this.getNomMae());
					stm.setString(3, this.getNomPai());
					stm.setDate(4, this.getDataNasc());
					stm.setInt(5, this.getCodAluno());//Agora estará alterando o codigo, fzd com que ele mude por isso precisa adicioná-lo
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
			public void alterandoAluno() {
				Aluno alu = new Aluno();
				Aluno a = new Aluno();
				a = alu.consultaPeloCodigo(4);
				String nomMae = a.getNomMae();
				
				nomMae = "Beatriz";
				alu.setNomMae(nomMae);
				if(alu.alterarAluno()) {
					System.out.println("Aluno alterado com sucesso");
				}else {
					System.out.println("Problema ao alterar o aluno");
				}
			}
		
			//Metodo que exclui um Auno no banco
			public boolean excluirAluno(int codaluno) {
				String sql = "delete from aluno where codaluno = ?";
				try {
					PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
					stm.setInt(1,codaluno);
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
				Aluno aluno = new Aluno();
				if(aluno.excluirAluno(1)) {
					System.out.println("excluído com sucesso");
				}
			}		
		
			//Metodo para ler a data de nascimento
					public void pegarDataDeNascimento() {
						Aluno alu = new Aluno();
						String dataNascimento = "2000-02-01";
						alu.setDataNasc(Date.valueOf(dataNascimento));
						alu.mostrarData();
						System.out.println("Data nascimento informada "+ dataNascimento);
					}
			
			//ToString para mostrar a data		
		    public String mostrarData() {
			   return "Aluno [dataNasc=" + dataNasc + "]";
		}
		*/
		
	}
