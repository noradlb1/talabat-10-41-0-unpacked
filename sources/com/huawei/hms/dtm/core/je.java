package com.huawei.hms.dtm.core;

import android.text.TextUtils;
import com.huawei.hms.dtm.core.ne;
import com.huawei.hms.dtm.core.util.Logger;

public class je implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f48499a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ne.a f48500b;

    public je(ne.a aVar, String str) {
        this.f48500b = aVar;
        this.f48499a = str;
    }

    public void run() {
        if (!TextUtils.isEmpty(this.f48499a) && this.f48499a.equals("Ping")) {
            Logger.info("DTM-AutoTrace", "receive heartbeat.");
            ne.this.f48532c.send("Pong");
        }
    }
}
