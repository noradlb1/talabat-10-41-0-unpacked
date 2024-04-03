package com.huawei.hms.framework.network.grs.e;

import android.content.Context;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.b;
import com.huawei.hms.framework.network.grs.g.d;
import com.huawei.hms.framework.network.grs.g.g;
import com.huawei.hms.framework.network.grs.g.j.c;
import com.huawei.hms.framework.network.grs.h.e;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Map;

public class a {

    /* renamed from: e  reason: collision with root package name */
    private static final String f48853e = "a";

    /* renamed from: f  reason: collision with root package name */
    private static final Map<String, Map<String, Map<String, String>>> f48854f = new ConcurrentHashMap(16);

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Long> f48855a = new ConcurrentHashMap(16);

    /* renamed from: b  reason: collision with root package name */
    private final c f48856b;

    /* renamed from: c  reason: collision with root package name */
    private final c f48857c;

    /* renamed from: d  reason: collision with root package name */
    private final g f48858d;

    public a(c cVar, c cVar2, g gVar) {
        this.f48857c = cVar2;
        this.f48856b = cVar;
        this.f48858d = gVar;
        gVar.a(this);
    }

    private void a(GrsBaseInfo grsBaseInfo, b bVar, Context context, String str) {
        Long l11 = this.f48855a.get(grsBaseInfo.getGrsParasKey(true, true, context));
        if (e.a(l11)) {
            bVar.a(2);
            return;
        }
        if (e.a(l11, 300000)) {
            this.f48858d.a(new c(grsBaseInfo, context), (b) null, str, this.f48857c, -1);
        }
        bVar.a(1);
    }

    private void a(GrsBaseInfo grsBaseInfo, String str, Context context) {
        if (e.a(this.f48855a.get(str), 300000)) {
            this.f48858d.a(new c(grsBaseInfo, context), (b) null, (String) null, this.f48857c, -1);
        }
    }

    public c a() {
        return this.f48856b;
    }

    public Map<String, String> a(GrsBaseInfo grsBaseInfo, String str, b bVar, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        Map<String, Map<String, Map<String, String>>> map = f48854f;
        Map map2 = map.get(grsParasKey);
        if (map2 == null || map2.isEmpty()) {
            String str2 = f48853e;
            Logger.i(str2, "Cache size is: " + map.size());
            return new HashMap();
        }
        a(grsBaseInfo, bVar, context, str);
        return (Map) map2.get(str);
    }

    public void a(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        c cVar = this.f48856b;
        cVar.b(grsParasKey + "time", "0");
        Map<String, Long> map = this.f48855a;
        map.remove(grsParasKey + "time");
        Map<String, Map<String, Map<String, String>>> map2 = f48854f;
        map2.remove(grsParasKey);
        String str = f48853e;
        Logger.i(str, "Cache size is: " + map2.size());
        this.f48858d.a(grsParasKey);
    }

    public void a(GrsBaseInfo grsBaseInfo, d dVar, Context context, c cVar) {
        if (dVar.f() == 2) {
            Logger.w(f48853e, "update cache from server failed");
            return;
        }
        if (cVar.d().size() == 0) {
            String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
            if (dVar.m()) {
                f48854f.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(this.f48856b.a(grsParasKey, "")));
            } else {
                this.f48856b.b(grsParasKey, dVar.j());
                f48854f.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(dVar.j()));
            }
            if (!TextUtils.isEmpty(dVar.e())) {
                c cVar2 = this.f48856b;
                cVar2.b(grsParasKey + HttpHeaders.ETAG, dVar.e());
            }
            c cVar3 = this.f48856b;
            cVar3.b(grsParasKey + "time", dVar.a());
            this.f48855a.put(grsParasKey, Long.valueOf(Long.parseLong(dVar.a())));
        } else {
            this.f48856b.b("geoipCountryCode", dVar.j());
            this.f48856b.b("geoipCountryCodetime", dVar.a());
        }
        String str = f48853e;
        Logger.i(str, "Cache size is: " + f48854f.size());
    }

    public g b() {
        return this.f48858d;
    }

    public void b(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        String a11 = this.f48856b.a(grsParasKey, "");
        c cVar = this.f48856b;
        String a12 = cVar.a(grsParasKey + "time", "0");
        long j11 = 0;
        if (!TextUtils.isEmpty(a12) && a12.matches("\\d+")) {
            try {
                j11 = Long.parseLong(a12);
            } catch (NumberFormatException e11) {
                Logger.w(f48853e, "convert urlParamKey from String to Long catch NumberFormatException.", (Throwable) e11);
            }
        }
        Map<String, Map<String, Map<String, String>>> map = f48854f;
        map.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(a11));
        String str = f48853e;
        Logger.i(str, "Cache size is: " + map.size());
        this.f48855a.put(grsParasKey, Long.valueOf(j11));
        a(grsBaseInfo, grsParasKey, context);
    }

    public c c() {
        return this.f48857c;
    }
}
