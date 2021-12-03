package model;

import java.util.Scanner;

public class ExtratoDosProdutosComprados {

	public static void main(String[] args) {
		/**
		 *  Desenvolva um programa que permita informar a qtd de itens vendidos.
		 *  Em seguida peça o código, descrição, valor unitário e qtd vendida.
		 *  Para cada item, imprimir os dados, calcular o valor total do item e 
		 *  ao final do programa imprimir o valor total da compra.
		 */

		int codigo;
		String descricao;
		double valor;
		double valorTotal = 0;
		double valorTotalDaCompra = 0;
		int qtdDesseItem;
		
		
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Quantos itens você comprou no total?");
		int j = ler.nextInt();
		
		for (int i = 1; i<=j; i ++ ) {
			
			System.out.println("Informe o código do item:");
			codigo= ler.nextInt();
			
			System.out.println("Qual o nome do item que você comprou?");
			descricao= ler.next();
			
			System.out.println("Informe a quantidade vendida deste item:");
			qtdDesseItem= ler.nextInt();			
			
			System.out.println("Informe o valor desse item:");
			valor= ler.nextDouble();
			valorTotal= ( valor * qtdDesseItem);
			valorTotalDaCompra= valorTotalDaCompra + valorTotal;
			
			System.out.println(" Produto: " + descricao + ", de código: " + codigo + 
					", que custa R$" + valor + " e foi vendido " + qtdDesseItem + 
					" desse item. Acrescentando R$" + valorTotal + " ao valor da compra.");		
		}
		System.out.println("");
		System.out.println("O valor da compra final foi de R$" + valorTotalDaCompra);
		
	}

}
