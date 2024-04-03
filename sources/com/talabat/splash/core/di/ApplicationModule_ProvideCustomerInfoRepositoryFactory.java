package com.talabat.splash.core.di;

import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper;
import com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ApplicationModule_ProvideCustomerInfoRepositoryFactory implements Factory<CustomerInfoRepository> {
    private final ApplicationModule module;
    private final Provider<ProCentralizationStatusWrapper> proCentralizationStatusWrapperProvider;

    public ApplicationModule_ProvideCustomerInfoRepositoryFactory(ApplicationModule applicationModule, Provider<ProCentralizationStatusWrapper> provider) {
        this.module = applicationModule;
        this.proCentralizationStatusWrapperProvider = provider;
    }

    public static ApplicationModule_ProvideCustomerInfoRepositoryFactory create(ApplicationModule applicationModule, Provider<ProCentralizationStatusWrapper> provider) {
        return new ApplicationModule_ProvideCustomerInfoRepositoryFactory(applicationModule, provider);
    }

    public static CustomerInfoRepository provideCustomerInfoRepository(ApplicationModule applicationModule, ProCentralizationStatusWrapper proCentralizationStatusWrapper) {
        return (CustomerInfoRepository) Preconditions.checkNotNullFromProvides(applicationModule.provideCustomerInfoRepository(proCentralizationStatusWrapper));
    }

    public CustomerInfoRepository get() {
        return provideCustomerInfoRepository(this.module, this.proCentralizationStatusWrapperProvider.get());
    }
}
