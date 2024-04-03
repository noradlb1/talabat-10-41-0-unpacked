package com.talabat.feature.subscriptions.data.model;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TProOnBoardingBannerAndPlansMapper_Factory implements Factory<TProOnBoardingBannerAndPlansMapper> {
    private final Provider<HeroBannerModelMapper> heroBannerModelMapperProvider;
    private final Provider<SubscriptionMultiPlanModelMapper> subscriptionPlanMapperProvider;
    private final Provider<TProOnBoardingCardMapper> tProOnBoardingCardMapperProvider;
    private final Provider<TProOnBoardingCardSpanningTitleMapper> tProOnBoardingCardSpanningTitleMapperProvider;

    public TProOnBoardingBannerAndPlansMapper_Factory(Provider<SubscriptionMultiPlanModelMapper> provider, Provider<HeroBannerModelMapper> provider2, Provider<TProOnBoardingCardMapper> provider3, Provider<TProOnBoardingCardSpanningTitleMapper> provider4) {
        this.subscriptionPlanMapperProvider = provider;
        this.heroBannerModelMapperProvider = provider2;
        this.tProOnBoardingCardMapperProvider = provider3;
        this.tProOnBoardingCardSpanningTitleMapperProvider = provider4;
    }

    public static TProOnBoardingBannerAndPlansMapper_Factory create(Provider<SubscriptionMultiPlanModelMapper> provider, Provider<HeroBannerModelMapper> provider2, Provider<TProOnBoardingCardMapper> provider3, Provider<TProOnBoardingCardSpanningTitleMapper> provider4) {
        return new TProOnBoardingBannerAndPlansMapper_Factory(provider, provider2, provider3, provider4);
    }

    public static TProOnBoardingBannerAndPlansMapper newInstance(SubscriptionMultiPlanModelMapper subscriptionMultiPlanModelMapper, HeroBannerModelMapper heroBannerModelMapper, TProOnBoardingCardMapper tProOnBoardingCardMapper, TProOnBoardingCardSpanningTitleMapper tProOnBoardingCardSpanningTitleMapper) {
        return new TProOnBoardingBannerAndPlansMapper(subscriptionMultiPlanModelMapper, heroBannerModelMapper, tProOnBoardingCardMapper, tProOnBoardingCardSpanningTitleMapper);
    }

    public TProOnBoardingBannerAndPlansMapper get() {
        return newInstance(this.subscriptionPlanMapperProvider.get(), this.heroBannerModelMapperProvider.get(), this.tProOnBoardingCardMapperProvider.get(), this.tProOnBoardingCardSpanningTitleMapperProvider.get());
    }
}
