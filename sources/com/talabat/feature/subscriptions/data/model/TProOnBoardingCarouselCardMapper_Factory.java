package com.talabat.feature.subscriptions.data.model;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TProOnBoardingCarouselCardMapper_Factory implements Factory<TProOnBoardingCarouselCardMapper> {
    private final Provider<TProOnBoardingCardMoreContentMapper> tProOnBoardingCardMoreContentMapperProvider;
    private final Provider<TProOnBoardingCardSpanningTitleMapper> tProOnBoardingCardSpanningTitleMapperProvider;

    public TProOnBoardingCarouselCardMapper_Factory(Provider<TProOnBoardingCardSpanningTitleMapper> provider, Provider<TProOnBoardingCardMoreContentMapper> provider2) {
        this.tProOnBoardingCardSpanningTitleMapperProvider = provider;
        this.tProOnBoardingCardMoreContentMapperProvider = provider2;
    }

    public static TProOnBoardingCarouselCardMapper_Factory create(Provider<TProOnBoardingCardSpanningTitleMapper> provider, Provider<TProOnBoardingCardMoreContentMapper> provider2) {
        return new TProOnBoardingCarouselCardMapper_Factory(provider, provider2);
    }

    public static TProOnBoardingCarouselCardMapper newInstance(TProOnBoardingCardSpanningTitleMapper tProOnBoardingCardSpanningTitleMapper, TProOnBoardingCardMoreContentMapper tProOnBoardingCardMoreContentMapper) {
        return new TProOnBoardingCarouselCardMapper(tProOnBoardingCardSpanningTitleMapper, tProOnBoardingCardMoreContentMapper);
    }

    public TProOnBoardingCarouselCardMapper get() {
        return newInstance(this.tProOnBoardingCardSpanningTitleMapperProvider.get(), this.tProOnBoardingCardMoreContentMapperProvider.get());
    }
}
