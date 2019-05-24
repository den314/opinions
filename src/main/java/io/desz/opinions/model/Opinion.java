package io.desz.opinions.model;

import io.desz.opinions.annotation.Past;
import io.desz.opinions.service.DateTimeFormatUtil;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringJoiner;

/**
 * Represents an opinion about a thing of type {@code Thing.Type}.
 * An opinion is filed by an {@link Reviewer} with a {@link Rate}.
 * Also, review date time is setup to the creation of the object,
 * yet specific date can be specified as well.
 */
@Getter
public class Opinion {

    private final Reviewer reviewer;
    private final Description description;
    private final Thing thing;
    private final Rate rate;

    @Past
    private LocalDateTime reviewDateTime = LocalDateTime.now();
    private Collection<Comment> comments = new ArrayList<>();

    Opinion(Reviewer reviewer, Thing thing, Description description, Rate rate) {
        this.reviewer = reviewer;
        this.thing = thing;
        this.description = description;
        this.rate = rate;
    }

    Opinion(Reviewer reviewer, Thing thing, Description description, Rate rate, LocalDateTime reviewDateTime) {
        this(reviewer, thing, description, rate);
        this.reviewDateTime = reviewDateTime;
    }

    /**
     * @return unmodifiable collection of comments
     */
    public Collection<Comment> getComments() {
        return Collections.unmodifiableCollection(comments);
    }

    public boolean add(Comment comment) {
        return comments.add(comment);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Opinion.class.getSimpleName() + "[", "]")
                .add("reviewer=" + reviewer)
                .add("thing=" + thing)
                .add("description=" + description)
                .add("reviewDateTime=" + DateTimeFormatUtil.format(reviewDateTime))
                .add("comments=" + comments.size())
                .toString();
    }
}
