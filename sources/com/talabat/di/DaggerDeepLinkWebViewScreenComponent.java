package com.talabat.di;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.DeepLinkWebViewScreen;
import com.talabat.DeepLinkWebViewScreen_MembersInjector;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.di.DeepLinkWebViewScreenComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerDeepLinkWebViewScreenComponent {

    public static final class DeepLinkWebViewScreenComponentImpl implements DeepLinkWebViewScreenComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final DeepLinkWebViewScreenComponentImpl deepLinkWebViewScreenComponentImpl;

        private DeepLinkWebViewScreenComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2) {
            this.deepLinkWebViewScreenComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private DeepLinkWebViewScreen injectDeepLinkWebViewScreen(DeepLinkWebViewScreen deepLinkWebViewScreen) {
            DeepLinkWebViewScreen_MembersInjector.injectConfigurationLocalRepository(deepLinkWebViewScreen, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            return deepLinkWebViewScreen;
        }

        public void inject(DeepLinkWebViewScreen deepLinkWebViewScreen) {
            injectDeepLinkWebViewScreen(deepLinkWebViewScreen);
        }
    }

    public static final class Factory implements DeepLinkWebViewScreenComponent.Factory {
        private Factory() {
        }

        public DeepLinkWebViewScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            return new DeepLinkWebViewScreenComponentImpl(configurationLocalCoreLibApi);
        }
    }

    private DaggerDeepLinkWebViewScreenComponent() {
    }

    public static DeepLinkWebViewScreenComponent.Factory factory() {
        return new Factory();
    }
}
