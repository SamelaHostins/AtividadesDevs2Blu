package principal;

import java.util.List;

import entidades.Carro;
import util.Conexao;

public class Principal {

	public static void main(String[] args) {
		alterarCarro();
		lerTodos();
	}
	
	//Método para ler a lista
		static void lerTodos() {
		List<Carro> listaCarro = new Carro().consultaTodos();
		for(Carro c : listaCarro) {
			System.out.println(c.getId());
			System.out.println(c.getPlaca());
			System.out.println(c.getMarca());
			System.out.println(c.getModelo());
			System.out.println("");
		}
	}
		//Metodo para consultar um específico
		public void Consultar() {
			Carro carro = new Carro().consultaPeloId(1);
			System.out.println(carro.getId());
			System.out.println(carro.getPlaca());
			System.out.println(carro.getMarca());
			System.out.println(carro.getModelo());
			System.out.println("");
		}
	
		//Metodo para criar um carro que será adicionado no array
		public void criar() {
			Carro carro = new Carro();
		
			carro.setPlaca("LZZ8176");
			carro.setMarca("Volkswagen");
			carro.setModelo("Fuscão preto");
		
			carro.setPlaca("MFH1978");
			carro.setMarca("Volkswagen");
			carro.setModelo("Grande Livina");
		
			if(carro.salvar()) {
				System.out.println("carro salvo com sucesso");
			}	
		}
		
		//Método para alterar(editar)
		static void alterarCarro() {
			Carro carro = new Carro().consultaPeloId(2);//Seleciona a partir da consulta qual quer mudar
			carro.setPlaca("abc124");//escreve p que quer alterar
			if(carro.update()) {
				System.out.println("Carro alterado");
			}
		}
	
		//Método para deletar o carro a partir do id
		static void chamaExcluir() {
			Carro carro = new Carro();
			if(carro.deletar(1)) {
				System.out.println("excluído com sucesso");
			}
		}
		
		//Método que testa a conexão com o banco de dados
		static void testeConexao() {
			if(Conexao.conectar() != null) {
				System.out.println("conectado");
			}else {
				System.out.println("erro ao conectar ao banco");
			}
		}

}
