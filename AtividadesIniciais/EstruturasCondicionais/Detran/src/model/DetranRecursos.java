package model;

import java.util.Scanner;

public class DetranRecursos {

	public static void main(String[] args) {
			
		int qtdDeMotoristas =0, numCarteira=0, multa=0, qtdDeMultas=0, totalDeMultas=0, valorTotal=0;
		String nome ="", descricao= "";
		
		Scanner ler = new Scanner(System.in);
	
		//Pedindo o número de motoristas para criar o for
		System.out.println("Informe a quantidade de motoristas:");
		qtdDeMotoristas= ler.nextInt();		
		
		for(int i =1; i<=qtdDeMotoristas; i++) {
			
			System.out.println("Informe seu nome:");
			nome= ler.next();
			
			System.out.println("Informe o número da sua carteira de motorista:");
			numCarteira= ler.nextInt();
			
			System.out.println("Informe quantas multas você recebeu:");
			qtdDeMultas= ler.nextInt();
			
			descricao= "";
			multa = 0;
			totalDeMultas = 0;
			valorTotal = 0;
			
			//A partir do número de multas criar outro for para receber as informações das multas
			for(int i1 =1; i1<=qtdDeMultas; i1++) {
				
				System.out.println("Informe a natureza da multa sendo:" );
				System.out.println("Opção 1 = LEVE");
				System.out.println("Opção 2 = MÉDIA");
				System.out.println("Opção 3 = GRAVE");
				System.out.println("Opção 4 = GRAVÍSSIMA");
				multa= ler.nextInt();

				switch(multa) {
				
				case 1: {
					descricao += " Leve = 3 pontos = R$88,00 ";
					totalDeMultas += 3;
					valorTotal += 88;	
					break;
				}
				
				case 2: {
					descricao += " Média = 4 pontos = R$130,00 ";
					totalDeMultas += 4;
					valorTotal += 130;	
					break;
				}
				
				case 3: {
					descricao += " Grave = 5 pontos = R$195,00 ";
					totalDeMultas += 5;
					valorTotal += 195;	
					break;
				}
				
				case 4: {
					descricao += " Gravíssima = 7 pontos = R$293,00 ";
					totalDeMultas += 7;
					valorTotal += 293;
					break;
				}
				
				default:
					System.out.println("Atencao opção inválida");
				break;
				}
				
			
				
			}
			System.out.println("O motorista: " + nome + ", que possui a carteira de motorista de "
					+ "número: " + numCarteira + ", levou " + qtdDeMultas + " multas. ");
					
			System.out.println("que foram levadas na sequencia sendo: " + descricao); 
					
			System.out.println("totalizando " + totalDeMultas + " pontos na carteira e R$" 
			+ valorTotal + ",00 para o Detran.");
			
			System.out.println(" ");
		}	
		
  }
			
}
