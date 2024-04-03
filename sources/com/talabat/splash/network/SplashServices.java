package com.talabat.splash.network;

import com.talabat.splash.data.network.AppInfoApi;
import com.talabat.splash.domain.entity.AppInitRootEntity;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Retrofit;

@Singleton
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R#\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00010\u00018BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/talabat/splash/network/SplashServices;", "Lcom/talabat/splash/data/network/AppInfoApi;", "retrofit", "Lretrofit2/Retrofit;", "(Lretrofit2/Retrofit;)V", "appInfoApi", "kotlin.jvm.PlatformType", "getAppInfoApi", "()Lcom/talabat/splash/data/network/AppInfoApi;", "appInfoApi$delegate", "Lkotlin/Lazy;", "getAppInfo", "Lretrofit2/Call;", "Lcom/talabat/splash/domain/entity/AppInitRootEntity;", "countryId", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplashServices implements AppInfoApi {
    @NotNull
    private final Lazy appInfoApi$delegate;

    @Inject
    public SplashServices(@NotNull Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        this.appInfoApi$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new SplashServices$appInfoApi$2(retrofit));
    }

    private final AppInfoApi getAppInfoApi() {
        return (AppInfoApi) this.appInfoApi$delegate.getValue();
    }

    @NotNull
    public Call<AppInitRootEntity> getAppInfo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "countryId");
        return getAppInfoApi().getAppInfo(str);
    }
}
