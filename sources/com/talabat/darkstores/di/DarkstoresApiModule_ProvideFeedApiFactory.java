package com.talabat.darkstores.di;

import com.talabat.darkstores.data.discovery.FeedApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@ScopeMetadata("com.talabat.darkstores.di.LibScope")
@DaggerGenerated
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.QCommerceGrocery"})
public final class DarkstoresApiModule_ProvideFeedApiFactory implements Factory<FeedApi> {
    private final Provider<String> baseUrlProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;

    public DarkstoresApiModule_ProvideFeedApiFactory(Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        this.retrofitBuilderProvider = provider;
        this.okHttpClientProvider = provider2;
        this.baseUrlProvider = provider3;
    }

    public static DarkstoresApiModule_ProvideFeedApiFactory create(Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        return new DarkstoresApiModule_ProvideFeedApiFactory(provider, provider2, provider3);
    }

    public static FeedApi provideFeedApi(Retrofit.Builder builder, OkHttpClient okHttpClient, String str) {
        return (FeedApi) Preconditions.checkNotNullFromProvides(DarkstoresApiModule.INSTANCE.provideFeedApi(builder, okHttpClient, str));
    }

    public FeedApi get() {
        return provideFeedApi(this.retrofitBuilderProvider.get(), this.okHttpClientProvider.get(), this.baseUrlProvider.get());
    }
}
