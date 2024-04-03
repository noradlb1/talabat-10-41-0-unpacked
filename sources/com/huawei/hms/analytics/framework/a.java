package com.huawei.hms.analytics.framework;

import com.huawei.hms.analytics.core.storage.Event;
import com.huawei.hms.analytics.core.storage.IStorageHandler;
import com.huawei.hms.analytics.framework.SyncManager;
import com.huawei.hms.analytics.framework.b.c;
import com.huawei.hms.analytics.framework.c.f;
import com.huawei.hms.analytics.framework.c.h;
import com.huawei.hms.analytics.framework.config.ICallback;
import com.huawei.hms.analytics.framework.config.IConfig;
import com.huawei.hms.analytics.framework.e.b;
import java.util.List;
import org.json.JSONObject;

public final class a implements HAFrameworkInstance {

    /* renamed from: a  reason: collision with root package name */
    private String f47919a;

    public a(String str) {
        this.f47919a = str;
    }

    private com.huawei.hms.analytics.framework.c.a.a a(IConfig iConfig, boolean z11, String str) {
        com.huawei.hms.analytics.framework.c.a.a aVar = new com.huawei.hms.analytics.framework.c.a.a();
        aVar.f47943b = str;
        aVar.f47942a = this.f47919a;
        aVar.f47944c = iConfig;
        aVar.f47947f = z11;
        return aVar;
    }

    public final void clearCacheData(String str) {
        com.huawei.hms.analytics.framework.d.a.a().b(this.f47919a);
    }

    public final void onBackground(long j11) {
        b a11 = com.huawei.hms.analytics.framework.e.a.a().a(this.f47919a);
        a11.f47993c = true;
        a11.f47994d = j11;
    }

    public final void onEvent(String str, List<JSONObject> list, ICallback iCallback) {
        com.huawei.hms.analytics.framework.d.a.a().a(this.f47919a, str, list, iCallback);
    }

    public final void onEvent(String str, List<JSONObject> list, ICallback iCallback, long j11) {
        com.huawei.hms.analytics.framework.d.a.a().a(this.f47919a, str, list, iCallback, j11);
    }

    public final void onEvent(List<Event> list, ICallback iCallback) {
        com.huawei.hms.analytics.framework.d.a.a().a(list, iCallback);
    }

    public final void onEventRecord(String str, List<JSONObject> list, long j11) {
        com.huawei.hms.analytics.framework.d.a.a();
        com.huawei.hms.analytics.framework.d.a.a(this.f47919a, str, list, j11);
    }

    public final void onForeground(long j11) {
        b a11 = com.huawei.hms.analytics.framework.e.a.a().a(this.f47919a);
        if (a11.f47994d != 0) {
            a11.f47993c = j11 - a11.f47994d > a11.f47992b;
            a11.f47994d = 0;
        }
    }

    public final void onReport(IConfig iConfig, String str, ICallback iCallback) {
        com.huawei.hms.analytics.framework.d.a.a();
        com.huawei.hms.analytics.framework.c.a.a a11 = a(iConfig, true, str);
        if (com.huawei.hms.analytics.framework.d.a.a(a11.f47942a)) {
            SyncManager.getInstance().start(SyncManager.TaskNames.REGION_CHANGE);
            new f(a11, iCallback).run();
            return;
        }
        IStorageHandler a12 = com.huawei.hms.analytics.framework.a.a.a(a11.f47942a);
        if (a12 != null) {
            a12.deleteByTag(a11.f47942a);
            com.huawei.hms.analytics.framework.b.b.a().a(a11.f47942a).serviceListener(true, a11.f47944c);
        }
    }

    public final void onReport(IConfig iConfig, String str, List<?> list, ICallback iCallback) {
        com.huawei.hms.analytics.framework.c.a.a a11 = a(iConfig, !iCallback.isNeedStorage(), str);
        if (!iCallback.isNeedStorage()) {
            a11.f47946e = true;
        }
        com.huawei.hms.analytics.framework.d.a.a();
        if (com.huawei.hms.analytics.framework.d.a.a(a11.f47942a)) {
            com.huawei.hms.analytics.framework.f.a.b().a(new f(a11, list, iCallback));
        }
    }

    public final void onReport(String str, ICallback iCallback) {
        com.huawei.hms.analytics.framework.d.a.a();
        String str2 = this.f47919a;
        if (com.huawei.hms.analytics.framework.d.a.a(str2)) {
            com.huawei.hms.analytics.framework.f.a.b().a(new h(str2, str, iCallback));
        }
    }

    public final void onStreamEvent(String str, List<JSONObject> list, ICallback iCallback) {
        com.huawei.hms.analytics.framework.d.a.a();
        com.huawei.hms.analytics.framework.d.a.b(this.f47919a, str, list, iCallback);
    }

    public final void onStreamEvent(String str, List<JSONObject> list, ICallback iCallback, long j11) {
        com.huawei.hms.analytics.framework.d.a.a();
        com.huawei.hms.analytics.framework.d.a.b(this.f47919a, str, list, iCallback, j11);
    }

    public final void setMinSessionDuration(long j11) {
        com.huawei.hms.analytics.framework.e.a.a().a(this.f47919a).f47992b = j11;
    }

    public final void setNeedRefreshSession(boolean z11) {
        c b11 = com.huawei.hms.analytics.framework.b.b.a().b(this.f47919a);
        if (b11 != null) {
            b11.f47926a = z11;
        }
    }

    public final void setSessionTimeoutDuration(long j11) {
        com.huawei.hms.analytics.framework.e.a.a().a(this.f47919a).f47991a = j11;
    }
}
