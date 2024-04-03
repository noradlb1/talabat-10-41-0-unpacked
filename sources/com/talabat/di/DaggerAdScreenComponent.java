package com.talabat.di;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.adscreen.AdScreen;
import com.talabat.adscreen.AdScreen_MembersInjector;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.di.AdScreenComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerAdScreenComponent {

    public static final class AdScreenComponentImpl implements AdScreenComponent {
        private final AdScreenComponentImpl adScreenComponentImpl;
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;

        private AdScreenComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2) {
            this.adScreenComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private AdScreen injectAdScreen(AdScreen adScreen) {
            AdScreen_MembersInjector.injectConfigurationLocalRepository(adScreen, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            return adScreen;
        }

        public void inject(AdScreen adScreen) {
            injectAdScreen(adScreen);
        }
    }

    public static final class Factory implements AdScreenComponent.Factory {
        private Factory() {
        }

        public AdScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            return new AdScreenComponentImpl(configurationLocalCoreLibApi);
        }
    }

    private DaggerAdScreenComponent() {
    }

    public static AdScreenComponent.Factory factory() {
        return new Factory();
    }
}
