package Cadastro.model;

public class Cadastro {

	public static void main(String[] args) {
		/**1-Crie um array de 10 posi��es contendo inteiros e outro de 10 contendo String.
		 * Depois cadastre os nomes com seus respectivos c�digos nos dois Array's e liste 
		 * os c�digos com os nomes lado a lado desta forma:
		 * C�digo Nome
		 * 1      Jo�o
		 * 
		 * 2-Crie mais um vetor para guardar o sal�rio de cada pessoa, ao t�rmino, 
		 * totalize os sal�rios
		 * 
		 * 3-Liste os 3 maiores salarios
		 */
		
		//Array de numero
		int[] codigo = new int [10];
		
		//Array de String
		String[] nome = new String[]{"Jo�o","Jos�","Ani","Sam","Joe","Samy","Luiza","Ana","Lara",
				"Gabi"};

		
		//Estabelecendo os c�digos
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
