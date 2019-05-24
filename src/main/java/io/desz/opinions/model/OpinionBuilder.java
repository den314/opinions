package io.desz.opinions.model;

import java.time.LocalDateTime;

public class OpinionBuilder {

    private Reviewer reviewer;
    private Thing thing;
    private Description description;
    private Rate rate;
    private LocalDateTime reviewDateTime;

    public OpinionBuilder setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
        return this;
    }

    public OpinionBuilder setThing(Thing thing) {
        this.thing = thing;
        return this;
    }

    public OpinionBuilder setDescription(Description description) {
        this.description = description;
        return this;
    }

    public OpinionBuilder setRate(Rate rate) {
        this.rate = rate;
        return this;
    }

    public OpinionBuilder setReviewDateTime(LocalDateTime reviewDateTime) {
        this.reviewDateTime = reviewDateTime;
        return this;
    }

    public Opinion createOpinion() {
        if (reviewDateTime != null) {
            return new Opinion(reviewer, thing, description, rate, reviewDateTime);
        }
        return new Opinion(reviewer, thing, description, rate);
    }
}