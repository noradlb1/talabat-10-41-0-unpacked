package com.talabat.di.order;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.PlacesSearchScreen;
import com.talabat.PlacesSearchScreen_MembersInjector;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.di.order.PlacesSearchScreenComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerPlacesSearchScreenComponent {

    public static final class Factory implements PlacesSearchScreenComponent.Factory {
        private Factory() {
        }

        public PlacesSearchScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new PlacesSearchScreenComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi);
        }
    }

    public static final class PlacesSearchScreenComponentImpl implements PlacesSearchScreenComponent {
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final PlacesSearchScreenComponentImpl placesSearchScreenComponentImpl;

        private PlacesSearchScreenComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.placesSearchScreenComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private PlacesSearchScreen injectPlacesSearchScreen(PlacesSearchScreen placesSearchScreen) {
            PlacesSearchScreen_MembersInjector.injectAppVersionProvider(placesSearchScreen, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            return placesSearchScreen;
        }

        public void inject(PlacesSearchScreen placesSearchScreen) {
            injectPlacesSearchScreen(placesSearchScreen);
        }
    }

    private DaggerPlacesSearchScreenComponent() {
    }

    public static PlacesSearchScreenComponent.Factory factory() {
        return new Factory();
    }
}
