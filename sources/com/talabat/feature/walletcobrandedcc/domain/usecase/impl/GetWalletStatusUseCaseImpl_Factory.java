package com.talabat.feature.walletcobrandedcc.domain.usecase.impl;

import com.talabat.feature.walletcobrandedcc.domain.WalletCobrandedCcRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetWalletStatusUseCaseImpl_Factory implements Factory<GetWalletStatusUseCaseImpl> {
    private final Provider<WalletCobrandedCcRepository> walletCobrandedCcRepositoryProvider;

    public GetWalletStatusUseCaseImpl_Factory(Provider<WalletCobrandedCcRepository> provider) {
        this.walletCobrandedCcRepositoryProvider = provider;
    }

    public static GetWalletStatusUseCaseImpl_Factory create(Provider<WalletCobrandedCcRepository> provider) {
        return new GetWalletStatusUseCaseImpl_Factory(provider);
    }

    public static GetWalletStatusUseCaseImpl newInstance(WalletCobrandedCcRepository walletCobrandedCcRepository) {
        return new GetWalletStatusUseCaseImpl(walletCobrandedCcRepository);
    }

    public GetWalletStatusUseCaseImpl get() {
        return newInstance(this.walletCobrandedCcRepositoryProvider.get());
    }
}
