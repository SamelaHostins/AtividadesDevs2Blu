package pacote2;

public class OperadorLogico {

	public static void main(String[] args) {
		//&& = E
		int n1, n2, n3, n4;
		n1 = 10;
		n2 = 20;
		n3 = 10;
		n4 = 20;
		
		//O "==" compara primeiro o tipo da variavel e depois compara as variaveis
		if(n1 == n2) {
			System.out.println("Ambos s�o iguais");
		}else {
			System.out.println("S�o diferentes");
		}

		if((n1 == n3) && (n2 == n4)) {
			System.out.println("Todos s�o iguais");
		}else {
			System.out.println("Todos s�o diferentes");
		}
		
		if((n1 == n2) || (n2 == n4)) {
			System.out.println("Algu�m � diferente");
		}else {
			System.out.println("Algu�m � igual");
		}
		
	}

}
