package principal;

import java.util.List;

import entidades.Carro;
import util.Conexao;

public class Principal {

	public static void main(String[] args) {
		lerTodos();
	}
	
	//M�todo para ler a lista
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
		//Metodo para consultar um espec�fico
		public void Consultar() {
			Carro carro = new Carro().consultaPeloId(1);
			System.out.println(carro.getId());
			System.out.println(carro.getPlaca());
			System.out.println(carro.getMarca());
			System.out.println(carro.getModelo());
			System.out.println("");
		}
	
		//Metodo para criar um carro que ser� adicionado no array
		public void criar() {
			Carro carro = new Carro();
		
			carro.setPlaca("LZZ8176");
			carro.setMarca("Volkswagen");
			carro.setModelo("Fusc�o preto");
		
			carro.setPlaca("MFH1978");
			carro.setMarca("Volkswagen");
			carro.setModelo("Grande Livina");
		
			if(carro.salvar()) {
				System.out.println("carro salvo com sucesso");
			}	
		}
	
		//M�todo que testa a conex�o com o banco de dados
		static void testeConexao() {
			if(Conexao.conectar() != null) {
				System.out.println("conectado");
			}else {
				System.out.println("erro ao conectar ao banco");
			}
		}

}