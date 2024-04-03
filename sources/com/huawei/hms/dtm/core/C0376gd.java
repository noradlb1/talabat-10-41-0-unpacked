package com.huawei.hms.dtm.core;

import com.huawei.hms.dtm.core.util.Logger;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.hms.dtm.core.gd  reason: case insensitive filesystem */
public class C0376gd implements C0386id {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f48487a;

    private C0376gd() {
        HashMap hashMap = new HashMap();
        this.f48487a = hashMap;
        hashMap.put("kit_package_name", "com.huawei.hms.dtmkit");
        this.f48487a.put("version", "6.6.0.302");
        this.f48487a.put("service", "dtmkit");
    }

    public static C0376gd a() {
        return new C0376gd();
    }

    public C0376gd a(int i11) {
        return (C0376gd) a("retry", String.valueOf(i11));
    }

    public C0376gd a(String str) {
        return (C0376gd) a("configurationId", str);
    }

    public C0386id a(String str, String str2) {
        this.f48487a.put(str, str2);
        return this;
    }

    public C0376gd b(String str) {
        return (C0376gd) a("result", str);
    }

    public void b() {
        Logger.debug("DTM_DOWNLOAD_STATUS, reportInfo:" + this.f48487a.toString());
        C0406md.a().a(J.b(), "DTM_DOWNLOAD_STATUS", this.f48487a);
    }

    public C0376gd c(String str) {
        return (C0376gd) a("time", str);
    }
}
