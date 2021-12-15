package InterfaceVeiculo;

public class Automovel implements Veiculo {
	
	private int limiteDeVel;
	private String tipoDoCombustivel;
	private int litragemTotal;
	private String intensidade;
	
	
	//Construtor
	public Automovel(int limiteDeVel, String tipoDoCombustivel, int litragemTotal, String intensidade) {
		super();
		this.limiteDeVel = limiteDeVel;
		this.tipoDoCombustivel = tipoDoCombustivel;
		this.litragemTotal = litragemTotal;
		this.intensidade = intensidade;
	}

	
	
	public float ajustarVelocidade() {
		float veloAjustada = this.limiteDeVel *1.10f;
		return veloAjustada;
	}
	

	@Override
	public int acelerar() {
		int velocidade = 80;
		return velocidade;
	}

	@Override
	public float abastecer() {		
		float litragem = 44f;
		return litragem;
	}

	@Override
	public void frear() {	
		System.out.println("Automóvel freou");
	}


	//Getters e Setters
	public int getLimiteDeVel() {
		return limiteDeVel;
	}


	public void setLimiteDeVel(int limiteDeVel) {
		this.limiteDeVel = limiteDeVel;
	}


	public String getTipoDoCombustivel() {
		return tipoDoCombustivel;
	}


	public void setTipoDoCombustivel(String tipoDoCombustivel) {
		this.tipoDoCombustivel = tipoDoCombustivel;
	}


	public int getLitragemTotal() {
		return litragemTotal;
	}


	public void setLitragemTotal(int litragemTotal) {
		this.litragemTotal = litragemTotal;
	}


	public String getIntensidade() {
		return intensidade;
	}


	public void setIntensidade(String intensidade) {
		this.intensidade = intensidade;
	}
	
	
	
}
