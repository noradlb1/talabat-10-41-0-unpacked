package com.huawei.hms.analytics.framework.d;

import com.huawei.hms.analytics.core.storage.Event;
import com.huawei.hms.analytics.core.storage.IStorageHandler;
import com.huawei.hms.analytics.framework.c.d;
import com.huawei.hms.analytics.framework.config.ICallback;
import com.huawei.hms.analytics.framework.policy.IStoragePolicy;
import java.util.List;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f47988a;

    public static a a() {
        if (f47988a == null) {
            b();
        }
        return f47988a;
    }

    public static void a(String str, String str2, List<JSONObject> list, long j11) {
        new d(str, str2, list, j11).run();
    }

    public static boolean a(String str) {
        IStoragePolicy b11 = com.huawei.hms.analytics.framework.a.a.b(str);
        return b11 != null && b11.decide(IStoragePolicy.PolicyType.NETWORK, (Object) "");
    }

    private static synchronized void b() {
        synchronized (a.class) {
            if (f47988a == null) {
                f47988a = new a();
            }
        }
    }

    public static void b(String str, String str2, List<JSONObject> list, ICallback iCallback) {
        d dVar = new d(str, str2, list);
        dVar.f47964a = true;
        dVar.f47965b = iCallback;
        com.huawei.hms.analytics.framework.f.a.a().a(dVar);
    }

    public static void b(String str, String str2, List<JSONObject> list, ICallback iCallback, long j11) {
        d dVar = new d(str, str2, list, j11);
        dVar.f47964a = true;
        dVar.f47965b = iCallback;
        com.huawei.hms.analytics.framework.f.a.a().a(dVar);
    }

    public final synchronized void a(String str, String str2, List<JSONObject> list, ICallback iCallback) {
        d dVar = new d(str, str2, list);
        dVar.f47965b = iCallback;
        com.huawei.hms.analytics.framework.f.a.a().a(dVar);
    }

    public final synchronized void a(String str, String str2, List<JSONObject> list, ICallback iCallback, long j11) {
        d dVar = new d(str, str2, list, j11);
        dVar.f47965b = iCallback;
        com.huawei.hms.analytics.framework.f.a.a().a(dVar);
    }

    public final synchronized void a(List<Event> list, ICallback iCallback) {
        d dVar = new d(list);
        dVar.f47965b = iCallback;
        com.huawei.hms.analytics.framework.f.a.a().a(dVar);
    }

    public final synchronized void b(String str) {
        IStorageHandler a11 = com.huawei.hms.analytics.framework.a.a.a(str);
        if (a11 != null) {
            a11.deleteAll();
        }
    }
}
