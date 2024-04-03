package com.talabat.di.cart;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.CartScreen;
import com.talabat.CartScreen_MembersInjector;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.discovery.DiscoveryConfigurationRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.orderexperience.OrderExperienceConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.di.cart.CartScreenComponent;
import com.talabat.feature.fees.domain.FeesFeatureApi;
import com.talabat.feature.fees.domain.IFeesTracker;
import com.talabat.feature.fees.domain.repository.IDisclaimerRepository;
import com.talabat.feature.fees.domain.repository.IPricingRepository;
import com.talabat.feature.fees.domain.usecase.GetFeesUseCase;
import com.talabat.feature.fees.domain.usecase.GetFeesUseCase_Factory;
import com.talabat.feature.fees.presentation.di.PricingPresentationModule_ProvideTalabatFormatterFactory;
import com.talabat.feature.fees.presentation.viewmodel.FeesViewModel;
import com.talabat.feature.fees.presentation.viewmodel.FeesViewModelFactory;
import com.talabat.feature.fees.presentation.viewmodel.FeesViewModel_Factory;
import com.talabat.feature.foodcart2.domain.IFoodCartRepository;
import com.talabat.feature.foodcart2.domain.di.FoodCartFeatureApi;
import com.talabat.feature.incentiveautoapplydiscounts.domain.GetAutoApplyDiscountsUseCase;
import com.talabat.feature.incentiveautoapplydiscounts.domain.di.IncentiveAutoApplyDiscountsFeatureApi;
import com.talabat.feature.incentiveautoapplydiscounts.domain.repository.IncentiveAutoApplyDiscountsRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetTProOrderStatusUseCase;
import com.talabat.feature.subscriptions.domain.wrapper.GetActiveSubscriptionsRxWrapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import library.talabat.mvp.cart.CartUtility;

@DaggerGenerated
public final class DaggerCartScreenComponent {

    public static final class CartScreenComponentImpl implements CartScreenComponent {
        private final CartScreenComponentImpl cartScreenComponentImpl;
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final CustomerCoreLibApi customerCoreLibApi;
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final ExperimentCoreLibApi experimentCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private Provider<FeesViewModel> feesViewModelProvider;
        private final FoodCartFeatureApi foodCartFeatureApi;
        private Provider<IDisclaimerRepository> getDisclaimerRepositoryProvider;
        private Provider<GetFeesUseCase> getFeesUseCaseProvider;
        private Provider<IPricingRepository> getPricingRepositoryProvider;
        private Provider<IFeesTracker> getTrackerProvider;
        private final IncentiveAutoApplyDiscountsFeatureApi incentiveAutoApplyDiscountsFeatureApi;
        private final NavigationCoreLibApi navigationCoreLibApi;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private final SubscriptionsFeatureApi subscriptionsFeatureApi;

        public static final class GetDisclaimerRepositoryProvider implements Provider<IDisclaimerRepository> {
            private final FeesFeatureApi feesFeatureApi;

            public GetDisclaimerRepositoryProvider(FeesFeatureApi feesFeatureApi2) {
                this.feesFeatureApi = feesFeatureApi2;
            }

            public IDisclaimerRepository get() {
                return (IDisclaimerRepository) Preconditions.checkNotNullFromComponent(this.feesFeatureApi.getDisclaimerRepository());
            }
        }

        public static final class GetPricingRepositoryProvider implements Provider<IPricingRepository> {
            private final FeesFeatureApi feesFeatureApi;

            public GetPricingRepositoryProvider(FeesFeatureApi feesFeatureApi2) {
                this.feesFeatureApi = feesFeatureApi2;
            }

            public IPricingRepository get() {
                return (IPricingRepository) Preconditions.checkNotNullFromComponent(this.feesFeatureApi.getPricingRepository());
            }
        }

        public static final class GetTrackerProvider implements Provider<IFeesTracker> {
            private final FeesFeatureApi feesFeatureApi;

            public GetTrackerProvider(FeesFeatureApi feesFeatureApi2) {
                this.feesFeatureApi = feesFeatureApi2;
            }

