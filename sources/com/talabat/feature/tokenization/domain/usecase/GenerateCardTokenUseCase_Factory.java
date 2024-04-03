package com.talabat.feature.tokenization.domain.usecase;

import com.talabat.feature.tokenization.domain.TokenizationRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GenerateCardTokenUseCase_Factory implements Factory<GenerateCardTokenUseCase> {
    private final Provider<GetTokenizationPublicKeyUseCase> getTokenizationPublicKeyUseCaseProvider;
    private final Provider<ObserveTokenizationFailedUseCase> observeFailedUseCaseProvider;
    private final Provider<ObserveTokenizationSuccessUseCase> observeSuccessUseCaseProvider;
    private final Provider<TokenizationRepository> tokenizationRepositoryProvider;

    public GenerateCardTokenUseCase_Factory(Provider<TokenizationRepository> provider, Provider<GetTokenizationPublicKeyUseCase> provider2, Provider<ObserveTokenizationFailedUseCase> provider3, Provider<ObserveTokenizationSuccessUseCase> provider4) {
        this.tokenizationRepositoryProvider = provider;
        this.getTokenizationPublicKeyUseCaseProvider = provider2;
        this.observeFailedUseCaseProvider = provider3;
        this.observeSuccessUseCaseProvider = provider4;
    }

    public static GenerateCardTokenUseCase_Factory create(Provider<TokenizationRepository> provider, Provider<GetTokenizationPublicKeyUseCase> provider2, Provider<ObserveTokenizationFailedUseCase> provider3, Provider<ObserveTokenizationSuccessUseCase> provider4) {
        return new GenerateCardTokenUseCase_Factory(provider, provider2, provider3, provider4);
    }

    public static GenerateCardTokenUseCase newInstance(TokenizationRepository tokenizationRepository, GetTokenizationPublicKeyUseCase getTokenizationPublicKeyUseCase, ObserveTokenizationFailedUseCase observeTokenizationFailedUseCase, ObserveTokenizationSuccessUseCase observeTokenizationSuccessUseCase) {
        return new GenerateCardTokenUseCase(tokenizationRepository, getTokenizationPublicKeyUseCase, observeTokenizationFailedUseCase, observeTokenizationSuccessUseCase);
    }

    public GenerateCardTokenUseCase get() {
        return newInstance(this.tokenizationRepositoryProvider.get(), this.getTokenizationPublicKeyUseCaseProvider.get(), this.observeFailedUseCaseProvider.get(), this.observeSuccessUseCaseProvider.get());
    }
}
