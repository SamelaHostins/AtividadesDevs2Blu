package model;

import javax.swing.JOptionPane;

public class Switch {

	public static void main(String[] args) {
		
		int opcao;
		
		opcao = Integer.parseInt(JOptionPane.showInputDialog("Informe a opção"));
		
		switch (opcao) {
		
		case 1: {
			System.out.println("Inclusao");
			break;
		}
		
		case 2: {
			System.out.println("Alteracao");
			break;
		}
		
		case 3: {
			System.out.println("Exclusao");
			break;
		}
		
		case 4: {
			System.out.println("Consulta");
			break;
		}
		
		default:
			JOptionPane.showMessageDialog(null, "Atencao opção inválida");
			
		
		
		}

	}

}
