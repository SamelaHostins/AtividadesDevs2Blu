package model;

public class TratarExcecaoEx {

	public static void main(String[] args) {
	carros();
	}
	
	static void carros() {
		String [] vagas = {"Fusca", "Kombi", "TL","Brasilia"};
		try {
			System.out.println(vagas[4]);//Não pode ser 4
		} catch (Exception e) {
			System.out.println("Fim do programa");
		}
		

	}
	static void divisaoPorZero() {
		
	}

}
