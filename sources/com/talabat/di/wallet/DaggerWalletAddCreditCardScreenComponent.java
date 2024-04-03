package com.talabat.di.wallet;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.di.wallet.WalletAddCreditCardScreenComponent;
import com.talabat.feature.tokenization.domain.TokenizationFeatureApi;
import com.talabat.feature.tokenization.domain.TokenizationRepository;
import com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase;
import com.talabat.feature.tokenization.domain.usecase.GetTokenizationPublicKeyUseCase;
import com.talabat.feature.tokenization.domain.usecase.ObserveTokenizationFailedUseCase;
import com.talabat.feature.tokenization.domain.usecase.ObserveTokenizationSuccessUseCase;
import com.talabat.wallet.screens.walletAddCard.view.WalletAddCreditCardScreen;
import com.talabat.wallet.screens.walletAddCard.view.WalletAddCreditCardScreen_MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerWalletAddCreditCardScreenComponent {

    public static final class Factory implements WalletAddCreditCardScreenComponent.Factory {
        private Factory() {
        }

        public WalletAddCreditCardScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, TokenizationFeatureApi tokenizationFeatureApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(tokenizationFeatureApi);
            return new WalletAddCreditCardScreenComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, contextCoreLibApi, featureFlagCoreLibApi, observabilityCoreLibApi, tokenizationFeatureApi);
        }
    }

    public static final class WalletAddCreditCardScreenComponentImpl implements WalletAddCreditCardScreenComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private final TokenizationFeatureApi tokenizationFeatureApi;
        private final WalletAddCreditCardScreenComponentImpl walletAddCreditCardScreenComponentImpl;

        private WalletAddCreditCardScreenComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi2, TokenizationFeatureApi tokenizationFeatureApi2) {
            this.walletAddCreditCardScreenComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.tokenizationFeatureApi = tokenizationFeatureApi2;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
        }

        private GenerateCardTokenUseCase generateCardTokenUseCase() {
            return new GenerateCardTokenUseCase((TokenizationRepository) Preconditions.checkNotNullFromComponent(this.tokenizationFeatureApi.getRepository()), getTokenizationPublicKeyUseCase(), observeTokenizationFailedUseCase(), observeTokenizationSuccessUseCase());
        }

        private GetTokenizationPublicKeyUseCase getTokenizationPublicKeyUseCase() {
            return new GetTokenizationPublicKeyUseCase((TokenizationRepository) Preconditions.checkNotNullFromComponent(this.tokenizationFeatureApi.getRepository()), (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
        }

        @CanIgnoreReturnValue
        private WalletAddCreditCardScreen injectWalletAddCreditCardScreen(WalletAddCreditCardScreen walletAddCreditCardScreen) {
            WalletAddCreditCardScreen_MembersInjector.injectConfigurationLocalRepository(walletAddCreditCardScreen, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            WalletAddCreditCardScreen_MembersInjector.injectLocationConfigurationRepository(walletAddCreditCardScreen, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            WalletAddCreditCardScreen_MembersInjector.injectPaymentConfigurationRepository(walletAddCreditCardScreen, (PaymentConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getPaymentConfigurationRepository()));
            WalletAddCreditCardScreen_MembersInjector.injectGenerateCardTokenUseCase(walletAddCreditCardScreen, generateCardTokenUseCase());
            return walletAddCreditCardScreen;
        }

        private ObserveTokenizationFailedUseCase observeTokenizationFailedUseCase() {
            return new ObserveTokenizationFailedUseCase((IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
        }

        private ObserveTokenizationSuccessUseCase observeTokenizationSuccessUseCase() {
            return new ObserveTokenizationSuccessUseCase((IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
        }

        public void inject(WalletAddCreditCardScreen walletAddCreditCardScreen) {
            injectWalletAddCreditCardScreen(walletAddCreditCardScreen);
        }
    }

    private DaggerWalletAddCreditCardScreenComponent() {
    }

    public static WalletAddCreditCardScreenComponent.Factory factory() {
        return new Factory();
    }
}
