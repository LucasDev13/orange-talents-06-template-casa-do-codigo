package br.com.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotBlank
    private String nameState;

    @ManyToOne
    private Country country;

    @Deprecated
    public State() {
    }

    public State(String nameState, Country country) {
        this.nameState = nameState;
        this.country = country;
    }
}
