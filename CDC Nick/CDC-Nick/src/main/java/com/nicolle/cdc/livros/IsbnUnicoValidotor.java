package com.nicolle.cdc.livros;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class IsbnUnicoValidotor implements Validator {
	
	private LivroRepository livroRepository;
	
	public IsbnUnicoValidotor(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
		
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return NovoLivroForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NovoLivroForm form = (NovoLivroForm) target;
		String isbn = form.getIsbn();
		
		Optional<Livro> possivelLivro = livroRepository.findByIsbn(isbn);
		if (possivelLivro.isPresent()) {
			errors.rejectValue("isbn", null, "esse isbn já está registrado");
		}
		

	}

}
