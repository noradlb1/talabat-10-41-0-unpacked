package com.talabat.talabatcommon.views.wallet.walletCardManagement.view.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
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
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.AddCardCustomView;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.AddCardCustomView_MembersInjector;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.di.AddCardCustomViewComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
import retrofit2.Retrofit;

@DaggerGenerated
public final class DaggerAddCardCustomViewComponent {

    public static final class AddCardCustomViewComponentImpl implements AddCardCustomViewComponent {
        private final AddCardCustomViewComponentImpl addCardCustomViewComponentImpl;
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final DispatcherCoreLibApi dispatcherCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private Provider<BaseUrlFactory> getBaseUrlFactoryProvider;
        private Provider<Retrofit.Builder> getRetrofitWithMoshiProvider;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private Provider<WalletCardManagementApi> provideWalletCardManagementApiProvider;
        private final TokenizationFeatureApi tokenizationFeatureApi;
        private final TrackingCoreLibApi trackingCoreLibApi;

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

        private AddCardCustomViewComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, DispatcherCoreLibApi dispatcherCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, NetworkCoreLibApi networkCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi2, TrackingCoreLibApi trackingCoreLibApi2, TokenizationFeatureApi tokenizationFeatureApi2) {
            this.addCardCustomViewComponentImpl = this;
            this.tokenizationFeatureApi = tokenizationFeatureApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.trackingCoreLibApi = trackingCoreLibApi2;
            this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            initialize(configurationLocalCoreLibApi2, configurationRemoteCoreLibApi2, dispatcherCoreLibApi2, featureFlagCoreLibApi2, networkCoreLibApi, observabilityCoreLibApi2, trackingCoreLibApi2, tokenizationFeatureApi2);
        }

        private GenerateCardTokenUseCase generateCardTokenUseCase() {
            return new GenerateCardTokenUseCase((TokenizationRepository) Preconditions.checkNotNullFromComponent(this.tokenizationFeatureApi.getRepository()), getTokenizationPublicKeyUseCase(), observeTokenizationFailedUseCase(), observeTokenizationSuccessUseCase());
        }

        private GetTokenizationPublicKeyUseCase getTokenizationPublicKeyUseCase() {
            return new GetTokenizationPublicKeyUseCase((TokenizationRepository) Preconditions.checkNotNullFromComponent(this.tokenizationFeatureApi.getRepository()), (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
        }

        private void initialize(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, DispatcherCoreLibApi dispatcherCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, NetworkCoreLibApi networkCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi2, TrackingCoreLibApi trackingCoreLibApi2, TokenizationFeatureApi tokenizationFeatureApi2) {
            this.getRetrofitWithMoshiProvider = new GetRetrofitWithMoshiProvider(networkCoreLibApi);
            GetBaseUrlFactoryProvider getBaseUrlFactoryProvider2 = new GetBaseUrlFactoryProvider(networkCoreLibApi);
            this.getBaseUrlFactoryProvider = getBaseUrlFactoryProvider2;
            this.provideWalletCardManagementApiProvider = SingleCheck.provider(AddCardCustomViewModule_ProvideWalletCardManagementApiFactory.create(this.getRetrofitWithMoshiProvider, getBaseUrlFactoryProvider2, WalletCardManagementBaseUrl_Factory.create()));
        }

        private AddCardCustomView injectAddCardCustomView(AddCardCustomView addCardCustomView) {
            AddCardCustomView_MembersInjector.injectGenerateCardTokenUseCase(addCardCustomView, generateCardTokenUseCase());
            AddCardCustomView_MembersInjector.injectPaymentConfigurationRepository(addCardCustomView, (PaymentConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getPaymentConfigurationRepository()));
            AddCardCustomView_MembersInjector.injectFeatureFlagRepo(addCardCustomView, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            AddCardCustomView_MembersInjector.injectTracker(addCardCustomView, (TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker()));
            AddCardCustomView_MembersInjector.injectCoroutineDispatchersFactory(addCardCustomView, (CoroutineDispatchersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getCoroutineDispatchersFactory()));
            AddCardCustomView_MembersInjector.injectObservabilityManager(addCardCustomView, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
            AddCardCustomView_MembersInjector.injectWalletCardManagementApi(addCardCustomView, this.provideWalletCardManagementApiProvider.get());
            return addCardCustomView;
        }

        private ObserveTokenizationFailedUseCase observeTokenizationFailedUseCase() {
            return new ObserveTokenizationFailedUseCase((IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
        }

        private ObserveTokenizationSuccessUseCase observeTokenizationSuccessUseCase() {
            return new ObserveTokenizationSuccessUseCase((IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
        }

        public void inject(AddCardCustomView addCardCustomView) {
            injectAddCardCustomView(addCardCustomView);
        }
    }

    public static final class Factory implements AddCardCustomViewComponent.Factory {
        private Factory() {
        }

        public AddCardCustomViewComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NetworkCoreLibApi networkCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, TrackingCoreLibApi trackingCoreLibApi, TokenizationFeatureApi tokenizationFeatureApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(networkCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            Preconditions.checkNotNull(tokenizationFeatureApi);
            return new AddCardCustomViewComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, dispatcherCoreLibApi, featureFlagCoreLibApi, networkCoreLibApi, observabilityCoreLibApi, trackingCoreLibApi, tokenizationFeatureApi);
        }
    }

    private DaggerAddCardCustomViewComponent() {
    }

    public static AddCardCustomViewComponent.Factory factory() {
        return new Factory();
    }
}
