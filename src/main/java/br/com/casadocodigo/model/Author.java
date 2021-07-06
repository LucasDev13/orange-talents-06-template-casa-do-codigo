package br.com.casadocodigo.model;

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
    @Size(min = 5, max = 400)
    @Column(nullable = false)
    private String description;
    @NotNull
    @Column(nullable = false, updatable = false)
    private Instant instantCreated = Instant.now();

    @Deprecated
    public Author() {
    }

    public Author(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
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
