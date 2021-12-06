package model;

import java.util.Scanner;

public class AcharMediaDeNotas {

	public static void main(String[] args) {
		
		/**
		 * Informe a quantidade de alunos
		 * Informe a quantidade de notas
		 * Informe cada nota
		 * Calcule a m�dia
		 * Para cada aluno verifique se a m�dia < 6 = reprovado, 
		 * se media >=6 e < 7.5 - em recupera��o
		 * se m�dia >= 7.5 - aprovado
		 * Para cada aluno imprimir nome, m�dia e situa��o
		 * No final do programa imprimir a melhor m�dia e a m�dia da turma.
		 */
		
		int i, qtdDeAlunos, qtdDeNotas;
		double notas= 0, nota=0, media= 0, maior = 0, somaMedias = 0, maiorMedia=0;
		String nome, situacao="";

		Scanner ler = new Scanner(System.in); 
			
			System.out.println("Quantos alunos tem nessa sala?");
			qtdDeAlunos= ler.nextInt();
			
			System.out.println("Informe a quantidade de notas");
			qtdDeNotas= ler.nextInt();
			
			for(i =1; i<=qtdDeAlunos; i++) {
				
				System.out.println("Informe seu nome");
				nome= ler.next();
				
				//Pedindo as notas para achar o resultado
				for(int i1 =1; i1<=qtdDeNotas; i1++) {
					
					System.out.println("Informe a nota");
					nota = ler.nextDouble();
					
					//Achando a soma das notas
					notas = notas + nota;
				}	
				
				
				//Achando a m�dia
				media = notas/qtdDeNotas;
				somaMedias = somaMedias + media;
				
				//Achando a maior media
				if (media > maiorMedia) {
					maiorMedia = media;
				}
		
				//Vendo resultado da media
				if(media<6) {
				situacao ="Reprovado";
				}else if(media >= 6 && media <= 7.5) {
				situacao ="Em recupera��o";
				}else {
				situacao ="Aprovado";
				}
								
				//Achando maior m�dia
				if (i == 1) {
					maior = media;
				}
			
				if(notas> maior) {
					maior = media;				 				
				}
				
				System.out.println(" O aluno(a) " + nome + " com a m�dia " + media +
						" est� " + situacao);
						
			}
		System.out.println("A melhor media foi " + maiorMedia);	
		System.out.println("A m�dia da turma foi: " + somaMedias/qtdDeAlunos);
	}		
}
