package com.talabat.feature.subscriptions.data.model;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SubscriptionMultiPlanModelMapper_Factory implements Factory<SubscriptionMultiPlanModelMapper> {
    private final Provider<SubscriptionPlanModelMapper> subscriptionPlanMapperProvider;

    public SubscriptionMultiPlanModelMapper_Factory(Provider<SubscriptionPlanModelMapper> provider) {
        this.subscriptionPlanMapperProvider = provider;
    }

    public static SubscriptionMultiPlanModelMapper_Factory create(Provider<SubscriptionPlanModelMapper> provider) {
        return new SubscriptionMultiPlanModelMapper_Factory(provider);
    }

    public static SubscriptionMultiPlanModelMapper newInstance(SubscriptionPlanModelMapper subscriptionPlanModelMapper) {
        return new SubscriptionMultiPlanModelMapper(subscriptionPlanModelMapper);
    }

    public SubscriptionMultiPlanModelMapper get() {
        return newInstance(this.subscriptionPlanMapperProvider.get());
    }
}
