package com.talabat.di.checkout;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.CheckOutScreen;
import com.talabat.CheckOutScreen_MembersInjector;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.discovery.DiscoveryConfigurationRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.di.checkout.CheckoutScreenComponent;
import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import com.talabat.feature.cancellationpolicy.domain.ICancellationPolicyFlag;
import com.talabat.feature.darkstoresscheduleddelivery.domain.DarkstoresScheduledDeliveryFeatureApi;
import com.talabat.feature.darkstoresscheduleddelivery.domain.usecase.DarkstoresScheduledDeliveryUseCase;
import com.talabat.feature.darkstoresscheduleddelivery.domain.usecase.IsDarkstoresScheduledDeliveryDiscountEnabledUseCase;
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
import com.talabat.feature.pickup.domain.PickupFeatureApi;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionPaymentWithErrorHandlingUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetTProOrderStatusUseCase;
import com.talabat.feature.subscriptions.domain.wrapper.GetActiveSubscriptionsRxWrapper;
import com.talabat.feature.subscriptions.domain.wrapper.PostSubscriptionPaymentRxWrapper;
import com.talabat.maps.domain.CameraUpdateFactory;
import com.talabat.maps.domain.LatLngFactory;
import com.talabat.maps.domain.MapsInitializer;
import com.talabat.maps.domain.ModelsRepository;
import com.talabat.maps.domain.di.MapsCoreLibApi;
import com.talabat.wallet.bnplmanager.di.module.BnplManagerDaggerModule_ProvideBnplManagerLocalDataSourceFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerCheckoutScreenComponent {

    public static final class CheckoutScreenComponentImpl implements CheckoutScreenComponent {
        private final CheckoutScreenComponentImpl checkoutScreenComponentImpl;
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final CustomerCoreLibApi customerCoreLibApi;
        private final DarkstoresScheduledDeliveryFeatureApi darkstoresScheduledDeliveryFeatureApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private Provider<FeesViewModel> feesViewModelProvider;
        private Provider<IDisclaimerRepository> getDisclaimerRepositoryProvider;
        private Provider<GetFeesUseCase> getFeesUseCaseProvider;
        private Provider<IPricingRepository> getPricingRepositoryProvider;
        private Provider<IFeesTracker> getTrackerProvider;
        private final HelpCenterFeatureApi helpCenterFeatureApi;
        private final MapsCoreLibApi mapsCoreLibApi;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private final PickupFeatureApi pickupFeatureApi;
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

        private CheckoutScreenComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, FeesFeatureApi feesFeatureApi, HelpCenterFeatureApi helpCenterFeatureApi2, MapsCoreLibApi mapsCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, SubscriptionsFeatureApi subscriptionsFeatureApi2, DarkstoresScheduledDeliveryFeatureApi darkstoresScheduledDeliveryFeatureApi2, CustomerCoreLibApi customerCoreLibApi2, PickupFeatureApi pickupFeatureApi2) {
            this.checkoutScreenComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.pickupFeatureApi = pickupFeatureApi2;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.subscriptionsFeatureApi = subscriptionsFeatureApi2;
            this.darkstoresScheduledDeliveryFeatureApi = darkstoresScheduledDeliveryFeatureApi2;
            this.mapsCoreLibApi = mapsCoreLibApi2;
            this.customerCoreLibApi = customerCoreLibApi2;
            this.helpCenterFeatureApi = helpCenterFeatureApi2;
            initialize(configurationLocalCoreLibApi2, configurationRemoteCoreLibApi2, featureFlagCoreLibApi2, feesFeatureApi, helpCenterFeatureApi2, mapsCoreLibApi2, observabilityCoreLibApi2, subscriptionsFeatureApi2, darkstoresScheduledDeliveryFeatureApi2, customerCoreLibApi2, pickupFeatureApi2);
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

        private GetSubscriptionPaymentWithErrorHandlingUseCase getSubscriptionPaymentWithErrorHandlingUseCase() {
            return new GetSubscriptionPaymentWithErrorHandlingUseCase((ISubscriptionsRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getRepository()));
        }

        private void initialize(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, FeesFeatureApi feesFeatureApi, HelpCenterFeatureApi helpCenterFeatureApi2, MapsCoreLibApi mapsCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, SubscriptionsFeatureApi subscriptionsFeatureApi2, DarkstoresScheduledDeliveryFeatureApi darkstoresScheduledDeliveryFeatureApi2, CustomerCoreLibApi customerCoreLibApi2, PickupFeatureApi pickupFeatureApi2) {
            GetPricingRepositoryProvider getPricingRepositoryProvider2 = new GetPricingRepositoryProvider(feesFeatureApi);
            this.getPricingRepositoryProvider = getPricingRepositoryProvider2;
            this.getFeesUseCaseProvider = GetFeesUseCase_Factory.create(getPricingRepositoryProvider2);
            this.getDisclaimerRepositoryProvider = new GetDisclaimerRepositoryProvider(feesFeatureApi);
            GetTrackerProvider getTrackerProvider2 = new GetTrackerProvider(feesFeatureApi);
            this.getTrackerProvider = getTrackerProvider2;
            this.feesViewModelProvider = FeesViewModel_Factory.create(this.getFeesUseCaseProvider, this.getDisclaimerRepositoryProvider, getTrackerProvider2, PricingPresentationModule_ProvideTalabatFormatterFactory.create());
        }

        @CanIgnoreReturnValue
        private CheckOutScreen injectCheckOutScreen(CheckOutScreen checkOutScreen) {
            CheckOutScreen_MembersInjector.injectAppVersionProvider(checkOutScreen, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            CheckOutScreen_MembersInjector.injectConfigurationLocalRepository(checkOutScreen, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            CheckOutScreen_MembersInjector.injectPickupFeatureApi(checkOutScreen, this.pickupFeatureApi);
            CheckOutScreen_MembersInjector.injectLocationConfigurationRepository(checkOutScreen, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            CheckOutScreen_MembersInjector.injectDiscoveryConfigurationRepository(checkOutScreen, (DiscoveryConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getDiscoveryConfigurationRepository()));
            CheckOutScreen_MembersInjector.injectPaymentConfigurationRepository(checkOutScreen, (PaymentConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getPaymentConfigurationRepository()));
            CheckOutScreen_MembersInjector.injectFeesViewModelFactory(checkOutScreen, feesViewModelFactory());
            CheckOutScreen_MembersInjector.injectObservabilityManager(checkOutScreen, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
            CheckOutScreen_MembersInjector.injectTalabatFeatureFlag(checkOutScreen, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            CheckOutScreen_MembersInjector.injectSubscriptionsTracker(checkOutScreen, (ISubscriptionsTracker) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getTracker()));
            CheckOutScreen_MembersInjector.injectDarkstoresScheduledDeliveryUseCase(checkOutScreen, (DarkstoresScheduledDeliveryUseCase) Preconditions.checkNotNullFromComponent(this.darkstoresScheduledDeliveryFeatureApi.darkstoresScheduledDeliveryUseCase()));
            CheckOutScreen_MembersInjector.injectIsDarkstoresScheduledDeliveryDiscountEnabledUseCase(checkOutScreen, (IsDarkstoresScheduledDeliveryDiscountEnabledUseCase) Preconditions.checkNotNullFromComponent(this.darkstoresScheduledDeliveryFeatureApi.isDarkstoresScheduledDeliveryDiscountEnabledUseCase()));
            CheckOutScreen_MembersInjector.injectTermsAndConditionsConfigurationRepository(checkOutScreen, (TermsAndConditionsConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getTermsAndConditionsConfigurationRepository()));
            CheckOutScreen_MembersInjector.injectGetTProOrderStatusUseCase(checkOutScreen, (GetTProOrderStatusUseCase) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getGetTProOrderStatusUseCase()));
            CheckOutScreen_MembersInjector.injectModelsRepository(checkOutScreen, (ModelsRepository) Preconditions.checkNotNullFromComponent(this.mapsCoreLibApi.getModelsRepository()));
            CheckOutScreen_MembersInjector.injectLatLngFactory(checkOutScreen, (LatLngFactory) Preconditions.checkNotNullFromComponent(this.mapsCoreLibApi.getLatLngFactory()));
            CheckOutScreen_MembersInjector.injectMapsInitializer(checkOutScreen, (MapsInitializer) Preconditions.checkNotNullFromComponent(this.mapsCoreLibApi.getMapsInitializer()));
            CheckOutScreen_MembersInjector.injectCameraUpdateFactory(checkOutScreen, (CameraUpdateFactory) Preconditions.checkNotNullFromComponent(this.mapsCoreLibApi.getCameraUpdateFactory()));
            CheckOutScreen_MembersInjector.injectCustomerRepository(checkOutScreen, (CustomerRepository) Preconditions.checkNotNullFromComponent(this.customerCoreLibApi.getRepository()));
            CheckOutScreen_MembersInjector.injectScreenTracker(checkOutScreen, (IScreenTracker) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getScreenTracker()));
            CheckOutScreen_MembersInjector.injectPostSubscriptionPaymentRxWrapper(checkOutScreen, postSubscriptionPaymentRxWrapper());
            CheckOutScreen_MembersInjector.injectGetActiveSubscriptionsRxWrapper(checkOutScreen, getActiveSubscriptionsRxWrapper());
            CheckOutScreen_MembersInjector.injectSubscriptionStatusRepository(checkOutScreen, (ISubscriptionStatusRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionStatusRepository()));
            CheckOutScreen_MembersInjector.injectCancellationPolicyFlag(checkOutScreen, (ICancellationPolicyFlag) Preconditions.checkNotNullFromComponent(this.helpCenterFeatureApi.getCancellationPolicyFlag()));
            CheckOutScreen_MembersInjector.injectBnplManagerLocalDataSource(checkOutScreen, BnplManagerDaggerModule_ProvideBnplManagerLocalDataSourceFactory.provideBnplManagerLocalDataSource());
            return checkOutScreen;
        }

        private PostSubscriptionPaymentRxWrapper postSubscriptionPaymentRxWrapper() {
            return new PostSubscriptionPaymentRxWrapper(getSubscriptionPaymentWithErrorHandlingUseCase());
        }

        public void inject(CheckOutScreen checkOutScreen) {
            injectCheckOutScreen(checkOutScreen);
        }
    }

    public static final class Factory implements CheckoutScreenComponent.Factory {
        private Factory() {
        }

        public CheckoutScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, FeesFeatureApi feesFeatureApi, HelpCenterFeatureApi helpCenterFeatureApi, MapsCoreLibApi mapsCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, SubscriptionsFeatureApi subscriptionsFeatureApi, DarkstoresScheduledDeliveryFeatureApi darkstoresScheduledDeliveryFeatureApi, CustomerCoreLibApi customerCoreLibApi, PickupFeatureApi pickupFeatureApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(feesFeatureApi);
            Preconditions.checkNotNull(helpCenterFeatureApi);
            Preconditions.checkNotNull(mapsCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(subscriptionsFeatureApi);
            Preconditions.checkNotNull(darkstoresScheduledDeliveryFeatureApi);
            Preconditions.checkNotNull(customerCoreLibApi);
            Preconditions.checkNotNull(pickupFeatureApi);
            return new CheckoutScreenComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, featureFlagCoreLibApi, feesFeatureApi, helpCenterFeatureApi, mapsCoreLibApi, observabilityCoreLibApi, subscriptionsFeatureApi, darkstoresScheduledDeliveryFeatureApi, customerCoreLibApi, pickupFeatureApi);
        }
    }

    private DaggerCheckoutScreenComponent() {
    }

    public static CheckoutScreenComponent.Factory factory() {
        return new Factory();
    }
}
