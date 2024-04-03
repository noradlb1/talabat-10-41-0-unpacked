package com.talabat.feature.pickup.presentation.provider.impl;

import buisnessmodels.Customer;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CreditProviderImpl_Factory implements Factory<CreditProviderImpl> {
    private final Provider<Customer> customerProvider;

    public CreditProviderImpl_Factory(Provider<Customer> provider) {
        this.customerProvider = provider;
    }

    public static CreditProviderImpl_Factory create(Provider<Customer> provider) {
        return new CreditProviderImpl_Factory(provider);
    }

    public static CreditProviderImpl newInstance(Customer customer) {
        return new CreditProviderImpl(customer);
    }

    public CreditProviderImpl get() {
        return newInstance(this.customerProvider.get());
    }
}
