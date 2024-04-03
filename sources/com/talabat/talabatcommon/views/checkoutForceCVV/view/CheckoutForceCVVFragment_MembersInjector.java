package com.talabat.talabatcommon.views.checkoutForceCVV.view;

import com.talabat.configuration.payment.PaymentConfigurationRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class CheckoutForceCVVFragment_MembersInjector implements MembersInjector<CheckoutForceCVVFragment> {
    private final Provider<PaymentConfigurationRepository> paymentConfigurationRepositoryProvider;

    public CheckoutForceCVVFragment_MembersInjector(Provider<PaymentConfigurationRepository> provider) {
        this.paymentConfigurationRepositoryProvider = provider;
    }

    public static MembersInjector<CheckoutForceCVVFragment> create(Provider<PaymentConfigurationRepository> provider) {
        return new CheckoutForceCVVFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.talabatcommon.views.checkoutForceCVV.view.CheckoutForceCVVFragment.paymentConfigurationRepository")
    public static void injectPaymentConfigurationRepository(CheckoutForceCVVFragment checkoutForceCVVFragment, PaymentConfigurationRepository paymentConfigurationRepository) {
        checkoutForceCVVFragment.paymentConfigurationRepository = paymentConfigurationRepository;
    }

    public void injectMembers(CheckoutForceCVVFragment checkoutForceCVVFragment) {
        injectPaymentConfigurationRepository(checkoutForceCVVFragment, this.paymentConfigurationRepositoryProvider.get());
    }
}