            public IFeesTracker get() {
                return (IFeesTracker) Preconditions.checkNotNullFromComponent(this.feesFeatureApi.getTracker());
            }
        }

        private CartScreenComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, FeesFeatureApi feesFeatureApi, FeatureFlagCoreLibApi featureFlagCoreLibApi2, ExperimentCoreLibApi experimentCoreLibApi2, IncentiveAutoApplyDiscountsFeatureApi incentiveAutoApplyDiscountsFeatureApi2, FoodCartFeatureApi foodCartFeatureApi2, SubscriptionsFeatureApi subscriptionsFeatureApi2, CustomerCoreLibApi customerCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, NavigationCoreLibApi navigationCoreLibApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2) {
            this.cartScreenComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.experimentCoreLibApi = experimentCoreLibApi2;
            this.foodCartFeatureApi = foodCartFeatureApi2;
            this.navigationCoreLibApi = navigationCoreLibApi2;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
            this.subscriptionsFeatureApi = subscriptionsFeatureApi2;
            this.customerCoreLibApi = customerCoreLibApi2;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
            this.incentiveAutoApplyDiscountsFeatureApi = incentiveAutoApplyDiscountsFeatureApi2;
            initialize(configurationLocalCoreLibApi2, configurationRemoteCoreLibApi2, feesFeatureApi, featureFlagCoreLibApi2, experimentCoreLibApi2, incentiveAutoApplyDiscountsFeatureApi2, foodCartFeatureApi2, subscriptionsFeatureApi2, customerCoreLibApi2, observabilityCoreLibApi2, navigationCoreLibApi2, deepLinkCoreLibApi2);
        }

        private CartUtility cartUtility() {
            return CartUtilityModule_ProvideCartUtilityFactory.provideCartUtility((IFoodCartRepository) Preconditions.checkNotNullFromComponent(this.foodCartFeatureApi.getRepository()));
        }

        private FeesViewModelFactory feesViewModelFactory() {
            return new FeesViewModelFactory(this.feesViewModelProvider);
        }

        private GetActiveSubscriptionsRxWrapper getActiveSubscriptionsRxWrapper() {
            return new GetActiveSubscriptionsRxWrapper(getActiveSubscriptionsUseCase(), (ISubscriptionsCustomerRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionsCustomerRepository()));
        }

        private GetActiveSubscriptionsUseCase getActiveSubscriptionsUseCase() {
            return new GetActiveSubscriptionsUseCase((ISubscriptionsRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getRepository()), (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()), (ISubscriptionStatusRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionStatusRepository()));
        }

        private GetAutoApplyDiscountsUseCase getAutoApplyDiscountsUseCase() {
            return new GetAutoApplyDiscountsUseCase((IncentiveAutoApplyDiscountsRepository) Preconditions.checkNotNullFromComponent(this.incentiveAutoApplyDiscountsFeatureApi.getRepository()));
        }

        private void initialize(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, FeesFeatureApi feesFeatureApi, FeatureFlagCoreLibApi featureFlagCoreLibApi2, ExperimentCoreLibApi experimentCoreLibApi2, IncentiveAutoApplyDiscountsFeatureApi incentiveAutoApplyDiscountsFeatureApi2, FoodCartFeatureApi foodCartFeatureApi2, SubscriptionsFeatureApi subscriptionsFeatureApi2, CustomerCoreLibApi customerCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, NavigationCoreLibApi navigationCoreLibApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2) {
            GetPricingRepositoryProvider getPricingRepositoryProvider2 = new GetPricingRepositoryProvider(feesFeatureApi);
            this.getPricingRepositoryProvider = getPricingRepositoryProvider2;
            this.getFeesUseCaseProvider = GetFeesUseCase_Factory.create(getPricingRepositoryProvider2);
            this.getDisclaimerRepositoryProvider = new GetDisclaimerRepositoryProvider(feesFeatureApi);
            GetTrackerProvider getTrackerProvider2 = new GetTrackerProvider(feesFeatureApi);
            this.getTrackerProvider = getTrackerProvider2;
            this.feesViewModelProvider = FeesViewModel_Factory.create(this.getFeesUseCaseProvider, this.getDisclaimerRepositoryProvider, getTrackerProvider2, PricingPresentationModule_ProvideTalabatFormatterFactory.create());
        }

