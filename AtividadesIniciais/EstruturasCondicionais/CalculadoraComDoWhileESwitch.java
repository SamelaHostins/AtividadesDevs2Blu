package model;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class CalculadoraComDoWhileESwitch {

	public static void main(String[] args) {
		
		/**
		 * Implemente uma calculadora com 5 opções de menu.
		 * O usuario deve continuar a execução até optar pela opção sair
		 * Se o divisor for igual a zero deve emitir aviso
		 * Na divisão deve mostrar o resto. 
		 */
	
		int opcao =1;
		int resultado, resto, n1, n2;
	
		do {
			
			System.out.println("Menu:");
			System.out.println("Opção 1 = Somar");
			System.out.println("Opção 2 = Subtrair");
			System.out.println("Opção 3 = Multiplicar");
			System.out.println("Opção 4 = Dividir");
			System.out.println("Opção 9 = Sair");
			
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Informe a opcao"));
			if(opcao == 9) {
				break;
			}
			n1 = Integer.parseInt(JOptionPane.showInputDialog("Informe o número 1"));
			n2 = Integer.parseInt(JOptionPane.showInputDialog("Informe o número 2"));
			switch (opcao) {
			
			case 1: {
				resultado = n1 + n2;
				System.out.println("Resultado da soma: " + resultado);
				break;
			}
			
			case 2: {
				resultado = n1 - n2;
				System.out.println("Resultado da subtração: " + resultado);
				break;
			}
			
			case 3: {
				resultado = n1 * n2;
				System.out.println("Resultado da multiplicação: " + resultado);
				break;
			}
			
			case 4: {
				if( n2 != 0) {
					resultado = n1/n2;
					resto = n1%n2;					
					System.out.println("Resultado da divisao: " + resultado + " Resto: "+ resto);					
				}else {
					System.out.println("Divisão por zero não é possível");
				break;
			}}
			
			case 9: {
				System.out.println("Programa saiu normalmente");
				break;
			}
			
			default:
				JOptionPane.showMessageDialog(null, "Atencao opção inválida");
			break;
			}
			
			
		}while(opcao!=9);		

	}

}
