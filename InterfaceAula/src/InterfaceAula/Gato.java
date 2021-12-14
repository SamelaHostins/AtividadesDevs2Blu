package InterfaceAula;

public class Gato implements Animal {

	@Override
	public String emitirSom() {
		String som = "miaaauuu";
		return som;
	}

	@Override
	public String tipoAlimento() {
		String tipoAlimento = "Leite";		
		return tipoAlimento;
	}

}
