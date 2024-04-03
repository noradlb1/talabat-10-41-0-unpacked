package com.talabat.feature.mission.control.data.di;

import com.talabat.feature.mission.control.data.remote.LifeStyleMissionControlApi;
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
@QualifierMetadata({"javax.inject.Named", "com.talabat.core.network.domain.MoshiRetrofit"})
public final class MissionControlNetworkModule_ProvideLifeStyleMissionControlApiFactory implements Factory<LifeStyleMissionControlApi> {
    private final Provider<String> baseUrlProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;

    public MissionControlNetworkModule_ProvideLifeStyleMissionControlApiFactory(Provider<String> provider, Provider<OkHttpClient> provider2, Provider<Retrofit.Builder> provider3) {
        this.baseUrlProvider = provider;
        this.okHttpClientProvider = provider2;
        this.retrofitBuilderProvider = provider3;
    }

    public static MissionControlNetworkModule_ProvideLifeStyleMissionControlApiFactory create(Provider<String> provider, Provider<OkHttpClient> provider2, Provider<Retrofit.Builder> provider3) {
        return new MissionControlNetworkModule_ProvideLifeStyleMissionControlApiFactory(provider, provider2, provider3);
    }

    public static LifeStyleMissionControlApi provideLifeStyleMissionControlApi(String str, OkHttpClient okHttpClient, Retrofit.Builder builder) {
        return (LifeStyleMissionControlApi) Preconditions.checkNotNullFromProvides(MissionControlNetworkModule.INSTANCE.provideLifeStyleMissionControlApi(str, okHttpClient, builder));
    }

    public LifeStyleMissionControlApi get() {
        return provideLifeStyleMissionControlApi(this.baseUrlProvider.get(), this.okHttpClientProvider.get(), this.retrofitBuilderProvider.get());
    }
}
