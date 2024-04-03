package com.talabat.feature.tokenization.data.di;

import com.talabat.core.network.domain.MoshiRetrofit;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.tokenization.data.baseurl.TokenizationBaseUrl;
import com.talabat.feature.tokenization.data.datasource.RemoteTokenizationDataSource;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/tokenization/data/di/TokenizationDataSourceModule;", "", "()V", "remoteTokenizationDataSource", "Lcom/talabat/feature/tokenization/data/datasource/RemoteTokenizationDataSource;", "retrofitBuilder", "Lretrofit2/Retrofit$Builder;", "tokenizationBaseUrl", "Lcom/talabat/feature/tokenization/data/baseurl/TokenizationBaseUrl;", "baseUrlFactory", "Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "com_talabat_feature_tokenization_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class TokenizationDataSourceModule {
    @NotNull
    public static final TokenizationDataSourceModule INSTANCE = new TokenizationDataSourceModule();

    private TokenizationDataSourceModule() {
    }

    @NotNull
    @Reusable
    @Provides
    public final RemoteTokenizationDataSource remoteTokenizationDataSource(@NotNull @MoshiRetrofit Retrofit.Builder builder, @NotNull TokenizationBaseUrl tokenizationBaseUrl, @NotNull BaseUrlFactory baseUrlFactory) {
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Intrinsics.checkNotNullParameter(tokenizationBaseUrl, "tokenizationBaseUrl");
        Intrinsics.checkNotNullParameter(baseUrlFactory, "baseUrlFactory");
        Retrofit build = builder.baseUrl(baseUrlFactory.baseUrl(tokenizationBaseUrl)).build();
        Intrinsics.checkNotNullExpressionValue(build, "retrofitBuilder\n        …rl))\n            .build()");
        return (RemoteTokenizationDataSource) build.create(RemoteTokenizationDataSource.class);
    }
}
