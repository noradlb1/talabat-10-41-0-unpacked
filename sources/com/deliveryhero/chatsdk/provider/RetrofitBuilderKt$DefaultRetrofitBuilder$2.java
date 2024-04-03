package com.deliveryhero.chatsdk.provider;

import com.deliveryhero.customerchat.analytics.service.AnalyticsClientKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lretrofit2/Retrofit$Builder;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RetrofitBuilderKt$DefaultRetrofitBuilder$2 extends Lambda implements Function0<Retrofit.Builder> {
    public static final RetrofitBuilderKt$DefaultRetrofitBuilder$2 INSTANCE = new RetrofitBuilderKt$DefaultRetrofitBuilder$2();

    public RetrofitBuilderKt$DefaultRetrofitBuilder$2() {
        super(0);
    }

    public final Retrofit.Builder invoke() {
        return new Retrofit.Builder().baseUrl(AnalyticsClientKt.DUMMY_URL).addCallAdapterFactory(RetrofitBuilderKt.getCallAdapter()).addConverterFactory(RetrofitBuilderKt.getMoshiConverter());
    }
}
