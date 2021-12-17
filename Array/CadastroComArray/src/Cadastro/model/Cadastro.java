package Cadastro.model;

public class Cadastro {

	public static void main(String[] args) {
		/**1-Crie um array de 10 posições contendo inteiros e outro de 10 contendo String.
		 * Depois cadastre os nomes com seus respectivos códigos nos dois Array's e liste 
		 * os códigos com os nomes lado a lado desta forma:
		 * Código Nome
		 * 1      João
		 * 
		 * 2-Crie mais um vetor para guardar o salário de cada pessoa, ao término, 
		 * totalize os salários
		 * 
		 * 3-Liste os 3 maiores salarios
		 */
		
		//Array de numero
		int[] codigo = new int [10];
		
		//Array de String
		String[] nome = new String[]{"João","José","Ani","Sam","Joe","Samy","Luiza","Ana","Lara",
				"Gabi"};

		
		//Estabelecendo os códigos
		for (int i = 0; i < 10; i++) {
			codigo[i] = i+1;
		}
				
		//saida de dados
		for (int i = 0; i < 10; i++) {
		System.out.println("Codigo:" + " " + "Nome:");	
		System.out.println(codigo[i] + "       " + nome[i]);
		}
		
		

	}
}	
