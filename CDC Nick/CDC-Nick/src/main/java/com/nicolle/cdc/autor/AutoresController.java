package com.nicolle.cdc.autor;


import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutoresController {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@InitBinder("NovoAutorForm")
	public void init(WebDataBinder dataBinder) {
		dataBinder.addValidators(new SemEmailDuplicadoValidator(autorRepository));
	
	}
	
	@PostMapping(value = "/api/autor")
	@Transactional
	public void novo(@RequestBody @Valid NovoAutorForm form) {
		Autor novoAutor = form.novoAutor();
		autorRepository.save(novoAutor);
		
	}
	
}
