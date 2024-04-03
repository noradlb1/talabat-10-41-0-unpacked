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
public final class GetSubscriptionCancellationReasonsUseCase_Factory implements Factory<GetSubscriptionCancellationReasonsUseCase> {
    private final Provider<ISubscriptionsRepository> repositoryProvider;

    public GetSubscriptionCancellationReasonsUseCase_Factory(Provider<ISubscriptionsRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static GetSubscriptionCancellationReasonsUseCase_Factory create(Provider<ISubscriptionsRepository> provider) {
        return new GetSubscriptionCancellationReasonsUseCase_Factory(provider);
    }

    public static GetSubscriptionCancellationReasonsUseCase newInstance(ISubscriptionsRepository iSubscriptionsRepository) {
        return new GetSubscriptionCancellationReasonsUseCase(iSubscriptionsRepository);
    }

    public GetSubscriptionCancellationReasonsUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
