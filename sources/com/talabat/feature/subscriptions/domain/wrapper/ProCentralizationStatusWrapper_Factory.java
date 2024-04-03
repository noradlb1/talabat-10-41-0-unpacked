package com.talabat.feature.subscriptions.domain.wrapper;

import com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository;
import com.talabat.feature.subscriptions.domain.usecase.GetProCentralizationStatusUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ProCentralizationStatusWrapper_Factory implements Factory<ProCentralizationStatusWrapper> {
    private final Provider<GetProCentralizationStatusUseCase> getProCentralizationStatusUseCaseProvider;
    private final Provider<ISubscriptionsCustomerRepository> subscriptionsCustomerHelperProvider;

    public ProCentralizationStatusWrapper_Factory(Provider<GetProCentralizationStatusUseCase> provider, Provider<ISubscriptionsCustomerRepository> provider2) {
        this.getProCentralizationStatusUseCaseProvider = provider;
        this.subscriptionsCustomerHelperProvider = provider2;
    }

    public static ProCentralizationStatusWrapper_Factory create(Provider<GetProCentralizationStatusUseCase> provider, Provider<ISubscriptionsCustomerRepository> provider2) {
        return new ProCentralizationStatusWrapper_Factory(provider, provider2);
    }

    public static ProCentralizationStatusWrapper newInstance(GetProCentralizationStatusUseCase getProCentralizationStatusUseCase, ISubscriptionsCustomerRepository iSubscriptionsCustomerRepository) {
        return new ProCentralizationStatusWrapper(getProCentralizationStatusUseCase, iSubscriptionsCustomerRepository);
    }

    public ProCentralizationStatusWrapper get() {
        return newInstance(this.getProCentralizationStatusUseCaseProvider.get(), this.subscriptionsCustomerHelperProvider.get());
    }
}
