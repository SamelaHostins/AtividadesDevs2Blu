package principal;

import java.util.List;

import entidades.Carro;
import entidadesDao.DaoCarro;
import util.Conexao;

public class Principal {

	public static void main(String[] args) {
		RetornaTodosOsCarros();
	}
	
	//Metodo que salva
	static void salvarCarro() {
		DaoCarro dao = new DaoCarro();
		
		Carro carro = new Carro();
		carro.setPlaca("LOL2876");
		carro.setMarca("Chevrolet");
		carro.setModelo("Minivan");
	
		if(dao.salvar(carro)) {
			System.out.println("carro salvo com sucesso");
		}	
		//OU
		Carro carro2 = new Carro("EAL2021", "HB20","Hyundai");
		if(dao.salvar(carro2)) {
			System.out.println("carro2 salvo com sucesso");
		}		
	}
	
	//Método para alterar(editar)
	static void alterarCarro() {
		Carro carro = new DaoCarro().retornarUm(3);//Seleciona a partir do retornar qual quer mudar
			carro.setPlaca("ABC124");//escreve p que quer alterar
			if(new DaoCarro().update(carro)) {
				System.out.println("Carro alterado");
			}
		}
	
	//Metodo excluir
	static void excluirCarro() {
		if(new DaoCarro().excluir(2)) {
			System.out.println("carro excluido com sucesso");
		}
	}
	
	//Metodo excluir por objeto
	static void chamaExcluirPorObjeto() {
		Carro carro = new DaoCarro().retornarUm(4);
		if(new DaoCarro().excluir(carro)) {
			System.out.println("carro excluido com sucesso");		
		}
	}
	
	//Metodo que retorna a lista
	static void RetornaTodosOsCarros() {
		List<Carro> carros = new DaoCarro().retornarTodos();
		for(Carro c : carros) {
			System.out.println(c.getId());
			System.out.println(c.getPlaca());
			System.out.println(c.getMarca());
			System.out.println(c.getModelo());
			System.out.println("");
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