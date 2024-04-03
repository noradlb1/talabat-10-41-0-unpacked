package com.huawei.hms.analytics.framework.c;

import android.text.TextUtils;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.core.storage.Event;
import com.huawei.hms.analytics.framework.b.b;
import com.huawei.hms.analytics.framework.c.a.a;
import com.huawei.hms.analytics.framework.config.ICallback;
import com.huawei.hms.analytics.framework.config.IConfig;
import java.util.List;

public final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    String f47984a;

    /* renamed from: b  reason: collision with root package name */
    String f47985b;

    /* renamed from: c  reason: collision with root package name */
    List<Event> f47986c;

    /* renamed from: d  reason: collision with root package name */
    ICallback f47987d;

    public k(String str, String str2, List<Event> list, ICallback iCallback) {
        this.f47984a = str;
        this.f47985b = str2;
        this.f47986c = list;
        this.f47987d = iCallback;
    }

    public final void run() {
        List<Event> a11;
        a aVar = new a();
        aVar.f47946e = true;
        aVar.f47942a = this.f47984a;
        aVar.f47943b = this.f47985b;
        aVar.f47944c = b.a().a(this.f47984a).getServiceConfig();
        if (!this.f47987d.isStopEvent() && (a11 = c.a(this.f47984a, this.f47985b, true)) != null) {
            if (this.f47986c.size() <= 1) {
                String pushEvtFlag = this.f47986c.get(0).getPushEvtFlag();
                if (!TextUtils.isEmpty(pushEvtFlag)) {
                    for (Event next : a11) {
                        if (!pushEvtFlag.equals(next.getPushEvtFlag())) {
                            this.f47986c.add(next);
                        }
                    }
                }
            }
            this.f47986c.addAll(a11);
        }
        j jVar = new j(this.f47986c, aVar, this.f47987d);
        if (jVar.b()) {
            jVar.a(false, (IConfig) null);
            try {
                jVar.c();
                return;
            } catch (IllegalArgumentException e11) {
                HiLog.e("ReportAssignment", e11.getMessage());
            }
        }
        jVar.a(System.currentTimeMillis());
    }
}
