package com.talabat.splash.core.di;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import library.talabat.mvp.login.domain.repository.CustomerRepository;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ApplicationModule_ProvideCustomerRepositoryFactory implements Factory<CustomerRepository> {
    private final Provider<Context> contextProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvideCustomerRepositoryFactory(ApplicationModule applicationModule, Provider<Context> provider) {
        this.module = applicationModule;
        this.contextProvider = provider;
    }

    public static ApplicationModule_ProvideCustomerRepositoryFactory create(ApplicationModule applicationModule, Provider<Context> provider) {
        return new ApplicationModule_ProvideCustomerRepositoryFactory(applicationModule, provider);
    }

    public static CustomerRepository provideCustomerRepository(ApplicationModule applicationModule, Context context) {
        return (CustomerRepository) Preconditions.checkNotNullFromProvides(applicationModule.provideCustomerRepository(context));
    }

    public CustomerRepository get() {
        return provideCustomerRepository(this.module, this.contextProvider.get());
    }
}
