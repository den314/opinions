package io.desz.opinions.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.StringJoiner;

@Getter
public class Reviewer {

    private String nick;
    private Collection<Opinion> reviews = new ArrayList<>();

    public Reviewer(String nick) {
        this.nick = nick;
    }

    public boolean addReview(Opinion opinion) {
        return reviews.add(opinion);
    }

    public boolean deleteReview(Opinion opinion) {
        return reviews.remove(opinion);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Reviewer.class.getSimpleName() + "[", "]")
                .add("nick='" + nick + "'")
                .add("review count='" + reviews.size() + "'")
                .toString();
    }
}