        @CanIgnoreReturnValue
        private CartScreen injectCartScreen(CartScreen cartScreen) {
            CartScreen_MembersInjector.injectAppVersionProvider(cartScreen, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            CartScreen_MembersInjector.injectDiscoveryConfigurationRepository(cartScreen, (DiscoveryConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getDiscoveryConfigurationRepository()));
            CartScreen_MembersInjector.injectConfigurationLocalRepository(cartScreen, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            CartScreen_MembersInjector.injectLocationConfigRepository(cartScreen, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            CartScreen_MembersInjector.injectOrderExperienceConfigurationRepository(cartScreen, (OrderExperienceConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getOrderExperienceConfigurationRepository()));
            CartScreen_MembersInjector.injectPaymentConfigurationRepository(cartScreen, (PaymentConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getPaymentConfigurationRepository()));
            CartScreen_MembersInjector.injectTalabatFeatureFlag(cartScreen, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            CartScreen_MembersInjector.injectTalabatExperiment(cartScreen, (ITalabatExperiment) Preconditions.checkNotNullFromComponent(this.experimentCoreLibApi.getExperimentProvider()));
            CartScreen_MembersInjector.injectFeesViewModelFactory(cartScreen, feesViewModelFactory());
            CartScreen_MembersInjector.injectCartUtility(cartScreen, cartUtility());
            CartScreen_MembersInjector.injectNavigator(cartScreen, (Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator()));
            CartScreen_MembersInjector.injectDeepLinkNavigator(cartScreen, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            CartScreen_MembersInjector.injectGetTProOrderStatusUseCase(cartScreen, (GetTProOrderStatusUseCase) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getGetTProOrderStatusUseCase()));
            CartScreen_MembersInjector.injectGetActiveSubscriptions(cartScreen, getActiveSubscriptionsRxWrapper());
            CartScreen_MembersInjector.injectSubscriptionStatusRepository(cartScreen, (ISubscriptionStatusRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionStatusRepository()));
            CartScreen_MembersInjector.injectCustomerRepository(cartScreen, (CustomerRepository) Preconditions.checkNotNullFromComponent(this.customerCoreLibApi.getRepository()));
            CartScreen_MembersInjector.injectScreenTracker(cartScreen, (IScreenTracker) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getScreenTracker()));
            CartScreen_MembersInjector.injectGetAutoApplyDiscountsUseCase(cartScreen, getAutoApplyDiscountsUseCase());
            return cartScreen;
        }

        public void inject(CartScreen cartScreen) {
            injectCartScreen(cartScreen);
        }
    }

    public static final class Factory implements CartScreenComponent.Factory {
        private Factory() {
        }

        public CartScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeesFeatureApi feesFeatureApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, IncentiveAutoApplyDiscountsFeatureApi incentiveAutoApplyDiscountsFeatureApi, FoodCartFeatureApi foodCartFeatureApi, SubscriptionsFeatureApi subscriptionsFeatureApi, CustomerCoreLibApi customerCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, NavigationCoreLibApi navigationCoreLibApi, DeepLinkCoreLibApi deepLinkCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(feesFeatureApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(experimentCoreLibApi);
            Preconditions.checkNotNull(incentiveAutoApplyDiscountsFeatureApi);
            Preconditions.checkNotNull(foodCartFeatureApi);
            Preconditions.checkNotNull(subscriptionsFeatureApi);
            Preconditions.checkNotNull(customerCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(navigationCoreLibApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            return new CartScreenComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, feesFeatureApi, featureFlagCoreLibApi, experimentCoreLibApi, incentiveAutoApplyDiscountsFeatureApi, foodCartFeatureApi, subscriptionsFeatureApi, customerCoreLibApi, observabilityCoreLibApi, navigationCoreLibApi, deepLinkCoreLibApi);
        }
    }

    private DaggerCartScreenComponent() {
    }

    public static CartScreenComponent.Factory factory() {
        return new Factory();
    }
}
