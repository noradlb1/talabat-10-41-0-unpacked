package com.talabat.di.home;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.HomeMapPlaceSearchScreen;
import com.talabat.HomeMapPlaceSearchScreen_MembersInjector;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.di.home.HomeMapPlaceSearchScreenComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerHomeMapPlaceSearchScreenComponent {

    public static final class Factory implements HomeMapPlaceSearchScreenComponent.Factory {
        private Factory() {
        }

        public HomeMapPlaceSearchScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new HomeMapPlaceSearchScreenComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi);
        }
    }

    public static final class HomeMapPlaceSearchScreenComponentImpl implements HomeMapPlaceSearchScreenComponent {
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final HomeMapPlaceSearchScreenComponentImpl homeMapPlaceSearchScreenComponentImpl;

        private HomeMapPlaceSearchScreenComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.homeMapPlaceSearchScreenComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private HomeMapPlaceSearchScreen injectHomeMapPlaceSearchScreen(HomeMapPlaceSearchScreen homeMapPlaceSearchScreen) {
            HomeMapPlaceSearchScreen_MembersInjector.injectAppVersionProvider(homeMapPlaceSearchScreen, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            HomeMapPlaceSearchScreen_MembersInjector.injectLocationConfigurationRepository(homeMapPlaceSearchScreen, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            return homeMapPlaceSearchScreen;
        }

        public void inject(HomeMapPlaceSearchScreen homeMapPlaceSearchScreen) {
            injectHomeMapPlaceSearchScreen(homeMapPlaceSearchScreen);
        }
    }

    private DaggerHomeMapPlaceSearchScreenComponent() {
    }

    public static HomeMapPlaceSearchScreenComponent.Factory factory() {
        return new Factory();
    }
}
