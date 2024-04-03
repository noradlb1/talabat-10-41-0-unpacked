package com.talabat.di.checkout;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.Adyen.AdyenCheckoutScreen;
import com.talabat.Adyen.AdyenCheckoutScreen_MembersInjector;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.discovery.DiscoveryConfigurationRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.di.checkout.CheckoutAdyenScreenComponent;
import com.talabat.feature.tokenization.data.mapper.NonEnglishNumbersMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerCheckoutAdyenScreenComponent {

    public static final class CheckoutAdyenScreenComponentImpl implements CheckoutAdyenScreenComponent {
        private final CheckoutAdyenScreenComponentImpl checkoutAdyenScreenComponentImpl;
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;

        private CheckoutAdyenScreenComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.checkoutAdyenScreenComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private AdyenCheckoutScreen injectAdyenCheckoutScreen(AdyenCheckoutScreen adyenCheckoutScreen) {
            AdyenCheckoutScreen_MembersInjector.injectAppVersionProvider(adyenCheckoutScreen, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            AdyenCheckoutScreen_MembersInjector.injectConfigurationLocalRepository(adyenCheckoutScreen, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            AdyenCheckoutScreen_MembersInjector.injectDiscoveryConfigurationRepository(adyenCheckoutScreen, (DiscoveryConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getDiscoveryConfigurationRepository()));
            AdyenCheckoutScreen_MembersInjector.injectLocationConfigurationRepository(adyenCheckoutScreen, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            AdyenCheckoutScreen_MembersInjector.injectPaymentConfigurationRepository(adyenCheckoutScreen, (PaymentConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getPaymentConfigurationRepository()));
            AdyenCheckoutScreen_MembersInjector.injectTermsAndConditionsConfigurationRepository(adyenCheckoutScreen, (TermsAndConditionsConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getTermsAndConditionsConfigurationRepository()));
            AdyenCheckoutScreen_MembersInjector.injectNonEnglishNumbersMapper(adyenCheckoutScreen, new NonEnglishNumbersMapper());
            return adyenCheckoutScreen;
        }

        public void inject(AdyenCheckoutScreen adyenCheckoutScreen) {
            injectAdyenCheckoutScreen(adyenCheckoutScreen);
        }
    }

    public static final class Factory implements CheckoutAdyenScreenComponent.Factory {
        private Factory() {
        }

        public CheckoutAdyenScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new CheckoutAdyenScreenComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi);
        }
    }

    private DaggerCheckoutAdyenScreenComponent() {
    }

    public static CheckoutAdyenScreenComponent.Factory factory() {
        return new Factory();
    }
}
