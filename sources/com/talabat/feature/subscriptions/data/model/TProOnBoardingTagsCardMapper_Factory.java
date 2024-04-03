package com.talabat.feature.subscriptions.data.model;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TProOnBoardingTagsCardMapper_Factory implements Factory<TProOnBoardingTagsCardMapper> {
    private final Provider<TProOnBoardingCardMoreContentMapper> tProOnBoardingCardMoreContentMapperProvider;
    private final Provider<TProOnBoardingCardSpanningTitleMapper> tProOnBoardingCardSpanningTitleMapperProvider;

    public TProOnBoardingTagsCardMapper_Factory(Provider<TProOnBoardingCardSpanningTitleMapper> provider, Provider<TProOnBoardingCardMoreContentMapper> provider2) {
        this.tProOnBoardingCardSpanningTitleMapperProvider = provider;
        this.tProOnBoardingCardMoreContentMapperProvider = provider2;
    }

    public static TProOnBoardingTagsCardMapper_Factory create(Provider<TProOnBoardingCardSpanningTitleMapper> provider, Provider<TProOnBoardingCardMoreContentMapper> provider2) {
        return new TProOnBoardingTagsCardMapper_Factory(provider, provider2);
    }

    public static TProOnBoardingTagsCardMapper newInstance(TProOnBoardingCardSpanningTitleMapper tProOnBoardingCardSpanningTitleMapper, TProOnBoardingCardMoreContentMapper tProOnBoardingCardMoreContentMapper) {
        return new TProOnBoardingTagsCardMapper(tProOnBoardingCardSpanningTitleMapper, tProOnBoardingCardMoreContentMapper);
    }

    public TProOnBoardingTagsCardMapper get() {
        return newInstance(this.tProOnBoardingCardSpanningTitleMapperProvider.get(), this.tProOnBoardingCardMoreContentMapperProvider.get());
    }
}
