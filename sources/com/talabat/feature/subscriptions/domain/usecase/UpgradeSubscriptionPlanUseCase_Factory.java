package com.talabat.feature.subscriptions.domain.usecase;

import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class UpgradeSubscriptionPlanUseCase_Factory implements Factory<UpgradeSubscriptionPlanUseCase> {
    private final Provider<ISubscriptionsRepository> repositoryProvider;

    public UpgradeSubscriptionPlanUseCase_Factory(Provider<ISubscriptionsRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static UpgradeSubscriptionPlanUseCase_Factory create(Provider<ISubscriptionsRepository> provider) {
        return new UpgradeSubscriptionPlanUseCase_Factory(provider);
    }

    public static UpgradeSubscriptionPlanUseCase newInstance(ISubscriptionsRepository iSubscriptionsRepository) {
        return new UpgradeSubscriptionPlanUseCase(iSubscriptionsRepository);
    }

    public UpgradeSubscriptionPlanUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
