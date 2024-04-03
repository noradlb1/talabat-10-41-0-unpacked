package com.talabat.darkstores.di;

import com.talabat.darkstores.data.mission.control.MissionControlProductApi;
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
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.Darkstores", "com.talabat.darkstores.di.qualifier.QCommerceGrocery"})
public final class DarkstoresApiModule_ProvideMissionControlProductApiFactory implements Factory<MissionControlProductApi> {
    private final Provider<String> baseUrlProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;

    public DarkstoresApiModule_ProvideMissionControlProductApiFactory(Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        this.retrofitBuilderProvider = provider;
        this.okHttpClientProvider = provider2;
        this.baseUrlProvider = provider3;
    }

    public static DarkstoresApiModule_ProvideMissionControlProductApiFactory create(Provider<Retrofit.Builder> provider, Provider<OkHttpClient> provider2, Provider<String> provider3) {
        return new DarkstoresApiModule_ProvideMissionControlProductApiFactory(provider, provider2, provider3);
    }

    public static MissionControlProductApi provideMissionControlProductApi(Retrofit.Builder builder, OkHttpClient okHttpClient, String str) {
        return (MissionControlProductApi) Preconditions.checkNotNullFromProvides(DarkstoresApiModule.INSTANCE.provideMissionControlProductApi(builder, okHttpClient, str));
    }

    public MissionControlProductApi get() {
        return provideMissionControlProductApi(this.retrofitBuilderProvider.get(), this.okHttpClientProvider.get(), this.baseUrlProvider.get());
    }
}
