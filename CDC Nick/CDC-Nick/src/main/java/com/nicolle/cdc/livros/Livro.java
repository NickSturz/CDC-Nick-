package com.nicolle.cdc.livros;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.nicolle.cdc.autor.Autor;
import com.nicolle.cdc.categorias.Categoria;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private @NotBlank @Size(max = 100) String titulo;
	private @NotBlank @Size(max = 500) String resumo;
	private @NotNull @Min(20) BigDecimal preco;
	private @NotBlank String sumario;
	private @Min(100) int numeroPaginas;
	private @NotBlank String isbn;
	@ManyToOne
	private @NotNull Autor autor;
	@ManyToOne
	private @NotNull Categoria categoria;
	
	@Deprecated
	public Livro() {}

	public Livro(@NotBlank @Size(max = 100) String titulo, @NotBlank @Size(max = 500) String resumo,
			@Min(20) BigDecimal preco, @NotBlank String sumario, @Min(100) int numeroPaginas,
			@NotBlank String isbn, @NotNull Autor autor,  @NotNull Categoria categoria) {
				this.titulo = titulo;
				this.resumo = resumo;
				this.preco = preco;
				this.sumario = sumario;
				this.numeroPaginas = numeroPaginas;
				this.isbn = isbn; 
				this.autor = autor;
				this.categoria = categoria;
	}
	
	

}
