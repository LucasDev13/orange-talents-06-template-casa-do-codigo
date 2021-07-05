package br.com.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 1)
    @Column(nullable = false,updatable = false)
    private String nameCategory;

    @Deprecated
    public Category(){}

    public Category(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
