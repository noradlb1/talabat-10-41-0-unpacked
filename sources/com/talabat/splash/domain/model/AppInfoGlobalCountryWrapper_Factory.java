package com.talabat.splash.domain.model;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.MutableConfigurationLocalCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.splash.data.preferences.SplashPreferences;
import com.talabat.splash.presentation.infrastructure.thirdparty.Tracking;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class AppInfoGlobalCountryWrapper_Factory implements Factory<AppInfoGlobalCountryWrapper> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<MutableConfigurationLocalCoreLibApi> mutableConfigurationLocalCoreLibApiProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<SplashPreferences> splashPreferencesProvider;
    private final Provider<Tracking> trackingProvider;

    public AppInfoGlobalCountryWrapper_Factory(Provider<SplashPreferences> provider, Provider<Tracking> provider2, Provider<ConfigurationLocalRepository> provider3, Provider<LocationConfigurationRepository> provider4, Provider<MutableConfigurationLocalCoreLibApi> provider5, Provider<IObservabilityManager> provider6) {
        this.splashPreferencesProvider = provider;
        this.trackingProvider = provider2;
        this.configurationLocalRepositoryProvider = provider3;
        this.locationConfigurationRepositoryProvider = provider4;
        this.mutableConfigurationLocalCoreLibApiProvider = provider5;
        this.observabilityManagerProvider = provider6;
    }

    public static AppInfoGlobalCountryWrapper_Factory create(Provider<SplashPreferences> provider, Provider<Tracking> provider2, Provider<ConfigurationLocalRepository> provider3, Provider<LocationConfigurationRepository> provider4, Provider<MutableConfigurationLocalCoreLibApi> provider5, Provider<IObservabilityManager> provider6) {
        return new AppInfoGlobalCountryWrapper_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static AppInfoGlobalCountryWrapper newInstance(SplashPreferences splashPreferences, Tracking tracking2, ConfigurationLocalRepository configurationLocalRepository, LocationConfigurationRepository locationConfigurationRepository, MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi, IObservabilityManager iObservabilityManager) {
        return new AppInfoGlobalCountryWrapper(splashPreferences, tracking2, configurationLocalRepository, locationConfigurationRepository, mutableConfigurationLocalCoreLibApi, iObservabilityManager);
    }

    public AppInfoGlobalCountryWrapper get() {
        return newInstance(this.splashPreferencesProvider.get(), this.trackingProvider.get(), this.configurationLocalRepositoryProvider.get(), this.locationConfigurationRepositoryProvider.get(), this.mutableConfigurationLocalCoreLibApiProvider.get(), this.observabilityManagerProvider.get());
    }
}
