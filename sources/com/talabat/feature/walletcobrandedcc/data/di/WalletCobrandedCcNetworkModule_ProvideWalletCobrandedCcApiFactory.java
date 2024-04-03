package com.talabat.feature.walletcobrandedcc.data.di;

import com.talabat.feature.walletcobrandedcc.data.remote.WalletCobrandedCcApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class WalletCobrandedCcNetworkModule_ProvideWalletCobrandedCcApiFactory implements Factory<WalletCobrandedCcApi> {
    private final Provider<String> baseUrlProvider;

    public WalletCobrandedCcNetworkModule_ProvideWalletCobrandedCcApiFactory(Provider<String> provider) {
        this.baseUrlProvider = provider;
    }

    public static WalletCobrandedCcNetworkModule_ProvideWalletCobrandedCcApiFactory create(Provider<String> provider) {
        return new WalletCobrandedCcNetworkModule_ProvideWalletCobrandedCcApiFactory(provider);
    }

    public static WalletCobrandedCcApi provideWalletCobrandedCcApi(String str) {
        return (WalletCobrandedCcApi) Preconditions.checkNotNullFromProvides(WalletCobrandedCcNetworkModule.INSTANCE.provideWalletCobrandedCcApi(str));
    }

    public WalletCobrandedCcApi get() {
        return provideWalletCobrandedCcApi(this.baseUrlProvider.get());
    }
}
