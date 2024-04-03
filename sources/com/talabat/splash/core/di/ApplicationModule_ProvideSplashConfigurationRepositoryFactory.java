package com.talabat.splash.core.di;

import com.talabat.splash.data.remote.SplashConfigurationRemoteDataSource;
import com.talabat.splash.domain.repository.SplashConfigurationRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ApplicationModule_ProvideSplashConfigurationRepositoryFactory implements Factory<SplashConfigurationRepository> {
    private final ApplicationModule module;
    private final Provider<SplashConfigurationRemoteDataSource> splashConfigurationRemoteDataSourceProvider;

    public ApplicationModule_ProvideSplashConfigurationRepositoryFactory(ApplicationModule applicationModule, Provider<SplashConfigurationRemoteDataSource> provider) {
        this.module = applicationModule;
        this.splashConfigurationRemoteDataSourceProvider = provider;
    }

    public static ApplicationModule_ProvideSplashConfigurationRepositoryFactory create(ApplicationModule applicationModule, Provider<SplashConfigurationRemoteDataSource> provider) {
        return new ApplicationModule_ProvideSplashConfigurationRepositoryFactory(applicationModule, provider);
    }

    public static SplashConfigurationRepository provideSplashConfigurationRepository(ApplicationModule applicationModule, SplashConfigurationRemoteDataSource splashConfigurationRemoteDataSource) {
        return (SplashConfigurationRepository) Preconditions.checkNotNullFromProvides(applicationModule.provideSplashConfigurationRepository(splashConfigurationRemoteDataSource));
    }

    public SplashConfigurationRepository get() {
        return provideSplashConfigurationRepository(this.module, this.splashConfigurationRemoteDataSourceProvider.get());
    }
}
