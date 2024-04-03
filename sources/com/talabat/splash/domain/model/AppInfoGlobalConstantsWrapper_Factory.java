package com.talabat.splash.domain.model;

import com.talabat.splash.data.preferences.SplashPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class AppInfoGlobalConstantsWrapper_Factory implements Factory<AppInfoGlobalConstantsWrapper> {
    private final Provider<SplashPreferences> splashPreferencesProvider;

    public AppInfoGlobalConstantsWrapper_Factory(Provider<SplashPreferences> provider) {
        this.splashPreferencesProvider = provider;
    }

    public static AppInfoGlobalConstantsWrapper_Factory create(Provider<SplashPreferences> provider) {
        return new AppInfoGlobalConstantsWrapper_Factory(provider);
    }

    public static AppInfoGlobalConstantsWrapper newInstance(SplashPreferences splashPreferences) {
        return new AppInfoGlobalConstantsWrapper(splashPreferences);
    }

    public AppInfoGlobalConstantsWrapper get() {
        return newInstance(this.splashPreferencesProvider.get());
    }
}
