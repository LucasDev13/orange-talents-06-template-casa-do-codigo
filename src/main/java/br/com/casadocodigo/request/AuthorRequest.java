package br.com.casadocodigo.request;

import br.com.casadocodigo.config.validation.UniqueValue;
import br.com.casadocodigo.model.Author;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AuthorRequest {

    @NotBlank
    @Size(min = 3)
    private String name;
    @NotBlank
    @Size(min = 5)
    @Email
    @UniqueValue(domainClass = Author.class, fieldName = "email")
    private String email;
    @NotBlank
    @Size(min = 10, max = 400)
    private String description;

    @Deprecated
    public AuthorRequest() {
    }

    public Author toModel(){
        return new Author(this.name, this.email, this.description);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }
}
