package model;

import java.util.Scanner;

public class MaiorNumero {

	public static void main(String[] args) {
		
		
		int numero, maior=0, menor=0;
		
		Scanner ler = new Scanner(System.in);
		
		for (int i = 1; i<=3; i++) {
			
			System.out.println("Informe um n�mero");
			numero = ler.nextInt();
			
			if (i == 1) {
                maior = numero;
                menor = numero;
            }
			
			if(numero> maior) {
				maior = numero;				 				
			}

			if(numero< menor) {
				menor = numero;				 				
			}
			
		}
		System.out.println("O maior n�mero �: "+ maior + ", o menor n�mero �: "+ menor);

	}
}
