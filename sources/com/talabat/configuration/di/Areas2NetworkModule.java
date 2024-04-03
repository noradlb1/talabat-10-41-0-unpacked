package com.talabat.configuration.di;

import com.talabat.configuration.areas.Areas2Rest;
import com.talabat.configuration.areas.endpoint.Areas2BaseUrl;
import com.talabat.core.network.domain.MoshiRetrofit;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/talabat/configuration/di/Areas2NetworkModule;", "", "()V", "areasRest", "Lcom/talabat/configuration/areas/Areas2Rest;", "baseUrlFactory", "Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "areas2BaseUrl", "Lcom/talabat/configuration/areas/endpoint/Areas2BaseUrl;", "retrofitBuilder", "Lretrofit2/Retrofit$Builder;", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class Areas2NetworkModule {
    @NotNull
    public static final Areas2NetworkModule INSTANCE = new Areas2NetworkModule();

    private Areas2NetworkModule() {
    }

    @NotNull
    @AreasRest
    @Provides
    public final Areas2Rest areasRest(@NotNull BaseUrlFactory baseUrlFactory, @NotNull Areas2BaseUrl areas2BaseUrl, @NotNull @MoshiRetrofit Retrofit.Builder builder) {
        Intrinsics.checkNotNullParameter(baseUrlFactory, "baseUrlFactory");
        Intrinsics.checkNotNullParameter(areas2BaseUrl, "areas2BaseUrl");
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Retrofit build = builder.baseUrl(baseUrlFactory.baseUrl(areas2BaseUrl)).build();
        Intrinsics.checkNotNullExpressionValue(build, "retrofitBuilder\n        …rl))\n            .build()");
        return (Areas2Rest) build.create(Areas2Rest.class);
    }
}
