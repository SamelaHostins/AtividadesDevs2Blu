package model;

public class TratarExcecao {

	public static void main(String[] args) {
		//Se executar este código sem o try, dará uma exceção aritmética
		

		try {
			//Bloco a ser executado
			int x =10;
			int y = 0;
			int z = x/y;
			
		} catch (Exception e) {
			System.out.println("O valor não pode ser dividido por zero");
			System.out.println("erro: "+ e.getMessage()); // Apresentará o nome do erro
			System.out.println("Classe de erro: " + e.toString()); // Apresentará o nome da classe do erro
		}
   }
}
