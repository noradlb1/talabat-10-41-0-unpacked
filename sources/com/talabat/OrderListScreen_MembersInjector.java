package com.talabat;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;
import library.talabat.mvp.cart.CartUtility;

@QualifierMetadata
@DaggerGenerated
public final class OrderListScreen_MembersInjector implements MembersInjector<OrderListScreen> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<CartUtility> cartUtilityProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<DeepLinkNavigator> navigatorProvider;
    private final Provider<ITalabatExperiment> talabatExperimentProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public OrderListScreen_MembersInjector(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<LocationConfigurationRepository> provider3, Provider<ITalabatFeatureFlag> provider4, Provider<ITalabatExperiment> provider5, Provider<CartUtility> provider6, Provider<DeepLinkNavigator> provider7) {
        this.appVersionProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
        this.locationConfigurationRepositoryProvider = provider3;
        this.talabatFeatureFlagProvider = provider4;
        this.talabatExperimentProvider = provider5;
        this.cartUtilityProvider = provider6;
        this.navigatorProvider = provider7;
    }

    public static MembersInjector<OrderListScreen> create(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<LocationConfigurationRepository> provider3, Provider<ITalabatFeatureFlag> provider4, Provider<ITalabatExperiment> provider5, Provider<CartUtility> provider6, Provider<DeepLinkNavigator> provider7) {
        return new OrderListScreen_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.talabat.OrderListScreen.appVersionProvider")
    public static void injectAppVersionProvider(OrderListScreen orderListScreen, AppVersionProvider appVersionProvider2) {
        orderListScreen.f54466u = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.OrderListScreen.cartUtility")
    public static void injectCartUtility(OrderListScreen orderListScreen, CartUtility cartUtility) {
        orderListScreen.f54469x = cartUtility;
    }

    @InjectedFieldSignature("com.talabat.OrderListScreen.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(OrderListScreen orderListScreen, ConfigurationLocalRepository configurationLocalRepository) {
        orderListScreen.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.OrderListScreen.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(OrderListScreen orderListScreen, LocationConfigurationRepository locationConfigurationRepository) {
        orderListScreen.locationConfigurationRepository = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.OrderListScreen.navigator")
    public static void injectNavigator(OrderListScreen orderListScreen, DeepLinkNavigator deepLinkNavigator) {
        orderListScreen.f54470y = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.OrderListScreen.talabatExperiment")
    public static void injectTalabatExperiment(OrderListScreen orderListScreen, ITalabatExperiment iTalabatExperiment) {
        orderListScreen.f54468w = iTalabatExperiment;
    }

    @InjectedFieldSignature("com.talabat.OrderListScreen.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(OrderListScreen orderListScreen, ITalabatFeatureFlag iTalabatFeatureFlag) {
        orderListScreen.f54467v = iTalabatFeatureFlag;
    }

    public void injectMembers(OrderListScreen orderListScreen) {
        injectAppVersionProvider(orderListScreen, this.appVersionProvider.get());
        injectConfigurationLocalRepository(orderListScreen, this.configurationLocalRepositoryProvider.get());
        injectLocationConfigurationRepository(orderListScreen, this.locationConfigurationRepositoryProvider.get());
        injectTalabatFeatureFlag(orderListScreen, this.talabatFeatureFlagProvider.get());
        injectTalabatExperiment(orderListScreen, this.talabatExperimentProvider.get());
        injectCartUtility(orderListScreen, this.cartUtilityProvider.get());
        injectNavigator(orderListScreen, this.navigatorProvider.get());
    }
}
