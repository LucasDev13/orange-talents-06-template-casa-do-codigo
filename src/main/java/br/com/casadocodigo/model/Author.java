package br.com.casadocodigo.model;

import br.com.casadocodigo.dto.AuthorDto;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.time.LocalDate;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Length(min = 3)
    private String name;
    @NotBlank
    @Length(min = 3)
    private String email;
    @NotBlank
    @Length(min = 10, max = 400)
    private String description;
    @NotNull
    private Instant instantCreated = Instant.now();

    public Author() {
    }

    public Author(Long id, String name, String email,
                  String description) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public Author(AuthorDto authorDto){
        name = authorDto.getName();
        email = authorDto.getEmail();
        description = authorDto.getDescription();
    }

    public Long getId() {
        return id;
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

    public Instant getInstantCreated() {
        return instantCreated;
    }
}
