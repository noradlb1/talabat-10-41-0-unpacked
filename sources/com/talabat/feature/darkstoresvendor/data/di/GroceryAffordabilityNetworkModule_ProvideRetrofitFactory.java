package com.talabat.feature.darkstoresvendor.data.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.feature.darkstoresvendor.data.di.GroceryAffordability", "com.talabat.core.network.domain.MoshiRetrofit"})
public final class GroceryAffordabilityNetworkModule_ProvideRetrofitFactory implements Factory<Retrofit> {
    private final Provider<String> baseUrlProvider;
    private final GroceryAffordabilityNetworkModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;

    public GroceryAffordabilityNetworkModule_ProvideRetrofitFactory(GroceryAffordabilityNetworkModule groceryAffordabilityNetworkModule, Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        this.module = groceryAffordabilityNetworkModule;
        this.retrofitBuilderProvider = provider;
        this.okHttpClientProvider = provider2;
        this.baseUrlProvider = provider3;
    }

    public static GroceryAffordabilityNetworkModule_ProvideRetrofitFactory create(GroceryAffordabilityNetworkModule groceryAffordabilityNetworkModule, Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        return new GroceryAffordabilityNetworkModule_ProvideRetrofitFactory(groceryAffordabilityNetworkModule, provider, provider2, provider3);
    }

    public static Retrofit provideRetrofit(GroceryAffordabilityNetworkModule groceryAffordabilityNetworkModule, Retrofit.Builder builder, OkHttpClient okHttpClient, String str) {
        return (Retrofit) Preconditions.checkNotNullFromProvides(groceryAffordabilityNetworkModule.provideRetrofit(builder, okHttpClient, str));
    }

    public Retrofit get() {
        return provideRetrofit(this.module, this.retrofitBuilderProvider.get(), this.okHttpClientProvider.get(), this.baseUrlProvider.get());
    }
}
