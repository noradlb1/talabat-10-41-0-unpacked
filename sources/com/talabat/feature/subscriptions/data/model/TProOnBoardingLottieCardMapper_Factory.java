package com.talabat.feature.subscriptions.data.model;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TProOnBoardingLottieCardMapper_Factory implements Factory<TProOnBoardingLottieCardMapper> {
    private final Provider<TProOnBoardingCardMoreContentMapper> tProOnBoardingCardMoreContentMapperProvider;
    private final Provider<TProOnBoardingCardSpanningTitleMapper> tProOnBoardingCardSpanningTitleMapperProvider;

    public TProOnBoardingLottieCardMapper_Factory(Provider<TProOnBoardingCardSpanningTitleMapper> provider, Provider<TProOnBoardingCardMoreContentMapper> provider2) {
        this.tProOnBoardingCardSpanningTitleMapperProvider = provider;
        this.tProOnBoardingCardMoreContentMapperProvider = provider2;
    }

    public static TProOnBoardingLottieCardMapper_Factory create(Provider<TProOnBoardingCardSpanningTitleMapper> provider, Provider<TProOnBoardingCardMoreContentMapper> provider2) {
        return new TProOnBoardingLottieCardMapper_Factory(provider, provider2);
    }

    public static TProOnBoardingLottieCardMapper newInstance(TProOnBoardingCardSpanningTitleMapper tProOnBoardingCardSpanningTitleMapper, TProOnBoardingCardMoreContentMapper tProOnBoardingCardMoreContentMapper) {
        return new TProOnBoardingLottieCardMapper(tProOnBoardingCardSpanningTitleMapper, tProOnBoardingCardMoreContentMapper);
    }

    public TProOnBoardingLottieCardMapper get() {
        return newInstance(this.tProOnBoardingCardSpanningTitleMapperProvider.get(), this.tProOnBoardingCardMoreContentMapperProvider.get());
    }
}
