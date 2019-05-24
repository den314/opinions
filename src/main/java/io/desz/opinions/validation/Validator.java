package io.desz.opinions.validation;

import java.util.Set;

public interface Validator<T> {

    Set<Constraint> validate(T object);
}
