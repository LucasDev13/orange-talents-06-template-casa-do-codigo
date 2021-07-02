package br.com.casadocodigo.config.validation;

import br.com.casadocodigo.model.Category;
import br.com.casadocodigo.repository.CategoryRepository;
import br.com.casadocodigo.request.CategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ValidatorNameCategory implements Validator {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return CategoryRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        CategoryRequest request = (CategoryRequest) o;
        Optional<Category> optional = categoryRepository.findByNameCategory(request.getNameCategory());
        if (optional.isPresent()){
            errors.rejectValue("nameCategory", null, "Já existe esse nome de categoria cadastrado.");
        }
    }
}
