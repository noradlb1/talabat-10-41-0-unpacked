package com.talabat.darkstores.di;

import com.talabat.darkstores.data.darkstores.AuthHeaderInterceptor;
import com.talabat.darkstores.data.darkstores.DarkstoresHeaderInterceptor;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("com.talabat.darkstores.di.LibScope")
@DaggerGenerated
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.Darkstores"})
public final class DarkstoresNetworkModule_ProvideDarkstoresOkHttpFactory implements Factory<OkHttpClient> {
    private final Provider<AuthHeaderInterceptor> authInterceptorProvider;
    private final Provider<DarkstoresHeaderInterceptor> darkstoresHeaderInterceptorProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public DarkstoresNetworkModule_ProvideDarkstoresOkHttpFactory(Provider<OkHttpClient> provider, Provider<AuthHeaderInterceptor> provider2, Provider<DarkstoresHeaderInterceptor> provider3) {
        this.okHttpClientProvider = provider;
        this.authInterceptorProvider = provider2;
        this.darkstoresHeaderInterceptorProvider = provider3;
    }

    public static DarkstoresNetworkModule_ProvideDarkstoresOkHttpFactory create(Provider<OkHttpClient> provider, Provider<AuthHeaderInterceptor> provider2, Provider<DarkstoresHeaderInterceptor> provider3) {
        return new DarkstoresNetworkModule_ProvideDarkstoresOkHttpFactory(provider, provider2, provider3);
    }

    public static OkHttpClient provideDarkstoresOkHttp(OkHttpClient okHttpClient, AuthHeaderInterceptor authHeaderInterceptor, DarkstoresHeaderInterceptor darkstoresHeaderInterceptor) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(DarkstoresNetworkModule.INSTANCE.provideDarkstoresOkHttp(okHttpClient, authHeaderInterceptor, darkstoresHeaderInterceptor));
    }

    public OkHttpClient get() {
        return provideDarkstoresOkHttp(this.okHttpClientProvider.get(), this.authInterceptorProvider.get(), this.darkstoresHeaderInterceptorProvider.get());
    }
}
