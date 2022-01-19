package exceptions;

import java.util.Scanner;

public class Exe3Excecao {

	public static void main(String[] args) {
		/**
		 * Criar uma Exception para ser lançada quando for digitado um digito diferente
		 * da sequencia de algorismos de 0 a 9
		 */		
		try {
			lerIdade();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	 }
	
	static Scanner ler = new Scanner(System.in);
	
	static void lerIdade() throws ExcecaoMenorQueZeroMaiorQueDez {
		System.out.println("Informe a idade");
		//Só pode ter 0, 1, 2, 3, 4, 5, 6, 7, 8 e 9
		int idade = ler.nextInt();
		
		if(idade < 0 || idade > 10) {
			throw new ExcecaoMenorQueZeroMaiorQueDez("Valor incorreto");
		}else {
			System.out.println("Sua idade é de "+ idade);
		}
	}
	

}