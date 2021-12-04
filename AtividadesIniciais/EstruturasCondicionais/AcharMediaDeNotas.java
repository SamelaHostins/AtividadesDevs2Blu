package model;

import java.util.Scanner;

public class AcharMediaDeNotas {

	public static void main(String[] args) {
		
		/**
		 * Informe a quantidade de alunos
		 * Informe a quantidade de notas
		 * Informe cada nota
		 * Calcule a média
		 * Para cada aluno verifique se a média < 6 = reprovado, 
		 * se media >=6 e < 7.5 - em recuperação
		 * se média >= 7.5 - aprovado
		 * Para cada aluno imprimir nome, média e situação
		 * No final do programa imprimir a melhor média e a média da turma.
		 */
		
		int i, qtdDeAlunos, qtdDeNotas, notas= 0, nota, media= 0, maior = 0;
		String nome, situacao="";

		Scanner ler = new Scanner(System.in); 
			
			System.out.println("Quantos alunos tem nessa sala?");
			qtdDeAlunos= ler.nextInt();
			
			System.out.println("Informe a quantidade de notas");
			qtdDeNotas= ler.nextInt();
			
			for(i =1; i<=qtdDeAlunos; i++) {
				
				System.out.println("Informe seu nome");
				nome= ler.next();
				
				for(int i1 =1; i1<=qtdDeNotas; i1++) {
					
					System.out.println("Informe a nota");
					nota = ler.nextInt();
					
					//Achando a media
					notas = notas + nota;
					media = notas/qtdDeNotas;
				
					//Vendo resultado da media
					if(media<6) {
					situacao ="Reprovado";
					}else if(media >= 6 && media <= 7.5) {
					situacao ="Em recuperação";
					}else {
					situacao ="Aprovado";
					}
									
					//Achando maior média
					if (i == 1) {
						maior = media;
					}
				
					if(notas> maior) {
						maior = media;				 				
					}	
				}
				System.out.println(" O aluno(a) " + nome + " com a média " + media +
						" está " + situacao);
								
			}					
		
	}
		
}
