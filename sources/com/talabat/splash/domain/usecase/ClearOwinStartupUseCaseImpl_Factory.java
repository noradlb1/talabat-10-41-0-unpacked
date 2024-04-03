package com.talabat.splash.domain.usecase;

import com.talabat.authentication.token.domain.repository.ClearOwinUseCase;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ClearOwinStartupUseCaseImpl_Factory implements Factory<ClearOwinStartupUseCaseImpl> {
    private final Provider<ClearOwinUseCase> clearOwinUseCaseProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<TokenRepository> tokenRepositoryProvider;

    public ClearOwinStartupUseCaseImpl_Factory(Provider<ClearOwinUseCase> provider, Provider<TokenRepository> provider2, Provider<IObservabilityManager> provider3) {
        this.clearOwinUseCaseProvider = provider;
        this.tokenRepositoryProvider = provider2;
        this.observabilityManagerProvider = provider3;
    }

    public static ClearOwinStartupUseCaseImpl_Factory create(Provider<ClearOwinUseCase> provider, Provider<TokenRepository> provider2, Provider<IObservabilityManager> provider3) {
        return new ClearOwinStartupUseCaseImpl_Factory(provider, provider2, provider3);
    }

    public static ClearOwinStartupUseCaseImpl newInstance(ClearOwinUseCase clearOwinUseCase, TokenRepository tokenRepository, IObservabilityManager iObservabilityManager) {
        return new ClearOwinStartupUseCaseImpl(clearOwinUseCase, tokenRepository, iObservabilityManager);
    }

    public ClearOwinStartupUseCaseImpl get() {
        return newInstance(this.clearOwinUseCaseProvider.get(), this.tokenRepositoryProvider.get(), this.observabilityManagerProvider.get());
    }
}
