package com.talabat.splash.network;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class SplashServices_Factory implements Factory<SplashServices> {
    private final Provider<Retrofit> retrofitProvider;

    public SplashServices_Factory(Provider<Retrofit> provider) {
        this.retrofitProvider = provider;
    }

    public static SplashServices_Factory create(Provider<Retrofit> provider) {
        return new SplashServices_Factory(provider);
    }

    public static SplashServices newInstance(Retrofit retrofit) {
        return new SplashServices(retrofit);
    }

    public SplashServices get() {
        return newInstance(this.retrofitProvider.get());
    }
}
