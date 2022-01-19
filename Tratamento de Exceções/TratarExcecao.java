package model;

public class TratarExcecao {

	public static void main(String[] args) {
		//Se executar este c�digo sem o try, dar� uma exce��o aritm�tica
		

		try {
			//Bloco a ser executado
			int x =10;
			int y = 0;
			int z = x/y;
			
		} catch (Exception e) {
			System.out.println("O valor n�o pode ser dividido por zero");
			System.out.println("erro: "+ e.getMessage()); // Apresentar� o nome do erro
			System.out.println("Classe de erro: " + e.toString()); // Apresentar� o nome da classe do erro
		}
   }
}
