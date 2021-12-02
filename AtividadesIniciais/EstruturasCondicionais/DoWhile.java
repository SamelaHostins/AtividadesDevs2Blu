package model;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class DoWhile {

	public static void main(String[] args) {
		/** Do while Statement: Entra primeiro no la�o de repeti��o e testa depois. 
		 * Tem que executar pelo menos uma vez, se nao puder entrar no la�o, n�o 
		 * se deve us�-lo. "Fa�a enquanto op��o"
		 */

		
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Menu:");
		System.out.println("Op��o 1 = Incluir");
		System.out.println("Op��o 2 = Alterar");
		System.out.println("Op��o 3 = Excluir");
		System.out.println("Op��o 4 = Consultar");
		System.out.println("Op��o 9 = Sair");
		
		int opcao;
		
		opcao = Integer.parseInt(JOptionPane.showInputDialog("Informe a op��o"));
		
		do {
			
			switch (opcao) {
			
			case 1: {
				System.out.println("Incluir");
				break;
			}
			
			case 2: {
				System.out.println("Alterar");
				break;
			}
			
			case 3: {
				System.out.println("Excluir");
				break;
			}
			
			case 4: {
				System.out.println("Consultar");
				break;
			}
			
			case 9: {
				System.out.println("Programa saiu normalmente");
				break;
			}
			
			default:
				JOptionPane.showMessageDialog(null, "Atencao op��o inv�lida");
			
			}
			
			System.out.println("Menu:");
			System.out.println("Op��o 1 = Incluir");
			System.out.println("Op��o 2 = Alterar");
			System.out.println("Op��o 3 = Excluir");
			System.out.println("Op��o 4 = Consultar");
			System.out.println("Op��o 9 = Sair");
			
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Informe a op��o"));
			
		}while(opcao!=9);		

	}

}
