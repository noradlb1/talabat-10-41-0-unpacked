package com.talabat.feature.darkstoresvendor.data.di;

import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.core.network.domain.MoshiRetrofit;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.network.domain.endpoint.IBaseUrl;
import com.talabat.core.network.network.KeyValueHeaderInterceptor;
import com.talabat.feature.darkstoresvendor.data.remote.GroceryAffordabilityApi;
import com.talabat.feature.darkstoresvendor.data.remote.GroceryAffordabilityBaseUrl;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\fH\u0007J\u0012\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0007J\b\u0010\u0011\u001a\u00020\fH\u0007J%\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0013\b\u0001\u0010\u0015\u001a\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00170\u0016H\u0007J&\u0010\u0018\u001a\u00020\u00102\b\b\u0001\u0010\u0019\u001a\u00020\u001a2\b\b\u0001\u0010\u0014\u001a\u00020\u00132\b\b\u0001\u0010\u001b\u001a\u00020\bH\u0007¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/darkstoresvendor/data/di/GroceryAffordabilityNetworkModule;", "", "()V", "provideAuthInterceptor", "Lokhttp3/Interceptor;", "secretProvider", "Lcom/talabat/authentication/aaa/secrets/SecretProvider;", "provideBaseUrl", "", "baseUrlFactory", "Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "groceryAffordabilityBaseUrl", "Lcom/talabat/core/network/domain/endpoint/IBaseUrl;", "provideGroceryAffordabilityApi", "Lcom/talabat/feature/darkstoresvendor/data/remote/GroceryAffordabilityApi;", "retrofit", "Lretrofit2/Retrofit;", "provideGroceryAffordabilityBaseUrl", "provideOkHttpClient", "Lokhttp3/OkHttpClient;", "okHttpClient", "interceptors", "", "Lkotlin/jvm/JvmSuppressWildcards;", "provideRetrofit", "retrofitBuilder", "Lretrofit2/Retrofit$Builder;", "baseUrl", "Companion", "com_talabat_feature_darkstores-vendor_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class GroceryAffordabilityNetworkModule {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String HEADER_API_KEY = "X-API-Key";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/darkstoresvendor/data/di/GroceryAffordabilityNetworkModule$Companion;", "", "()V", "HEADER_API_KEY", "", "com_talabat_feature_darkstores-vendor_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @IntoSet
    @NotNull
    @GroceryAffordability
    @Provides
    public final Interceptor provideAuthInterceptor(@NotNull SecretProvider secretProvider) {
        Intrinsics.checkNotNullParameter(secretProvider, "secretProvider");
        return new KeyValueHeaderInterceptor(HEADER_API_KEY, secretProvider.getDarkstoresAPIKey(), true);
    }

    @NotNull
    @GroceryAffordability
    @Provides
    public final String provideBaseUrl(@NotNull BaseUrlFactory baseUrlFactory, @NotNull @GroceryAffordability IBaseUrl iBaseUrl) {
        Intrinsics.checkNotNullParameter(baseUrlFactory, "baseUrlFactory");
        Intrinsics.checkNotNullParameter(iBaseUrl, "groceryAffordabilityBaseUrl");
        return baseUrlFactory.baseUrl(iBaseUrl);
    }

    @NotNull
    @Provides
    public final GroceryAffordabilityApi provideGroceryAffordabilityApi(@NotNull @GroceryAffordability Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        return (GroceryAffordabilityApi) retrofit.create(GroceryAffordabilityApi.class);
    }

    @NotNull
    @GroceryAffordability
    @Provides
    public final IBaseUrl provideGroceryAffordabilityBaseUrl() {
        return new GroceryAffordabilityBaseUrl();
    }

    @NotNull
    @GroceryAffordability
    @Provides
    public final OkHttpClient provideOkHttpClient(@NotNull OkHttpClient okHttpClient, @NotNull @GroceryAffordability Set<Interceptor> set) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(set, "interceptors");
        OkHttpClient.Builder newBuilder = okHttpClient.newBuilder();
        for (Interceptor addInterceptor : set) {
            newBuilder.addInterceptor(addInterceptor);
        }
        return newBuilder.build();
    }

    @NotNull
    @GroceryAffordability
    @Provides
    public final Retrofit provideRetrofit(@NotNull @MoshiRetrofit Retrofit.Builder builder, @NotNull @GroceryAffordability OkHttpClient okHttpClient, @NotNull @GroceryAffordability String str) {
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Retrofit build = builder.client(okHttpClient).baseUrl(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "retrofitBuilder.client(o…Url)\n            .build()");
        return build;
    }
}
