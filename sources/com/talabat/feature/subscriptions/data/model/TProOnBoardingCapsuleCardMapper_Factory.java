package com.talabat.feature.subscriptions.data.model;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TProOnBoardingCapsuleCardMapper_Factory implements Factory<TProOnBoardingCapsuleCardMapper> {
    private final Provider<TProOnBoardingCardMoreContentMapper> tProOnBoardingCardMoreContentMapperProvider;
    private final Provider<TProOnBoardingCardSpanningTitleMapper> tProOnBoardingCardSpanningTitleMapperProvider;

    public TProOnBoardingCapsuleCardMapper_Factory(Provider<TProOnBoardingCardSpanningTitleMapper> provider, Provider<TProOnBoardingCardMoreContentMapper> provider2) {
        this.tProOnBoardingCardSpanningTitleMapperProvider = provider;
        this.tProOnBoardingCardMoreContentMapperProvider = provider2;
    }

    public static TProOnBoardingCapsuleCardMapper_Factory create(Provider<TProOnBoardingCardSpanningTitleMapper> provider, Provider<TProOnBoardingCardMoreContentMapper> provider2) {
        return new TProOnBoardingCapsuleCardMapper_Factory(provider, provider2);
    }

    public static TProOnBoardingCapsuleCardMapper newInstance(TProOnBoardingCardSpanningTitleMapper tProOnBoardingCardSpanningTitleMapper, TProOnBoardingCardMoreContentMapper tProOnBoardingCardMoreContentMapper) {
        return new TProOnBoardingCapsuleCardMapper(tProOnBoardingCardSpanningTitleMapper, tProOnBoardingCardMoreContentMapper);
    }

    public TProOnBoardingCapsuleCardMapper get() {
        return newInstance(this.tProOnBoardingCardSpanningTitleMapperProvider.get(), this.tProOnBoardingCardMoreContentMapperProvider.get());
    }
}
