package com.talabat.splash.data.repositories;

import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.discovery.DiscoveryConfigurationRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.splash.core.platform.NetworkHandler;
import com.talabat.splash.data.preferences.AppInfoLocalDataSource;
import com.talabat.splash.data.preferences.SplashPreferences;
import com.talabat.splash.domain.model.AppInfoGlobalConstantsWrapper;
import com.talabat.splash.domain.model.AppInfoGlobalCountryWrapper;
import com.talabat.splash.domain.model.AppInfoGlobalCustomerWrapper;
import com.talabat.splash.domain.model.AppInfoResponseMapper;
import com.talabat.splash.network.SplashServices;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AppInfoRepositoryImpl_Factory implements Factory<AppInfoRepositoryImpl> {
    private final Provider<AppInfoGlobalConstantsWrapper> appInfoGlobalConstantsWrapperProvider;
    private final Provider<AppInfoGlobalCountryWrapper> appInfoGlobalCountryWrapperProvider;
    private final Provider<AppInfoGlobalCustomerWrapper> appInfoGlobalCustomerWrapperProvider;
    private final Provider<AppInfoLocalDataSource> appInfoLocalDataSourceProvider;
    private final Provider<DiscoveryConfigurationRepository> discoveryConfigurationRepositoryProvider;
    private final Provider<CoroutineDispatcher> dispatcherIOProvider;
    private final Provider<LocationConfigurationRepository> locationConfigRepositoryProvider;
    private final Provider<AppInfoResponseMapper> mapperProvider;
    private final Provider<MutableLocationConfigurationRepository> mutableLocationConfigurationRepositoryProvider;
    private final Provider<NetworkHandler> networkHandlerProvider;
    private final Provider<SplashServices> serviceProvider;
    private final Provider<SplashPreferences> splashPreferencesProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public AppInfoRepositoryImpl_Factory(Provider<NetworkHandler> provider, Provider<SplashServices> provider2, Provider<SplashPreferences> provider3, Provider<AppInfoLocalDataSource> provider4, Provider<AppInfoGlobalConstantsWrapper> provider5, Provider<AppInfoGlobalCountryWrapper> provider6, Provider<AppInfoGlobalCustomerWrapper> provider7, Provider<DiscoveryConfigurationRepository> provider8, Provider<LocationConfigurationRepository> provider9, Provider<CoroutineDispatcher> provider10, Provider<AppInfoResponseMapper> provider11, Provider<ITalabatFeatureFlag> provider12, Provider<MutableLocationConfigurationRepository> provider13) {
        this.networkHandlerProvider = provider;
        this.serviceProvider = provider2;
        this.splashPreferencesProvider = provider3;
        this.appInfoLocalDataSourceProvider = provider4;
        this.appInfoGlobalConstantsWrapperProvider = provider5;
        this.appInfoGlobalCountryWrapperProvider = provider6;
        this.appInfoGlobalCustomerWrapperProvider = provider7;
        this.discoveryConfigurationRepositoryProvider = provider8;
        this.locationConfigRepositoryProvider = provider9;
        this.dispatcherIOProvider = provider10;
        this.mapperProvider = provider11;
        this.talabatFeatureFlagProvider = provider12;
        this.mutableLocationConfigurationRepositoryProvider = provider13;
    }

    public static AppInfoRepositoryImpl_Factory create(Provider<NetworkHandler> provider, Provider<SplashServices> provider2, Provider<SplashPreferences> provider3, Provider<AppInfoLocalDataSource> provider4, Provider<AppInfoGlobalConstantsWrapper> provider5, Provider<AppInfoGlobalCountryWrapper> provider6, Provider<AppInfoGlobalCustomerWrapper> provider7, Provider<DiscoveryConfigurationRepository> provider8, Provider<LocationConfigurationRepository> provider9, Provider<CoroutineDispatcher> provider10, Provider<AppInfoResponseMapper> provider11, Provider<ITalabatFeatureFlag> provider12, Provider<MutableLocationConfigurationRepository> provider13) {
        return new AppInfoRepositoryImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    public static AppInfoRepositoryImpl newInstance(NetworkHandler networkHandler, SplashServices splashServices, SplashPreferences splashPreferences, AppInfoLocalDataSource appInfoLocalDataSource, AppInfoGlobalConstantsWrapper appInfoGlobalConstantsWrapper, AppInfoGlobalCountryWrapper appInfoGlobalCountryWrapper, AppInfoGlobalCustomerWrapper appInfoGlobalCustomerWrapper, DiscoveryConfigurationRepository discoveryConfigurationRepository, LocationConfigurationRepository locationConfigurationRepository, CoroutineDispatcher coroutineDispatcher, AppInfoResponseMapper appInfoResponseMapper, ITalabatFeatureFlag iTalabatFeatureFlag, MutableLocationConfigurationRepository mutableLocationConfigurationRepository) {
        return new AppInfoRepositoryImpl(networkHandler, splashServices, splashPreferences, appInfoLocalDataSource, appInfoGlobalConstantsWrapper, appInfoGlobalCountryWrapper, appInfoGlobalCustomerWrapper, discoveryConfigurationRepository, locationConfigurationRepository, coroutineDispatcher, appInfoResponseMapper, iTalabatFeatureFlag, mutableLocationConfigurationRepository);
    }

    public AppInfoRepositoryImpl get() {
        return newInstance(this.networkHandlerProvider.get(), this.serviceProvider.get(), this.splashPreferencesProvider.get(), this.appInfoLocalDataSourceProvider.get(), this.appInfoGlobalConstantsWrapperProvider.get(), this.appInfoGlobalCountryWrapperProvider.get(), this.appInfoGlobalCustomerWrapperProvider.get(), this.discoveryConfigurationRepositoryProvider.get(), this.locationConfigRepositoryProvider.get(), this.dispatcherIOProvider.get(), this.mapperProvider.get(), this.talabatFeatureFlagProvider.get(), this.mutableLocationConfigurationRepositoryProvider.get());
    }
}
