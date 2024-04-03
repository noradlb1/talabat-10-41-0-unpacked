package com.talabat.feature.walletcobrandedcc.data.di;

import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.walletcobrandedcc.data.remote.WalletCobrandedCcBaseUrl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class WalletCobrandedCcNetworkModule_ProvideBaseUrlFactory implements Factory<String> {
    private final Provider<BaseUrlFactory> baseUrlFactoryProvider;
    private final Provider<WalletCobrandedCcBaseUrl> walletCobrandedCcBaseUrlProvider;

    public WalletCobrandedCcNetworkModule_ProvideBaseUrlFactory(Provider<BaseUrlFactory> provider, Provider<WalletCobrandedCcBaseUrl> provider2) {
        this.baseUrlFactoryProvider = provider;
        this.walletCobrandedCcBaseUrlProvider = provider2;
    }

    public static WalletCobrandedCcNetworkModule_ProvideBaseUrlFactory create(Provider<BaseUrlFactory> provider, Provider<WalletCobrandedCcBaseUrl> provider2) {
        return new WalletCobrandedCcNetworkModule_ProvideBaseUrlFactory(provider, provider2);
    }

    public static String provideBaseUrl(BaseUrlFactory baseUrlFactory, WalletCobrandedCcBaseUrl walletCobrandedCcBaseUrl) {
        return (String) Preconditions.checkNotNullFromProvides(WalletCobrandedCcNetworkModule.INSTANCE.provideBaseUrl(baseUrlFactory, walletCobrandedCcBaseUrl));
    }

    public String get() {
        return provideBaseUrl(this.baseUrlFactoryProvider.get(), this.walletCobrandedCcBaseUrlProvider.get());
    }
}
