package com.talabat.talabatcommon.feature.walletBanner.service;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class WalletBannerServiceImpl_Factory implements Factory<WalletBannerServiceImpl> {
    private final Provider<WalletBannerApi> walletBannerApiProvider;

    public WalletBannerServiceImpl_Factory(Provider<WalletBannerApi> provider) {
        this.walletBannerApiProvider = provider;
    }

    public static WalletBannerServiceImpl_Factory create(Provider<WalletBannerApi> provider) {
        return new WalletBannerServiceImpl_Factory(provider);
    }

    public static WalletBannerServiceImpl newInstance(WalletBannerApi walletBannerApi) {
        return new WalletBannerServiceImpl(walletBannerApi);
    }

    public WalletBannerServiceImpl get() {
        return newInstance(this.walletBannerApiProvider.get());
    }
}
