package entidades;

public class Carro {
	
	/**Classe para aplicar os atributos pertencentes a
	 * entidade carro, também já foi feito os métodos 
	 * de acesso e os construtores.
	 */

	private int id;
	private String placa;
	private String modelo;
	private String marca;
	
	public Carro() {
	}

	public Carro(String placa, String modelo, String marca) {
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
	}
		
	public Carro(int id, String placa, String modelo, String marca) {
		super();
		this.id = id;
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
}
