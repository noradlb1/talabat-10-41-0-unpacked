package com.huawei.hms.dtm.core;

import com.huawei.hms.dtm.core.util.h;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.hms.dtm.core.hd  reason: case insensitive filesystem */
public class C0381hd implements C0386id {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f48490a;

    private C0381hd() {
        HashMap hashMap = new HashMap();
        this.f48490a = hashMap;
        hashMap.put("kit_package_name", "com.huawei.hms.dtmkit");
        this.f48490a.put("version", "6.6.0.302");
        this.f48490a.put("service", "dtmkit");
    }

    public static C0381hd a() {
        return new C0381hd();
    }

    public C0381hd a(String str) {
        return (C0381hd) a("configurationId", str);
    }

    public C0386id a(String str, String str2) {
        this.f48490a.put(str, str2);
        return this;
    }

    public void a(Throwable th2, String str) {
        if (th2 != null && J.a() != null) {
            String configurationID = DynamicTagManager.getInstance().getConfigurationID();
            c("DTM_RUN_EXCEPTION").e(th2.getClass().getSimpleName()).a(configurationID).d(h.a(Thread.currentThread(), th2)).b(str).b();
        }
    }

    public C0381hd b(String str) {
        return (C0381hd) a("exception_location", str);
    }

    public void b() {
        C0406md.a().a(J.b(), this.f48490a.get("REPORT_NAME"), this.f48490a);
    }

    public C0381hd c(String str) {
        return (C0381hd) a("REPORT_NAME", str);
    }

    public C0381hd d(String str) {
        return (C0381hd) a("result", str);
    }

    public C0381hd e(String str) {
        return (C0381hd) a("throwable_name", str);
    }
}
