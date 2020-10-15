package com.nicolle.cdc.autor;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SemEmailDuplicadoValidator implements Validator {
	
	private AutorRepository autorRepository;
	
	public SemEmailDuplicadoValidator(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return NovoAutorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NovoAutorForm form = (NovoAutorForm) target;
		Optional<Autor> possivelAutor = autorRepository.findByEmail(form.getEmail());
		
		if(possivelAutor.isPresent()) {
			errors.rejectValue("email", null, "Essa email já está cadastrado para um autor");
		}

	}

}
