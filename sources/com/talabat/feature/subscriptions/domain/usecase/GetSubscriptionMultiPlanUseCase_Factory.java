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
public final class GetSubscriptionMultiPlanUseCase_Factory implements Factory<GetSubscriptionMultiPlanUseCase> {
    private final Provider<ISubscriptionsRepository> repositoryProvider;

    public GetSubscriptionMultiPlanUseCase_Factory(Provider<ISubscriptionsRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static GetSubscriptionMultiPlanUseCase_Factory create(Provider<ISubscriptionsRepository> provider) {
        return new GetSubscriptionMultiPlanUseCase_Factory(provider);
    }

    public static GetSubscriptionMultiPlanUseCase newInstance(ISubscriptionsRepository iSubscriptionsRepository) {
        return new GetSubscriptionMultiPlanUseCase(iSubscriptionsRepository);
    }

    public GetSubscriptionMultiPlanUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
