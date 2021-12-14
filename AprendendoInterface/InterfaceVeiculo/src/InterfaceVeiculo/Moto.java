package InterfaceVeiculo;

public class Moto implements Veiculo {

	private int limiteDeVel;
	private String tipoDoCombustivel;
	private int litragemTotal;
	private String intensidade;
	
	public Moto(int limiteDeVel, String tipoDoCombustivel, int litragemTotal, String intensidade) {
		super();
		this.limiteDeVel = limiteDeVel;
		this.tipoDoCombustivel = tipoDoCombustivel;
		this.litragemTotal = litragemTotal;
		this.intensidade = intensidade;
	}

	@Override
	public int acelerar() {	
		int velocidade = 60;
		return velocidade;
	}

	@Override
	public float abastecer() {	
		float litragem = 8;
		return litragem;
	}

	@Override
	public void frear() {
		System.out.println("A moto freou");
	}

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
