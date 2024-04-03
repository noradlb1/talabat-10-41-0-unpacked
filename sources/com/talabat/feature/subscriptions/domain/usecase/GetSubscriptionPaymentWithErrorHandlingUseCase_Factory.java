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
public final class GetSubscriptionPaymentWithErrorHandlingUseCase_Factory implements Factory<GetSubscriptionPaymentWithErrorHandlingUseCase> {
    private final Provider<ISubscriptionsRepository> repositoryProvider;

    public GetSubscriptionPaymentWithErrorHandlingUseCase_Factory(Provider<ISubscriptionsRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static GetSubscriptionPaymentWithErrorHandlingUseCase_Factory create(Provider<ISubscriptionsRepository> provider) {
        return new GetSubscriptionPaymentWithErrorHandlingUseCase_Factory(provider);
    }

    public static GetSubscriptionPaymentWithErrorHandlingUseCase newInstance(ISubscriptionsRepository iSubscriptionsRepository) {
        return new GetSubscriptionPaymentWithErrorHandlingUseCase(iSubscriptionsRepository);
    }

    public GetSubscriptionPaymentWithErrorHandlingUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
