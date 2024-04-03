package com.talabat.authentication.authenticate.data.usecase;

import com.talabat.authentication.authenticate.domain.repository.TokenExchangeRetriesRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TokenExchangeAllowedImpl_Factory implements Factory<TokenExchangeAllowedImpl> {
    private final Provider<TokenExchangeRetriesRepository> tokenExchangeRetriesRepositoryProvider;

    public TokenExchangeAllowedImpl_Factory(Provider<TokenExchangeRetriesRepository> provider) {
        this.tokenExchangeRetriesRepositoryProvider = provider;
    }

    public static TokenExchangeAllowedImpl_Factory create(Provider<TokenExchangeRetriesRepository> provider) {
        return new TokenExchangeAllowedImpl_Factory(provider);
    }

    public static TokenExchangeAllowedImpl newInstance(TokenExchangeRetriesRepository tokenExchangeRetriesRepository) {
        return new TokenExchangeAllowedImpl(tokenExchangeRetriesRepository);
    }

    public TokenExchangeAllowedImpl get() {
        return newInstance(this.tokenExchangeRetriesRepositoryProvider.get());
    }
}
