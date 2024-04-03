package com.talabat.feature.walletcobrandedcc.domain.usecase.impl;

import com.talabat.customer.domain.CustomerRepository;
import com.talabat.feature.walletcobrandedcc.domain.WalletCobrandedCcRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ShowCobrandedNotificationUseCaseImpl_Factory implements Factory<ShowCobrandedNotificationUseCaseImpl> {
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<WalletCobrandedCcRepository> walletCobrandedCcRepositoryProvider;

    public ShowCobrandedNotificationUseCaseImpl_Factory(Provider<WalletCobrandedCcRepository> provider, Provider<CustomerRepository> provider2) {
        this.walletCobrandedCcRepositoryProvider = provider;
        this.customerRepositoryProvider = provider2;
    }

    public static ShowCobrandedNotificationUseCaseImpl_Factory create(Provider<WalletCobrandedCcRepository> provider, Provider<CustomerRepository> provider2) {
        return new ShowCobrandedNotificationUseCaseImpl_Factory(provider, provider2);
    }

    public static ShowCobrandedNotificationUseCaseImpl newInstance(WalletCobrandedCcRepository walletCobrandedCcRepository, CustomerRepository customerRepository) {
        return new ShowCobrandedNotificationUseCaseImpl(walletCobrandedCcRepository, customerRepository);
    }

    public ShowCobrandedNotificationUseCaseImpl get() {
        return newInstance(this.walletCobrandedCcRepositoryProvider.get(), this.customerRepositoryProvider.get());
    }
}
