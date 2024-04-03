package com.talabat.talabatcommon.views.checkoutForceCVV.di;

import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.talabatcommon.views.checkoutForceCVV.di.CheckoutForceCVVFragmentComponent;
import com.talabat.talabatcommon.views.checkoutForceCVV.view.CheckoutForceCVVFragment;
import com.talabat.talabatcommon.views.checkoutForceCVV.view.CheckoutForceCVVFragment_MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerCheckoutForceCVVFragmentComponent {

    public static final class CheckoutForceCVVFragmentComponentImpl implements CheckoutForceCVVFragmentComponent {
        private final CheckoutForceCVVFragmentComponentImpl checkoutForceCVVFragmentComponentImpl;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;

        private CheckoutForceCVVFragmentComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.checkoutForceCVVFragmentComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        private CheckoutForceCVVFragment injectCheckoutForceCVVFragment(CheckoutForceCVVFragment checkoutForceCVVFragment) {
            CheckoutForceCVVFragment_MembersInjector.injectPaymentConfigurationRepository(checkoutForceCVVFragment, (PaymentConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getPaymentConfigurationRepository()));
            return checkoutForceCVVFragment;
        }

        public void inject(CheckoutForceCVVFragment checkoutForceCVVFragment) {
            injectCheckoutForceCVVFragment(checkoutForceCVVFragment);
        }
    }

    public static final class Factory implements CheckoutForceCVVFragmentComponent.Factory {
        private Factory() {
        }

        public CheckoutForceCVVFragmentComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new CheckoutForceCVVFragmentComponentImpl(configurationRemoteCoreLibApi);
        }
    }

    private DaggerCheckoutForceCVVFragmentComponent() {
    }

    public static CheckoutForceCVVFragmentComponent.Factory factory() {
        return new Factory();
    }
}
