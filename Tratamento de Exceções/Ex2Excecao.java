package model;

import java.util.Scanner;

public class Ex2Excecao {
	
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		int i;
        int n = 3; // tamanho do vetor
        String v [] = new String [n]; // declaração nome
        int s [] = new int[n]; //declaração idade 

        //Entrada de dados
        try {
        	for (i = 0; i<n; i++){

                System.out.println("Informe o nome");
                v[i] = ler.next();
        	}
                
                for (i = 0; i<n; i++){

                    System.out.println("Informe a idade");
                    s[i] = ler.nextInt();
                }
                    
                    //saida de dados
                    for (i = 0; i<n; i++){
                    System.out.print("a " + v[i] + " tem " + s[i] + " anos - ");
                    }
              
		} catch (Exception e) {
			System.err.println("O valor informado não é está correto");
		}       

	}

}


