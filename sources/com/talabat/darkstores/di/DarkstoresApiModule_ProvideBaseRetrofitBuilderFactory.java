package com.talabat.darkstores.di;

import com.squareup.moshi.Moshi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata("com.talabat.darkstores.di.LibScope")
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresApiModule_ProvideBaseRetrofitBuilderFactory implements Factory<Retrofit.Builder> {
    private final Provider<Moshi> moshiProvider;

    public DarkstoresApiModule_ProvideBaseRetrofitBuilderFactory(Provider<Moshi> provider) {
        this.moshiProvider = provider;
    }

    public static DarkstoresApiModule_ProvideBaseRetrofitBuilderFactory create(Provider<Moshi> provider) {
        return new DarkstoresApiModule_ProvideBaseRetrofitBuilderFactory(provider);
    }

    public static Retrofit.Builder provideBaseRetrofitBuilder(Moshi moshi) {
        return (Retrofit.Builder) Preconditions.checkNotNullFromProvides(DarkstoresApiModule.INSTANCE.provideBaseRetrofitBuilder(moshi));
    }

    public Retrofit.Builder get() {
        return provideBaseRetrofitBuilder(this.moshiProvider.get());
    }
}
