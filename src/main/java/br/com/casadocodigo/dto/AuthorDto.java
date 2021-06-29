package br.com.casadocodigo.dto;

import br.com.casadocodigo.model.Author;

import java.time.LocalDate;

public class AuthorDto {

    private Long id;
    private String name;
    private String email;
    private String description;
    private LocalDate registrationDate = LocalDate.now();

    public AuthorDto() {
    }

    public AuthorDto(Long id, String name, String email,
                     String description, LocalDate registrationDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.description = description;
        this.registrationDate = registrationDate;
    }

    public AuthorDto(Author author){
        id = author.getId();
        name = author.getName();
        email = author.getEmail();
        description = author.getDescription();
        registrationDate = author.getRegistrationDate();
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

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
}
