package com.talabat.darkstores.di;

import com.talabat.darkstores.data.partialFulfillment.remote.PartialFulfillmentApi;
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
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.PartialFulfillment"})
public final class DarkstoresApiModule_ProvidePartialFulfillmentApiFactory implements Factory<PartialFulfillmentApi> {
    private final Provider<String> baseUrlProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;

    public DarkstoresApiModule_ProvidePartialFulfillmentApiFactory(Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        this.retrofitBuilderProvider = provider;
        this.okHttpClientProvider = provider2;
        this.baseUrlProvider = provider3;
    }

    public static DarkstoresApiModule_ProvidePartialFulfillmentApiFactory create(Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        return new DarkstoresApiModule_ProvidePartialFulfillmentApiFactory(provider, provider2, provider3);
    }

    public static PartialFulfillmentApi providePartialFulfillmentApi(Retrofit.Builder builder, OkHttpClient okHttpClient, String str) {
        return (PartialFulfillmentApi) Preconditions.checkNotNullFromProvides(DarkstoresApiModule.INSTANCE.providePartialFulfillmentApi(builder, okHttpClient, str));
    }

    public PartialFulfillmentApi get() {
        return providePartialFulfillmentApi(this.retrofitBuilderProvider.get(), this.okHttpClientProvider.get(), this.baseUrlProvider.get());
    }
}
