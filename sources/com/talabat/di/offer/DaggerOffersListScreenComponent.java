package com.talabat.di.offer;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.OffersListScreen;
import com.talabat.OffersListScreen_MembersInjector;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.di.offer.OffersListScreenComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerOffersListScreenComponent {

    public static final class Factory implements OffersListScreenComponent.Factory {
        private Factory() {
        }

        public OffersListScreenComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new OffersListScreenComponentImpl(configurationRemoteCoreLibApi);
        }
    }

    public static final class OffersListScreenComponentImpl implements OffersListScreenComponent {
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final OffersListScreenComponentImpl offersListScreenComponentImpl;

        private OffersListScreenComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.offersListScreenComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private OffersListScreen injectOffersListScreen(OffersListScreen offersListScreen) {
            OffersListScreen_MembersInjector.injectAppVersionProvider(offersListScreen, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            return offersListScreen;
        }

        public void inject(OffersListScreen offersListScreen) {
            injectOffersListScreen(offersListScreen);
        }
    }

    private DaggerOffersListScreenComponent() {
    }

    public static OffersListScreenComponent.Factory factory() {
        return new Factory();
    }
}
