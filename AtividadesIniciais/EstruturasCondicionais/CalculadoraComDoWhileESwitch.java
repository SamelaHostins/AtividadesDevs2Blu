package model;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class CalculadoraComDoWhileESwitch {

	public static void main(String[] args) {
		
		/**
		 * Implemente uma calculadora com 5 op��es de menu.
		 * O usuario deve continuar a execu��o at� optar pela op��o sair
		 * Se o divisor for igual a zero deve emitir aviso
		 * Na divis�o deve mostrar o resto. 
		 */
	
		int opcao =1;
		int resultado, resto, n1, n2;
	
		do {
			
			System.out.println("Menu:");
			System.out.println("Op��o 1 = Somar");
			System.out.println("Op��o 2 = Subtrair");
			System.out.println("Op��o 3 = Multiplicar");
			System.out.println("Op��o 4 = Dividir");
			System.out.println("Op��o 9 = Sair");
			
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Informe a opcao"));
			if(opcao == 9) {
				break;
			}
			n1 = Integer.parseInt(JOptionPane.showInputDialog("Informe o n�mero 1"));
			n2 = Integer.parseInt(JOptionPane.showInputDialog("Informe o n�mero 2"));
			switch (opcao) {
			
			case 1: {
				resultado = n1 + n2;
				System.out.println("Resultado da soma: " + resultado);
				break;
			}
			
			case 2: {
				resultado = n1 - n2;
				System.out.println("Resultado da subtra��o: " + resultado);
				break;
			}
			
			case 3: {
				resultado = n1 * n2;
				System.out.println("Resultado da multiplica��o: " + resultado);
				break;
			}
			
			case 4: {
				if( n2 != 0) {
					resultado = n1/n2;
					resto = n1%n2;					
					System.out.println("Resultado da divisao: " + resultado + " Resto: "+ resto);					
				}else {
					System.out.println("Divis�o por zero n�o � poss�vel");
				break;
			}}
			
			case 9: {
				System.out.println("Programa saiu normalmente");
				break;
			}
			
			default:
				JOptionPane.showMessageDialog(null, "Atencao op��o inv�lida");
			break;
			}
			
			
		}while(opcao!=9);		

	}

}
