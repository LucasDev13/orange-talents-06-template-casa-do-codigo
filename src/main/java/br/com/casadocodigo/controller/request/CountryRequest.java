package br.com.casadocodigo.controller.request;

import br.com.casadocodigo.config.validation.UniqueValue;
import br.com.casadocodigo.model.Country;
import br.com.casadocodigo.model.State;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class CountryRequest {

    private Long id;
    @NotBlank
    @UniqueValue(domainClass = Country.class, fieldName = "nameCountry")
    private String nameCountry;
    private List<State> state;

    @Deprecated
    public CountryRequest() {
    }

    public Country toModel() {
        return new Country(nameCountry);
    }

    public String getNameCountry() {
        return nameCountry;
    }
}
