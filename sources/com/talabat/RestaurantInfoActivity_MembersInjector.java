package com.talabat;

import com.talabat.configuration.payment.PaymentConfigurationRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class RestaurantInfoActivity_MembersInjector implements MembersInjector<RestaurantInfoActivity> {
    private final Provider<PaymentConfigurationRepository> paymentConfigurationRepositoryProvider;

    public RestaurantInfoActivity_MembersInjector(Provider<PaymentConfigurationRepository> provider) {
        this.paymentConfigurationRepositoryProvider = provider;
    }

    public static MembersInjector<RestaurantInfoActivity> create(Provider<PaymentConfigurationRepository> provider) {
        return new RestaurantInfoActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.RestaurantInfoActivity.paymentConfigurationRepository")
    public static void injectPaymentConfigurationRepository(RestaurantInfoActivity restaurantInfoActivity, PaymentConfigurationRepository paymentConfigurationRepository) {
        restaurantInfoActivity.f54947l = paymentConfigurationRepository;
    }

    public void injectMembers(RestaurantInfoActivity restaurantInfoActivity) {
        injectPaymentConfigurationRepository(restaurantInfoActivity, this.paymentConfigurationRepositoryProvider.get());
    }
}
