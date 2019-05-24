package io.desz.opinions.config;

import com.google.inject.AbstractModule;
import io.desz.opinions.service.OpinionRepository;
import io.desz.opinions.service.StubOpinionRepository;

public class OpinionsModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(OpinionRepository.class).to(StubOpinionRepository.class);
    }
}
