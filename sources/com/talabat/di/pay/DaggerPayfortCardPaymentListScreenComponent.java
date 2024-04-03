package com.talabat.di.pay;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.PayfortCardPaymentListScreen;
import com.talabat.PayfortCardPaymentListScreen_MembersInjector;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.di.pay.PayfortCardPaymentListScreenComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerPayfortCardPaymentListScreenComponent {

    public static final class Factory implements PayfortCardPaymentListScreenComponent.Factory {
        private Factory() {
        }

        public PayfortCardPaymentListScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new PayfortCardPaymentListScreenComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi);
        }
    }

    public static final class PayfortCardPaymentListScreenComponentImpl implements PayfortCardPaymentListScreenComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final PayfortCardPaymentListScreenComponentImpl payfortCardPaymentListScreenComponentImpl;

        private PayfortCardPaymentListScreenComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.payfortCardPaymentListScreenComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private PayfortCardPaymentListScreen injectPayfortCardPaymentListScreen(PayfortCardPaymentListScreen payfortCardPaymentListScreen) {
            PayfortCardPaymentListScreen_MembersInjector.injectAppVersionProvider(payfortCardPaymentListScreen, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            PayfortCardPaymentListScreen_MembersInjector.injectConfigurationLocalRepository(payfortCardPaymentListScreen, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            PayfortCardPaymentListScreen_MembersInjector.injectLocationConfigurationRepository(payfortCardPaymentListScreen, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            return payfortCardPaymentListScreen;
        }

        public void inject(PayfortCardPaymentListScreen payfortCardPaymentListScreen) {
            injectPayfortCardPaymentListScreen(payfortCardPaymentListScreen);
        }
    }

    private DaggerPayfortCardPaymentListScreenComponent() {
    }

    public static PayfortCardPaymentListScreenComponent.Factory factory() {
        return new Factory();
    }
}
