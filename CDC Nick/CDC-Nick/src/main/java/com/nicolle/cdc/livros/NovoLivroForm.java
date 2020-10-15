package com.nicolle.cdc.livros;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import com.google.common.base.Function;
import com.nicolle.cdc.autor.Autor;
import com.nicolle.cdc.autor.AutorRepository;
import com.nicolle.cdc.categorias.Categoria;
import com.nicolle.cdc.categorias.CategoryRepository;


public class NovoLivroForm {
	
	
	
	@NotBlank
	@Size(max = 100)
	private String titulo;
	
	@NotBlank
	@Size(max = 500)
	private String resumo;
	
	
	@Min(20)
	private BigDecimal preco;
	
	@NotBlank
	private String sumario;
	
	@Min(100)
	private int numeroPaginas;
	
	@NotBlank
	private String isbn;
	
	@NotNull
	private Long autorId;
	
	@NotNull
	private String categoriaNome;

	
	
	
	
	

	public String getNomeCategoria() {
		return categoriaNome;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.categoriaNome = categoriaNome;
	}

	public Long getAutorId() {
		return autorId;
	}

	public void setAutorId(Long autorId) {
		this.autorId = autorId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}


	public String getSumario() {
		return sumario;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	

	public Livro novoLivro(AutorRepository autorRepository, CategoryRepository categoryRepository) {
		Autor autor = autorRepository.findById(autorId).get();
		Categoria categoria = categoryRepository.findByNome(categoriaNome).get();
		return new Livro(titulo,resumo,preco,sumario,numeroPaginas,isbn,autor,categoria);
	}


	
}
