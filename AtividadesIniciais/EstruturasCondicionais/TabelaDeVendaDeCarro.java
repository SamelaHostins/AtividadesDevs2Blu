
import java.util.Scanner;


/**
 * @author Sâmela Hostins
 */
public class TabelaDeVendaDeCarro {

    public static void main(String[] args) {
        
/**
 * 1. Faça um programa que receba o valor de um carro e mostre uma tabela 
   com os seguintes dados: preço final, quantidade de parcelas e valor da parcela. 
   Considere o seguinte:

   O preço final para compra à vista tem um desconto de 20%;
   Se for a prazo, a quantidades de parcelas pode ser: 
      6, 12, 18, 24, 30, 36, 42, 48, 54 e 60.
		
   Os percentuais de acréscimo seguem a tabela a seguir.  
			
	Parcelas	Acréscimo
	6		3%
	12		6%
	18		9%
	24		12%
	30		15%
	36		18%
	42		21%
	48		24%
	54		27%
	60		30%
 */
       
        double valorDoCarro, precoVista, precoPrazo, valorDaParcela;
        int i;
        
        Scanner ler = new Scanner(System.in);
        System.out.println("Informe o preço do carro:");
        valorDoCarro = ler.nextDouble();
        
        //Achando o preço a vista com desconto de 20%
        precoVista = valorDoCarro - (valorDoCarro * 0.2);
        
         for (i=1; i<=10; i++){
            //fará com que some de 6 em 6: 0+6=6, 6+6=12
            int parcelas = 6*i;

            //Para achar o tanto que acrescentará no valor do carro fornecido
            double prazoTotal = 1 + 0.03*i;
            
            //Acrescentando o acrescimo ao valor do carro
            precoPrazo = valorDoCarro *prazoTotal;
            
            //Achando o valor de cada parcela
            valorDaParcela = precoPrazo / parcelas;
            
             System.out.println("Para a parcela de: "+ parcelas+ " vezes, o preco final ficou em R$" + precoPrazo
                     + " e o valor de cada parcela ficou de R$" + valorDaParcela); 
        }
    }        
}
