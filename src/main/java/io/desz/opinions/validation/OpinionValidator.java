package io.desz.opinions.validation;


import com.google.inject.Inject;
import io.desz.opinions.annotation.Past;
import io.desz.opinions.model.Opinion;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class OpinionValidator implements Validator<Opinion> {

    private PastDateValidator pastDateValidator;

    @Inject
    public OpinionValidator(PastDateValidator pastDateValidator) {
        this.pastDateValidator = pastDateValidator;
    }

    @Override
    public Set<Constraint> validate(Opinion opinion) {

        Set<Constraint> constraints = new HashSet<>();

        String fieldName = "reviewDateTime";
        try {
            Field reviewDateTimeField = opinion.getClass().getDeclaredField(fieldName);
            for (Annotation annotation : reviewDateTimeField.getDeclaredAnnotations()) {
                if (annotation instanceof Past) {
                    reviewDateTimeField.setAccessible(true);
                    constraints.addAll(pastDateValidator.validate((LocalDateTime) reviewDateTimeField.get(opinion)));
                }
            }
        } catch (NoSuchFieldException e) {
            throw new IllegalStateException("no field`" + fieldName + "` present");
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("could not access field`" + fieldName + "`");
        }
        return constraints;
    }


}
