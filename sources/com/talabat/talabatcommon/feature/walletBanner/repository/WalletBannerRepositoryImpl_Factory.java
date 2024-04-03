package com.talabat.talabatcommon.feature.walletBanner.repository;

import com.talabat.talabatcommon.feature.walletBanner.service.WalletBannerService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class WalletBannerRepositoryImpl_Factory implements Factory<WalletBannerRepositoryImpl> {
    private final Provider<WalletBannerService> walletBannerServiceProvider;

    public WalletBannerRepositoryImpl_Factory(Provider<WalletBannerService> provider) {
        this.walletBannerServiceProvider = provider;
    }

    public static WalletBannerRepositoryImpl_Factory create(Provider<WalletBannerService> provider) {
        return new WalletBannerRepositoryImpl_Factory(provider);
    }

    public static WalletBannerRepositoryImpl newInstance(WalletBannerService walletBannerService) {
        return new WalletBannerRepositoryImpl(walletBannerService);
    }

    public WalletBannerRepositoryImpl get() {
        return newInstance(this.walletBannerServiceProvider.get());
    }
}
