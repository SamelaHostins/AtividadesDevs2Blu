package model;

import java.util.Scanner;

public class AchandoNumeroPares {

	public static void main(String[] args) {
		
		//Objetivo � achar quais n�mero s�o pares e quais n�meros s�o �mpares
		
		int i;
		
		for (i = 1; i<= 10; i++) {
			if(i % 2 == 0) {
			System.out.println(i + " � par");
			}
			else {
			System.out.println(i + " � �mpar");
			}
			
			
		}
		

	}

}
