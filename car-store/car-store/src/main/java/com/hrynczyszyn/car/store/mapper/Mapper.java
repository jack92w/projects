package com.hrynczyszyn.car.store.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface Mapper<D, E> {

    /**
     * Maps from Entity to DTO
     */
    public D mapToDto(E t);

    /**
     * Maps from DTO to Entity
     */
    public E mapToEntity(D d);

    default List<D> mapToDtos(List<E> list) {
        return list.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    default List<E> mapToEntities(List<D> list) {
        return list.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());
    }

}

