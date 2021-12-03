package model;

import java.util.Scanner;

public class UsoDoFor {

	public static void main(String[] args) {
		/**
		 *  O laço for é extremamente utilizado em operações com ARRAY.
		 *  Não há necessidade de se preocupar com criação de variavel para
		 *  controle de laço, nem criação da cláusula de controle de mesmo e 
		 *  tampouco a incrementação da variável de controle.
		 */
		
		//Achando os múltiplos do número informado
		
		int i, numero; 
		
		Scanner ler = new Scanner(System.in);
		System.out.println("Digite um número");
		numero = ler.nextInt();
		
		for (i = 1; i<= 20; i++) {
			
			System.out.println(numero +" x " + i + " = " + (numero * i));
		}
		

	}

}
