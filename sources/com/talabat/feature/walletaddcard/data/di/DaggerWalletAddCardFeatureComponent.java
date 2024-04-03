package com.talabat.feature.walletaddcard.data.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
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
import com.talabat.feature.walletaddcard.data.WalletAddCardRepositoryImpl;
import com.talabat.feature.walletaddcard.data.WalletAddCardRepositoryImpl_Factory;
import com.talabat.feature.walletaddcard.data.di.WalletAddCardFeatureComponent;
import com.talabat.feature.walletaddcard.domain.WalletAddCardRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerWalletAddCardFeatureComponent {

    public static final class Factory implements WalletAddCardFeatureComponent.Factory {
        private Factory() {
        }

        public WalletAddCardFeatureComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, TokenizationFeatureApi tokenizationFeatureApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(tokenizationFeatureApi);
            return new WalletAddCardFeatureComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, contextCoreLibApi, featureFlagCoreLibApi, observabilityCoreLibApi, tokenizationFeatureApi);
        }
    }

    public static final class WalletAddCardFeatureComponentImpl implements WalletAddCardFeatureComponent {
        private Provider<GenerateCardTokenUseCase> generateCardTokenUseCaseProvider;
        private Provider<IObservabilityManager> getObservabilityManagerProvider;
        private Provider<ConfigurationLocalRepository> getRepositoryProvider;
        private Provider<TokenizationRepository> getRepositoryProvider2;
        private Provider<ITalabatFeatureFlag> getTalabatFeatureFlagProvider;
        private Provider<GetTokenizationPublicKeyUseCase> getTokenizationPublicKeyUseCaseProvider;
        private Provider<ObserveTokenizationFailedUseCase> observeTokenizationFailedUseCaseProvider;
        private Provider<ObserveTokenizationSuccessUseCase> observeTokenizationSuccessUseCaseProvider;
        private final WalletAddCardFeatureComponentImpl walletAddCardFeatureComponentImpl;
        private Provider<WalletAddCardRepositoryImpl> walletAddCardRepositoryImplProvider;
        private Provider<WalletAddCardRepository> walletAddCardRepositoryProvider;

        public static final class GetObservabilityManagerProvider implements Provider<IObservabilityManager> {
            private final ObservabilityCoreLibApi observabilityCoreLibApi;

            public GetObservabilityManagerProvider(ObservabilityCoreLibApi observabilityCoreLibApi2) {
                this.observabilityCoreLibApi = observabilityCoreLibApi2;
            }

            public IObservabilityManager get() {
                return (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager());
            }
        }

        public static final class GetRepositoryProvider implements Provider<ConfigurationLocalRepository> {
            private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;

            public GetRepositoryProvider(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2) {
                this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            }

            public ConfigurationLocalRepository get() {
                return (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository());
            }
        }

        public static final class GetRepositoryProvider2 implements Provider<TokenizationRepository> {
            private final TokenizationFeatureApi tokenizationFeatureApi;

            public GetRepositoryProvider2(TokenizationFeatureApi tokenizationFeatureApi2) {
                this.tokenizationFeatureApi = tokenizationFeatureApi2;
            }

            public TokenizationRepository get() {
                return (TokenizationRepository) Preconditions.checkNotNullFromComponent(this.tokenizationFeatureApi.getRepository());
            }
        }

        public static final class GetTalabatFeatureFlagProvider implements Provider<ITalabatFeatureFlag> {
            private final FeatureFlagCoreLibApi featureFlagCoreLibApi;

            public GetTalabatFeatureFlagProvider(FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
                this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            }

            public ITalabatFeatureFlag get() {
                return (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag());
            }
        }

        private WalletAddCardFeatureComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, TokenizationFeatureApi tokenizationFeatureApi) {
            this.walletAddCardFeatureComponentImpl = this;
            initialize(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, contextCoreLibApi, featureFlagCoreLibApi, observabilityCoreLibApi, tokenizationFeatureApi);
        }

        private void initialize(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, TokenizationFeatureApi tokenizationFeatureApi) {
            this.getTalabatFeatureFlagProvider = new GetTalabatFeatureFlagProvider(featureFlagCoreLibApi);
            this.getRepositoryProvider = new GetRepositoryProvider(configurationLocalCoreLibApi);
            GetRepositoryProvider2 getRepositoryProvider22 = new GetRepositoryProvider2(tokenizationFeatureApi);
            this.getRepositoryProvider2 = getRepositoryProvider22;
            this.getTokenizationPublicKeyUseCaseProvider = GetTokenizationPublicKeyUseCase_Factory.create(getRepositoryProvider22, this.getRepositoryProvider);
            GetObservabilityManagerProvider getObservabilityManagerProvider2 = new GetObservabilityManagerProvider(observabilityCoreLibApi);
            this.getObservabilityManagerProvider = getObservabilityManagerProvider2;
            this.observeTokenizationFailedUseCaseProvider = ObserveTokenizationFailedUseCase_Factory.create(getObservabilityManagerProvider2);
            ObserveTokenizationSuccessUseCase_Factory create = ObserveTokenizationSuccessUseCase_Factory.create(this.getObservabilityManagerProvider);
            this.observeTokenizationSuccessUseCaseProvider = create;
            GenerateCardTokenUseCase_Factory create2 = GenerateCardTokenUseCase_Factory.create(this.getRepositoryProvider2, this.getTokenizationPublicKeyUseCaseProvider, this.observeTokenizationFailedUseCaseProvider, create);
            this.generateCardTokenUseCaseProvider = create2;
            WalletAddCardRepositoryImpl_Factory create3 = WalletAddCardRepositoryImpl_Factory.create(this.getTalabatFeatureFlagProvider, this.getRepositoryProvider, create2);
            this.walletAddCardRepositoryImplProvider = create3;
            this.walletAddCardRepositoryProvider = SingleCheck.provider(create3);
        }

        public WalletAddCardRepository getRepository() {
            return this.walletAddCardRepositoryProvider.get();
        }
    }

    private DaggerWalletAddCardFeatureComponent() {
    }

    public static WalletAddCardFeatureComponent.Factory factory() {
        return new Factory();
    }
}
