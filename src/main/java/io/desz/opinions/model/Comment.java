package io.desz.opinions.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Comment {

    private Reviewer reviewer;
    private String description;
    private LocalDateTime commentDateTime = LocalDateTime.now();

    public Comment(Reviewer reviewer, String description) {
        this.reviewer = reviewer;
        this.description = description;
    }
}
