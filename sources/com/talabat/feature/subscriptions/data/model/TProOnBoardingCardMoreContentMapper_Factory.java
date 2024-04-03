package com.talabat.feature.subscriptions.data.model;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TProOnBoardingCardMoreContentMapper_Factory implements Factory<TProOnBoardingCardMoreContentMapper> {
    private final Provider<TProOnBoardingCardMoreContentItemMapper> tProOnBoardingCardMoreContentItemMapperProvider;

    public TProOnBoardingCardMoreContentMapper_Factory(Provider<TProOnBoardingCardMoreContentItemMapper> provider) {
        this.tProOnBoardingCardMoreContentItemMapperProvider = provider;
    }

    public static TProOnBoardingCardMoreContentMapper_Factory create(Provider<TProOnBoardingCardMoreContentItemMapper> provider) {
        return new TProOnBoardingCardMoreContentMapper_Factory(provider);
    }

    public static TProOnBoardingCardMoreContentMapper newInstance(TProOnBoardingCardMoreContentItemMapper tProOnBoardingCardMoreContentItemMapper) {
        return new TProOnBoardingCardMoreContentMapper(tProOnBoardingCardMoreContentItemMapper);
    }

    public TProOnBoardingCardMoreContentMapper get() {
        return newInstance(this.tProOnBoardingCardMoreContentItemMapperProvider.get());
    }
}
