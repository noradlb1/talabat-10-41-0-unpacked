package com.talabat.talabatcommon.views.wallet.walletCardManagement.view;

import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
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
public final class AddCardCustomView_MembersInjector implements MembersInjector<AddCardCustomView> {
    private final Provider<CoroutineDispatchersFactory> coroutineDispatchersFactoryProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagRepoProvider;
    private final Provider<GenerateCardTokenUseCase> generateCardTokenUseCaseProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<PaymentConfigurationRepository> paymentConfigurationRepositoryProvider;
    private final Provider<TalabatTracker> trackerProvider;
    private final Provider<WalletCardManagementApi> walletCardManagementApiProvider;

    public AddCardCustomView_MembersInjector(Provider<GenerateCardTokenUseCase> provider, Provider<PaymentConfigurationRepository> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<TalabatTracker> provider4, Provider<CoroutineDispatchersFactory> provider5, Provider<IObservabilityManager> provider6, Provider<WalletCardManagementApi> provider7) {
        this.generateCardTokenUseCaseProvider = provider;
        this.paymentConfigurationRepositoryProvider = provider2;
        this.featureFlagRepoProvider = provider3;
        this.trackerProvider = provider4;
        this.coroutineDispatchersFactoryProvider = provider5;
        this.observabilityManagerProvider = provider6;
        this.walletCardManagementApiProvider = provider7;
    }

    public static MembersInjector<AddCardCustomView> create(Provider<GenerateCardTokenUseCase> provider, Provider<PaymentConfigurationRepository> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<TalabatTracker> provider4, Provider<CoroutineDispatchersFactory> provider5, Provider<IObservabilityManager> provider6, Provider<WalletCardManagementApi> provider7) {
        return new AddCardCustomView_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.talabat.talabatcommon.views.wallet.walletCardManagement.view.AddCardCustomView.coroutineDispatchersFactory")
    public static void injectCoroutineDispatchersFactory(AddCardCustomView addCardCustomView, CoroutineDispatchersFactory coroutineDispatchersFactory) {
        addCardCustomView.coroutineDispatchersFactory = coroutineDispatchersFactory;
    }

    @InjectedFieldSignature("com.talabat.talabatcommon.views.wallet.walletCardManagement.view.AddCardCustomView.featureFlagRepo")
    public static void injectFeatureFlagRepo(AddCardCustomView addCardCustomView, ITalabatFeatureFlag iTalabatFeatureFlag) {
        addCardCustomView.featureFlagRepo = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.talabatcommon.views.wallet.walletCardManagement.view.AddCardCustomView.generateCardTokenUseCase")
    public static void injectGenerateCardTokenUseCase(AddCardCustomView addCardCustomView, GenerateCardTokenUseCase generateCardTokenUseCase) {
        addCardCustomView.generateCardTokenUseCase = generateCardTokenUseCase;
    }

    @InjectedFieldSignature("com.talabat.talabatcommon.views.wallet.walletCardManagement.view.AddCardCustomView.observabilityManager")
    public static void injectObservabilityManager(AddCardCustomView addCardCustomView, IObservabilityManager iObservabilityManager) {
        addCardCustomView.observabilityManager = iObservabilityManager;
    }

    @InjectedFieldSignature("com.talabat.talabatcommon.views.wallet.walletCardManagement.view.AddCardCustomView.paymentConfigurationRepository")
    public static void injectPaymentConfigurationRepository(AddCardCustomView addCardCustomView, PaymentConfigurationRepository paymentConfigurationRepository) {
        addCardCustomView.paymentConfigurationRepository = paymentConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.talabatcommon.views.wallet.walletCardManagement.view.AddCardCustomView.tracker")
    public static void injectTracker(AddCardCustomView addCardCustomView, TalabatTracker talabatTracker) {
        addCardCustomView.tracker = talabatTracker;
    }

    @InjectedFieldSignature("com.talabat.talabatcommon.views.wallet.walletCardManagement.view.AddCardCustomView.walletCardManagementApi")
    public static void injectWalletCardManagementApi(AddCardCustomView addCardCustomView, WalletCardManagementApi walletCardManagementApi) {
        addCardCustomView.walletCardManagementApi = walletCardManagementApi;
    }

    public void injectMembers(AddCardCustomView addCardCustomView) {
        injectGenerateCardTokenUseCase(addCardCustomView, this.generateCardTokenUseCaseProvider.get());
        injectPaymentConfigurationRepository(addCardCustomView, this.paymentConfigurationRepositoryProvider.get());
        injectFeatureFlagRepo(addCardCustomView, this.featureFlagRepoProvider.get());
        injectTracker(addCardCustomView, this.trackerProvider.get());
        injectCoroutineDispatchersFactory(addCardCustomView, this.coroutineDispatchersFactoryProvider.get());
        injectObservabilityManager(addCardCustomView, this.observabilityManagerProvider.get());
        injectWalletCardManagementApi(addCardCustomView, this.walletCardManagementApiProvider.get());
    }
}
