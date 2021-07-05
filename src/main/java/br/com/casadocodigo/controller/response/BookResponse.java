package br.com.casadocodigo.controller.response;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BookResponse {

    @NotNull
    @Valid
    private Long id;
    @NotBlank
    @Valid
    private String title;

    public BookResponse(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
