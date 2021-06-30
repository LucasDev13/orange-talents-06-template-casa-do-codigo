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
    private Instant instantCreated;

    public AuthorDto() {
    }

    public AuthorDto(String name, String email,
                     String description, Instant instantCreated) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.instantCreated = instantCreated;
    }

    public AuthorDto(Author author){
        name = author.getName();
        email = author.getEmail();
        description = author.getDescription();
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
