package com.talabat.feature.mission.control.data.di;

import com.talabat.feature.mission.control.data.remote.PrimaryMissionControlApi;
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
public final class MissionControlNetworkModule_ProvidePrimaryMissionControlApiFactory implements Factory<PrimaryMissionControlApi> {
    private final Provider<String> baseUrlProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;

    public MissionControlNetworkModule_ProvidePrimaryMissionControlApiFactory(Provider<String> provider, Provider<OkHttpClient> provider2, Provider<Retrofit.Builder> provider3) {
        this.baseUrlProvider = provider;
        this.okHttpClientProvider = provider2;
        this.retrofitBuilderProvider = provider3;
    }

    public static MissionControlNetworkModule_ProvidePrimaryMissionControlApiFactory create(Provider<String> provider, Provider<OkHttpClient> provider2, Provider<Retrofit.Builder> provider3) {
        return new MissionControlNetworkModule_ProvidePrimaryMissionControlApiFactory(provider, provider2, provider3);
    }

    public static PrimaryMissionControlApi providePrimaryMissionControlApi(String str, OkHttpClient okHttpClient, Retrofit.Builder builder) {
        return (PrimaryMissionControlApi) Preconditions.checkNotNullFromProvides(MissionControlNetworkModule.INSTANCE.providePrimaryMissionControlApi(str, okHttpClient, builder));
    }

    public PrimaryMissionControlApi get() {
        return providePrimaryMissionControlApi(this.baseUrlProvider.get(), this.okHttpClientProvider.get(), this.retrofitBuilderProvider.get());
    }
}
