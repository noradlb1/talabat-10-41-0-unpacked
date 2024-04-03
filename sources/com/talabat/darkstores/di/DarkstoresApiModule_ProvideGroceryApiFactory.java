package com.talabat.darkstores.di;

import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.darkstores.data.voucher.VoucherApi;
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
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.Grocery"})
public final class DarkstoresApiModule_ProvideGroceryApiFactory implements Factory<VoucherApi> {
    private final Provider<String> baseUrlProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;
    private final Provider<SecretProvider> secretProvider;

    public DarkstoresApiModule_ProvideGroceryApiFactory(Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<SecretProvider> provider3, Provider<String> provider4) {
        this.retrofitBuilderProvider = provider;
        this.okHttpClientProvider = provider2;
        this.secretProvider = provider3;
        this.baseUrlProvider = provider4;
    }

    public static DarkstoresApiModule_ProvideGroceryApiFactory create(Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<SecretProvider> provider3, Provider<String> provider4) {
        return new DarkstoresApiModule_ProvideGroceryApiFactory(provider, provider2, provider3, provider4);
    }

    public static VoucherApi provideGroceryApi(Retrofit.Builder builder, OkHttpClient okHttpClient, SecretProvider secretProvider2, String str) {
        return (VoucherApi) Preconditions.checkNotNullFromProvides(DarkstoresApiModule.INSTANCE.provideGroceryApi(builder, okHttpClient, secretProvider2, str));
    }

    public VoucherApi get() {
        return provideGroceryApi(this.retrofitBuilderProvider.get(), this.okHttpClientProvider.get(), this.secretProvider.get(), this.baseUrlProvider.get());
    }
}
