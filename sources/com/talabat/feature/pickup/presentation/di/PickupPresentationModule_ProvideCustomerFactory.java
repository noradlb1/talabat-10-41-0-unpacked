package com.talabat.feature.pickup.presentation.di;

import buisnessmodels.Customer;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PickupPresentationModule_ProvideCustomerFactory implements Factory<Customer> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final PickupPresentationModule_ProvideCustomerFactory INSTANCE = new PickupPresentationModule_ProvideCustomerFactory();

        private InstanceHolder() {
        }
    }

    public static PickupPresentationModule_ProvideCustomerFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Customer provideCustomer() {
        return (Customer) Preconditions.checkNotNullFromProvides(PickupPresentationModule.INSTANCE.provideCustomer());
    }

    public Customer get() {
        return provideCustomer();
    }
}
