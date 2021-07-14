package br.com.casadocodigo.controller.request;

import br.com.casadocodigo.config.validation.*;
import br.com.casadocodigo.model.Client;
import br.com.casadocodigo.model.Country;
import br.com.casadocodigo.model.State;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@StateBelongsToCountry
@IfCountryHasStatesThanStateNotNull
public class ClientRequest implements CountryStateValidatorInterface {

    private Long id;
    @NotBlank @Email @UniqueValue(domainClass = Client.class,fieldName = "email")
    private String email;

    @NotBlank
    private String nameClient;
    @NotBlank
    private String lastNameClient;

    @NotBlank @Document() //@Document ainda não implementado
    @UniqueValue(domainClass = Client.class,fieldName = "document")
    private String document;

    @NotBlank
    private String address;
    @NotBlank
    private String complement;
    @NotBlank
    private String city;
    @ValueIdExists(domainClass = Country.class, fieldName = "id")
    @NotNull
    private Long idCountry;
    @ValueIdExists(domainClass = State.class, fieldName = "id")
    @NotNull
    private Long idState;
    private String phone;
    private String cep;

    public ClientRequest() {
    }

    public Client toModel(EntityManager entityManager){
        State state = null;
        Country country = entityManager.find(Country.class, idCountry);
        if(this.idState !=null){
            state = entityManager.find(State.class, idState);
        }

        return new Client(this.email,
                this.nameClient, this.lastNameClient,
                this.document, this.address,
                this.complement, this.city, country,
                state, this.phone, this.cep);
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNameClient() {
        return nameClient;
    }

    public String getLastNameClient() {
        return lastNameClient;
    }

    public String getDocument() {
        return document;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public String getCity() {
        return city;
    }

    public Long getIdCountry() {
        return idCountry;
    }

    public Long getIdState() {
        return idState;
    }

    public String getPhone() {
        return phone;
    }

    public String getCep() {
        return cep;
    }

    @Override
    public Long getCountry_id() {
        return this.idCountry;
    }

    @Override
    public Long getState_id() {
        return this.idState;
    }
}
