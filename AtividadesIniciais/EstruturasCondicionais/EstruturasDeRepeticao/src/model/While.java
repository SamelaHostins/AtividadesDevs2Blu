package model;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class While {

	public static void main(String[] args) {
		
		//Missão: Informar as notas, pedir as notas e calcular a média
		float nota = 0, media = 0, mediaFinal=0;
		int qtdNotas = 0;
		int contaNotas = 1;
		
		
		qtdNotas = Integer.parseInt(JOptionPane.showInputDialog("Informe a qtd de notas"));
		
		
		while(contaNotas <= qtdNotas) {
			nota = Float.parseFloat(JOptionPane.showInputDialog("Informe a nota numero " + contaNotas));
			contaNotas++;
			media = (media + nota);
			mediaFinal = media / qtdNotas;
		}
		
		System.out.println(mediaFinal);
	}

}
