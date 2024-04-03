package com.talabat.talabatcommon.feature.walletBanner;

import com.talabat.talabatcommon.feature.walletBanner.repository.WalletBannerRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetWalletBannerUseCase_Factory implements Factory<GetWalletBannerUseCase> {
    private final Provider<WalletBannerRepository> walletBannerRepositoryProvider;

    public GetWalletBannerUseCase_Factory(Provider<WalletBannerRepository> provider) {
        this.walletBannerRepositoryProvider = provider;
    }

    public static GetWalletBannerUseCase_Factory create(Provider<WalletBannerRepository> provider) {
        return new GetWalletBannerUseCase_Factory(provider);
    }

    public static GetWalletBannerUseCase newInstance(WalletBannerRepository walletBannerRepository) {
        return new GetWalletBannerUseCase(walletBannerRepository);
    }

    public GetWalletBannerUseCase get() {
        return newInstance(this.walletBannerRepositoryProvider.get());
    }
}
