package com.talabat.feature.tmart.growth.data.di;

import com.serjltt.moshi.adapters.FallbackEnum;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.core.network.endpoint.GroceryEndPointProvider;
import com.talabat.core.network.network.KeyValueHeaderInterceptor;
import com.talabat.feature.tmart.growth.data.remote.TMartGrowthApi;
import com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthReminderResponse;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0007H\u0007J*\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/di/TMartGrowthNetworkModule;", "", "()V", "BASE_URL", "", "provideBaseUrl", "provideFeatureMoshi", "Lcom/squareup/moshi/Moshi;", "provideTMartGrowthApi", "Lcom/talabat/feature/tmart/growth/data/remote/TMartGrowthApi;", "baseUrl", "featureMoshi", "okHttpClient", "Lokhttp3/OkHttpClient;", "secretProvider", "Lcom/talabat/authentication/aaa/secrets/SecretProvider;", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class TMartGrowthNetworkModule {
    @NotNull
    private static final String BASE_URL = "baseUrl";
    @NotNull
    public static final TMartGrowthNetworkModule INSTANCE = new TMartGrowthNetworkModule();

    private TMartGrowthNetworkModule() {
    }

    @NotNull
    @Provides
    @Named("baseUrl")
    public final String provideBaseUrl() {
        return new GroceryEndPointProvider((String) null, (String) null, 3, (DefaultConstructorMarker) null).getBaseUrl();
    }

    @NotNull
    @Provides
    public final Moshi provideFeatureMoshi() {
        Class cls = TMartGrowthReminderResponse.Plain.class;
        Class cls2 = TMartGrowthReminderResponse.Rich.class;
        Moshi build = new Moshi.Builder().add(FallbackEnum.ADAPTER_FACTORY).add((JsonAdapter.Factory) PolymorphicJsonAdapterFactory.of(TMartGrowthReminderResponse.class, "type").withSubtype(TMartGrowthReminderResponse.Basic.class, TMartGrowthReminderResponse.Type.WIDGET_BASIC.getApiName()).withSubtype(cls, TMartGrowthReminderResponse.Type.MESSAGE_PLAIN.getApiName()).withSubtype(cls2, TMartGrowthReminderResponse.Type.WIDGET_RICH.getApiName()).withDefaultValue(TMartGrowthReminderResponse.Unknown.INSTANCE)).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n        .add(F…       )\n        .build()");
        return build;
    }

    @NotNull
    @Provides
    public final TMartGrowthApi provideTMartGrowthApi(@NotNull @Named("baseUrl") String str, @NotNull Moshi moshi, @NotNull OkHttpClient okHttpClient, @NotNull SecretProvider secretProvider) {
        Intrinsics.checkNotNullParameter(str, BASE_URL);
        Intrinsics.checkNotNullParameter(moshi, "featureMoshi");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(secretProvider, "secretProvider");
        Retrofit build = new Retrofit.Builder().client(okHttpClient.newBuilder().addInterceptor(new KeyValueHeaderInterceptor("X-API-Key", secretProvider.getTMartAPIKey(), true)).build()).baseUrl(str).addConverterFactory(MoshiConverterFactory.create(moshi)).build();
        Intrinsics.checkNotNullExpressionValue(build, "okHttpClient.newBuilder(…   .build()\n            }");
        return (TMartGrowthApi) build.create(TMartGrowthApi.class);
    }
}
