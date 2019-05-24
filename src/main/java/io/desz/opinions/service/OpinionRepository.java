package io.desz.opinions.service;

import io.desz.opinions.model.Opinion;

import java.util.stream.Stream;

public interface OpinionRepository {

    int count();

    boolean add(Opinion opinion);

    boolean delete(Opinion opinion);

    Stream<Opinion> stream();
}
