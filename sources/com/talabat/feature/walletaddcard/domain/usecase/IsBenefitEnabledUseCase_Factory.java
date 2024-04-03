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
public final class IsBenefitEnabledUseCase_Factory implements Factory<IsBenefitEnabledUseCase> {
    private final Provider<WalletAddCardRepository> repositoryProvider;

    public IsBenefitEnabledUseCase_Factory(Provider<WalletAddCardRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static IsBenefitEnabledUseCase_Factory create(Provider<WalletAddCardRepository> provider) {
        return new IsBenefitEnabledUseCase_Factory(provider);
    }

    public static IsBenefitEnabledUseCase newInstance(WalletAddCardRepository walletAddCardRepository) {
        return new IsBenefitEnabledUseCase(walletAddCardRepository);
    }

    public IsBenefitEnabledUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
