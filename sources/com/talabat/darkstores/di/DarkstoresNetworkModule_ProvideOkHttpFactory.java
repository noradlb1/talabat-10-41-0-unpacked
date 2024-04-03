package com.talabat.darkstores.di;

import com.talabat.darkstores.data.NetworkConnectionInterceptor;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("com.talabat.darkstores.di.LibScope")
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresNetworkModule_ProvideOkHttpFactory implements Factory<OkHttpClient> {
    private final Provider<NetworkConnectionInterceptor> networkConnectionInterceptorProvider;

    public DarkstoresNetworkModule_ProvideOkHttpFactory(Provider<NetworkConnectionInterceptor> provider) {
        this.networkConnectionInterceptorProvider = provider;
    }

    public static DarkstoresNetworkModule_ProvideOkHttpFactory create(Provider<NetworkConnectionInterceptor> provider) {
        return new DarkstoresNetworkModule_ProvideOkHttpFactory(provider);
    }

    public static OkHttpClient provideOkHttp(NetworkConnectionInterceptor networkConnectionInterceptor) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(DarkstoresNetworkModule.INSTANCE.provideOkHttp(networkConnectionInterceptor));
    }

    public OkHttpClient get() {
        return provideOkHttp(this.networkConnectionInterceptorProvider.get());
    }
}
