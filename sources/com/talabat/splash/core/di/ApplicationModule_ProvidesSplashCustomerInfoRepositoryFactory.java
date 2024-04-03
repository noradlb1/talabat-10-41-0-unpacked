package com.talabat.splash.core.di;

import com.talabat.splash.data.repositories.SplashCustomerInfoRepository;
import com.talabat.splash.data.repositories.SplashCustomerInfoRepositoryImp;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class ApplicationModule_ProvidesSplashCustomerInfoRepositoryFactory implements Factory<SplashCustomerInfoRepository> {
    private final ApplicationModule module;
    private final Provider<SplashCustomerInfoRepositoryImp> splashCustomerInfoRepositoryImpProvider;

    public ApplicationModule_ProvidesSplashCustomerInfoRepositoryFactory(ApplicationModule applicationModule, Provider<SplashCustomerInfoRepositoryImp> provider) {
        this.module = applicationModule;
        this.splashCustomerInfoRepositoryImpProvider = provider;
    }

    public static ApplicationModule_ProvidesSplashCustomerInfoRepositoryFactory create(ApplicationModule applicationModule, Provider<SplashCustomerInfoRepositoryImp> provider) {
        return new ApplicationModule_ProvidesSplashCustomerInfoRepositoryFactory(applicationModule, provider);
    }

    public static SplashCustomerInfoRepository providesSplashCustomerInfoRepository(ApplicationModule applicationModule, SplashCustomerInfoRepositoryImp splashCustomerInfoRepositoryImp) {
        return (SplashCustomerInfoRepository) Preconditions.checkNotNullFromProvides(applicationModule.providesSplashCustomerInfoRepository(splashCustomerInfoRepositoryImp));
    }

    public SplashCustomerInfoRepository get() {
        return providesSplashCustomerInfoRepository(this.module, this.splashCustomerInfoRepositoryImpProvider.get());
    }
}
