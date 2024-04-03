package com.talabat.feature.darkstoresvendor.data.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Set;
import javax.inject.Provider;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.feature.darkstoresvendor.data.di.GroceryAffordability"})
public final class GroceryAffordabilityNetworkModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
    private final Provider<Set<Interceptor>> interceptorsProvider;
    private final GroceryAffordabilityNetworkModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public GroceryAffordabilityNetworkModule_ProvideOkHttpClientFactory(GroceryAffordabilityNetworkModule groceryAffordabilityNetworkModule, Provider<OkHttpClient> provider, Provider<Set<Interceptor>> provider2) {
        this.module = groceryAffordabilityNetworkModule;
        this.okHttpClientProvider = provider;
        this.interceptorsProvider = provider2;
    }

    public static GroceryAffordabilityNetworkModule_ProvideOkHttpClientFactory create(GroceryAffordabilityNetworkModule groceryAffordabilityNetworkModule, Provider<OkHttpClient> provider, Provider<Set<Interceptor>> provider2) {
        return new GroceryAffordabilityNetworkModule_ProvideOkHttpClientFactory(groceryAffordabilityNetworkModule, provider, provider2);
    }

    public static OkHttpClient provideOkHttpClient(GroceryAffordabilityNetworkModule groceryAffordabilityNetworkModule, OkHttpClient okHttpClient, Set<Interceptor> set) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(groceryAffordabilityNetworkModule.provideOkHttpClient(okHttpClient, set));
    }

    public OkHttpClient get() {
        return provideOkHttpClient(this.module, this.okHttpClientProvider.get(), this.interceptorsProvider.get());
    }
}
