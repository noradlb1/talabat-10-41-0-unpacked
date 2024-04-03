package com.talabat.di.choose;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.ChooseCityScreen;
import com.talabat.ChooseCityScreen_MembersInjector;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.di.choose.ChooseCityScreenComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerChooseCityScreenComponent {

    public static final class ChooseCityScreenComponentImpl implements ChooseCityScreenComponent {
        private final ChooseCityScreenComponentImpl chooseCityScreenComponentImpl;
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;

        private ChooseCityScreenComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.chooseCityScreenComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private ChooseCityScreen injectChooseCityScreen(ChooseCityScreen chooseCityScreen) {
            ChooseCityScreen_MembersInjector.injectConfigurationLocalRepository(chooseCityScreen, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            ChooseCityScreen_MembersInjector.injectLocationConfigurationRepository(chooseCityScreen, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            return chooseCityScreen;
        }

        public void inject(ChooseCityScreen chooseCityScreen) {
            injectChooseCityScreen(chooseCityScreen);
        }
    }

    public static final class Factory implements ChooseCityScreenComponent.Factory {
        private Factory() {
        }

        public ChooseCityScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new ChooseCityScreenComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi);
        }
    }

    private DaggerChooseCityScreenComponent() {
    }

    public static ChooseCityScreenComponent.Factory factory() {
        return new Factory();
    }
}
