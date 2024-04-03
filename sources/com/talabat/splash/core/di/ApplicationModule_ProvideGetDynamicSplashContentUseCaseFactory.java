package com.talabat.splash.core.di;

import com.talabat.splash.domain.repository.DownloadsRepository;
import com.talabat.splash.domain.repository.SplashConfigurationRepository;
import com.talabat.splash.domain.usecase.GetDynamicSplashContentUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ApplicationModule_ProvideGetDynamicSplashContentUseCaseFactory implements Factory<GetDynamicSplashContentUseCase> {
    private final Provider<DownloadsRepository> downloadsRepositoryProvider;
    private final ApplicationModule module;
    private final Provider<SplashConfigurationRepository> splashConfigurationRepositoryProvider;

    public ApplicationModule_ProvideGetDynamicSplashContentUseCaseFactory(ApplicationModule applicationModule, Provider<SplashConfigurationRepository> provider, Provider<DownloadsRepository> provider2) {
        this.module = applicationModule;
        this.splashConfigurationRepositoryProvider = provider;
        this.downloadsRepositoryProvider = provider2;
    }

    public static ApplicationModule_ProvideGetDynamicSplashContentUseCaseFactory create(ApplicationModule applicationModule, Provider<SplashConfigurationRepository> provider, Provider<DownloadsRepository> provider2) {
        return new ApplicationModule_ProvideGetDynamicSplashContentUseCaseFactory(applicationModule, provider, provider2);
    }

    public static GetDynamicSplashContentUseCase provideGetDynamicSplashContentUseCase(ApplicationModule applicationModule, SplashConfigurationRepository splashConfigurationRepository, DownloadsRepository downloadsRepository) {
        return (GetDynamicSplashContentUseCase) Preconditions.checkNotNullFromProvides(applicationModule.provideGetDynamicSplashContentUseCase(splashConfigurationRepository, downloadsRepository));
    }

    public GetDynamicSplashContentUseCase get() {
        return provideGetDynamicSplashContentUseCase(this.module, this.splashConfigurationRepositoryProvider.get(), this.downloadsRepositoryProvider.get());
    }
}
