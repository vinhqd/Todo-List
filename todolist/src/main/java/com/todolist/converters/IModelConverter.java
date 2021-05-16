package com.todolist.converters;

public interface IModelConverter<D, E> {

    D toDto(E entity);

    E toEntity(D dto);

}
