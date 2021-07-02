package br.com.casadocodigo.request;

import br.com.casadocodigo.model.Category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CategoryRequest {

    @NotBlank
    @Size(min = 1)
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
