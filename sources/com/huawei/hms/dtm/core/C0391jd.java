package com.huawei.hms.dtm.core;

import com.huawei.hms.dtm.core.util.Logger;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.hms.dtm.core.jd  reason: case insensitive filesystem */
public class C0391jd implements C0386id {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f48498a;

    private C0391jd() {
        HashMap hashMap = new HashMap();
        this.f48498a = hashMap;
        hashMap.put("kit_package_name", "com.huawei.hms.dtmkit");
        this.f48498a.put("version", "6.6.0.302");
        this.f48498a.put("service", "dtmkit");
    }

    public static C0391jd a() {
        return new C0391jd();
    }

    public C0386id a(String str, String str2) {
        this.f48498a.put(str, str2);
        return this;
    }

    public C0391jd a(String str) {
        return (C0391jd) a("configurationId", str);
    }

    public C0391jd b(String str) {
        return (C0391jd) a("errorMessage", str);
    }

    public void b() {
        Logger.debug("DTM_REPORT_VENDOR, reportInfo:" + this.f48498a.toString());
        C0406md.a().a(J.b(), "DTM_REPORT_VENDOR", this.f48498a);
    }

    public C0391jd c(String str) {
        return (C0391jd) a("result", str);
    }

    public C0391jd d(String str) {
        return (C0391jd) a("time", str);
    }

    public C0391jd e(String str) {
        return (C0391jd) a("vendor", str);
    }
}
