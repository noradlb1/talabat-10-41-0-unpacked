package com.talabat.authentication.token.data.remote.impl;

import com.talabat.authentication.token.data.remote.api.SwapTokenApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class LegacyTokenRemoteDataSourceImpl_Factory implements Factory<LegacyTokenRemoteDataSourceImpl> {
    private final Provider<SwapTokenApi> swapTokenApiProvider;

    public LegacyTokenRemoteDataSourceImpl_Factory(Provider<SwapTokenApi> provider) {
        this.swapTokenApiProvider = provider;
    }

    public static LegacyTokenRemoteDataSourceImpl_Factory create(Provider<SwapTokenApi> provider) {
        return new LegacyTokenRemoteDataSourceImpl_Factory(provider);
    }

    public static LegacyTokenRemoteDataSourceImpl newInstance(SwapTokenApi swapTokenApi) {
        return new LegacyTokenRemoteDataSourceImpl(swapTokenApi);
    }

    public LegacyTokenRemoteDataSourceImpl get() {
        return newInstance(this.swapTokenApiProvider.get());
    }
}
