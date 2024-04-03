package com.talabat.authentication.authenticate.data.usecase;

import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.gdm.owin.domain.GdmOwinTokenRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class UserLoggedInImpl_Factory implements Factory<UserLoggedInImpl> {
    private final Provider<GdmOwinTokenRepository> gdmOwinTokenRepositoryProvider;
    private final Provider<TokenRepository> tokenRepositoryProvider;

    public UserLoggedInImpl_Factory(Provider<GdmOwinTokenRepository> provider, Provider<TokenRepository> provider2) {
        this.gdmOwinTokenRepositoryProvider = provider;
        this.tokenRepositoryProvider = provider2;
    }

    public static UserLoggedInImpl_Factory create(Provider<GdmOwinTokenRepository> provider, Provider<TokenRepository> provider2) {
        return new UserLoggedInImpl_Factory(provider, provider2);
    }

    public static UserLoggedInImpl newInstance(GdmOwinTokenRepository gdmOwinTokenRepository, TokenRepository tokenRepository) {
        return new UserLoggedInImpl(gdmOwinTokenRepository, tokenRepository);
    }

    public UserLoggedInImpl get() {
        return newInstance(this.gdmOwinTokenRepositoryProvider.get(), this.tokenRepositoryProvider.get());
    }
}
