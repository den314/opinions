package io.desz.opinions;

import io.desz.opinions.model.*;
import io.desz.opinions.service.OpinionService;
import io.desz.opinions.service.StubOpinionRepository;
import io.desz.opinions.validation.OpinionValidator;
import io.desz.opinions.validation.PastDateValidator;

import java.time.LocalDateTime;
import java.time.Month;

public class Main {

    public static void main(String[] args) {

        OpinionService opinionService = new OpinionService(
                new OpinionValidator(new PastDateValidator()),
                new StubOpinionRepository());

        Reviewer denis = new Reviewer("denis");
        Reviewer fred = new Reviewer("fred");

        Opinion opinion = new OpinionBuilder()
                .setReviewer(denis)
                .setThing(new Thing("wallet from TheWallet company", Thing.Type.PRODUCT))
                .setDescription(new Description("don't buy it", "the wallet's quality is really poor"))
                .setRate(Rate.NOT_RECOMMEND)
                .setReviewDateTime(LocalDateTime.of(2010, Month.JANUARY, 10, 10, 15))
                .createOpinion();

        opinionService.add(opinion);
        opinion.add(new Comment(fred, "that's not true!"));

        System.out.println(opinion);
        System.out.println(denis);
    }
}
