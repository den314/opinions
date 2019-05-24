package io.desz.opinions.service;

import io.desz.opinions.model.Opinion;
import io.desz.opinions.validation.Constraint;
import io.desz.opinions.validation.OpinionValidator;

import java.util.Set;
import java.util.stream.Stream;

public class OpinionService {

    private OpinionValidator validator;
    private OpinionRepository repo;

    public OpinionService(OpinionValidator validator, OpinionRepository repo) {
        this.validator = validator;
        this.repo = repo;
    }

    public int count() {
        return repo.count();
    }

    public boolean add(Opinion opinion) {
        Set<Constraint> constraints = validator.validate(opinion);
        if (!constraints.isEmpty()) {
            throw new RuntimeException("Opinion not valid. \r\nConstraints: " + constraints);
        }
        opinion.getReviewer().addReview(opinion);
        return repo.add(opinion);
    }

    public boolean delete(Opinion opinion) {
        opinion.getReviewer().deleteReview(opinion);
        return repo.delete(opinion);
    }

    public Stream<Opinion> stream() {
        return repo.stream();
    }
}
