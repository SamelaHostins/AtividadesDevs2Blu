package exceptions;

public class ExcecaoMenorQueZeroMaiorQueDez extends Exception {

	/**
	 * S� precisa disso pois estamos usando static
	 */
	private static final long serialVersionUID = 1L;

	//Criando construtor que qd lan�ado deve receber uma String
	public ExcecaoMenorQueZeroMaiorQueDez(String message) {
		super(message);
	}
	
	
}
