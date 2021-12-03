package model;

import java.util.Scanner;

public class AchandoNumeroPares {

	public static void main(String[] args) {
		
		//Objetivo é achar quais número são pares e quais números são ímpares
		
		int i;
		
		for (i = 1; i<= 10; i++) {
			if(i % 2 == 0) {
			System.out.println(i + " É par");
			}
			else {
			System.out.println(i + " É ímpar");
			}
			
			
		}
		

	}

}
