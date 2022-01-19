package exceptions;

public class ExcecaoMenorQueZeroMaiorQueDez extends Exception {

	/**
	 * Só precisa disso pois estamos usando static
	 */
	private static final long serialVersionUID = 1L;

	//Criando construtor que qd lançado deve receber uma String
	public ExcecaoMenorQueZeroMaiorQueDez(String message) {
		super(message);
	}
	
	
}
