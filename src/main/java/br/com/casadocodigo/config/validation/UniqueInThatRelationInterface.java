package br.com.casadocodigo.config.validation;

public interface UniqueInThatRelationInterface<U,R>{
    public U getUniqueValue();

    public R getRelationValue();
}
