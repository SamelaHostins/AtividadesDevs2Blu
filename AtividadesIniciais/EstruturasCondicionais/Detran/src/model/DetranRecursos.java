package model;

import java.util.Scanner;

public class DetranRecursos {

	public static void main(String[] args) {
			
		int qtdDeMotoristas =0, numCarteira=0, multa=0, qtdDeMultas=0, totalDeMultas=0, valorTotal=0;
		String nome ="", descricao= "";
		
		Scanner ler = new Scanner(System.in);
	
		//Pedindo o n�mero de motoristas para criar o for
		System.out.println("Informe a quantidade de motoristas:");
		qtdDeMotoristas= ler.nextInt();		
		
		for(int i =1; i<=qtdDeMotoristas; i++) {
			
			System.out.println("Informe seu nome:");
			nome= ler.next();
			
			System.out.println("Informe o n�mero da sua carteira de motorista:");
			numCarteira= ler.nextInt();
			
			System.out.println("Informe quantas multas voc� recebeu:");
			qtdDeMultas= ler.nextInt();
			
			descricao= "";
			multa = 0;
			totalDeMultas = 0;
			valorTotal = 0;
			
			//A partir do n�mero de multas criar outro for para receber as informa��es das multas
			for(int i1 =1; i1<=qtdDeMultas; i1++) {
				
				System.out.println("Informe a natureza da multa sendo:" );
				System.out.println("Op��o 1 = LEVE");
				System.out.println("Op��o 2 = M�DIA");
				System.out.println("Op��o 3 = GRAVE");
				System.out.println("Op��o 4 = GRAV�SSIMA");
				multa= ler.nextInt();

				switch(multa) {
				
				case 1: {
					descricao += " Leve = 3 pontos = R$88,00 ";
					totalDeMultas += 3;
					valorTotal += 88;	
					break;
				}
				
				case 2: {
					descricao += " M�dia = 4 pontos = R$130,00 ";
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
					descricao += " Grav�ssima = 7 pontos = R$293,00 ";
					totalDeMultas += 7;
					valorTotal += 293;
					break;
				}
				
				default:
					System.out.println("Atencao op��o inv�lida");
				break;
				}
				
			
				
			}
			System.out.println("O motorista: " + nome + ", que possui a carteira de motorista de "
					+ "n�mero: " + numCarteira + ", levou " + qtdDeMultas + " multas. ");
					
			System.out.println("que foram levadas na sequencia sendo: " + descricao); 
					
			System.out.println("totalizando " + totalDeMultas + " pontos na carteira e R$" 
			+ valorTotal + ",00 para o Detran.");
			
			System.out.println(" ");
		}	
		
  }
			
}
