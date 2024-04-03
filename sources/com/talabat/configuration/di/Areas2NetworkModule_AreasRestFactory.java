package com.talabat.configuration.di;

import com.talabat.configuration.areas.Areas2Rest;
import com.talabat.configuration.areas.endpoint.Areas2BaseUrl;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.configuration.di.AreasRest", "com.talabat.core.network.domain.MoshiRetrofit"})
public final class Areas2NetworkModule_AreasRestFactory implements Factory<Areas2Rest> {
    private final Provider<Areas2BaseUrl> areas2BaseUrlProvider;
    private final Provider<BaseUrlFactory> baseUrlFactoryProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;

    public Areas2NetworkModule_AreasRestFactory(Provider<BaseUrlFactory> provider, Provider<Areas2BaseUrl> provider2, Provider<Retrofit.Builder> provider3) {
        this.baseUrlFactoryProvider = provider;
        this.areas2BaseUrlProvider = provider2;
        this.retrofitBuilderProvider = provider3;
    }

    public static Areas2Rest areasRest(BaseUrlFactory baseUrlFactory, Areas2BaseUrl areas2BaseUrl, Retrofit.Builder builder) {
        return (Areas2Rest) Preconditions.checkNotNullFromProvides(Areas2NetworkModule.INSTANCE.areasRest(baseUrlFactory, areas2BaseUrl, builder));
    }

    public static Areas2NetworkModule_AreasRestFactory create(Provider<BaseUrlFactory> provider, Provider<Areas2BaseUrl> provider2, Provider<Retrofit.Builder> provider3) {
        return new Areas2NetworkModule_AreasRestFactory(provider, provider2, provider3);
    }

    public Areas2Rest get() {
        return areasRest(this.baseUrlFactoryProvider.get(), this.areas2BaseUrlProvider.get(), this.retrofitBuilderProvider.get());
    }
}
