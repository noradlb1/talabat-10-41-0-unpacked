package com.talabat.feature.walletaddcard.domain.usecase;

import com.talabat.feature.walletaddcard.domain.WalletAddCardRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class IsQPayEnabledUseCase_Factory implements Factory<IsQPayEnabledUseCase> {
    private final Provider<WalletAddCardRepository> repositoryProvider;

    public IsQPayEnabledUseCase_Factory(Provider<WalletAddCardRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static IsQPayEnabledUseCase_Factory create(Provider<WalletAddCardRepository> provider) {
        return new IsQPayEnabledUseCase_Factory(provider);
    }

    public static IsQPayEnabledUseCase newInstance(WalletAddCardRepository walletAddCardRepository) {
        return new IsQPayEnabledUseCase(walletAddCardRepository);
    }

    public IsQPayEnabledUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
