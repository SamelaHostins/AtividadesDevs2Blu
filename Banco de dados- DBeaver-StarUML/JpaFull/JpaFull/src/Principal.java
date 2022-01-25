
public class Principal {

	public static void main(String[] args) {
		chamaPegaUm();
		System.out.println("");
		chamaUpdate();
	}
	
	static void salvar() {
		Contato contato2 = new Contato();
		
		contato2.setNome("Sâmela");
		contato2.setEmail("samyhost017@gmail.com");
		contato2.setCelular("(47)99943-9309");
		
		new DaoContato().salvar(contato2);
	}
	
	 static void chamaPegaUm() {
		Contato contato = new DaoContato().pegarUm(2L);
		System.out.println("Nome: "+ contato.getNome());
		System.out.println("Email: "+ contato.getEmail());
		System.out.println("Celular: "+ contato.getCelular());
	}

	static void chamaUpdate() {
		Contato contato = new DaoContato().pegarUm(2L);
		contato.setCelular("(47)99934-5687");
		if(new DaoContato().update(contato)) {
			System.out.println("alterado com sucesso");
		}
	}
	
}
