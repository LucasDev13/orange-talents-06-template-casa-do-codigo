package br.com.casadocodigo.config.validation;

import br.com.casadocodigo.dto.AuthorDto;
import br.com.casadocodigo.model.Author;
import br.com.casadocodigo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ValidatorEmail implements Validator {

    @Autowired
    private AuthorRepository authorRepository;

    /**
     * Qual o tipo de parametro que devo aplicar nessa validação
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return AuthorDto.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
        AuthorDto request = (AuthorDto) o;
        Optional<Author> optional = authorRepository.findByEmail(request.getEmail());
        if(optional.isPresent()){
            errors.reject("email", null, "Já existe um email com esse nome cadastrado.");
            System.out.println("Não encontrado.");
        }
    }
}
