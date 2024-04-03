package com.talabat.wallet.ui.walletCardManagement.view.walletCardList.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.feature.tokenization.domain.TokenizationFeatureApi;
import com.talabat.feature.tokenization.domain.TokenizationRepository;
import com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase;
import com.talabat.feature.tokenization.domain.usecase.GetTokenizationPublicKeyUseCase;
import com.talabat.feature.tokenization.domain.usecase.ObserveTokenizationFailedUseCase;
import com.talabat.feature.tokenization.domain.usecase.ObserveTokenizationSuccessUseCase;
import com.talabat.talabatcommon.feature.walletCardManagement.network.WalletCardManagementApi;
import com.talabat.talabatcommon.feature.walletCardManagement.network.WalletCardManagementBaseUrl_Factory;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.di.AddCardCustomViewModule_ProvideWalletCardManagementApiFactory;
import com.talabat.wallet.ui.walletCardManagement.view.walletCardList.WalletCardManagementFragment;
import com.talabat.wallet.ui.walletCardManagement.view.walletCardList.WalletCardManagementFragment_MembersInjector;
import com.talabat.wallet.ui.walletCardManagement.view.walletCardList.di.WalletCardManagementFragmentComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
import retrofit2.Retrofit;

@DaggerGenerated
public final class DaggerWalletCardManagementFragmentComponent {

    public static final class Factory implements WalletCardManagementFragmentComponent.Factory {
        private Factory() {
        }

        public WalletCardManagementFragmentComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, DeepLinkCoreLibApi deepLinkCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, NetworkCoreLibApi networkCoreLibApi, NavigationCoreLibApi navigationCoreLibApi, TrackingCoreLibApi trackingCoreLibApi, TokenizationFeatureApi tokenizationFeatureApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(networkCoreLibApi);
            Preconditions.checkNotNull(navigationCoreLibApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            Preconditions.checkNotNull(tokenizationFeatureApi);
            return new WalletCardManagementFragmentComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, deepLinkCoreLibApi, dispatcherCoreLibApi, featureFlagCoreLibApi, observabilityCoreLibApi, networkCoreLibApi, navigationCoreLibApi, trackingCoreLibApi, tokenizationFeatureApi);
        }
    }

    public static final class WalletCardManagementFragmentComponentImpl implements WalletCardManagementFragmentComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final DispatcherCoreLibApi dispatcherCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private Provider<BaseUrlFactory> getBaseUrlFactoryProvider;
        private Provider<Retrofit.Builder> getRetrofitWithMoshiProvider;
        private final NavigationCoreLibApi navigationCoreLibApi;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private Provider<WalletCardManagementApi> provideWalletCardManagementApiProvider;
        private final TokenizationFeatureApi tokenizationFeatureApi;
        private final TrackingCoreLibApi trackingCoreLibApi;
        private final WalletCardManagementFragmentComponentImpl walletCardManagementFragmentComponentImpl;

        public static final class GetBaseUrlFactoryProvider implements Provider<BaseUrlFactory> {
            private final NetworkCoreLibApi networkCoreLibApi;

            public GetBaseUrlFactoryProvider(NetworkCoreLibApi networkCoreLibApi2) {
                this.networkCoreLibApi = networkCoreLibApi2;
            }

            public BaseUrlFactory get() {
                return (BaseUrlFactory) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getBaseUrlFactory());
            }
        }

        public static final class GetRetrofitWithMoshiProvider implements Provider<Retrofit.Builder> {
            private final NetworkCoreLibApi networkCoreLibApi;

            public GetRetrofitWithMoshiProvider(NetworkCoreLibApi networkCoreLibApi2) {
                this.networkCoreLibApi = networkCoreLibApi2;
            }

            public Retrofit.Builder get() {
                return (Retrofit.Builder) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getRetrofitWithMoshi());
            }
        }

        private WalletCardManagementFragmentComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2, DispatcherCoreLibApi dispatcherCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, NetworkCoreLibApi networkCoreLibApi, NavigationCoreLibApi navigationCoreLibApi2, TrackingCoreLibApi trackingCoreLibApi2, TokenizationFeatureApi tokenizationFeatureApi2) {
            this.walletCardManagementFragmentComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.trackingCoreLibApi = trackingCoreLibApi2;
            this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
            this.tokenizationFeatureApi = tokenizationFeatureApi2;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
            this.navigationCoreLibApi = navigationCoreLibApi2;
            initialize(configurationLocalCoreLibApi2, configurationRemoteCoreLibApi2, deepLinkCoreLibApi2, dispatcherCoreLibApi2, featureFlagCoreLibApi2, observabilityCoreLibApi2, networkCoreLibApi, navigationCoreLibApi2, trackingCoreLibApi2, tokenizationFeatureApi2);
        }

        private GenerateCardTokenUseCase generateCardTokenUseCase() {
            return new GenerateCardTokenUseCase((TokenizationRepository) Preconditions.checkNotNullFromComponent(this.tokenizationFeatureApi.getRepository()), getTokenizationPublicKeyUseCase(), observeTokenizationFailedUseCase(), observeTokenizationSuccessUseCase());
        }

        private GetTokenizationPublicKeyUseCase getTokenizationPublicKeyUseCase() {
            return new GetTokenizationPublicKeyUseCase((TokenizationRepository) Preconditions.checkNotNullFromComponent(this.tokenizationFeatureApi.getRepository()), (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
        }

        private void initialize(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2, DispatcherCoreLibApi dispatcherCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, NetworkCoreLibApi networkCoreLibApi, NavigationCoreLibApi navigationCoreLibApi2, TrackingCoreLibApi trackingCoreLibApi2, TokenizationFeatureApi tokenizationFeatureApi2) {
            this.getRetrofitWithMoshiProvider = new GetRetrofitWithMoshiProvider(networkCoreLibApi);
            GetBaseUrlFactoryProvider getBaseUrlFactoryProvider2 = new GetBaseUrlFactoryProvider(networkCoreLibApi);
            this.getBaseUrlFactoryProvider = getBaseUrlFactoryProvider2;
            this.provideWalletCardManagementApiProvider = SingleCheck.provider(AddCardCustomViewModule_ProvideWalletCardManagementApiFactory.create(this.getRetrofitWithMoshiProvider, getBaseUrlFactoryProvider2, WalletCardManagementBaseUrl_Factory.create()));
        }

        private WalletCardManagementFragment injectWalletCardManagementFragment(WalletCardManagementFragment walletCardManagementFragment) {
            WalletCardManagementFragment_MembersInjector.injectConfigurationLocalRepository(walletCardManagementFragment, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            WalletCardManagementFragment_MembersInjector.injectPaymentConfigurationRepository(walletCardManagementFragment, (PaymentConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getPaymentConfigurationRepository()));
            WalletCardManagementFragment_MembersInjector.injectFeatureFlagRepo(walletCardManagementFragment, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            WalletCardManagementFragment_MembersInjector.injectTracker(walletCardManagementFragment, (TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker()));
            WalletCardManagementFragment_MembersInjector.injectCoroutineDispatchersFactory(walletCardManagementFragment, (CoroutineDispatchersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getCoroutineDispatchersFactory()));
            WalletCardManagementFragment_MembersInjector.injectObservabilityManager(walletCardManagementFragment, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
            WalletCardManagementFragment_MembersInjector.injectWalletCardManagementApi(walletCardManagementFragment, this.provideWalletCardManagementApiProvider.get());
            WalletCardManagementFragment_MembersInjector.injectGenerateCardTokenUseCase(walletCardManagementFragment, generateCardTokenUseCase());
            WalletCardManagementFragment_MembersInjector.injectDeeplinkNavigator(walletCardManagementFragment, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            WalletCardManagementFragment_MembersInjector.injectNavigator(walletCardManagementFragment, (Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator()));
            return walletCardManagementFragment;
        }

        private ObserveTokenizationFailedUseCase observeTokenizationFailedUseCase() {
            return new ObserveTokenizationFailedUseCase((IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
        }

        private ObserveTokenizationSuccessUseCase observeTokenizationSuccessUseCase() {
            return new ObserveTokenizationSuccessUseCase((IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
        }

        public void inject(WalletCardManagementFragment walletCardManagementFragment) {
            injectWalletCardManagementFragment(walletCardManagementFragment);
        }
    }

    private DaggerWalletCardManagementFragmentComponent() {
    }

    public static WalletCardManagementFragmentComponent.Factory factory() {
        return new Factory();
    }
}
