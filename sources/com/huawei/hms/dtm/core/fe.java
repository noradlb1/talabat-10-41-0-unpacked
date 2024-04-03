package com.huawei.hms.dtm.core;

import com.huawei.hms.dtm.core.ne;
import com.huawei.hms.dtm.core.util.Logger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import okhttp3.Request;

@Instrumented
public class fe implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f48485a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ne f48486b;

    public fe(ne neVar, String str) {
        this.f48486b = neVar;
        this.f48485a = str;
    }

    public void run() {
        Request.Builder url = new Request.Builder().url(this.f48485a);
        Request build = !(url instanceof Request.Builder) ? url.build() : OkHttp3Instrumentation.build(url);
        if (this.f48486b.f48533d != null) {
            Logger.info("DTM-AutoTrace", "WebSocket#connect");
            this.f48486b.f48533d.newWebSocket(build, new ne.a(this.f48486b, (ee) null));
        }
    }
}
