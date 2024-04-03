package com.talabat.darkstores.di;

import com.talabat.darkstores.data.grocery.GroceryShoppingApi;
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
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.Darkstores"})
public final class DarkstoresApiModule_ProvideGroceryShoppingApiFactory implements Factory<GroceryShoppingApi> {
    private final Provider<String> baseUrlProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;

    public DarkstoresApiModule_ProvideGroceryShoppingApiFactory(Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        this.retrofitBuilderProvider = provider;
        this.okHttpClientProvider = provider2;
        this.baseUrlProvider = provider3;
    }

    public static DarkstoresApiModule_ProvideGroceryShoppingApiFactory create(Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        return new DarkstoresApiModule_ProvideGroceryShoppingApiFactory(provider, provider2, provider3);
    }

    public static GroceryShoppingApi provideGroceryShoppingApi(Retrofit.Builder builder, OkHttpClient okHttpClient, String str) {
        return (GroceryShoppingApi) Preconditions.checkNotNullFromProvides(DarkstoresApiModule.INSTANCE.provideGroceryShoppingApi(builder, okHttpClient, str));
    }

    public GroceryShoppingApi get() {
        return provideGroceryShoppingApi(this.retrofitBuilderProvider.get(), this.okHttpClientProvider.get(), this.baseUrlProvider.get());
    }
}
