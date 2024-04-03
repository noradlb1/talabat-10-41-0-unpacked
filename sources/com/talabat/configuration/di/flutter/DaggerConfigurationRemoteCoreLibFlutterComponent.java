package com.talabat.configuration.di.flutter;

import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.di.flutter.ConfigurationRemoteCoreLibFlutterComponent;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.configuration.payment.flutter.TokenizedBankCardFlutterEncoder;
import com.talabat.configuration.payment.flutter.TokenizedBankCardFlutterEncoder_Factory;
import com.talabat.configuration.payment.flutter.WalletConfigFlutterChannel;
import com.talabat.configuration.payment.flutter.WalletConfigFlutterChannel_Factory;
import com.talabat.configuration.payment.flutter.WalletConfigFlutterEncoder;
import com.talabat.configuration.payment.flutter.WalletConfigFlutterEncoder_Factory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import io.flutter.plugin.common.MethodChannel;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerConfigurationRemoteCoreLibFlutterComponent {

    public static final class ConfigurationRemoteCoreLibFlutterComponentImpl implements ConfigurationRemoteCoreLibFlutterComponent {
        private final ConfigurationRemoteCoreLibFlutterComponentImpl configurationRemoteCoreLibFlutterComponentImpl;
        private Provider<PaymentConfigurationRepository> getPaymentConfigurationRepositoryProvider;
        private Provider<TokenizedBankCardFlutterEncoder> tokenizedBankCardFlutterEncoderProvider;
        private Provider<WalletConfigFlutterChannel> walletConfigFlutterChannelProvider;
        private Provider<WalletConfigFlutterEncoder> walletConfigFlutterEncoderProvider;

        public static final class GetPaymentConfigurationRepositoryProvider implements Provider<PaymentConfigurationRepository> {
            private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;

            public GetPaymentConfigurationRepositoryProvider(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
                this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            }

            public PaymentConfigurationRepository get() {
                return (PaymentConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getPaymentConfigurationRepository());
            }
        }

        private ConfigurationRemoteCoreLibFlutterComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            this.configurationRemoteCoreLibFlutterComponentImpl = this;
            initialize(configurationRemoteCoreLibApi);
        }

        private void initialize(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            this.getPaymentConfigurationRepositoryProvider = new GetPaymentConfigurationRepositoryProvider(configurationRemoteCoreLibApi);
            Provider<TokenizedBankCardFlutterEncoder> provider = SingleCheck.provider(TokenizedBankCardFlutterEncoder_Factory.create());
            this.tokenizedBankCardFlutterEncoderProvider = provider;
            Provider<WalletConfigFlutterEncoder> provider2 = SingleCheck.provider(WalletConfigFlutterEncoder_Factory.create(provider));
            this.walletConfigFlutterEncoderProvider = provider2;
            this.walletConfigFlutterChannelProvider = SingleCheck.provider(WalletConfigFlutterChannel_Factory.create(this.getPaymentConfigurationRepositoryProvider, provider2));
        }

        public MethodChannel.MethodCallHandler getWalletConfigFlutterChannel() {
            return this.walletConfigFlutterChannelProvider.get();
        }
    }

    public static final class Factory implements ConfigurationRemoteCoreLibFlutterComponent.Factory {
        private Factory() {
        }

        public ConfigurationRemoteCoreLibFlutterComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new ConfigurationRemoteCoreLibFlutterComponentImpl(configurationRemoteCoreLibApi);
        }
    }

    private DaggerConfigurationRemoteCoreLibFlutterComponent() {
    }

    public static ConfigurationRemoteCoreLibFlutterComponent.Factory factory() {
        return new Factory();
    }
}
