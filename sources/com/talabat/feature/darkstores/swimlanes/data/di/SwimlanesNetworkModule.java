package com.talabat.feature.darkstores.swimlanes.data.di;

import com.talabat.core.network.domain.MoshiRetrofit;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.darkstores.swimlanes.data.remote.GroceryBaseUrl;
import com.talabat.feature.darkstores.swimlanes.data.remote.SwimlanesApi;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J$\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/darkstores/swimlanes/data/di/SwimlanesNetworkModule;", "", "()V", "BASE_URL", "", "provideBaseUrl", "baseUrlFactory", "Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "baseUrl", "Lcom/talabat/feature/darkstores/swimlanes/data/remote/GroceryBaseUrl;", "provideSiwmlanesApi", "Lcom/talabat/feature/darkstores/swimlanes/data/remote/SwimlanesApi;", "okHttpClient", "Lokhttp3/OkHttpClient;", "retrofitBuilder", "Lretrofit2/Retrofit$Builder;", "com_talabat_feature_darkstores-swimlanes_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class SwimlanesNetworkModule {
    @NotNull
    private static final String BASE_URL = "baseUrl";
    @NotNull
    public static final SwimlanesNetworkModule INSTANCE = new SwimlanesNetworkModule();

    private SwimlanesNetworkModule() {
    }

    @NotNull
    @Provides
    @Named("baseUrl")
    public final String provideBaseUrl(@NotNull BaseUrlFactory baseUrlFactory, @NotNull GroceryBaseUrl groceryBaseUrl) {
        Intrinsics.checkNotNullParameter(baseUrlFactory, "baseUrlFactory");
        Intrinsics.checkNotNullParameter(groceryBaseUrl, BASE_URL);
        return baseUrlFactory.baseUrl(groceryBaseUrl);
    }

    @NotNull
    @Provides
    public final SwimlanesApi provideSiwmlanesApi(@NotNull @Named("baseUrl") String str, @NotNull OkHttpClient okHttpClient, @NotNull @MoshiRetrofit Retrofit.Builder builder) {
        Intrinsics.checkNotNullParameter(str, BASE_URL);
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Retrofit build = builder.client(okHttpClient).baseUrl(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "retrofitBuilder\n        …Url)\n            .build()");
        return (SwimlanesApi) build.create(SwimlanesApi.class);
    }
}
