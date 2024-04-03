package com.talabat.feature.subscriptions.data.model;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TProOnBoardingCardMapper_Factory implements Factory<TProOnBoardingCardMapper> {
    private final Provider<TProOnBoardingCapsuleCardMapper> tProOnBoardingCapsuleCardMapperProvider;
    private final Provider<TProOnBoardingCarouselCardMapper> tProOnBoardingCarouselCardMapperProvider;
    private final Provider<TProOnBoardingGridCardMapper> tProOnBoardingGridCardMapperProvider;
    private final Provider<TProOnBoardingLottieCardMapper> tProOnBoardingLottieCardMapperProvider;
    private final Provider<TProOnBoardingTagsCardMapper> tProOnBoardingTagsCardMapperProvider;

    public TProOnBoardingCardMapper_Factory(Provider<TProOnBoardingCapsuleCardMapper> provider, Provider<TProOnBoardingTagsCardMapper> provider2, Provider<TProOnBoardingGridCardMapper> provider3, Provider<TProOnBoardingLottieCardMapper> provider4, Provider<TProOnBoardingCarouselCardMapper> provider5) {
        this.tProOnBoardingCapsuleCardMapperProvider = provider;
        this.tProOnBoardingTagsCardMapperProvider = provider2;
        this.tProOnBoardingGridCardMapperProvider = provider3;
        this.tProOnBoardingLottieCardMapperProvider = provider4;
        this.tProOnBoardingCarouselCardMapperProvider = provider5;
    }

    public static TProOnBoardingCardMapper_Factory create(Provider<TProOnBoardingCapsuleCardMapper> provider, Provider<TProOnBoardingTagsCardMapper> provider2, Provider<TProOnBoardingGridCardMapper> provider3, Provider<TProOnBoardingLottieCardMapper> provider4, Provider<TProOnBoardingCarouselCardMapper> provider5) {
        return new TProOnBoardingCardMapper_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static TProOnBoardingCardMapper newInstance(TProOnBoardingCapsuleCardMapper tProOnBoardingCapsuleCardMapper, TProOnBoardingTagsCardMapper tProOnBoardingTagsCardMapper, TProOnBoardingGridCardMapper tProOnBoardingGridCardMapper, TProOnBoardingLottieCardMapper tProOnBoardingLottieCardMapper, TProOnBoardingCarouselCardMapper tProOnBoardingCarouselCardMapper) {
        return new TProOnBoardingCardMapper(tProOnBoardingCapsuleCardMapper, tProOnBoardingTagsCardMapper, tProOnBoardingGridCardMapper, tProOnBoardingLottieCardMapper, tProOnBoardingCarouselCardMapper);
    }

    public TProOnBoardingCardMapper get() {
        return newInstance(this.tProOnBoardingCapsuleCardMapperProvider.get(), this.tProOnBoardingTagsCardMapperProvider.get(), this.tProOnBoardingGridCardMapperProvider.get(), this.tProOnBoardingLottieCardMapperProvider.get(), this.tProOnBoardingCarouselCardMapperProvider.get());
    }
}
