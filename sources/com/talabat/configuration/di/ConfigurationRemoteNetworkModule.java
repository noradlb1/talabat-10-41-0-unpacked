package com.talabat.configuration.di;

import com.talabat.configuration.remote.ConfigurationRemoteRest;
import com.talabat.configuration.remote.endpoint.AppInfoBaseUrl;
import com.talabat.core.network.domain.MoshiRetrofit;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/talabat/configuration/di/ConfigurationRemoteNetworkModule;", "", "()V", "rest", "Lcom/talabat/configuration/remote/ConfigurationRemoteRest;", "baseUrlFactory", "Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "appInfoBaseUrl", "Lcom/talabat/configuration/remote/endpoint/AppInfoBaseUrl;", "retrofitBuilder", "Lretrofit2/Retrofit$Builder;", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class ConfigurationRemoteNetworkModule {
    @NotNull
    public static final ConfigurationRemoteNetworkModule INSTANCE = new ConfigurationRemoteNetworkModule();

    private ConfigurationRemoteNetworkModule() {
    }

    @AppInfoRest
    @NotNull
    @Provides
    public final ConfigurationRemoteRest rest(@NotNull BaseUrlFactory baseUrlFactory, @NotNull AppInfoBaseUrl appInfoBaseUrl, @NotNull @MoshiRetrofit Retrofit.Builder builder) {
        Intrinsics.checkNotNullParameter(baseUrlFactory, "baseUrlFactory");
        Intrinsics.checkNotNullParameter(appInfoBaseUrl, "appInfoBaseUrl");
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Retrofit build = builder.baseUrl(baseUrlFactory.baseUrl(appInfoBaseUrl)).build();
        Intrinsics.checkNotNullExpressionValue(build, "retrofitBuilder\n        …rl))\n            .build()");
        return (ConfigurationRemoteRest) build.create(ConfigurationRemoteRest.class);
    }
}
