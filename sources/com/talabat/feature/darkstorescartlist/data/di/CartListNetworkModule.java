package com.talabat.feature.darkstorescartlist.data.di;

import com.squareup.moshi.Moshi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.network.network.KeyValueHeaderInterceptor;
import com.talabat.feature.darkstorescartlist.data.remote.CartListApi;
import com.talabat.feature.darkstorescartlist.data.remote.CartListBaseUrl;
import com.talabat.feature.darkstorescartlist.data.remote.RestaurantJsonAdapter;
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
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0012\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0013\b\u0001\u0010\u0019\u001a\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u001b0\u001aH\u0007J&\u0010\u001c\u001a\u00020\u00102\b\b\u0001\u0010\u0018\u001a\u00020\u00172\b\b\u0001\u0010\u0013\u001a\u00020\u00122\b\b\u0001\u0010\u001d\u001a\u00020\bH\u0007¨\u0006\u001e"}, d2 = {"Lcom/talabat/feature/darkstorescartlist/data/di/CartListNetworkModule;", "", "()V", "provideAuthInterceptor", "Lokhttp3/Interceptor;", "secretProvider", "Lcom/talabat/authentication/aaa/secrets/SecretProvider;", "provideBaseUrl", "", "baseUrlFactory", "Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "vendorBaseUrl", "Lcom/talabat/feature/darkstorescartlist/data/remote/CartListBaseUrl;", "provideCartListApi", "Lcom/talabat/feature/darkstorescartlist/data/remote/CartListApi;", "retrofit", "Lretrofit2/Retrofit;", "provideMoshi", "Lcom/squareup/moshi/Moshi;", "moshi", "restaurantAdapter", "Lcom/talabat/feature/darkstorescartlist/data/remote/RestaurantJsonAdapter;", "provideOkHttpClient", "Lokhttp3/OkHttpClient;", "okHttpClient", "interceptors", "", "Lkotlin/jvm/JvmSuppressWildcards;", "provideRetrofit", "baseUrl", "com_talabat_feature_darkstores-cart-list_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class CartListNetworkModule {
    @IntoSet
    @CartList
    @NotNull
    @Provides
    public final Interceptor provideAuthInterceptor(@NotNull SecretProvider secretProvider) {
        Intrinsics.checkNotNullParameter(secretProvider, "secretProvider");
        return new KeyValueHeaderInterceptor("X-API-Key", secretProvider.getDarkstoresAPIKey(), true);
    }

    @CartList
    @NotNull
    @Provides
    public final String provideBaseUrl(@NotNull BaseUrlFactory baseUrlFactory, @NotNull CartListBaseUrl cartListBaseUrl) {
        Intrinsics.checkNotNullParameter(baseUrlFactory, "baseUrlFactory");
        Intrinsics.checkNotNullParameter(cartListBaseUrl, "vendorBaseUrl");
        return baseUrlFactory.baseUrl(cartListBaseUrl);
    }

    @NotNull
    @Provides
    public final CartListApi provideCartListApi(@CartList @NotNull Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        return (CartListApi) retrofit.create(CartListApi.class);
    }

    @CartList
    @NotNull
    @Provides
    public final Moshi provideMoshi(@NotNull Moshi moshi, @NotNull RestaurantJsonAdapter restaurantJsonAdapter) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(restaurantJsonAdapter, "restaurantAdapter");
        Moshi build = moshi.newBuilder().add((Object) restaurantJsonAdapter).build();
        Intrinsics.checkNotNullExpressionValue(build, "moshi.newBuilder()\n     …Adapter)\n        .build()");
        return build;
    }

    @CartList
    @NotNull
    @Provides
    public final OkHttpClient provideOkHttpClient(@NotNull OkHttpClient okHttpClient, @CartList @NotNull Set<Interceptor> set) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(set, "interceptors");
        OkHttpClient.Builder newBuilder = okHttpClient.newBuilder();
        for (Interceptor addInterceptor : set) {
            newBuilder.addInterceptor(addInterceptor);
        }
        return newBuilder.build();
    }

    @CartList
    @NotNull
    @Provides
    public final Retrofit provideRetrofit(@CartList @NotNull OkHttpClient okHttpClient, @CartList @NotNull Moshi moshi, @CartList @NotNull String str) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Retrofit build = new Retrofit.Builder().client(okHttpClient).baseUrl(str).addConverterFactory(MoshiConverterFactory.create(moshi)).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .c…e())\n            .build()");
        return build;
    }
}
