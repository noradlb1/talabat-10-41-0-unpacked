package com.talabat.di.checkout;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.checkoutdotcom.CheckoutTokenScreen;
import com.talabat.checkoutdotcom.CheckoutTokenScreen_MembersInjector;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.discovery.DiscoveryConfigurationRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.di.checkout.CheckoutTokenScreenComponent;
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
import com.talabat.feature.tokenization.domain.TokenizationFeatureApi;
import com.talabat.feature.tokenization.domain.TokenizationRepository;
import com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase;
import com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase_Factory;
import com.talabat.feature.tokenization.domain.usecase.GetTokenizationPublicKeyUseCase;
import com.talabat.feature.tokenization.domain.usecase.GetTokenizationPublicKeyUseCase_Factory;
import com.talabat.feature.tokenization.domain.usecase.ObserveTokenizationFailedUseCase;
import com.talabat.feature.tokenization.domain.usecase.ObserveTokenizationFailedUseCase_Factory;
import com.talabat.feature.tokenization.domain.usecase.ObserveTokenizationSuccessUseCase;
import com.talabat.feature.tokenization.domain.usecase.ObserveTokenizationSuccessUseCase_Factory;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.CheckoutKitWrapper;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.CheckoutKitWrapper_Factory;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.ICheckoutKit;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerCheckoutTokenScreenComponent {

    public static final class CheckoutTokenScreenComponentImpl implements CheckoutTokenScreenComponent {
        private Provider<CheckoutKitWrapper> checkoutKitWrapperProvider;
        private final CheckoutTokenScreenComponentImpl checkoutTokenScreenComponentImpl;
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private Provider<FeesViewModel> feesViewModelProvider;
        private Provider<GenerateCardTokenUseCase> generateCardTokenUseCaseProvider;
        private Provider<IDisclaimerRepository> getDisclaimerRepositoryProvider;
        private Provider<GetFeesUseCase> getFeesUseCaseProvider;
        private Provider<IObservabilityManager> getObservabilityManagerProvider;
        private Provider<IPricingRepository> getPricingRepositoryProvider;
        private Provider<TokenizationRepository> getRepositoryProvider;
        private Provider<ConfigurationLocalRepository> getRepositoryProvider2;
        private Provider<GetTokenizationPublicKeyUseCase> getTokenizationPublicKeyUseCaseProvider;
        private Provider<IFeesTracker> getTrackerProvider;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private Provider<ObserveTokenizationFailedUseCase> observeTokenizationFailedUseCaseProvider;
        private Provider<ObserveTokenizationSuccessUseCase> observeTokenizationSuccessUseCaseProvider;
        private Provider<ICheckoutKit> provideCheckoutKitProvider;

        public static final class GetDisclaimerRepositoryProvider implements Provider<IDisclaimerRepository> {
            private final FeesFeatureApi feesFeatureApi;

            public GetDisclaimerRepositoryProvider(FeesFeatureApi feesFeatureApi2) {
                this.feesFeatureApi = feesFeatureApi2;
            }

            public IDisclaimerRepository get() {
                return (IDisclaimerRepository) Preconditions.checkNotNullFromComponent(this.feesFeatureApi.getDisclaimerRepository());
            }
        }

        public static final class GetObservabilityManagerProvider implements Provider<IObservabilityManager> {
            private final ObservabilityCoreLibApi observabilityCoreLibApi;

            public GetObservabilityManagerProvider(ObservabilityCoreLibApi observabilityCoreLibApi2) {
                this.observabilityCoreLibApi = observabilityCoreLibApi2;
            }

            public IObservabilityManager get() {
                return (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager());
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

        public static final class GetRepositoryProvider implements Provider<TokenizationRepository> {
            private final TokenizationFeatureApi tokenizationFeatureApi;

            public GetRepositoryProvider(TokenizationFeatureApi tokenizationFeatureApi2) {
                this.tokenizationFeatureApi = tokenizationFeatureApi2;
            }

            public TokenizationRepository get() {
                return (TokenizationRepository) Preconditions.checkNotNullFromComponent(this.tokenizationFeatureApi.getRepository());
            }
        }

        public static final class GetRepositoryProvider2 implements Provider<ConfigurationLocalRepository> {
            private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;

            public GetRepositoryProvider2(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2) {
                this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            }

            public ConfigurationLocalRepository get() {
                return (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository());
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

        private CheckoutTokenScreenComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi2, FeesFeatureApi feesFeatureApi, ObservabilityCoreLibApi observabilityCoreLibApi2, TokenizationFeatureApi tokenizationFeatureApi, DeepLinkCoreLibApi deepLinkCoreLibApi2) {
            this.checkoutTokenScreenComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            initialize(configurationLocalCoreLibApi2, configurationRemoteCoreLibApi2, contextCoreLibApi, featureFlagCoreLibApi2, feesFeatureApi, observabilityCoreLibApi2, tokenizationFeatureApi, deepLinkCoreLibApi2);
        }

        private FeesViewModelFactory feesViewModelFactory() {
            return new FeesViewModelFactory(this.feesViewModelProvider);
        }

        private void initialize(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi2, FeesFeatureApi feesFeatureApi, ObservabilityCoreLibApi observabilityCoreLibApi2, TokenizationFeatureApi tokenizationFeatureApi, DeepLinkCoreLibApi deepLinkCoreLibApi2) {
            GetPricingRepositoryProvider getPricingRepositoryProvider2 = new GetPricingRepositoryProvider(feesFeatureApi);
            this.getPricingRepositoryProvider = getPricingRepositoryProvider2;
            this.getFeesUseCaseProvider = GetFeesUseCase_Factory.create(getPricingRepositoryProvider2);
            this.getDisclaimerRepositoryProvider = new GetDisclaimerRepositoryProvider(feesFeatureApi);
            GetTrackerProvider getTrackerProvider2 = new GetTrackerProvider(feesFeatureApi);
            this.getTrackerProvider = getTrackerProvider2;
            this.feesViewModelProvider = FeesViewModel_Factory.create(this.getFeesUseCaseProvider, this.getDisclaimerRepositoryProvider, getTrackerProvider2, PricingPresentationModule_ProvideTalabatFormatterFactory.create());
            this.getRepositoryProvider = new GetRepositoryProvider(tokenizationFeatureApi);
            GetRepositoryProvider2 getRepositoryProvider22 = new GetRepositoryProvider2(configurationLocalCoreLibApi2);
            this.getRepositoryProvider2 = getRepositoryProvider22;
            this.getTokenizationPublicKeyUseCaseProvider = GetTokenizationPublicKeyUseCase_Factory.create(this.getRepositoryProvider, getRepositoryProvider22);
            GetObservabilityManagerProvider getObservabilityManagerProvider2 = new GetObservabilityManagerProvider(observabilityCoreLibApi2);
            this.getObservabilityManagerProvider = getObservabilityManagerProvider2;
            this.observeTokenizationFailedUseCaseProvider = ObserveTokenizationFailedUseCase_Factory.create(getObservabilityManagerProvider2);
            ObserveTokenizationSuccessUseCase_Factory create = ObserveTokenizationSuccessUseCase_Factory.create(this.getObservabilityManagerProvider);
            this.observeTokenizationSuccessUseCaseProvider = create;
            GenerateCardTokenUseCase_Factory create2 = GenerateCardTokenUseCase_Factory.create(this.getRepositoryProvider, this.getTokenizationPublicKeyUseCaseProvider, this.observeTokenizationFailedUseCaseProvider, create);
            this.generateCardTokenUseCaseProvider = create2;
            CheckoutKitWrapper_Factory create3 = CheckoutKitWrapper_Factory.create(create2);
            this.checkoutKitWrapperProvider = create3;
            this.provideCheckoutKitProvider = SingleCheck.provider(create3);
        }

        @CanIgnoreReturnValue
        private CheckoutTokenScreen injectCheckoutTokenScreen(CheckoutTokenScreen checkoutTokenScreen) {
            CheckoutTokenScreen_MembersInjector.injectAppVersionProvider(checkoutTokenScreen, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            CheckoutTokenScreen_MembersInjector.injectConfigurationLocalRepository(checkoutTokenScreen, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            CheckoutTokenScreen_MembersInjector.injectDeepLinkNavigator(checkoutTokenScreen, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            CheckoutTokenScreen_MembersInjector.injectDiscoveryConfigurationRepository(checkoutTokenScreen, (DiscoveryConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getDiscoveryConfigurationRepository()));
            CheckoutTokenScreen_MembersInjector.injectLocationConfigurationRepository(checkoutTokenScreen, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            CheckoutTokenScreen_MembersInjector.injectPaymentConfigurationRepository(checkoutTokenScreen, (PaymentConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getPaymentConfigurationRepository()));
            CheckoutTokenScreen_MembersInjector.injectFeesViewModelFactory(checkoutTokenScreen, feesViewModelFactory());
            CheckoutTokenScreen_MembersInjector.injectObservabilityManager(checkoutTokenScreen, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
            CheckoutTokenScreen_MembersInjector.injectTalabatFeatureFlag(checkoutTokenScreen, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            CheckoutTokenScreen_MembersInjector.injectCheckoutKit(checkoutTokenScreen, this.provideCheckoutKitProvider.get());
            CheckoutTokenScreen_MembersInjector.injectTermsAndConditionsConfigurationRepository(checkoutTokenScreen, (TermsAndConditionsConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getTermsAndConditionsConfigurationRepository()));
            return checkoutTokenScreen;
        }

        public void inject(CheckoutTokenScreen checkoutTokenScreen) {
            injectCheckoutTokenScreen(checkoutTokenScreen);
        }
    }

    public static final class Factory implements CheckoutTokenScreenComponent.Factory {
        private Factory() {
        }

        public CheckoutTokenScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, FeesFeatureApi feesFeatureApi, ObservabilityCoreLibApi observabilityCoreLibApi, TokenizationFeatureApi tokenizationFeatureApi, DeepLinkCoreLibApi deepLinkCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(feesFeatureApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(tokenizationFeatureApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            return new CheckoutTokenScreenComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, contextCoreLibApi, featureFlagCoreLibApi, feesFeatureApi, observabilityCoreLibApi, tokenizationFeatureApi, deepLinkCoreLibApi);
        }
    }

    private DaggerCheckoutTokenScreenComponent() {
    }

    public static CheckoutTokenScreenComponent.Factory factory() {
        return new Factory();
    }
}
