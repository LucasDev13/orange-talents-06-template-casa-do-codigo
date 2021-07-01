package br.com.casadocodigo.model;

import br.com.casadocodigo.dto.AuthorDto;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 3)
    @Column(nullable = false)
    private String name;
    @NotBlank
    @Size(min = 5)
    @Email
    @Column(nullable = false)
    private String email;
    @NotBlank
    @Size(min = 10, max = 400)
    @Column(nullable = false)
    private String description;
    @NotNull
    @Column(nullable = false, updatable = false)
    private Instant instantCreated = Instant.now();

    @Deprecated
    public Author() {
    }

    public Author(AuthorDto authorDto){
        name = authorDto.getName();
        email = authorDto.getEmail();
        description = authorDto.getDescription();
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
