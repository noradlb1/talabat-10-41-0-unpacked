package com.talabat;

import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class HomeMapPlaceSearchScreen_MembersInjector implements MembersInjector<HomeMapPlaceSearchScreen> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;

    public HomeMapPlaceSearchScreen_MembersInjector(Provider<AppVersionProvider> provider, Provider<LocationConfigurationRepository> provider2) {
        this.appVersionProvider = provider;
        this.locationConfigurationRepositoryProvider = provider2;
    }

    public static MembersInjector<HomeMapPlaceSearchScreen> create(Provider<AppVersionProvider> provider, Provider<LocationConfigurationRepository> provider2) {
        return new HomeMapPlaceSearchScreen_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.HomeMapPlaceSearchScreen.appVersionProvider")
    public static void injectAppVersionProvider(HomeMapPlaceSearchScreen homeMapPlaceSearchScreen, AppVersionProvider appVersionProvider2) {
        homeMapPlaceSearchScreen.appVersionProvider = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.HomeMapPlaceSearchScreen.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(HomeMapPlaceSearchScreen homeMapPlaceSearchScreen, LocationConfigurationRepository locationConfigurationRepository) {
        homeMapPlaceSearchScreen.locationConfigurationRepository = locationConfigurationRepository;
    }

    public void injectMembers(HomeMapPlaceSearchScreen homeMapPlaceSearchScreen) {
        injectAppVersionProvider(homeMapPlaceSearchScreen, this.appVersionProvider.get());
        injectLocationConfigurationRepository(homeMapPlaceSearchScreen, this.locationConfigurationRepositoryProvider.get());
    }
}
