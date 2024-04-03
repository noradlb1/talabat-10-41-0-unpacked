package com.huawei.agconnect.common.api;

import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.credential.obs.n;
import com.huawei.agconnect.https.Adapter;
import com.huawei.hmf.tasks.Task;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Authenticator;
import okhttp3.Interceptor;

public class Backend {

    public interface MethodType {
        public static final int GET = 0;
        public static final int POST = 1;
        public static final int PUT = 2;
    }

    @Deprecated
    public static <Req, Rsp> Task<Rsp> call(Req req, int i11, Class<Rsp> cls) {
        return n.a().a(req, i11, cls, AGConnectInstance.getInstance().getOptions());
    }

    @Deprecated
    public static <Req, Rsp> Task<Rsp> call(Req req, int i11, Class<Rsp> cls, AGConnectOptions aGConnectOptions) {
        return n.a().a(req, i11, cls, aGConnectOptions);
    }

    @Deprecated
    public static <Req, Rsp> Task<Rsp> call(Req req, int i11, Class<Rsp> cls, Adapter.Factory factory, long j11, TimeUnit timeUnit) {
        return call(req, i11, cls, factory, j11, timeUnit, (List<Interceptor>) null, (Authenticator) null, AGConnectInstance.getInstance().getOptions());
    }

    @Deprecated
    public static <Req, Rsp> Task<Rsp> call(Req req, int i11, Class<Rsp> cls, Adapter.Factory factory, long j11, TimeUnit timeUnit, AGConnectOptions aGConnectOptions) {
        return call(req, i11, cls, factory, j11, timeUnit, (List<Interceptor>) null, (Authenticator) null, aGConnectOptions);
    }

    public static <Req, Rsp> Task<Rsp> call(Req req, int i11, Class<Rsp> cls, Adapter.Factory factory, long j11, TimeUnit timeUnit, List<Interceptor> list, Authenticator authenticator, AGConnectOptions aGConnectOptions) {
        return n.a().a(req, i11, cls, factory, j11, timeUnit, list, authenticator, aGConnectOptions);
    }
}
