package br.com.casadocodigo.controller.request;

import br.com.casadocodigo.config.validation.StateExistsInThisCountry;
import br.com.casadocodigo.config.validation.UniqueInThatRelationInterface;
import br.com.casadocodigo.config.validation.UniqueValue;
import br.com.casadocodigo.config.validation.ValueIdExists;
import br.com.casadocodigo.model.Country;
import br.com.casadocodigo.model.State;
import com.sun.source.tree.CompilationUnitTree;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@StateExistsInThisCountry(uniqueClass = State.class, uniqueField = "nameState",
        relationClass = Country.class, relationName = "country", relationField = "id")
public class StateRequest implements UniqueInThatRelationInterface<String, Long> {

    private Long id;
    @NotBlank
    //o nome é unico para o mesmo país.
    private String nameState;

    @ValueIdExists(domainClass = Country.class, fieldName = "id")
    private Long idCountry;

    public StateRequest() {
    }

    public StateRequest(String nameState) {
        this.nameState = nameState;
    }

    public String getNameState() {
        return nameState;
    }

    public Long getIdCountry() {
        return idCountry;
    }

    @Override
    public String getUniqueValue() {
        return nameState;
    }

    @Override
    public Long getRelationValue() {
        return idCountry;
    }

    public State toModel(EntityManager entityManager) {
        @NotNull Country country = entityManager.find(Country.class, idCountry);
        return new State(this.nameState, country);
    }
}
