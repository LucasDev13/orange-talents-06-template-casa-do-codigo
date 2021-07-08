package br.com.casadocodigo.model;

import br.com.casadocodigo.config.validation.UniqueValue;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nameCountry;

    @OneToMany(mappedBy = "country")
    private List<State> state;

    @Deprecated
    public Country() {
    }

    public Country(String nameCountry) {
        this.nameCountry = nameCountry;
    }

}
