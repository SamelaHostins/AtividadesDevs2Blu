
import java.util.Scanner;


/**
 * @author Sâmela Hostins
 */
public class RendimentoMensal {

    public static void main(String[] args) {
       
    /**
    * Uma agência bancária possui vários clientes que podem fazer investimentos 
   com rendimentos mensais, conforme a tabela a seguir:

    Tipo	Descrição		Rendimento mensal
     1		Poupança		1,5%
     2		Poupança plus		2.0%
     3		Fundos de renda		4.0%
			
   Faça um programa que leia o código do cliente, o tipo da conta e o valor investido 
   e que calcule e mostre o rendimento mensal de acordo com o tipo do investimento. 
   Ao final do programa mostre o total de juros pagos. 
   A leitura terminará quando o código do cliente digitado for menor ou igual a 0.
    */

    
    
    Scanner ler = new Scanner(System.in);
    int codigo =1;
      
    do{

    int tipoDoInvestimento;
    String descricao, tipoDaConta;
    double valorInvestido, jurosPagos, rendimentoMensal;
            
       System.out.println("Informe seu código");  
        codigo=ler.nextInt();
    
       System.out.println("Informe o valor investido");  
        valorInvestido=ler.nextDouble();
      
       System.out.println("Informe o tipo da conta:");  
        tipoDaConta=ler.next();
      
       System.out.println("Informe o tipo de investimento sendo: Poupança = 1, Poupança plus = 2 ou Fundos de renda = 3 ");  
        tipoDoInvestimento=ler.nextInt();

        if(tipoDoInvestimento == 1){
            descricao = "Poupanca";
            rendimentoMensal = (valorInvestido * 1.5) - valorInvestido;
            System.out.println(" A conta " + tipoDaConta + ", do codigo " + codigo + " fez um investimento tipo: "
                    + tipoDoInvestimento + ", que rendeu R$" + rendimentoMensal);
        }else if(tipoDoInvestimento == 2){
            descricao = "Poupança plus";
            rendimentoMensal = (valorInvestido * 2.0) - valorInvestido;
            System.out.println(" A conta " + tipoDaConta + ", do codigo " + codigo + " fez um investimento tipo: "
                    + tipoDoInvestimento + ", que rendeu R$" + rendimentoMensal);
        }else if(tipoDoInvestimento == 3){
            descricao = "Fundos de renda";
            rendimentoMensal = (valorInvestido * 4.0) - valorInvestido;
            System.out.println(" A conta " + tipoDaConta + ", do codigo " + codigo + " fez um investimento tipo: "
                    + descricao + ", que rendeu R$" + rendimentoMensal);
        }

    }while(codigo <=0);
    }

}
