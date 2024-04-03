package com.talabat.di.rate;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.RateMyOrderScreen;
import com.talabat.RateMyOrderScreen_MembersInjector;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.di.rate.RateMyOrderScreenComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerRateMyOrderScreenComponent {

    public static final class Factory implements RateMyOrderScreenComponent.Factory {
        private Factory() {
        }

        public RateMyOrderScreenComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new RateMyOrderScreenComponentImpl(configurationRemoteCoreLibApi);
        }
    }

    public static final class RateMyOrderScreenComponentImpl implements RateMyOrderScreenComponent {
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final RateMyOrderScreenComponentImpl rateMyOrderScreenComponentImpl;

        private RateMyOrderScreenComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.rateMyOrderScreenComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private RateMyOrderScreen injectRateMyOrderScreen(RateMyOrderScreen rateMyOrderScreen) {
            RateMyOrderScreen_MembersInjector.injectAppVersionProvider(rateMyOrderScreen, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            return rateMyOrderScreen;
        }

        public void inject(RateMyOrderScreen rateMyOrderScreen) {
            injectRateMyOrderScreen(rateMyOrderScreen);
        }
    }

    private DaggerRateMyOrderScreenComponent() {
    }

    public static RateMyOrderScreenComponent.Factory factory() {
        return new Factory();
    }
}
