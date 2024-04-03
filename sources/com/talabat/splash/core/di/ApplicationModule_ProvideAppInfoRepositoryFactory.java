package com.talabat.splash.core.di;

import com.talabat.splash.data.repositories.AppInfoRepository;
import com.talabat.splash.data.repositories.AppInfoRepositoryImpl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class ApplicationModule_ProvideAppInfoRepositoryFactory implements Factory<AppInfoRepository> {
    private final Provider<AppInfoRepositoryImpl> appInfoRepositoryProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvideAppInfoRepositoryFactory(ApplicationModule applicationModule, Provider<AppInfoRepositoryImpl> provider) {
        this.module = applicationModule;
        this.appInfoRepositoryProvider = provider;
    }

    public static ApplicationModule_ProvideAppInfoRepositoryFactory create(ApplicationModule applicationModule, Provider<AppInfoRepositoryImpl> provider) {
        return new ApplicationModule_ProvideAppInfoRepositoryFactory(applicationModule, provider);
    }

    public static AppInfoRepository provideAppInfoRepository(ApplicationModule applicationModule, AppInfoRepositoryImpl appInfoRepositoryImpl) {
        return (AppInfoRepository) Preconditions.checkNotNullFromProvides(applicationModule.provideAppInfoRepository(appInfoRepositoryImpl));
    }

    public AppInfoRepository get() {
        return provideAppInfoRepository(this.module, this.appInfoRepositoryProvider.get());
    }
}
