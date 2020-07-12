package br.com.malabar.xlsbuilder.entity;

import lombok.Data;

@Data
public class Aluno {
	private Long id;
	private String matricula;
	private String nome;
	private String responsavel;
	private String telefone1;
	private String telefone2;
	
	
	public Aluno(Long id, String matricula, String nome, String responsavel, String telefone1, String telefone2){
		this.id = id;
		this.matricula = matricula;
		this.nome = nome;
		this.responsavel = responsavel;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
	}
	
	public Aluno() { }
}
