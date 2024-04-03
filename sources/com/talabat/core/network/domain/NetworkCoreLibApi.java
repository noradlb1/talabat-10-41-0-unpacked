package com.talabat.core.network.domain;

import com.talabat.core.di.Api;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import kotlin.Deprecated;
import kotlin.Metadata;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000b8gX§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u000b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/talabat/core/network/domain/NetworkCoreLibApi;", "Lcom/talabat/core/di/Api;", "baseUrlFactory", "Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "getBaseUrlFactory", "()Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "retrofit", "Lretrofit2/Retrofit$Builder;", "getRetrofit$annotations", "()V", "getRetrofit", "()Lretrofit2/Retrofit$Builder;", "retrofitWithGson", "getRetrofitWithGson$annotations", "getRetrofitWithGson", "retrofitWithMoshi", "getRetrofitWithMoshi", "com_talabat_core_network_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface NetworkCoreLibApi extends Api {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated(message = "Please use Retrofit with Moshi converter")
        public static /* synthetic */ void getRetrofit$annotations() {
        }

        @Deprecated(message = "Please use Retrofit with Moshi converter")
        public static /* synthetic */ void getRetrofitWithGson$annotations() {
        }
    }

    @NotNull
    BaseUrlFactory getBaseUrlFactory();

    @NotNull
    OkHttpClient getOkHttpClient();

    @NotNull
    Retrofit.Builder getRetrofit();

    @NotNull
    @GsonRetrofit
    Retrofit.Builder getRetrofitWithGson();

    @NotNull
    @MoshiRetrofit
    Retrofit.Builder getRetrofitWithMoshi();
}
