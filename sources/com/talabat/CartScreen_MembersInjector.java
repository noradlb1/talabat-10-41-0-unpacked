package com.talabat;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.discovery.DiscoveryConfigurationRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.orderexperience.OrderExperienceConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.feature.fees.presentation.viewmodel.FeesViewModelFactory;
import com.talabat.feature.incentiveautoapplydiscounts.domain.GetAutoApplyDiscountsUseCase;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.usecase.GetTProOrderStatusUseCase;
import com.talabat.feature.subscriptions.domain.wrapper.GetActiveSubscriptionsRxWrapper;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;
import library.talabat.mvp.cart.CartUtility;

@QualifierMetadata
@DaggerGenerated
public final class CartScreen_MembersInjector implements MembersInjector<CartScreen> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<CartUtility> cartUtilityProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<DeepLinkNavigator> deepLinkNavigatorProvider;
    private final Provider<DiscoveryConfigurationRepository> discoveryConfigurationRepositoryProvider;
    private final Provider<FeesViewModelFactory> feesViewModelFactoryProvider;
    private final Provider<GetActiveSubscriptionsRxWrapper> getActiveSubscriptionsProvider;
    private final Provider<GetAutoApplyDiscountsUseCase> getAutoApplyDiscountsUseCaseProvider;
    private final Provider<GetTProOrderStatusUseCase> getTProOrderStatusUseCaseProvider;
    private final Provider<LocationConfigurationRepository> locationConfigRepositoryProvider;
    private final Provider<Navigator> navigatorProvider;
    private final Provider<OrderExperienceConfigurationRepository> orderExperienceConfigurationRepositoryProvider;
    private final Provider<PaymentConfigurationRepository> paymentConfigurationRepositoryProvider;
    private final Provider<IScreenTracker> screenTrackerProvider;
    private final Provider<ISubscriptionStatusRepository> subscriptionStatusRepositoryProvider;
    private final Provider<ITalabatExperiment> talabatExperimentProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public CartScreen_MembersInjector(Provider<AppVersionProvider> provider, Provider<DiscoveryConfigurationRepository> provider2, Provider<ConfigurationLocalRepository> provider3, Provider<LocationConfigurationRepository> provider4, Provider<OrderExperienceConfigurationRepository> provider5, Provider<PaymentConfigurationRepository> provider6, Provider<ITalabatFeatureFlag> provider7, Provider<ITalabatExperiment> provider8, Provider<FeesViewModelFactory> provider9, Provider<CartUtility> provider10, Provider<Navigator> provider11, Provider<DeepLinkNavigator> provider12, Provider<GetTProOrderStatusUseCase> provider13, Provider<GetActiveSubscriptionsRxWrapper> provider14, Provider<ISubscriptionStatusRepository> provider15, Provider<CustomerRepository> provider16, Provider<IScreenTracker> provider17, Provider<GetAutoApplyDiscountsUseCase> provider18) {
        this.appVersionProvider = provider;
        this.discoveryConfigurationRepositoryProvider = provider2;
        this.configurationLocalRepositoryProvider = provider3;
        this.locationConfigRepositoryProvider = provider4;
        this.orderExperienceConfigurationRepositoryProvider = provider5;
        this.paymentConfigurationRepositoryProvider = provider6;
        this.talabatFeatureFlagProvider = provider7;
        this.talabatExperimentProvider = provider8;
        this.feesViewModelFactoryProvider = provider9;
        this.cartUtilityProvider = provider10;
        this.navigatorProvider = provider11;
        this.deepLinkNavigatorProvider = provider12;
        this.getTProOrderStatusUseCaseProvider = provider13;
        this.getActiveSubscriptionsProvider = provider14;
        this.subscriptionStatusRepositoryProvider = provider15;
        this.customerRepositoryProvider = provider16;
        this.screenTrackerProvider = provider17;
        this.getAutoApplyDiscountsUseCaseProvider = provider18;
    }

    public static MembersInjector<CartScreen> create(Provider<AppVersionProvider> provider, Provider<DiscoveryConfigurationRepository> provider2, Provider<ConfigurationLocalRepository> provider3, Provider<LocationConfigurationRepository> provider4, Provider<OrderExperienceConfigurationRepository> provider5, Provider<PaymentConfigurationRepository> provider6, Provider<ITalabatFeatureFlag> provider7, Provider<ITalabatExperiment> provider8, Provider<FeesViewModelFactory> provider9, Provider<CartUtility> provider10, Provider<Navigator> provider11, Provider<DeepLinkNavigator> provider12, Provider<GetTProOrderStatusUseCase> provider13, Provider<GetActiveSubscriptionsRxWrapper> provider14, Provider<ISubscriptionStatusRepository> provider15, Provider<CustomerRepository> provider16, Provider<IScreenTracker> provider17, Provider<GetAutoApplyDiscountsUseCase> provider18) {
        return new CartScreen_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18);
    }

    @InjectedFieldSignature("com.talabat.CartScreen.appVersionProvider")
    public static void injectAppVersionProvider(CartScreen cartScreen, AppVersionProvider appVersionProvider2) {
        cartScreen.f53708p = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.CartScreen.cartUtility")
    public static void injectCartUtility(CartScreen cartScreen, CartUtility cartUtility) {
        cartScreen.f53717y = cartUtility;
    }

    @InjectedFieldSignature("com.talabat.CartScreen.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(CartScreen cartScreen, ConfigurationLocalRepository configurationLocalRepository) {
        cartScreen.f53710r = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.CartScreen.customerRepository")
    public static void injectCustomerRepository(CartScreen cartScreen, CustomerRepository customerRepository) {
        cartScreen.E = customerRepository;
    }

    @InjectedFieldSignature("com.talabat.CartScreen.deepLinkNavigator")
    public static void injectDeepLinkNavigator(CartScreen cartScreen, DeepLinkNavigator deepLinkNavigator) {
        cartScreen.A = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.CartScreen.discoveryConfigurationRepository")
    public static void injectDiscoveryConfigurationRepository(CartScreen cartScreen, DiscoveryConfigurationRepository discoveryConfigurationRepository) {
        cartScreen.f53709q = discoveryConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.CartScreen.feesViewModelFactory")
    public static void injectFeesViewModelFactory(CartScreen cartScreen, FeesViewModelFactory feesViewModelFactory) {
        cartScreen.f53716x = feesViewModelFactory;
    }

    @InjectedFieldSignature("com.talabat.CartScreen.getActiveSubscriptions")
    public static void injectGetActiveSubscriptions(CartScreen cartScreen, GetActiveSubscriptionsRxWrapper getActiveSubscriptionsRxWrapper) {
        cartScreen.C = getActiveSubscriptionsRxWrapper;
    }

    @InjectedFieldSignature("com.talabat.CartScreen.getAutoApplyDiscountsUseCase")
    public static void injectGetAutoApplyDiscountsUseCase(CartScreen cartScreen, GetAutoApplyDiscountsUseCase getAutoApplyDiscountsUseCase) {
        cartScreen.H = getAutoApplyDiscountsUseCase;
    }

    @InjectedFieldSignature("com.talabat.CartScreen.getTProOrderStatusUseCase")
    public static void injectGetTProOrderStatusUseCase(CartScreen cartScreen, GetTProOrderStatusUseCase getTProOrderStatusUseCase) {
        cartScreen.B = getTProOrderStatusUseCase;
    }

    @InjectedFieldSignature("com.talabat.CartScreen.locationConfigRepository")
    public static void injectLocationConfigRepository(CartScreen cartScreen, LocationConfigurationRepository locationConfigurationRepository) {
        cartScreen.f53711s = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.CartScreen.navigator")
    public static void injectNavigator(CartScreen cartScreen, Navigator navigator) {
        cartScreen.f53718z = navigator;
    }

    @InjectedFieldSignature("com.talabat.CartScreen.orderExperienceConfigurationRepository")
    public static void injectOrderExperienceConfigurationRepository(CartScreen cartScreen, OrderExperienceConfigurationRepository orderExperienceConfigurationRepository) {
        cartScreen.f53712t = orderExperienceConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.CartScreen.paymentConfigurationRepository")
    public static void injectPaymentConfigurationRepository(CartScreen cartScreen, PaymentConfigurationRepository paymentConfigurationRepository) {
        cartScreen.f53713u = paymentConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.CartScreen.screenTracker")
    public static void injectScreenTracker(CartScreen cartScreen, IScreenTracker iScreenTracker) {
        cartScreen.F = iScreenTracker;
    }

    @InjectedFieldSignature("com.talabat.CartScreen.subscriptionStatusRepository")
    public static void injectSubscriptionStatusRepository(CartScreen cartScreen, ISubscriptionStatusRepository iSubscriptionStatusRepository) {
        cartScreen.D = iSubscriptionStatusRepository;
    }

    @InjectedFieldSignature("com.talabat.CartScreen.talabatExperiment")
    public static void injectTalabatExperiment(CartScreen cartScreen, ITalabatExperiment iTalabatExperiment) {
        cartScreen.f53715w = iTalabatExperiment;
    }

    @InjectedFieldSignature("com.talabat.CartScreen.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(CartScreen cartScreen, ITalabatFeatureFlag iTalabatFeatureFlag) {
        cartScreen.f53714v = iTalabatFeatureFlag;
    }

    public void injectMembers(CartScreen cartScreen) {
        injectAppVersionProvider(cartScreen, this.appVersionProvider.get());
        injectDiscoveryConfigurationRepository(cartScreen, this.discoveryConfigurationRepositoryProvider.get());
        injectConfigurationLocalRepository(cartScreen, this.configurationLocalRepositoryProvider.get());
        injectLocationConfigRepository(cartScreen, this.locationConfigRepositoryProvider.get());
        injectOrderExperienceConfigurationRepository(cartScreen, this.orderExperienceConfigurationRepositoryProvider.get());
        injectPaymentConfigurationRepository(cartScreen, this.paymentConfigurationRepositoryProvider.get());
        injectTalabatFeatureFlag(cartScreen, this.talabatFeatureFlagProvider.get());
        injectTalabatExperiment(cartScreen, this.talabatExperimentProvider.get());
        injectFeesViewModelFactory(cartScreen, this.feesViewModelFactoryProvider.get());
        injectCartUtility(cartScreen, this.cartUtilityProvider.get());
        injectNavigator(cartScreen, this.navigatorProvider.get());
        injectDeepLinkNavigator(cartScreen, this.deepLinkNavigatorProvider.get());
        injectGetTProOrderStatusUseCase(cartScreen, this.getTProOrderStatusUseCaseProvider.get());
        injectGetActiveSubscriptions(cartScreen, this.getActiveSubscriptionsProvider.get());
        injectSubscriptionStatusRepository(cartScreen, this.subscriptionStatusRepositoryProvider.get());
        injectCustomerRepository(cartScreen, this.customerRepositoryProvider.get());
        injectScreenTracker(cartScreen, this.screenTrackerProvider.get());
        injectGetAutoApplyDiscountsUseCase(cartScreen, this.getAutoApplyDiscountsUseCaseProvider.get());
    }
}
