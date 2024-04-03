package com.talabat.darkstores.di;

import buisnessmodels.Customer;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresApplicationModule_ProvidesCustomerFactory implements Factory<Customer> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DarkstoresApplicationModule_ProvidesCustomerFactory INSTANCE = new DarkstoresApplicationModule_ProvidesCustomerFactory();

        private InstanceHolder() {
        }
    }

    public static DarkstoresApplicationModule_ProvidesCustomerFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Customer providesCustomer() {
        return (Customer) Preconditions.checkNotNullFromProvides(DarkstoresApplicationModule.INSTANCE.providesCustomer());
    }

    public Customer get() {
        return providesCustomer();
    }
}
