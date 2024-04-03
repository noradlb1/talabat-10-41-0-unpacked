package com.huawei.agconnect.common.api;

import android.content.Context;
import com.huawei.agconnect.credential.obs.p;
import java.util.List;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

public class Client {
    public static OkHttpClient build(Context context, List<Interceptor> list) {
        return new p(context, list, false).a();
    }

    public static OkHttpClient build(Context context, List<Interceptor> list, boolean z11) {
        return new p(context, list, z11).a();
    }
}
