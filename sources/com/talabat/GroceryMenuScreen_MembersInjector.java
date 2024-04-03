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
public final class GroceryMenuScreen_MembersInjector implements MembersInjector<GroceryMenuScreen> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<PaymentConfigurationRepository> paymentConfigurationRepositoryProvider;
    private final Provider<ISubscriptionsFeatureFlagsRepository> subscriptionsFeatureFlagRepoProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public GroceryMenuScreen_MembersInjector(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<LocationConfigurationRepository> provider3, Provider<PaymentConfigurationRepository> provider4, Provider<ITalabatFeatureFlag> provider5, Provider<CustomerRepository> provider6, Provider<ISubscriptionsFeatureFlagsRepository> provider7) {
        this.appVersionProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
        this.locationConfigurationRepositoryProvider = provider3;
        this.paymentConfigurationRepositoryProvider = provider4;
        this.talabatFeatureFlagProvider = provider5;
        this.customerRepositoryProvider = provider6;
        this.subscriptionsFeatureFlagRepoProvider = provider7;
    }

    public static MembersInjector<GroceryMenuScreen> create(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<LocationConfigurationRepository> provider3, Provider<PaymentConfigurationRepository> provider4, Provider<ITalabatFeatureFlag> provider5, Provider<CustomerRepository> provider6, Provider<ISubscriptionsFeatureFlagsRepository> provider7) {
        return new GroceryMenuScreen_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.talabat.GroceryMenuScreen.appVersionProvider")
    public static void injectAppVersionProvider(GroceryMenuScreen groceryMenuScreen, AppVersionProvider appVersionProvider2) {
        groceryMenuScreen.f54127w = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.GroceryMenuScreen.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(GroceryMenuScreen groceryMenuScreen, ConfigurationLocalRepository configurationLocalRepository) {
        groceryMenuScreen.f54128x = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.GroceryMenuScreen.customerRepository")
    public static void injectCustomerRepository(GroceryMenuScreen groceryMenuScreen, CustomerRepository customerRepository) {
        groceryMenuScreen.B = customerRepository;
    }

    @InjectedFieldSignature("com.talabat.GroceryMenuScreen.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(GroceryMenuScreen groceryMenuScreen, LocationConfigurationRepository locationConfigurationRepository) {
        groceryMenuScreen.f54129y = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.GroceryMenuScreen.paymentConfigurationRepository")
    public static void injectPaymentConfigurationRepository(GroceryMenuScreen groceryMenuScreen, PaymentConfigurationRepository paymentConfigurationRepository) {
        groceryMenuScreen.f54130z = paymentConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.GroceryMenuScreen.subscriptionsFeatureFlagRepo")
    public static void injectSubscriptionsFeatureFlagRepo(GroceryMenuScreen groceryMenuScreen, ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository) {
        groceryMenuScreen.C = iSubscriptionsFeatureFlagsRepository;
    }

    @InjectedFieldSignature("com.talabat.GroceryMenuScreen.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(GroceryMenuScreen groceryMenuScreen, ITalabatFeatureFlag iTalabatFeatureFlag) {
        groceryMenuScreen.A = iTalabatFeatureFlag;
    }

    public void injectMembers(GroceryMenuScreen groceryMenuScreen) {
        injectAppVersionProvider(groceryMenuScreen, this.appVersionProvider.get());
        injectConfigurationLocalRepository(groceryMenuScreen, this.configurationLocalRepositoryProvider.get());
        injectLocationConfigurationRepository(groceryMenuScreen, this.locationConfigurationRepositoryProvider.get());
        injectPaymentConfigurationRepository(groceryMenuScreen, this.paymentConfigurationRepositoryProvider.get());
        injectTalabatFeatureFlag(groceryMenuScreen, this.talabatFeatureFlagProvider.get());
        injectCustomerRepository(groceryMenuScreen, this.customerRepositoryProvider.get());
        injectSubscriptionsFeatureFlagRepo(groceryMenuScreen, this.subscriptionsFeatureFlagRepoProvider.get());
    }
}
