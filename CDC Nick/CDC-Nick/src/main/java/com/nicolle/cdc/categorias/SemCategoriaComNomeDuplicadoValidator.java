package com.nicolle.cdc.categorias;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class SemCategoriaComNomeDuplicadoValidator implements Validator {
	
	private CategoryRepository categoriaRespository;
	
	public SemCategoriaComNomeDuplicadoValidator(CategoryRepository categoriaRespository) {
		this.categoriaRespository = categoriaRespository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return NovaCategoriaForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NovaCategoriaForm form = (NovaCategoriaForm) target;
		Optional<Categoria> possivelCategoria = categoriaRespository.findByNome(form.getNome());
		
		if(possivelCategoria.isPresent()) {
			errors.rejectValue("nome", null, "Essa categoria já existe");
		}

	}

}
