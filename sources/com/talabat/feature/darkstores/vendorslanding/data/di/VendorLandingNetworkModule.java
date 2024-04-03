package com.talabat.feature.darkstores.vendorslanding.data.di;

import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.core.network.domain.MoshiRetrofit;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.network.network.KeyValueHeaderInterceptor;
import com.talabat.feature.darkstores.vendorslanding.data.remote.GroceryBaseUrl;
import com.talabat.feature.darkstores.vendorslanding.data.remote.VendorLandingApi;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J%\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0013\b\u0001\u0010\u0010\u001a\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00120\u0011H\u0007J&\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010\u0015\u001a\u00020\u00162\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0017\u001a\u00020\bH\u0007J\u0012\u0010\u0018\u001a\u00020\u00192\b\b\u0001\u0010\u001a\u001a\u00020\u0014H\u0007¨\u0006\u001b"}, d2 = {"Lcom/talabat/feature/darkstores/vendorslanding/data/di/VendorLandingNetworkModule;", "", "()V", "provideAuthInterceptor", "Lokhttp3/Interceptor;", "secretProvider", "Lcom/talabat/authentication/aaa/secrets/SecretProvider;", "provideBaseUrl", "", "baseUrlFactory", "Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "groceryBaseUrl", "Lcom/talabat/feature/darkstores/vendorslanding/data/remote/GroceryBaseUrl;", "provideOkHttpClient", "Lokhttp3/OkHttpClient;", "okHttpClient", "interceptors", "", "Lkotlin/jvm/JvmSuppressWildcards;", "provideRetrofit", "Lretrofit2/Retrofit;", "retrofitBuilder", "Lretrofit2/Retrofit$Builder;", "baseUrl", "provideVendorApi", "Lcom/talabat/feature/darkstores/vendorslanding/data/remote/VendorLandingApi;", "retrofit", "com_talabat_feature_darkstores-vendor-landing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class VendorLandingNetworkModule {
    @IntoSet
    @VendorLanding
    @NotNull
    @Provides
    public final Interceptor provideAuthInterceptor(@NotNull SecretProvider secretProvider) {
        Intrinsics.checkNotNullParameter(secretProvider, "secretProvider");
        return new KeyValueHeaderInterceptor("X-API-Key", secretProvider.getDarkstoresAPIKey(), true);
    }

    @VendorLanding
    @NotNull
    @Provides
    public final String provideBaseUrl(@NotNull BaseUrlFactory baseUrlFactory, @NotNull GroceryBaseUrl groceryBaseUrl) {
        Intrinsics.checkNotNullParameter(baseUrlFactory, "baseUrlFactory");
        Intrinsics.checkNotNullParameter(groceryBaseUrl, "groceryBaseUrl");
        return baseUrlFactory.baseUrl(groceryBaseUrl);
    }

    @VendorLanding
    @NotNull
    @Provides
    public final OkHttpClient provideOkHttpClient(@NotNull OkHttpClient okHttpClient, @VendorLanding @NotNull Set<Interceptor> set) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(set, "interceptors");
        OkHttpClient.Builder newBuilder = okHttpClient.newBuilder();
        for (Interceptor addInterceptor : set) {
            newBuilder.addInterceptor(addInterceptor);
        }
        return newBuilder.build();
    }

    @VendorLanding
    @NotNull
    @Provides
    public final Retrofit provideRetrofit(@NotNull @MoshiRetrofit Retrofit.Builder builder, @VendorLanding @NotNull OkHttpClient okHttpClient, @VendorLanding @NotNull String str) {
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Retrofit build = builder.client(okHttpClient).baseUrl(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "retrofitBuilder.client(o…baseUrl)\n        .build()");
        return build;
    }

    @NotNull
    @Provides
    public final VendorLandingApi provideVendorApi(@VendorLanding @NotNull Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        return (VendorLandingApi) retrofit.create(VendorLandingApi.class);
    }
}
