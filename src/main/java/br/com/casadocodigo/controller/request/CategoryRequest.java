package br.com.casadocodigo.controller.request;

import br.com.casadocodigo.config.validation.UniqueValue;
import br.com.casadocodigo.model.Category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CategoryRequest {

    @NotBlank
    @Size(min = 1)
    @UniqueValue(domainClass = Category.class, fieldName = "nameCategory")
    private String nameCategory;

    @Deprecated
    public CategoryRequest() {
    }

    public CategoryRequest(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Category toModel(){
        return new Category(this.nameCategory);
    }

    public String getNameCategory() {
        return nameCategory;
    }
}
