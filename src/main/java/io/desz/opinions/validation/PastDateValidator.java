package io.desz.opinions.validation;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class PastDateValidator implements Validator<LocalDateTime> {

    @Override
    public Set<Constraint> validate(LocalDateTime ldt) {

        Set<Constraint> constraints = new HashSet<>();
        if (!ldt.isBefore(LocalDateTime.now())) {
            constraints.add(new Constraint("date time must be in past"));
        }
        return constraints;
    }
}
