package InterfaceVeiculoView;

import InterfaceVeiculo.Automovel;
import InterfaceVeiculo.Moto;

public interface InterfaceModeloComConstrutor {
	
	public static void main(String[] args) {
		
				
		Automovel auto = new Automovel(60, "gasolina", 40, "o automovel freou"); //Com construtor
		System.out.println("O automovel acelerou até " + auto.getLimiteDeVel() + " Km/h" + 
				" e abasteceu com " + auto.getTipoDoCombustivel() + " " + auto.getLitragemTotal() +
				" litros ");
		System.out.println(auto.getIntensidade());
		
			
		Moto moto = new Moto(60, "gasolina", 8, "a moto freio" ); //Com construtor
		System.out.println("A moto acelerou até " + moto.getLimiteDeVel() + " Km/h" + 
				" e abasteceu com " + moto.getTipoDoCombustivel() + " " + moto.getLitragemTotal() +
				" litros ");
		System.out.println(moto.getIntensidade());
		
	}


	
}
