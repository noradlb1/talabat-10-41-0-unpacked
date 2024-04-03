package com.talabat.wallet.ui.walletCardManagement.view.walletCardList;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase;
import com.talabat.talabatcommon.feature.walletCardManagement.network.WalletCardManagementApi;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class WalletCardManagementFragment_MembersInjector implements MembersInjector<WalletCardManagementFragment> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<CoroutineDispatchersFactory> coroutineDispatchersFactoryProvider;
    private final Provider<DeepLinkNavigator> deeplinkNavigatorProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagRepoProvider;
    private final Provider<GenerateCardTokenUseCase> generateCardTokenUseCaseProvider;
    private final Provider<Navigator> navigatorProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<PaymentConfigurationRepository> paymentConfigurationRepositoryProvider;
    private final Provider<TalabatTracker> trackerProvider;
    private final Provider<WalletCardManagementApi> walletCardManagementApiProvider;

    public WalletCardManagementFragment_MembersInjector(Provider<ConfigurationLocalRepository> provider, Provider<PaymentConfigurationRepository> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<TalabatTracker> provider4, Provider<CoroutineDispatchersFactory> provider5, Provider<IObservabilityManager> provider6, Provider<WalletCardManagementApi> provider7, Provider<GenerateCardTokenUseCase> provider8, Provider<DeepLinkNavigator> provider9, Provider<Navigator> provider10) {
        this.configurationLocalRepositoryProvider = provider;
        this.paymentConfigurationRepositoryProvider = provider2;
        this.featureFlagRepoProvider = provider3;
        this.trackerProvider = provider4;
        this.coroutineDispatchersFactoryProvider = provider5;
        this.observabilityManagerProvider = provider6;
        this.walletCardManagementApiProvider = provider7;
        this.generateCardTokenUseCaseProvider = provider8;
        this.deeplinkNavigatorProvider = provider9;
        this.navigatorProvider = provider10;
    }

    public static MembersInjector<WalletCardManagementFragment> create(Provider<ConfigurationLocalRepository> provider, Provider<PaymentConfigurationRepository> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<TalabatTracker> provider4, Provider<CoroutineDispatchersFactory> provider5, Provider<IObservabilityManager> provider6, Provider<WalletCardManagementApi> provider7, Provider<GenerateCardTokenUseCase> provider8, Provider<DeepLinkNavigator> provider9, Provider<Navigator> provider10) {
        return new WalletCardManagementFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletCardManagement.view.walletCardList.WalletCardManagementFragment.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(WalletCardManagementFragment walletCardManagementFragment, ConfigurationLocalRepository configurationLocalRepository) {
        walletCardManagementFragment.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletCardManagement.view.walletCardList.WalletCardManagementFragment.coroutineDispatchersFactory")
    public static void injectCoroutineDispatchersFactory(WalletCardManagementFragment walletCardManagementFragment, CoroutineDispatchersFactory coroutineDispatchersFactory) {
        walletCardManagementFragment.coroutineDispatchersFactory = coroutineDispatchersFactory;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletCardManagement.view.walletCardList.WalletCardManagementFragment.deeplinkNavigator")
    public static void injectDeeplinkNavigator(WalletCardManagementFragment walletCardManagementFragment, DeepLinkNavigator deepLinkNavigator) {
        walletCardManagementFragment.deeplinkNavigator = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletCardManagement.view.walletCardList.WalletCardManagementFragment.featureFlagRepo")
    public static void injectFeatureFlagRepo(WalletCardManagementFragment walletCardManagementFragment, ITalabatFeatureFlag iTalabatFeatureFlag) {
        walletCardManagementFragment.featureFlagRepo = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletCardManagement.view.walletCardList.WalletCardManagementFragment.generateCardTokenUseCase")
    public static void injectGenerateCardTokenUseCase(WalletCardManagementFragment walletCardManagementFragment, GenerateCardTokenUseCase generateCardTokenUseCase) {
        walletCardManagementFragment.generateCardTokenUseCase = generateCardTokenUseCase;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletCardManagement.view.walletCardList.WalletCardManagementFragment.navigator")
    public static void injectNavigator(WalletCardManagementFragment walletCardManagementFragment, Navigator navigator) {
        walletCardManagementFragment.navigator = navigator;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletCardManagement.view.walletCardList.WalletCardManagementFragment.observabilityManager")
    public static void injectObservabilityManager(WalletCardManagementFragment walletCardManagementFragment, IObservabilityManager iObservabilityManager) {
        walletCardManagementFragment.observabilityManager = iObservabilityManager;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletCardManagement.view.walletCardList.WalletCardManagementFragment.paymentConfigurationRepository")
    public static void injectPaymentConfigurationRepository(WalletCardManagementFragment walletCardManagementFragment, PaymentConfigurationRepository paymentConfigurationRepository) {
        walletCardManagementFragment.paymentConfigurationRepository = paymentConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletCardManagement.view.walletCardList.WalletCardManagementFragment.tracker")
    public static void injectTracker(WalletCardManagementFragment walletCardManagementFragment, TalabatTracker talabatTracker) {
        walletCardManagementFragment.tracker = talabatTracker;
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletCardManagement.view.walletCardList.WalletCardManagementFragment.walletCardManagementApi")
    public static void injectWalletCardManagementApi(WalletCardManagementFragment walletCardManagementFragment, WalletCardManagementApi walletCardManagementApi) {
        walletCardManagementFragment.walletCardManagementApi = walletCardManagementApi;
    }

    public void injectMembers(WalletCardManagementFragment walletCardManagementFragment) {
        injectConfigurationLocalRepository(walletCardManagementFragment, this.configurationLocalRepositoryProvider.get());
        injectPaymentConfigurationRepository(walletCardManagementFragment, this.paymentConfigurationRepositoryProvider.get());
        injectFeatureFlagRepo(walletCardManagementFragment, this.featureFlagRepoProvider.get());
        injectTracker(walletCardManagementFragment, this.trackerProvider.get());
        injectCoroutineDispatchersFactory(walletCardManagementFragment, this.coroutineDispatchersFactoryProvider.get());
        injectObservabilityManager(walletCardManagementFragment, this.observabilityManagerProvider.get());
        injectWalletCardManagementApi(walletCardManagementFragment, this.walletCardManagementApiProvider.get());
        injectGenerateCardTokenUseCase(walletCardManagementFragment, this.generateCardTokenUseCaseProvider.get());
        injectDeeplinkNavigator(walletCardManagementFragment, this.deeplinkNavigatorProvider.get());
        injectNavigator(walletCardManagementFragment, this.navigatorProvider.get());
    }
}
