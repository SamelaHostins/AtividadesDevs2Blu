package model;

public class EmpresaRH {

	public static void main(String[] args) {
		
		Gerencia ger = new Gerencia();
		
		System.out.println("Dados do gerente");
				ger.nome= "Roberto Fonseca";
				ger.descDepto = "Gerencia de TI";
				ger.comissao = 0.02f; //2%
				ger.salario = 12500.00f;
				ger.listarFuncionario();
				
		
				
		Presidente pre = new Presidente();
		
		System.out.println("Dados do presidente");
		pre.nome = "Carlos Antonio Meirelles";
		
		
	}
}
