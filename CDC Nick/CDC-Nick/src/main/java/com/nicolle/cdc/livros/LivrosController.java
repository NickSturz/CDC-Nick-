package com.nicolle.cdc.livros;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nicolle.cdc.autor.AutorRepository;
import com.nicolle.cdc.categorias.CategoryRepository;

@RestController
public class LivrosController {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(new IsbnUnicoValidotor(livroRepository), new TituloLivroUnicoValidator(livroRepository));
	}
	
	@PostMapping(value = "/api/livro")
	@Transactional
	public void novo(@RequestBody @Valid NovoLivroForm  form) {
		Livro livro = form.novoLivro(autorRepository, categoryRepository);
		livroRepository.save(livro);
		
		//System.out.println("sechegou aqui a porra ta funfando");
	}
}
