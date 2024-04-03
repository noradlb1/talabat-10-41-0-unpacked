package com.talabat.feature.walletaddcard.data;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class WalletAddCardRepositoryImpl_Factory implements Factory<WalletAddCardRepositoryImpl> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagProvider;
    private final Provider<GenerateCardTokenUseCase> generateCardTokenUseCaseProvider;

    public WalletAddCardRepositoryImpl_Factory(Provider<ITalabatFeatureFlag> provider, Provider<ConfigurationLocalRepository> provider2, Provider<GenerateCardTokenUseCase> provider3) {
        this.featureFlagProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
        this.generateCardTokenUseCaseProvider = provider3;
    }

    public static WalletAddCardRepositoryImpl_Factory create(Provider<ITalabatFeatureFlag> provider, Provider<ConfigurationLocalRepository> provider2, Provider<GenerateCardTokenUseCase> provider3) {
        return new WalletAddCardRepositoryImpl_Factory(provider, provider2, provider3);
    }

    public static WalletAddCardRepositoryImpl newInstance(ITalabatFeatureFlag iTalabatFeatureFlag, ConfigurationLocalRepository configurationLocalRepository, GenerateCardTokenUseCase generateCardTokenUseCase) {
        return new WalletAddCardRepositoryImpl(iTalabatFeatureFlag, configurationLocalRepository, generateCardTokenUseCase);
    }

    public WalletAddCardRepositoryImpl get() {
        return newInstance(this.featureFlagProvider.get(), this.configurationLocalRepositoryProvider.get(), this.generateCardTokenUseCaseProvider.get());
    }
}
