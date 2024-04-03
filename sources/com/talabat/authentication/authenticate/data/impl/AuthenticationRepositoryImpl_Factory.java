package com.talabat.authentication.authenticate.data.impl;

import com.talabat.authentication.authenticate.data.remote.AuthenticationRemoteDataSource;
import com.talabat.authentication.authenticate.domain.usecase.UserLoggedIn;
import com.talabat.authentication.token.data.local.LegacyTokenLocalDataSource;
import com.talabat.authentication.token.data.remote.LegacyTokenRemoteDataSource;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AuthenticationRepositoryImpl_Factory implements Factory<AuthenticationRepositoryImpl> {
    private final Provider<AuthenticationRemoteDataSource> authenticationRemoteDataSourceProvider;
    private final Provider<LegacyTokenLocalDataSource> legacyTokenLocalDataSourceProvider;
    private final Provider<LegacyTokenRemoteDataSource> legacyTokenRemoteDataSourceProvider;
    private final Provider<TokenRepository> tokenRepositoryProvider;
    private final Provider<UserLoggedIn> userLoggedInProvider;

    public AuthenticationRepositoryImpl_Factory(Provider<TokenRepository> provider, Provider<AuthenticationRemoteDataSource> provider2, Provider<LegacyTokenRemoteDataSource> provider3, Provider<LegacyTokenLocalDataSource> provider4, Provider<UserLoggedIn> provider5) {
        this.tokenRepositoryProvider = provider;
        this.authenticationRemoteDataSourceProvider = provider2;
        this.legacyTokenRemoteDataSourceProvider = provider3;
        this.legacyTokenLocalDataSourceProvider = provider4;
        this.userLoggedInProvider = provider5;
    }

    public static AuthenticationRepositoryImpl_Factory create(Provider<TokenRepository> provider, Provider<AuthenticationRemoteDataSource> provider2, Provider<LegacyTokenRemoteDataSource> provider3, Provider<LegacyTokenLocalDataSource> provider4, Provider<UserLoggedIn> provider5) {
        return new AuthenticationRepositoryImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static AuthenticationRepositoryImpl newInstance(TokenRepository tokenRepository, AuthenticationRemoteDataSource authenticationRemoteDataSource, LegacyTokenRemoteDataSource legacyTokenRemoteDataSource, LegacyTokenLocalDataSource legacyTokenLocalDataSource, UserLoggedIn userLoggedIn) {
        return new AuthenticationRepositoryImpl(tokenRepository, authenticationRemoteDataSource, legacyTokenRemoteDataSource, legacyTokenLocalDataSource, userLoggedIn);
    }

    public AuthenticationRepositoryImpl get() {
        return newInstance(this.tokenRepositoryProvider.get(), this.authenticationRemoteDataSourceProvider.get(), this.legacyTokenRemoteDataSourceProvider.get(), this.legacyTokenLocalDataSourceProvider.get(), this.userLoggedInProvider.get());
    }
}
