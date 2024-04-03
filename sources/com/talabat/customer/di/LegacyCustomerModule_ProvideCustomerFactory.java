package com.talabat.customer.di;

import buisnessmodels.Customer;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class LegacyCustomerModule_ProvideCustomerFactory implements Factory<Customer> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final LegacyCustomerModule_ProvideCustomerFactory INSTANCE = new LegacyCustomerModule_ProvideCustomerFactory();

        private InstanceHolder() {
        }
    }

    public static LegacyCustomerModule_ProvideCustomerFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Customer provideCustomer() {
        return (Customer) Preconditions.checkNotNullFromProvides(LegacyCustomerModule.INSTANCE.provideCustomer());
    }

    public Customer get() {
        return provideCustomer();
    }
}
