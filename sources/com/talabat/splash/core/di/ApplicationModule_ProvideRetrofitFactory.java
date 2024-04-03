package com.talabat.splash.core.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class ApplicationModule_ProvideRetrofitFactory implements Factory<Retrofit> {
    private final ApplicationModule module;

    public ApplicationModule_ProvideRetrofitFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideRetrofitFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideRetrofitFactory(applicationModule);
    }

    public static Retrofit provideRetrofit(ApplicationModule applicationModule) {
        return (Retrofit) Preconditions.checkNotNullFromProvides(applicationModule.provideRetrofit());
    }

    public Retrofit get() {
        return provideRetrofit(this.module);
    }
}
