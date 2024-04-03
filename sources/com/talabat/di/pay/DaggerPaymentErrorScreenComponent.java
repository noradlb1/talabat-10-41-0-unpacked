package com.talabat.di.pay;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.PaymentErrorScreen;
import com.talabat.PaymentErrorScreen_MembersInjector;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.di.pay.PaymentErrorScreenComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerPaymentErrorScreenComponent {

    public static final class Factory implements PaymentErrorScreenComponent.Factory {
        private Factory() {
        }

        public PaymentErrorScreenComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new PaymentErrorScreenComponentImpl(configurationRemoteCoreLibApi);
        }
    }

    public static final class PaymentErrorScreenComponentImpl implements PaymentErrorScreenComponent {
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final PaymentErrorScreenComponentImpl paymentErrorScreenComponentImpl;

        private PaymentErrorScreenComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.paymentErrorScreenComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private PaymentErrorScreen injectPaymentErrorScreen(PaymentErrorScreen paymentErrorScreen) {
            PaymentErrorScreen_MembersInjector.injectAppVersionProvider(paymentErrorScreen, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            return paymentErrorScreen;
        }

        public void inject(PaymentErrorScreen paymentErrorScreen) {
            injectPaymentErrorScreen(paymentErrorScreen);
        }
    }

    private DaggerPaymentErrorScreenComponent() {
    }

    public static PaymentErrorScreenComponent.Factory factory() {
        return new Factory();
    }
}
