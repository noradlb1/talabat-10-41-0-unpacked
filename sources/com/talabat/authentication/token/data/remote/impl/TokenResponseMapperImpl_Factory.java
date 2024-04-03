package com.talabat.authentication.token.data.remote.impl;

import com.talabat.authentication.usecase.CalculateTokenTimeDifferenceUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TokenResponseMapperImpl_Factory implements Factory<TokenResponseMapperImpl> {
    private final Provider<CalculateTokenTimeDifferenceUseCase> calculateTokenTimeDifferenceUseCaseProvider;

    public TokenResponseMapperImpl_Factory(Provider<CalculateTokenTimeDifferenceUseCase> provider) {
        this.calculateTokenTimeDifferenceUseCaseProvider = provider;
    }

    public static TokenResponseMapperImpl_Factory create(Provider<CalculateTokenTimeDifferenceUseCase> provider) {
        return new TokenResponseMapperImpl_Factory(provider);
    }

    public static TokenResponseMapperImpl newInstance(CalculateTokenTimeDifferenceUseCase calculateTokenTimeDifferenceUseCase) {
        return new TokenResponseMapperImpl(calculateTokenTimeDifferenceUseCase);
    }

    public TokenResponseMapperImpl get() {
        return newInstance(this.calculateTokenTimeDifferenceUseCaseProvider.get());
    }
}
