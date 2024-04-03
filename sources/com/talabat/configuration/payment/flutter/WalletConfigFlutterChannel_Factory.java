package com.talabat.configuration.payment.flutter;

import com.talabat.configuration.payment.PaymentConfigurationRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class WalletConfigFlutterChannel_Factory implements Factory<WalletConfigFlutterChannel> {
    private final Provider<PaymentConfigurationRepository> paymentConfigurationRepositoryProvider;
    private final Provider<WalletConfigFlutterEncoder> walletConfigFlutterEncoderProvider;

    public WalletConfigFlutterChannel_Factory(Provider<PaymentConfigurationRepository> provider, Provider<WalletConfigFlutterEncoder> provider2) {
        this.paymentConfigurationRepositoryProvider = provider;
        this.walletConfigFlutterEncoderProvider = provider2;
    }

    public static WalletConfigFlutterChannel_Factory create(Provider<PaymentConfigurationRepository> provider, Provider<WalletConfigFlutterEncoder> provider2) {
        return new WalletConfigFlutterChannel_Factory(provider, provider2);
    }

    public static WalletConfigFlutterChannel newInstance(PaymentConfigurationRepository paymentConfigurationRepository, WalletConfigFlutterEncoder walletConfigFlutterEncoder) {
        return new WalletConfigFlutterChannel(paymentConfigurationRepository, walletConfigFlutterEncoder);
    }

    public WalletConfigFlutterChannel get() {
        return newInstance(this.paymentConfigurationRepositoryProvider.get(), this.walletConfigFlutterEncoderProvider.get());
    }
}
