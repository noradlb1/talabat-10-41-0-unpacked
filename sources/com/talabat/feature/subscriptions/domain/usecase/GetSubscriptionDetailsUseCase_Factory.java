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
public final class GetSubscriptionDetailsUseCase_Factory implements Factory<GetSubscriptionDetailsUseCase> {
    private final Provider<ISubscriptionsRepository> repositoryProvider;

    public GetSubscriptionDetailsUseCase_Factory(Provider<ISubscriptionsRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static GetSubscriptionDetailsUseCase_Factory create(Provider<ISubscriptionsRepository> provider) {
        return new GetSubscriptionDetailsUseCase_Factory(provider);
    }

    public static GetSubscriptionDetailsUseCase newInstance(ISubscriptionsRepository iSubscriptionsRepository) {
        return new GetSubscriptionDetailsUseCase(iSubscriptionsRepository);
    }

    public GetSubscriptionDetailsUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
