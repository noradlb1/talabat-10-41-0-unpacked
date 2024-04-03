package com.talabat.feature.tmart.growth.data.di;

import com.squareup.moshi.Moshi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.feature.tmart.growth.data.remote.TMartGrowthApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class TMartGrowthNetworkModule_ProvideTMartGrowthApiFactory implements Factory<TMartGrowthApi> {
    private final Provider<String> baseUrlProvider;
    private final Provider<Moshi> featureMoshiProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<SecretProvider> secretProvider;

    public TMartGrowthNetworkModule_ProvideTMartGrowthApiFactory(Provider<String> provider, Provider<Moshi> provider2, Provider<OkHttpClient> provider3, Provider<SecretProvider> provider4) {
        this.baseUrlProvider = provider;
        this.featureMoshiProvider = provider2;
        this.okHttpClientProvider = provider3;
        this.secretProvider = provider4;
    }

    public static TMartGrowthNetworkModule_ProvideTMartGrowthApiFactory create(Provider<String> provider, Provider<Moshi> provider2, Provider<OkHttpClient> provider3, Provider<SecretProvider> provider4) {
        return new TMartGrowthNetworkModule_ProvideTMartGrowthApiFactory(provider, provider2, provider3, provider4);
    }

    public static TMartGrowthApi provideTMartGrowthApi(String str, Moshi moshi, OkHttpClient okHttpClient, SecretProvider secretProvider2) {
        return (TMartGrowthApi) Preconditions.checkNotNullFromProvides(TMartGrowthNetworkModule.INSTANCE.provideTMartGrowthApi(str, moshi, okHttpClient, secretProvider2));
    }

    public TMartGrowthApi get() {
        return provideTMartGrowthApi(this.baseUrlProvider.get(), this.featureMoshiProvider.get(), this.okHttpClientProvider.get(), this.secretProvider.get());
    }
}
