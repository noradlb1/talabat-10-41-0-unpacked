package com.talabat.core.safety.data.di;

import com.talabat.core.network.domain.MoshiRetrofit;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.safety.data.interceptors.UserAgentInterceptor;
import com.talabat.core.safety.data.repository.shield.remote.ShieldBaseUrl;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J,\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\b2\b\b\u0001\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0014"}, d2 = {"Lcom/talabat/core/safety/data/di/PlayIntegrityNetworkModule;", "", "()V", "interceptor", "Lokhttp3/Interceptor;", "userAgentInterceptor", "Lcom/talabat/core/safety/data/interceptors/UserAgentInterceptor;", "provideBaseUrl", "", "baseUrlFactory", "Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "shieldBaseUrl", "Lcom/talabat/core/safety/data/repository/shield/remote/ShieldBaseUrl;", "retrofit", "Lretrofit2/Retrofit;", "okHttpClient", "Lokhttp3/OkHttpClient;", "baseUrl", "retrofitBuilder", "Lretrofit2/Retrofit$Builder;", "com_talabat_core_safety_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class PlayIntegrityNetworkModule {
    @NotNull
    @Reusable
    @Provides
    public final Interceptor interceptor(@NotNull UserAgentInterceptor userAgentInterceptor) {
        Intrinsics.checkNotNullParameter(userAgentInterceptor, "userAgentInterceptor");
        return userAgentInterceptor;
    }

    @ShieldEndpointBaseUrl
    @NotNull
    @Provides
    public final String provideBaseUrl(@NotNull BaseUrlFactory baseUrlFactory, @NotNull ShieldBaseUrl shieldBaseUrl) {
        Intrinsics.checkNotNullParameter(baseUrlFactory, "baseUrlFactory");
        Intrinsics.checkNotNullParameter(shieldBaseUrl, "shieldBaseUrl");
        return baseUrlFactory.baseUrl(shieldBaseUrl);
    }

    @NotNull
    @Reusable
    @Provides
    public final Retrofit retrofit(@NotNull OkHttpClient okHttpClient, @ShieldEndpointBaseUrl @NotNull String str, @NotNull @MoshiRetrofit Retrofit.Builder builder, @NotNull Interceptor interceptor) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        Retrofit build = builder.baseUrl(str).client(okHttpClient.newBuilder().addInterceptor(interceptor).build()).build();
        Intrinsics.checkNotNullExpressionValue(build, "retrofitBuilder.baseUrl(…build()\n        ).build()");
        return build;
    }
}
