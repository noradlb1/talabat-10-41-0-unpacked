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
public final class GetSubscriptionPaymentUseCase_Factory implements Factory<GetSubscriptionPaymentUseCase> {
    private final Provider<ISubscriptionsRepository> repositoryProvider;

    public GetSubscriptionPaymentUseCase_Factory(Provider<ISubscriptionsRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static GetSubscriptionPaymentUseCase_Factory create(Provider<ISubscriptionsRepository> provider) {
        return new GetSubscriptionPaymentUseCase_Factory(provider);
    }

    public static GetSubscriptionPaymentUseCase newInstance(ISubscriptionsRepository iSubscriptionsRepository) {
        return new GetSubscriptionPaymentUseCase(iSubscriptionsRepository);
    }

    public GetSubscriptionPaymentUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
