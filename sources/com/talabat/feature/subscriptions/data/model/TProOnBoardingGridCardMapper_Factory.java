package com.talabat.feature.subscriptions.data.model;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TProOnBoardingGridCardMapper_Factory implements Factory<TProOnBoardingGridCardMapper> {
    private final Provider<TProOnBoardingCardMoreContentMapper> tProOnBoardingCardMoreContentMapperProvider;
    private final Provider<TProOnBoardingCardSpanningTitleMapper> tProOnBoardingCardSpanningTitleMapperProvider;

    public TProOnBoardingGridCardMapper_Factory(Provider<TProOnBoardingCardSpanningTitleMapper> provider, Provider<TProOnBoardingCardMoreContentMapper> provider2) {
        this.tProOnBoardingCardSpanningTitleMapperProvider = provider;
        this.tProOnBoardingCardMoreContentMapperProvider = provider2;
    }

    public static TProOnBoardingGridCardMapper_Factory create(Provider<TProOnBoardingCardSpanningTitleMapper> provider, Provider<TProOnBoardingCardMoreContentMapper> provider2) {
        return new TProOnBoardingGridCardMapper_Factory(provider, provider2);
    }

    public static TProOnBoardingGridCardMapper newInstance(TProOnBoardingCardSpanningTitleMapper tProOnBoardingCardSpanningTitleMapper, TProOnBoardingCardMoreContentMapper tProOnBoardingCardMoreContentMapper) {
        return new TProOnBoardingGridCardMapper(tProOnBoardingCardSpanningTitleMapper, tProOnBoardingCardMoreContentMapper);
    }

    public TProOnBoardingGridCardMapper get() {
        return newInstance(this.tProOnBoardingCardSpanningTitleMapperProvider.get(), this.tProOnBoardingCardMoreContentMapperProvider.get());
    }
}
