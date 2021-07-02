package br.com.casadocodigo.dto;

import br.com.casadocodigo.model.Author;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;

public class AuthorDto {

    private Long id;
    @NotBlank
    @Size(min = 3)
    private String name;
    @NotBlank
    @Size(min = 5)
    @Email()
    private String email;
    @NotBlank
    @Size(min = 10, max = 400)
    private String description;

    @Deprecated
    public AuthorDto() {
    }

    public AuthorDto(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public Author toModel(){
        return new Author(name, email, description);
    }

    public String getEmail() {
        return email;
    }
}
