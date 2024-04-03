package com.talabat.authentication.token.data.remote.impl;

import com.google.gson.Gson;
import com.talabat.authentication.aaa.AaaApi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.authentication.token.data.remote.TokenResponseMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TokenRemoteDataSourceImpl_Factory implements Factory<TokenRemoteDataSourceImpl> {
    private final Provider<AaaApi> aaaApiProvider;
    private final Provider<Gson> gsonProvider;
    private final Provider<SecretProvider> secretProvider;
    private final Provider<TokenResponseMapper> tokenResponseMapperProvider;

    public TokenRemoteDataSourceImpl_Factory(Provider<AaaApi> provider, Provider<TokenResponseMapper> provider2, Provider<Gson> provider3, Provider<SecretProvider> provider4) {
        this.aaaApiProvider = provider;
        this.tokenResponseMapperProvider = provider2;
        this.gsonProvider = provider3;
        this.secretProvider = provider4;
    }

    public static TokenRemoteDataSourceImpl_Factory create(Provider<AaaApi> provider, Provider<TokenResponseMapper> provider2, Provider<Gson> provider3, Provider<SecretProvider> provider4) {
        return new TokenRemoteDataSourceImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static TokenRemoteDataSourceImpl newInstance(AaaApi aaaApi, TokenResponseMapper tokenResponseMapper, Gson gson, SecretProvider secretProvider2) {
        return new TokenRemoteDataSourceImpl(aaaApi, tokenResponseMapper, gson, secretProvider2);
    }

    public TokenRemoteDataSourceImpl get() {
        return newInstance(this.aaaApiProvider.get(), this.tokenResponseMapperProvider.get(), this.gsonProvider.get(), this.secretProvider.get());
    }
}
