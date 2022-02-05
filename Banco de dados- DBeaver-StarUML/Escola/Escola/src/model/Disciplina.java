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

public class Disciplina {

	private int codDisciplina;
	private String nomDisciplina;
	private String nomProfessor;
	private int qtdAvaliacoes;
	
	public int getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(int codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public String getNomDisciplina() {
		return nomDisciplina;
	}

	public void setNomDisciplina(String nomDisciplina) {
		this.nomDisciplina = nomDisciplina;
	}

	public String getNomProfessor() {
		return nomProfessor;
	}

	public void setNomProfessor(String nomProfessor) {
		this.nomProfessor = nomProfessor;
	}

	public int getQtdAvaliacoes() {
		return qtdAvaliacoes;
	}

	public void setQtdAvaliacoes(int qtdAvaliacoes) {
		this.qtdAvaliacoes = qtdAvaliacoes;
	}

	//Testa a conexão no main
			public void testeConexao() {
				if(Conexao.conectar() != null) {
					System.out.println("conectado");
				}else {
					System.out.println("erro ao conectar ao banco");
				}
		}
			
			
	//Metodo que salva uma disciplina no banco
			public boolean salvarDisciplina() {
				Connection con = Conexao.conectar();	
				String sql = "insert into disciplina(nomdisciplina, nomprofessor, qtdavaliacoes) values(?,?,?)";
				
				try {
					PreparedStatement stm = con.prepareStatement(sql);
					stm.setString(1, this.getNomDisciplina());
					stm.setString(2, this.getNomProfessor());
					stm.setInt(3, this.getQtdAvaliacoes());
					stm.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				finally {
					Conexao.fecharConexao();
				}
				return true;
			}		
			
			//Metodo para incluir uma disciplina que salvará no main
			public void incluirDisciplina() {
				Disciplina di = new Disciplina();
				
				String nome = JOptionPane.showInputDialog("Qual o nome da disciplina?");
				di.setNomDisciplina(nome);

				String nomeProf = JOptionPane.showInputDialog("Qual o nome do professor desta disciplina?");
				di.setNomProfessor(nomeProf);
				
				String qtdAva = JOptionPane.showInputDialog("Informe a quantidade de avaliações que está disciplina terá");
				di.setQtdAvaliacoes(Integer.valueOf(qtdAva));
			
				
				if(di.salvarDisciplina()) {
					System.out.println("Disciplina salva com sucesso");
				}
			}
			
			//Consulta se a disciplina existe no banco
					public Disciplina consultaPeloCodigo(int pcod) {
						Disciplina di = new Disciplina();
						String sql = "SELECT * FROM DISCIPLINA WHERE coddisciplina = " + pcod;
						try {
							PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
							ResultSet rs = stm.executeQuery();
							
							if(rs.next()) {
								di.setCodDisciplina(rs.getInt("coddisciplina"));	
								di.setNomDisciplina(rs.getString("nomdisciplina"));
								di.setNomProfessor(rs.getString("nomprofessor"));
								di.setQtdAvaliacoes(rs.getInt("qtdavaliacoes"));
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
						Disciplina a = new Disciplina().consultaPeloCodigo(1);
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
			
			//Metodo para alterar uma disciplina a partir de uma nova variável no main
			public void alterandoDisciplina() {
				Disciplina di = new Disciplina();
				di = di.consultaPeloCodigo(2);
				
				di.setNomProfessor("Ana Beatriz");
				if(di.alterarDisciplina()) {
					System.out.println("Disciplina alterada com sucesso");
				}else {
					System.out.println("Problema ao alterar a Disciplina");
				}
			}
		
			//Metodo que exclui uma disciplina no banco
			public boolean excluirDisciplina(int coddisciplina) {
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
				Disciplina di = new Disciplina();
				if(di.excluirDisciplina(1)) {
					System.out.println("excluído com sucesso");
				}
			}	
		
	}
