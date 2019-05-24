package io.desz.opinions;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.desz.opinions.config.OpinionsModule;
import io.desz.opinions.model.*;
import io.desz.opinions.service.OpinionService;

import java.time.LocalDateTime;
import java.time.Month;

public class Main {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new OpinionsModule());

        OpinionService opinionService = injector.getInstance(OpinionService.class);

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
