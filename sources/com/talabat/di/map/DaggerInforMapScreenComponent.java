package com.talabat.di.map;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.InforMapScreen;
import com.talabat.InforMapScreen_MembersInjector;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.di.map.InforMapScreenComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerInforMapScreenComponent {

    public static final class Factory implements InforMapScreenComponent.Factory {
        private Factory() {
        }

        public InforMapScreenComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new InforMapScreenComponentImpl(configurationRemoteCoreLibApi);
        }
    }

    public static final class InforMapScreenComponentImpl implements InforMapScreenComponent {
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final InforMapScreenComponentImpl inforMapScreenComponentImpl;

        private InforMapScreenComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.inforMapScreenComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private InforMapScreen injectInforMapScreen(InforMapScreen inforMapScreen) {
            InforMapScreen_MembersInjector.injectAppVersionProvider(inforMapScreen, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            InforMapScreen_MembersInjector.injectLocationConfigRepository(inforMapScreen, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            return inforMapScreen;
        }

        public void inject(InforMapScreen inforMapScreen) {
            injectInforMapScreen(inforMapScreen);
        }
    }

    private DaggerInforMapScreenComponent() {
    }

    public static InforMapScreenComponent.Factory factory() {
        return new Factory();
    }
}
