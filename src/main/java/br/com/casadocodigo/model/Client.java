package br.com.casadocodigo.model;

import br.com.casadocodigo.config.validation.UniqueValue;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false)
//    @Email
//    @UniqueValue(domainClass = Client.class,fieldName = "email")
    private String email;

    @NotBlank
    private String nameClient;

    @NotBlank
    private String lastNameClient;
    @NotBlank
    private String document;
    @NotBlank
    private String address;
    @NotBlank
    private String complement;
    @NotBlank
    private String city;
    @ManyToOne
    private Country country;
    @ManyToOne
    private State state;
    @NotBlank
    private String phone;
    @NotBlank
    private String cep;

    //utilizado somente para o hibernate poder construir as consultas
    @Deprecated
    public Client() {
    }

    public Client(String email, String nameClient, String lastNameClient,
                  String document, String address, String complement,
                  String city, Country country, State state, String phone, String cep) {
        this.email = email;
        this.nameClient = nameClient;
        this.lastNameClient = lastNameClient;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.country = country;
        this.state = state;
        this.phone = phone;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }
}
