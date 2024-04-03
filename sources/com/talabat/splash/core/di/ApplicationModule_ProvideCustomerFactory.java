package com.talabat.splash.core.di;

import buisnessmodels.Customer;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class ApplicationModule_ProvideCustomerFactory implements Factory<Customer> {
    private final ApplicationModule module;

    public ApplicationModule_ProvideCustomerFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideCustomerFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideCustomerFactory(applicationModule);
    }

    public static Customer provideCustomer(ApplicationModule applicationModule) {
        return (Customer) Preconditions.checkNotNullFromProvides(applicationModule.provideCustomer());
    }

    public Customer get() {
        return provideCustomer(this.module);
    }
}
