package com.talabat.feature.subscriptions.fake;

import com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.feature.subscriptions.fake.di.FakeSubscriptionsFeature"})
public final class FakeSubscriptionsRepository_Factory implements Factory<FakeSubscriptionsRepository> {
    private final Provider<Boolean> repositoryThrowErrorProvider;
    private final Provider<SubscriptionSavingsInfo> savingsInfoProvider;

    public FakeSubscriptionsRepository_Factory(Provider<Boolean> provider, Provider<SubscriptionSavingsInfo> provider2) {
        this.repositoryThrowErrorProvider = provider;
        this.savingsInfoProvider = provider2;
    }

    public static FakeSubscriptionsRepository_Factory create(Provider<Boolean> provider, Provider<SubscriptionSavingsInfo> provider2) {
        return new FakeSubscriptionsRepository_Factory(provider, provider2);
    }

    public static FakeSubscriptionsRepository newInstance(boolean z11, SubscriptionSavingsInfo subscriptionSavingsInfo) {
        return new FakeSubscriptionsRepository(z11, subscriptionSavingsInfo);
    }

    public FakeSubscriptionsRepository get() {
        return newInstance(this.repositoryThrowErrorProvider.get().booleanValue(), this.savingsInfoProvider.get());
    }
}
