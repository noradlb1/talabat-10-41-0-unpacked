package com.talabat.configuration.payment;

import com.talabat.configuration.AppInfoContainer;
import com.talabat.configuration.payment.mapper.PaymentConfigMapper;
import com.talabat.configuration.payment.mapper.WalletConfigMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class RealPaymentConfigurationRepository_Factory implements Factory<RealPaymentConfigurationRepository> {
    private final Provider<AppInfoContainer> appInfoContainerProvider;
    private final Provider<PaymentConfigMapper> mapperProvider;
    private final Provider<WalletConfigMapper> walletMapperProvider;

    public RealPaymentConfigurationRepository_Factory(Provider<AppInfoContainer> provider, Provider<PaymentConfigMapper> provider2, Provider<WalletConfigMapper> provider3) {
        this.appInfoContainerProvider = provider;
        this.mapperProvider = provider2;
        this.walletMapperProvider = provider3;
    }

    public static RealPaymentConfigurationRepository_Factory create(Provider<AppInfoContainer> provider, Provider<PaymentConfigMapper> provider2, Provider<WalletConfigMapper> provider3) {
        return new RealPaymentConfigurationRepository_Factory(provider, provider2, provider3);
    }

    public static RealPaymentConfigurationRepository newInstance(AppInfoContainer appInfoContainer, PaymentConfigMapper paymentConfigMapper, WalletConfigMapper walletConfigMapper) {
        return new RealPaymentConfigurationRepository(appInfoContainer, paymentConfigMapper, walletConfigMapper);
    }

    public RealPaymentConfigurationRepository get() {
        return newInstance(this.appInfoContainerProvider.get(), this.mapperProvider.get(), this.walletMapperProvider.get());
    }
}
