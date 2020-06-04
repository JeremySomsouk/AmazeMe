package com.manomano.AmazeMe.mapper;

public interface Mapper<A, T> {

    A toDto(T model);

    T toModel(A dto);
}
