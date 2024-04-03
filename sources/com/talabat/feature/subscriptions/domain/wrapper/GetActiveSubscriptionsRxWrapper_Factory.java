package com.talabat.feature.subscriptions.domain.wrapper;

import com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository;
import com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetActiveSubscriptionsRxWrapper_Factory implements Factory<GetActiveSubscriptionsRxWrapper> {
    private final Provider<GetActiveSubscriptionsUseCase> getActiveSubscriptionsUseCaseProvider;
    private final Provider<ISubscriptionsCustomerRepository> subscriptionsCustomerHelperProvider;

    public GetActiveSubscriptionsRxWrapper_Factory(Provider<GetActiveSubscriptionsUseCase> provider, Provider<ISubscriptionsCustomerRepository> provider2) {
        this.getActiveSubscriptionsUseCaseProvider = provider;
        this.subscriptionsCustomerHelperProvider = provider2;
    }

    public static GetActiveSubscriptionsRxWrapper_Factory create(Provider<GetActiveSubscriptionsUseCase> provider, Provider<ISubscriptionsCustomerRepository> provider2) {
        return new GetActiveSubscriptionsRxWrapper_Factory(provider, provider2);
    }

    public static GetActiveSubscriptionsRxWrapper newInstance(GetActiveSubscriptionsUseCase getActiveSubscriptionsUseCase, ISubscriptionsCustomerRepository iSubscriptionsCustomerRepository) {
        return new GetActiveSubscriptionsRxWrapper(getActiveSubscriptionsUseCase, iSubscriptionsCustomerRepository);
    }

    public GetActiveSubscriptionsRxWrapper get() {
        return newInstance(this.getActiveSubscriptionsUseCaseProvider.get(), this.subscriptionsCustomerHelperProvider.get());
    }
}
