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
public final class GetCardTokenUseCase_Factory implements Factory<GetCardTokenUseCase> {
    private final Provider<WalletAddCardRepository> repositoryProvider;

    public GetCardTokenUseCase_Factory(Provider<WalletAddCardRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static GetCardTokenUseCase_Factory create(Provider<WalletAddCardRepository> provider) {
        return new GetCardTokenUseCase_Factory(provider);
    }

    public static GetCardTokenUseCase newInstance(WalletAddCardRepository walletAddCardRepository) {
        return new GetCardTokenUseCase(walletAddCardRepository);
    }

    public GetCardTokenUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
