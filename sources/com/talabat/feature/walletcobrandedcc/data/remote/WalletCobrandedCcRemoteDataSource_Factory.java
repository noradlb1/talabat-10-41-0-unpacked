package com.talabat.feature.walletcobrandedcc.data.remote;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class WalletCobrandedCcRemoteDataSource_Factory implements Factory<WalletCobrandedCcRemoteDataSource> {
    private final Provider<WalletCobrandedCcApi> walletCobrandedCcApiProvider;

    public WalletCobrandedCcRemoteDataSource_Factory(Provider<WalletCobrandedCcApi> provider) {
        this.walletCobrandedCcApiProvider = provider;
    }

    public static WalletCobrandedCcRemoteDataSource_Factory create(Provider<WalletCobrandedCcApi> provider) {
        return new WalletCobrandedCcRemoteDataSource_Factory(provider);
    }

    public static WalletCobrandedCcRemoteDataSource newInstance(WalletCobrandedCcApi walletCobrandedCcApi) {
        return new WalletCobrandedCcRemoteDataSource(walletCobrandedCcApi);
    }

    public WalletCobrandedCcRemoteDataSource get() {
        return newInstance(this.walletCobrandedCcApiProvider.get());
    }
}
