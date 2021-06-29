package br.com.casadocodigo.dto;

import br.com.casadocodigo.model.Author;

import java.time.Instant;

public class AuthorDto {

    private Long id;
    private String name;
    private String email;
    private String description;
    private Instant instantCreated;

    public AuthorDto() {
    }

    public AuthorDto(Long id, String name, String email,
                     String description, Instant instantCreated) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.description = description;
        this.instantCreated = instantCreated;
    }

    public AuthorDto(Author author){
        id = author.getId();
        name = author.getName();
        email = author.getEmail();
        description = author.getDescription();
        instantCreated = author.getInstantCreated();
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
