package com.nicolle.cdc.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NovoAutorForm {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String descricao;

	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public Autor novoAutor() {
		return new Autor(nome,email,descricao);
		
	}
	


}
