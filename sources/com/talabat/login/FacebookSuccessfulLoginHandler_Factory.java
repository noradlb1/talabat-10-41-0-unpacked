package com.talabat.login;

import com.talabat.authentication.token.domain.repository.TokenRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FacebookSuccessfulLoginHandler_Factory implements Factory<FacebookSuccessfulLoginHandler> {
    private final Provider<TokenRepository> tokenRepositoryProvider;

    public FacebookSuccessfulLoginHandler_Factory(Provider<TokenRepository> provider) {
        this.tokenRepositoryProvider = provider;
    }

    public static FacebookSuccessfulLoginHandler_Factory create(Provider<TokenRepository> provider) {
        return new FacebookSuccessfulLoginHandler_Factory(provider);
    }

    public static FacebookSuccessfulLoginHandler newInstance(TokenRepository tokenRepository) {
        return new FacebookSuccessfulLoginHandler(tokenRepository);
    }

    public FacebookSuccessfulLoginHandler get() {
        return newInstance(this.tokenRepositoryProvider.get());
    }
}
