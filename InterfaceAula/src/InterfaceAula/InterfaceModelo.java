package InterfaceAula;

public interface InterfaceModelo {
	
	public static void main(String[] args) {
		
		Animal boi1 = new Boi();
		System.out.println("O boi fez " + boi1.emitirSom() + " e comeu " + boi1.tipoAlimento());
		
		Animal gato1 = new Gato();
		System.out.println("O gato fez " + gato1.emitirSom() + " e comeu " + gato1.tipoAlimento());
		
	}


	
}
