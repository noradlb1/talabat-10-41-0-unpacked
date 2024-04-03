package com.talabat.authentication.authenticate.data.remote.impl;

import com.google.gson.Gson;
import com.talabat.authentication.aaa.AaaApi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.authentication.token.data.remote.TokenResponseMapper;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AuthenticationRemoteDataSourceImpl_Factory implements Factory<AuthenticationRemoteDataSourceImpl> {
    private final Provider<AaaApi> aaaApiProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagProvider;
    private final Provider<Gson> gsonProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<SecretProvider> secretProvider;
    private final Provider<TokenResponseMapper> tokenResponseMapperProvider;

    public AuthenticationRemoteDataSourceImpl_Factory(Provider<AaaApi> provider, Provider<Gson> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<SecretProvider> provider4, Provider<TokenResponseMapper> provider5, Provider<IObservabilityManager> provider6) {
        this.aaaApiProvider = provider;
        this.gsonProvider = provider2;
        this.featureFlagProvider = provider3;
        this.secretProvider = provider4;
        this.tokenResponseMapperProvider = provider5;
        this.observabilityManagerProvider = provider6;
    }

    public static AuthenticationRemoteDataSourceImpl_Factory create(Provider<AaaApi> provider, Provider<Gson> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<SecretProvider> provider4, Provider<TokenResponseMapper> provider5, Provider<IObservabilityManager> provider6) {
        return new AuthenticationRemoteDataSourceImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static AuthenticationRemoteDataSourceImpl newInstance(AaaApi aaaApi, Gson gson, ITalabatFeatureFlag iTalabatFeatureFlag, SecretProvider secretProvider2, TokenResponseMapper tokenResponseMapper, IObservabilityManager iObservabilityManager) {
        return new AuthenticationRemoteDataSourceImpl(aaaApi, gson, iTalabatFeatureFlag, secretProvider2, tokenResponseMapper, iObservabilityManager);
    }

    public AuthenticationRemoteDataSourceImpl get() {
        return newInstance(this.aaaApiProvider.get(), this.gsonProvider.get(), this.featureFlagProvider.get(), this.secretProvider.get(), this.tokenResponseMapperProvider.get(), this.observabilityManagerProvider.get());
    }
}
