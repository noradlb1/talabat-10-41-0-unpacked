package com.talabat;

import com.squareup.moshi.Moshi;
import com.talabat.configuration.di.MutableConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class ChooseSavedAddressScreen_MembersInjector implements MembersInjector<ChooseSavedAddressScreen> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<DeepLinkNavigator> deepLinkNavigatorProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<MutableConfigurationLocalCoreLibApi> mutableConfigurationLocalCoreLibApiProvider;
    private final Provider<MutableConfigurationRemoteCoreLibApi> mutableConfigurationRemoteCoreLibApiProvider;
    private final Provider<Navigator> navigatorProvider;
    private final Provider<PaymentConfigurationRepository> paymentConfigurationRepositoryProvider;
    private final Provider<SubscriptionsFeatureApi> subscriptionsFeatureApiProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public ChooseSavedAddressScreen_MembersInjector(Provider<AppVersionProvider> provider, Provider<LocationConfigurationRepository> provider2, Provider<MutableConfigurationLocalCoreLibApi> provider3, Provider<MutableConfigurationRemoteCoreLibApi> provider4, Provider<PaymentConfigurationRepository> provider5, Provider<Moshi> provider6, Provider<SubscriptionsFeatureApi> provider7, Provider<ITalabatFeatureFlag> provider8, Provider<CustomerRepository> provider9, Provider<DeepLinkNavigator> provider10, Provider<Navigator> provider11) {
        this.appVersionProvider = provider;
        this.locationConfigurationRepositoryProvider = provider2;
        this.mutableConfigurationLocalCoreLibApiProvider = provider3;
        this.mutableConfigurationRemoteCoreLibApiProvider = provider4;
        this.paymentConfigurationRepositoryProvider = provider5;
        this.moshiProvider = provider6;
        this.subscriptionsFeatureApiProvider = provider7;
        this.talabatFeatureFlagProvider = provider8;
        this.customerRepositoryProvider = provider9;
        this.deepLinkNavigatorProvider = provider10;
        this.navigatorProvider = provider11;
    }

    public static MembersInjector<ChooseSavedAddressScreen> create(Provider<AppVersionProvider> provider, Provider<LocationConfigurationRepository> provider2, Provider<MutableConfigurationLocalCoreLibApi> provider3, Provider<MutableConfigurationRemoteCoreLibApi> provider4, Provider<PaymentConfigurationRepository> provider5, Provider<Moshi> provider6, Provider<SubscriptionsFeatureApi> provider7, Provider<ITalabatFeatureFlag> provider8, Provider<CustomerRepository> provider9, Provider<DeepLinkNavigator> provider10, Provider<Navigator> provider11) {
        return new ChooseSavedAddressScreen_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    @InjectedFieldSignature("com.talabat.ChooseSavedAddressScreen.appVersionProvider")
    public static void injectAppVersionProvider(ChooseSavedAddressScreen chooseSavedAddressScreen, AppVersionProvider appVersionProvider2) {
        chooseSavedAddressScreen.appVersionProvider = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.ChooseSavedAddressScreen.customerRepository")
    public static void injectCustomerRepository(ChooseSavedAddressScreen chooseSavedAddressScreen, CustomerRepository customerRepository) {
        chooseSavedAddressScreen.customerRepository = customerRepository;
    }

    @InjectedFieldSignature("com.talabat.ChooseSavedAddressScreen.deepLinkNavigator")
    public static void injectDeepLinkNavigator(ChooseSavedAddressScreen chooseSavedAddressScreen, DeepLinkNavigator deepLinkNavigator) {
        chooseSavedAddressScreen.deepLinkNavigator = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.ChooseSavedAddressScreen.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(ChooseSavedAddressScreen chooseSavedAddressScreen, LocationConfigurationRepository locationConfigurationRepository) {
        chooseSavedAddressScreen.locationConfigurationRepository = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.ChooseSavedAddressScreen.moshi")
    public static void injectMoshi(ChooseSavedAddressScreen chooseSavedAddressScreen, Moshi moshi) {
        chooseSavedAddressScreen.moshi = moshi;
    }

    @InjectedFieldSignature("com.talabat.ChooseSavedAddressScreen.mutableConfigurationLocalCoreLibApi")
    public static void injectMutableConfigurationLocalCoreLibApi(ChooseSavedAddressScreen chooseSavedAddressScreen, MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi) {
        chooseSavedAddressScreen.mutableConfigurationLocalCoreLibApi = mutableConfigurationLocalCoreLibApi;
    }

    @InjectedFieldSignature("com.talabat.ChooseSavedAddressScreen.mutableConfigurationRemoteCoreLibApi")
    public static void injectMutableConfigurationRemoteCoreLibApi(ChooseSavedAddressScreen chooseSavedAddressScreen, MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi) {
        chooseSavedAddressScreen.mutableConfigurationRemoteCoreLibApi = mutableConfigurationRemoteCoreLibApi;
    }

    @InjectedFieldSignature("com.talabat.ChooseSavedAddressScreen.navigator")
    public static void injectNavigator(ChooseSavedAddressScreen chooseSavedAddressScreen, Navigator navigator) {
        chooseSavedAddressScreen.navigator = navigator;
    }

    @InjectedFieldSignature("com.talabat.ChooseSavedAddressScreen.paymentConfigurationRepository")
    public static void injectPaymentConfigurationRepository(ChooseSavedAddressScreen chooseSavedAddressScreen, PaymentConfigurationRepository paymentConfigurationRepository) {
        chooseSavedAddressScreen.paymentConfigurationRepository = paymentConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.ChooseSavedAddressScreen.subscriptionsFeatureApi")
    public static void injectSubscriptionsFeatureApi(ChooseSavedAddressScreen chooseSavedAddressScreen, SubscriptionsFeatureApi subscriptionsFeatureApi) {
        chooseSavedAddressScreen.subscriptionsFeatureApi = subscriptionsFeatureApi;
    }

    @InjectedFieldSignature("com.talabat.ChooseSavedAddressScreen.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(ChooseSavedAddressScreen chooseSavedAddressScreen, ITalabatFeatureFlag iTalabatFeatureFlag) {
        chooseSavedAddressScreen.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public void injectMembers(ChooseSavedAddressScreen chooseSavedAddressScreen) {
        injectAppVersionProvider(chooseSavedAddressScreen, this.appVersionProvider.get());
        injectLocationConfigurationRepository(chooseSavedAddressScreen, this.locationConfigurationRepositoryProvider.get());
        injectMutableConfigurationLocalCoreLibApi(chooseSavedAddressScreen, this.mutableConfigurationLocalCoreLibApiProvider.get());
        injectMutableConfigurationRemoteCoreLibApi(chooseSavedAddressScreen, this.mutableConfigurationRemoteCoreLibApiProvider.get());
        injectPaymentConfigurationRepository(chooseSavedAddressScreen, this.paymentConfigurationRepositoryProvider.get());
        injectMoshi(chooseSavedAddressScreen, this.moshiProvider.get());
        injectSubscriptionsFeatureApi(chooseSavedAddressScreen, this.subscriptionsFeatureApiProvider.get());
        injectTalabatFeatureFlag(chooseSavedAddressScreen, this.talabatFeatureFlagProvider.get());
        injectCustomerRepository(chooseSavedAddressScreen, this.customerRepositoryProvider.get());
        injectDeepLinkNavigator(chooseSavedAddressScreen, this.deepLinkNavigatorProvider.get());
        injectNavigator(chooseSavedAddressScreen, this.navigatorProvider.get());
    }
}
