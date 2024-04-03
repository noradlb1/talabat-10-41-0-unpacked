package com.talabat.feature.walletaddcard.presentation.channel;

import com.talabat.feature.walletaddcard.domain.usecase.GetCardTokenUseCase;
import com.talabat.feature.walletaddcard.domain.usecase.IsBenefitEnabledUseCase;
import com.talabat.feature.walletaddcard.domain.usecase.IsQPayEnabledUseCase;
import com.talabat.feature.walletaddcard.presentation.channel.WalletMethodCallHandler;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineScope;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class WalletMethodCallHandler_Factory implements Factory<WalletMethodCallHandler> {
    private final Provider<CoroutineScope> coroutineScopeProvider;
    private final Provider<GetCardTokenUseCase> getCardTokenUseCaseProvider;
    private final Provider<IsBenefitEnabledUseCase> isBenefitEnabledUseCaseProvider;
    private final Provider<IsQPayEnabledUseCase> isQPayEnabledUseCaseProvider;
    private final Provider<WalletMethodCallHandler.WalletAddCardMethodChannelCallback> walletAddCardMethodChannelCallbackProvider;

    public WalletMethodCallHandler_Factory(Provider<GetCardTokenUseCase> provider, Provider<IsQPayEnabledUseCase> provider2, Provider<IsBenefitEnabledUseCase> provider3, Provider<CoroutineScope> provider4, Provider<WalletMethodCallHandler.WalletAddCardMethodChannelCallback> provider5) {
        this.getCardTokenUseCaseProvider = provider;
        this.isQPayEnabledUseCaseProvider = provider2;
        this.isBenefitEnabledUseCaseProvider = provider3;
        this.coroutineScopeProvider = provider4;
        this.walletAddCardMethodChannelCallbackProvider = provider5;
    }

    public static WalletMethodCallHandler_Factory create(Provider<GetCardTokenUseCase> provider, Provider<IsQPayEnabledUseCase> provider2, Provider<IsBenefitEnabledUseCase> provider3, Provider<CoroutineScope> provider4, Provider<WalletMethodCallHandler.WalletAddCardMethodChannelCallback> provider5) {
        return new WalletMethodCallHandler_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static WalletMethodCallHandler newInstance(GetCardTokenUseCase getCardTokenUseCase, IsQPayEnabledUseCase isQPayEnabledUseCase, IsBenefitEnabledUseCase isBenefitEnabledUseCase, CoroutineScope coroutineScope, WalletMethodCallHandler.WalletAddCardMethodChannelCallback walletAddCardMethodChannelCallback) {
        return new WalletMethodCallHandler(getCardTokenUseCase, isQPayEnabledUseCase, isBenefitEnabledUseCase, coroutineScope, walletAddCardMethodChannelCallback);
    }

    public WalletMethodCallHandler get() {
        return newInstance(this.getCardTokenUseCaseProvider.get(), this.isQPayEnabledUseCaseProvider.get(), this.isBenefitEnabledUseCaseProvider.get(), this.coroutineScopeProvider.get(), this.walletAddCardMethodChannelCallbackProvider.get());
    }
}
