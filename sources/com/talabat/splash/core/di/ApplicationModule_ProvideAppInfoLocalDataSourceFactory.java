package com.talabat.splash.core.di;

import com.talabat.splash.data.preferences.AppInfoLocalDataSource;
import com.talabat.splash.data.preferences.AppInfoLocalDataSourceImp;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ApplicationModule_ProvideAppInfoLocalDataSourceFactory implements Factory<AppInfoLocalDataSource> {
    private final Provider<AppInfoLocalDataSourceImp> appInfoLocalDataSourceImpProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvideAppInfoLocalDataSourceFactory(ApplicationModule applicationModule, Provider<AppInfoLocalDataSourceImp> provider) {
        this.module = applicationModule;
        this.appInfoLocalDataSourceImpProvider = provider;
    }

    public static ApplicationModule_ProvideAppInfoLocalDataSourceFactory create(ApplicationModule applicationModule, Provider<AppInfoLocalDataSourceImp> provider) {
        return new ApplicationModule_ProvideAppInfoLocalDataSourceFactory(applicationModule, provider);
    }

    public static AppInfoLocalDataSource provideAppInfoLocalDataSource(ApplicationModule applicationModule, AppInfoLocalDataSourceImp appInfoLocalDataSourceImp) {
        return (AppInfoLocalDataSource) Preconditions.checkNotNullFromProvides(applicationModule.provideAppInfoLocalDataSource(appInfoLocalDataSourceImp));
    }

    public AppInfoLocalDataSource get() {
        return provideAppInfoLocalDataSource(this.module, this.appInfoLocalDataSourceImpProvider.get());
    }
}
