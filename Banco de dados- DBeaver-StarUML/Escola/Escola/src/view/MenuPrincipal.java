package view;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import controller.Conexao;
import model.Aluno;

public class MenuPrincipal {
	
	public static void main(String[] args) {
		Aluno alu = new Aluno();
		alu.incluirAluno();
	}

	static void testeConexao() {
		if(Conexao.conectar() != null) {
			System.out.println("conectado");
		}else {
			System.out.println("erro ao conectar ao banco");
		}
}
	
	public void pegarDataDeNascimento() {
		Aluno alu = new Aluno();
		String dataNascimento = "2000-02-01";
		alu.setDataNasc(Date.valueOf(dataNascimento));
		alu.mostrarData();
		System.out.println("Data nascimento informada "+ dataNascimento);
	}
}