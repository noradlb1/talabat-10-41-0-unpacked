package com.talabat.feature.tokenization.data.baseurl;

import com.talabat.configuration.payment.PaymentConfigurationRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TokenizationBaseUrl_Factory implements Factory<TokenizationBaseUrl> {
    private final Provider<PaymentConfigurationRepository> paymentConfigurationRepositoryProvider;

    public TokenizationBaseUrl_Factory(Provider<PaymentConfigurationRepository> provider) {
        this.paymentConfigurationRepositoryProvider = provider;
    }

    public static TokenizationBaseUrl_Factory create(Provider<PaymentConfigurationRepository> provider) {
        return new TokenizationBaseUrl_Factory(provider);
    }

    public static TokenizationBaseUrl newInstance(PaymentConfigurationRepository paymentConfigurationRepository) {
        return new TokenizationBaseUrl(paymentConfigurationRepository);
    }

    public TokenizationBaseUrl get() {
        return newInstance(this.paymentConfigurationRepositoryProvider.get());
    }
}
