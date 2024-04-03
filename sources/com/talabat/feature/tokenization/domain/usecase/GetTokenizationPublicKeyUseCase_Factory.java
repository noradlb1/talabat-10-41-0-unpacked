package com.talabat.feature.tokenization.domain.usecase;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.feature.tokenization.domain.TokenizationRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetTokenizationPublicKeyUseCase_Factory implements Factory<GetTokenizationPublicKeyUseCase> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<TokenizationRepository> tokenizationRepositoryProvider;

    public GetTokenizationPublicKeyUseCase_Factory(Provider<TokenizationRepository> provider, Provider<ConfigurationLocalRepository> provider2) {
        this.tokenizationRepositoryProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
    }

    public static GetTokenizationPublicKeyUseCase_Factory create(Provider<TokenizationRepository> provider, Provider<ConfigurationLocalRepository> provider2) {
        return new GetTokenizationPublicKeyUseCase_Factory(provider, provider2);
    }

    public static GetTokenizationPublicKeyUseCase newInstance(TokenizationRepository tokenizationRepository, ConfigurationLocalRepository configurationLocalRepository) {
        return new GetTokenizationPublicKeyUseCase(tokenizationRepository, configurationLocalRepository);
    }

    public GetTokenizationPublicKeyUseCase get() {
        return newInstance(this.tokenizationRepositoryProvider.get(), this.configurationLocalRepositoryProvider.get());
    }
}
