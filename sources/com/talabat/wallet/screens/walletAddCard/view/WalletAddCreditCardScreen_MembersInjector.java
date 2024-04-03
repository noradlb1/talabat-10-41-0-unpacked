package com.talabat.wallet.screens.walletAddCard.view;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class WalletAddCreditCardScreen_MembersInjector implements MembersInjector<WalletAddCreditCardScreen> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<GenerateCardTokenUseCase> generateCardTokenUseCaseProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<PaymentConfigurationRepository> paymentConfigurationRepositoryProvider;

    public WalletAddCreditCardScreen_MembersInjector(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2, Provider<PaymentConfigurationRepository> provider3, Provider<GenerateCardTokenUseCase> provider4) {
        this.configurationLocalRepositoryProvider = provider;
        this.locationConfigurationRepositoryProvider = provider2;
        this.paymentConfigurationRepositoryProvider = provider3;
        this.generateCardTokenUseCaseProvider = provider4;
    }

    public static MembersInjector<WalletAddCreditCardScreen> create(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2, Provider<PaymentConfigurationRepository> provider3, Provider<GenerateCardTokenUseCase> provider4) {
        return new WalletAddCreditCardScreen_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.talabat.wallet.screens.walletAddCard.view.WalletAddCreditCardScreen.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(WalletAddCreditCardScreen walletAddCreditCardScreen, ConfigurationLocalRepository configurationLocalRepository) {
        walletAddCreditCardScreen.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.wallet.screens.walletAddCard.view.WalletAddCreditCardScreen.generateCardTokenUseCase")
    public static void injectGenerateCardTokenUseCase(WalletAddCreditCardScreen walletAddCreditCardScreen, GenerateCardTokenUseCase generateCardTokenUseCase) {
        walletAddCreditCardScreen.generateCardTokenUseCase = generateCardTokenUseCase;
    }

    @InjectedFieldSignature("com.talabat.wallet.screens.walletAddCard.view.WalletAddCreditCardScreen.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(WalletAddCreditCardScreen walletAddCreditCardScreen, LocationConfigurationRepository locationConfigurationRepository) {
        walletAddCreditCardScreen.locationConfigurationRepository = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.wallet.screens.walletAddCard.view.WalletAddCreditCardScreen.paymentConfigurationRepository")
    public static void injectPaymentConfigurationRepository(WalletAddCreditCardScreen walletAddCreditCardScreen, PaymentConfigurationRepository paymentConfigurationRepository) {
        walletAddCreditCardScreen.paymentConfigurationRepository = paymentConfigurationRepository;
    }

    public void injectMembers(WalletAddCreditCardScreen walletAddCreditCardScreen) {
        injectConfigurationLocalRepository(walletAddCreditCardScreen, this.configurationLocalRepositoryProvider.get());
        injectLocationConfigurationRepository(walletAddCreditCardScreen, this.locationConfigurationRepositoryProvider.get());
        injectPaymentConfigurationRepository(walletAddCreditCardScreen, this.paymentConfigurationRepositoryProvider.get());
        injectGenerateCardTokenUseCase(walletAddCreditCardScreen, this.generateCardTokenUseCaseProvider.get());
    }
}
