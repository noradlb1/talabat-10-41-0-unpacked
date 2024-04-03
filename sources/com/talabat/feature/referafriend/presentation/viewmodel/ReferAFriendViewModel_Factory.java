package com.talabat.feature.referafriend.presentation.viewmodel;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherCodeUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ReferAFriendViewModel_Factory implements Factory<ReferAFriendViewModel> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<CoroutineDispatchersFactory> coroutineDispatchersFactoryProvider;
    private final Provider<RedeemVoucherCodeUseCase> redeemVoucherCodeUseCaseProvider;

    public ReferAFriendViewModel_Factory(Provider<RedeemVoucherCodeUseCase> provider, Provider<ConfigurationLocalRepository> provider2, Provider<CoroutineDispatchersFactory> provider3) {
        this.redeemVoucherCodeUseCaseProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
        this.coroutineDispatchersFactoryProvider = provider3;
    }

    public static ReferAFriendViewModel_Factory create(Provider<RedeemVoucherCodeUseCase> provider, Provider<ConfigurationLocalRepository> provider2, Provider<CoroutineDispatchersFactory> provider3) {
        return new ReferAFriendViewModel_Factory(provider, provider2, provider3);
    }

    public static ReferAFriendViewModel newInstance(RedeemVoucherCodeUseCase redeemVoucherCodeUseCase, ConfigurationLocalRepository configurationLocalRepository, CoroutineDispatchersFactory coroutineDispatchersFactory) {
        return new ReferAFriendViewModel(redeemVoucherCodeUseCase, configurationLocalRepository, coroutineDispatchersFactory);
    }

    public ReferAFriendViewModel get() {
        return newInstance(this.redeemVoucherCodeUseCaseProvider.get(), this.configurationLocalRepositoryProvider.get(), this.coroutineDispatchersFactoryProvider.get());
    }
}
