package com.huawei.hms.dtm.core;

import android.text.TextUtils;
import com.huawei.hms.dtm.core.util.Logger;

public class ge implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f48488a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ne f48489b;

    public ge(ne neVar, String str) {
        this.f48489b = neVar;
        this.f48488a = str;
    }

    public void run() {
        String str;
        synchronized (this.f48489b.f48535f) {
            str = null;
            if (!TextUtils.isEmpty(this.f48489b.f48534e)) {
                String c11 = this.f48489b.f48534e;
                String unused = this.f48489b.f48534e = null;
                str = c11;
            }
        }
        if (this.f48489b.f48532c != null && !TextUtils.isEmpty(str)) {
            Logger.info("DTM-AutoTrace", "WebSocket#send");
            this.f48489b.f48532c.send(this.f48488a);
        }
    }
}
