package pacote2;

public class Condicionais {

	public static void main(String[] args) {
		//Comando condicional Simples
		
		int idade;
		idade = 92;
		
		if(idade < 18) {
			System.out.println("Menor de idade");
		}
		
		//Comando condicional composto
		if(idade < 18) {
			System.out.println("Menor de idade");	
		}else {
			System.out.println("Maior de idade");
		}

		//Comando condicional composto com "else"
				if(idade < 18) {
					System.out.println("Menor de idade");	
				}else if(idade >= 18 && idade <= 55) {
					System.out.println("Esta pessoa é adulta");
				}else {
					System.out.println("Esta pessoa é idoso(a)");
				}

	}

}
