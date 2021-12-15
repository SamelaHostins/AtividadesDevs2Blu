package InterfaceVeiculoView;

import java.util.Scanner;

import InterfaceVeiculo.Automovel;
import InterfaceVeiculo.EsforcoDeFrenagem;
import InterfaceVeiculo.Moto;

public interface InterfaceModeloComConstrutor {
	
	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		
		Automovel auto = new Automovel(80, "gasolina", 40, "alta"); //Com construtor
		System.out.println("O automovel acelerou até " + auto.getLimiteDeVel() + " Km/h" + 
				" e abasteceu com " + auto.getTipoDoCombustivel() + " " + auto.getLitragemTotal() +
				" litros ");
		System.out.println("O automóvel teve intensidade de frenagem: " + auto.getIntensidade());
		System.out.println("Velocidade liberada até: " + auto.ajustarVelocidade());
		
		System.out.println(" ");
		
			
		Moto moto = new Moto(60, "gasolina", 8, "baixa" ); //Com construtor
		System.out.println("A moto acelerou até " + moto.getLimiteDeVel() + " Km/h" + 
				" e abasteceu com " + moto.getTipoDoCombustivel() + " " + moto.getLitragemTotal() +
				" litros ");
		System.out.println("A moto teve intensidade de frenagem: " +moto.getIntensidade());
		System.out.println("Velocidade liberada até: " + moto.ajustarVelocidade());
		
		System.out.println(" ");
		
		System.out.println("Qual o valor do esforço da frenagem?");
		int esforcoDeFrenagem=ler.nextInt();
		if (esforcoDeFrenagem> 80) {
			 System.out.println(EsforcoDeFrenagem.ALTA);
		}else if ( esforcoDeFrenagem <= 80 && esforcoDeFrenagem > 50 ) {
			 System.out.println(EsforcoDeFrenagem.MÉDIA);
		}else {
			 System.out.println(EsforcoDeFrenagem.BAIXA);
		}
	}
	
	}


	

