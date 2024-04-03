package com.huawei.hms.analytics.framework.c;

import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.core.storage.Event;
import com.huawei.hms.analytics.core.storage.IStorageHandler;
import com.huawei.hms.analytics.framework.a.a;
import com.huawei.hms.analytics.framework.b.b;
import com.huawei.hms.analytics.framework.config.ICallback;
import java.util.List;

public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private String f47976a;

    /* renamed from: b  reason: collision with root package name */
    private String f47977b;

    /* renamed from: c  reason: collision with root package name */
    private ICallback f47978c;

    /* renamed from: d  reason: collision with root package name */
    private IStorageHandler f47979d;

    public h(String str, String str2, ICallback iCallback) {
        this.f47976a = str;
        this.f47977b = str2;
        this.f47978c = iCallback;
        this.f47979d = a.a(str);
    }

    public final void run() {
        HiLog.d("ReportMission", "report running, serviceTag: " + this.f47976a);
        ICallback iCallback = this.f47978c;
        if (iCallback != null && iCallback.isAAIDChanged(this.f47976a, true)) {
            HiLog.i("ReportMission", "aaid changed");
        } else if (this.f47979d != null) {
            List<Event> a11 = c.a(this.f47976a, this.f47977b, false);
            if (a11 != null && a11.size() > 0) {
                this.f47979d.insertEx(a11);
            }
            com.huawei.hms.analytics.framework.c.a.a aVar = new com.huawei.hms.analytics.framework.c.a.a();
            aVar.f47942a = this.f47976a;
            aVar.f47943b = this.f47977b;
            aVar.f47944c = b.a().a(this.f47976a).getServiceConfig();
            new g((List<Event>) null, aVar, this.f47978c).d();
        }
    }
}
