import java.util.Scanner;

public class RendimentoMensal {
	
	
	public static void main(String[] args) {
		 /**
		    * Uma ag�ncia banc�ria possui v�rios clientes que podem fazer investimentos 
		   com rendimentos mensais, conforme a tabela a seguir:
		    Tipo	Descri��o		Rendimento mensal
		     1		Poupan�a		1,5%
		     2		Poupan�a plus		2.0%
		     3		Fundos de renda		4.0%
					
		   Fa�a um programa que leia o c�digo do cliente, o tipo da conta e o valor investido 
		   e que calcule e mostre o rendimento mensal de acordo com o tipo do investimento. 
		   Ao final do programa mostre o total de juros pagos. 
		   A leitura terminar� quando o c�digo do cliente digitado for menor ou igual a 0.
		    */

		    
		    
		    Scanner ler = new Scanner(System.in);
		    int codigo =1;
		      
		    do{

		    int tipoDoInvestimento;
		    String descricao, tipoDaConta;
		    double valorInvestido, jurosPagos, rendimentoMensal;
		            
		       System.out.println("Informe seu c�digo");  
		        codigo=ler.nextInt();
		        if(codigo == 0 || codigo < 0) {
					System.out.println("Fim");
					break;
				}
		    
		       System.out.println("Informe o valor investido");  
		        valorInvestido=ler.nextDouble();
		      
		       System.out.println("Informe o tipo da conta:");  
		        tipoDaConta=ler.next();
		      
		       System.out.println("Informe o tipo de investimento sendo: Poupan�a = 1, Poupan�a plus = 2 ou "
		       		+ "Fundos de renda = 3 ");  
		        tipoDoInvestimento=ler.nextInt();

		        if(tipoDoInvestimento == 1){
		            descricao = "Poupanca";
		            rendimentoMensal = (valorInvestido * 1.5) - valorInvestido;
		            System.out.println(" A conta " + tipoDaConta + ", do codigo " + codigo 
		             + " fez um investimento tipo: " + tipoDoInvestimento + ", que rendeu R$" + rendimentoMensal);
		        }else if(tipoDoInvestimento == 2){
		            descricao = "Poupan�a plus";
		            rendimentoMensal = (valorInvestido * 2.0) - valorInvestido;
		            System.out.println(" A conta " + tipoDaConta + ", do codigo " + codigo + " fez um investimento"
		            		+ " tipo: " + tipoDoInvestimento + ", que rendeu R$" + rendimentoMensal);
		        }else if(tipoDoInvestimento == 3){
		            descricao = "Fundos de renda";
		            rendimentoMensal = (valorInvestido * 4.0) - valorInvestido;
		            System.out.println(" A conta " + tipoDaConta + ", do codigo " + codigo + " fez um investimento"
		            		+ " tipo: " + descricao + ", que rendeu R$" + rendimentoMensal);
		        }
		        

		    }while(codigo>0);
		    }

		}