package com.talabat.feature.tokenization.data.di;

import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.tokenization.data.baseurl.TokenizationBaseUrl;
import com.talabat.feature.tokenization.data.datasource.RemoteTokenizationDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.core.network.domain.MoshiRetrofit"})
public final class TokenizationDataSourceModule_RemoteTokenizationDataSourceFactory implements Factory<RemoteTokenizationDataSource> {
    private final Provider<BaseUrlFactory> baseUrlFactoryProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;
    private final Provider<TokenizationBaseUrl> tokenizationBaseUrlProvider;

    public TokenizationDataSourceModule_RemoteTokenizationDataSourceFactory(Provider<Retrofit.Builder> provider, Provider<TokenizationBaseUrl> provider2, Provider<BaseUrlFactory> provider3) {
        this.retrofitBuilderProvider = provider;
        this.tokenizationBaseUrlProvider = provider2;
        this.baseUrlFactoryProvider = provider3;
    }

    public static TokenizationDataSourceModule_RemoteTokenizationDataSourceFactory create(Provider<Retrofit.Builder> provider, Provider<TokenizationBaseUrl> provider2, Provider<BaseUrlFactory> provider3) {
        return new TokenizationDataSourceModule_RemoteTokenizationDataSourceFactory(provider, provider2, provider3);
    }

    public static RemoteTokenizationDataSource remoteTokenizationDataSource(Retrofit.Builder builder, TokenizationBaseUrl tokenizationBaseUrl, BaseUrlFactory baseUrlFactory) {
        return (RemoteTokenizationDataSource) Preconditions.checkNotNullFromProvides(TokenizationDataSourceModule.INSTANCE.remoteTokenizationDataSource(builder, tokenizationBaseUrl, baseUrlFactory));
    }

    public RemoteTokenizationDataSource get() {
        return remoteTokenizationDataSource(this.retrofitBuilderProvider.get(), this.tokenizationBaseUrlProvider.get(), this.baseUrlFactoryProvider.get());
    }
}
