package model;

import java.util.Scanner;

public class UsoDoFor {

	public static void main(String[] args) {
		/**
		 *  O la�o for � extremamente utilizado em opera��es com ARRAY.
		 *  N�o h� necessidade de se preocupar com cria��o de variavel para
		 *  controle de la�o, nem cria��o da cl�usula de controle de mesmo e 
		 *  tampouco a incrementa��o da vari�vel de controle.
		 */
		
		//Achando os m�ltiplos do n�mero informado
		
		int i, numero; 
		
		Scanner ler = new Scanner(System.in);
		System.out.println("Digite um n�mero");
		numero = ler.nextInt();
		
		for (i = 1; i<= 20; i++) {
			
			System.out.println(numero +" x " + i + " = " + (numero * i));
		}
		

	}

}
