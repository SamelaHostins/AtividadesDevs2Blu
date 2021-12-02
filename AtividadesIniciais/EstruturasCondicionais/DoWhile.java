package model;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class DoWhile {

	public static void main(String[] args) {
		/** Do while Statement: Entra primeiro no laço de repetição e testa depois. 
		 * Tem que executar pelo menos uma vez, se nao puder entrar no laço, não 
		 * se deve usá-lo. "Faça enquanto opção"
		 */

		
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Menu:");
		System.out.println("Opção 1 = Incluir");
		System.out.println("Opção 2 = Alterar");
		System.out.println("Opção 3 = Excluir");
		System.out.println("Opção 4 = Consultar");
		System.out.println("Opção 9 = Sair");
		
		int opcao;
		
		opcao = Integer.parseInt(JOptionPane.showInputDialog("Informe a opção"));
		
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
				JOptionPane.showMessageDialog(null, "Atencao opção inválida");
			
			}
			
			System.out.println("Menu:");
			System.out.println("Opção 1 = Incluir");
			System.out.println("Opção 2 = Alterar");
			System.out.println("Opção 3 = Excluir");
			System.out.println("Opção 4 = Consultar");
			System.out.println("Opção 9 = Sair");
			
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Informe a opção"));
			
		}while(opcao!=9);		

	}

}
