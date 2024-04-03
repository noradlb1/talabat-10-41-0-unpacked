package com.talabat;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class RestaurantMenuScreenR_MembersInjector implements MembersInjector<RestaurantMenuScreenR> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<PaymentConfigurationRepository> paymentConfigurationRepositoryProvider;
    private final Provider<ISubscriptionsFeatureFlagsRepository> subscriptionsFeatureFlagRepoProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public RestaurantMenuScreenR_MembersInjector(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<LocationConfigurationRepository> provider3, Provider<PaymentConfigurationRepository> provider4, Provider<ITalabatFeatureFlag> provider5, Provider<CustomerRepository> provider6, Provider<ISubscriptionsFeatureFlagsRepository> provider7) {
        this.appVersionProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
        this.locationConfigurationRepositoryProvider = provider3;
        this.paymentConfigurationRepositoryProvider = provider4;
        this.talabatFeatureFlagProvider = provider5;
        this.customerRepositoryProvider = provider6;
        this.subscriptionsFeatureFlagRepoProvider = provider7;
    }

    public static MembersInjector<RestaurantMenuScreenR> create(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<LocationConfigurationRepository> provider3, Provider<PaymentConfigurationRepository> provider4, Provider<ITalabatFeatureFlag> provider5, Provider<CustomerRepository> provider6, Provider<ISubscriptionsFeatureFlagsRepository> provider7) {
        return new RestaurantMenuScreenR_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.talabat.RestaurantMenuScreenR.appVersionProvider")
    public static void injectAppVersionProvider(RestaurantMenuScreenR restaurantMenuScreenR, AppVersionProvider appVersionProvider2) {
        restaurantMenuScreenR.f54963u = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.RestaurantMenuScreenR.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(RestaurantMenuScreenR restaurantMenuScreenR, ConfigurationLocalRepository configurationLocalRepository) {
        restaurantMenuScreenR.f54964v = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.RestaurantMenuScreenR.customerRepository")
    public static void injectCustomerRepository(RestaurantMenuScreenR restaurantMenuScreenR, CustomerRepository customerRepository) {
        restaurantMenuScreenR.f54968z = customerRepository;
    }

    @InjectedFieldSignature("com.talabat.RestaurantMenuScreenR.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(RestaurantMenuScreenR restaurantMenuScreenR, LocationConfigurationRepository locationConfigurationRepository) {
        restaurantMenuScreenR.f54965w = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.RestaurantMenuScreenR.paymentConfigurationRepository")
    public static void injectPaymentConfigurationRepository(RestaurantMenuScreenR restaurantMenuScreenR, PaymentConfigurationRepository paymentConfigurationRepository) {
        restaurantMenuScreenR.f54966x = paymentConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.RestaurantMenuScreenR.subscriptionsFeatureFlagRepo")
    public static void injectSubscriptionsFeatureFlagRepo(RestaurantMenuScreenR restaurantMenuScreenR, ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository) {
        restaurantMenuScreenR.A = iSubscriptionsFeatureFlagsRepository;
    }

    @InjectedFieldSignature("com.talabat.RestaurantMenuScreenR.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(RestaurantMenuScreenR restaurantMenuScreenR, ITalabatFeatureFlag iTalabatFeatureFlag) {
        restaurantMenuScreenR.f54967y = iTalabatFeatureFlag;
    }

    public void injectMembers(RestaurantMenuScreenR restaurantMenuScreenR) {
        injectAppVersionProvider(restaurantMenuScreenR, this.appVersionProvider.get());
        injectConfigurationLocalRepository(restaurantMenuScreenR, this.configurationLocalRepositoryProvider.get());
        injectLocationConfigurationRepository(restaurantMenuScreenR, this.locationConfigurationRepositoryProvider.get());
        injectPaymentConfigurationRepository(restaurantMenuScreenR, this.paymentConfigurationRepositoryProvider.get());
        injectTalabatFeatureFlag(restaurantMenuScreenR, this.talabatFeatureFlagProvider.get());
        injectCustomerRepository(restaurantMenuScreenR, this.customerRepositoryProvider.get());
        injectSubscriptionsFeatureFlagRepo(restaurantMenuScreenR, this.subscriptionsFeatureFlagRepoProvider.get());
    }
}
