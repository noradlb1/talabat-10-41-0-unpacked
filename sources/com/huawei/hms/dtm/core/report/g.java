package com.huawei.hms.dtm.core.report;

import com.huawei.hms.dtm.core.report.h;
import com.huawei.hms.dtm.core.util.Logger;

public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f48570a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ h.a f48571b;

    public g(h.a aVar, long j11) {
        this.f48571b = aVar;
        this.f48570a = j11;
    }

    public void run() {
        if (!this.f48571b.f48575a || !this.f48571b.f48576b) {
            Logger.debug("DTM-Execute", "still foreground");
            return;
        }
        boolean unused = this.f48571b.f48575a = false;
        Logger.debug("DTM-Execute", "Background. Pause time: " + this.f48570a);
        h.f48574c.a();
    }
}
