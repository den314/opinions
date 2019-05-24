package io.desz.opinions.service;

import io.desz.opinions.model.Opinion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public class StubOpinionRepository implements OpinionRepository {

    private Collection<Opinion> opinions = new ArrayList<>();

    @Override
    public int count() {
        return opinions.size();
    }

    @Override
    public boolean add(Opinion opinion) {
        return opinions.add(opinion);
    }

    @Override
    public boolean delete(Opinion opinion) {
        return opinions.remove(opinion);
    }

    @Override
    public Stream<Opinion> stream() {
        return opinions.stream();
    }
}
