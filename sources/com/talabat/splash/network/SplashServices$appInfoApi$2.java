package com.talabat.splash.network;

import com.talabat.splash.data.network.AppInfoApi;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/talabat/splash/data/network/AppInfoApi;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SplashServices$appInfoApi$2 extends Lambda implements Function0<AppInfoApi> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Retrofit f61498g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SplashServices$appInfoApi$2(Retrofit retrofit) {
        super(0);
        this.f61498g = retrofit;
    }

    public final AppInfoApi invoke() {
        return (AppInfoApi) this.f61498g.create(AppInfoApi.class);
    }
}
