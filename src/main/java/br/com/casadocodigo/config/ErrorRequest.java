package br.com.casadocodigo.config;

public class ErrorRequest {

    private String field;
    private String error;

    public ErrorRequest(String field, String error) {
        this.field = field;
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public String getError() {
        return error;
    }
}
