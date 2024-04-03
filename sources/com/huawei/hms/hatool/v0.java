package com.huawei.hms.hatool;

import android.content.Context;
import android.util.Pair;
import java.util.List;
import java.util.Map;

public class v0 implements g {

    /* renamed from: a  reason: collision with root package name */
    private Context f49140a = q0.i();

    /* renamed from: b  reason: collision with root package name */
    private String f49141b;

    /* renamed from: c  reason: collision with root package name */
    private String f49142c;

    /* renamed from: d  reason: collision with root package name */
    private String f49143d;

    public v0(String str, String str2, String str3) {
        this.f49141b = str;
        this.f49142c = str2;
        this.f49143d = str3;
    }

    private void a(String str, List<b1> list) {
        Pair<String, String> a11 = n1.a(str);
        new u(list, (String) a11.first, (String) a11.second, this.f49143d).a();
    }

    public void run() {
        v.c("hmsSdk", "eventReportTask is running");
        boolean a11 = c0.a(this.f49140a);
        if (a11) {
            v.c("hmsSdk", "workKey is refresh,begin report all data");
            this.f49142c = "alltype";
        }
        try {
            Map<String, List<b1>> a12 = c1.a(this.f49140a, this.f49141b, this.f49142c);
            if (a12.size() == 0) {
                v.b("hmsSdk", "no have events to report: tag:%s : type:%s", this.f49141b, this.f49142c);
                if ("alltype".equals(this.f49142c)) {
                    d.a(this.f49140a, "stat_v2_1", new String[0]);
                    d.a(this.f49140a, "cached_v2_1", new String[0]);
                    return;
                }
                String a13 = n1.a(this.f49141b, this.f49142c);
                d.a(this.f49140a, "stat_v2_1", a13);
                d.a(this.f49140a, "cached_v2_1", a13);
                return;
            }
            for (Map.Entry next : a12.entrySet()) {
                a((String) next.getKey(), (List) next.getValue());
            }
            if ("alltype".equals(this.f49142c)) {
                d.a(this.f49140a, "stat_v2_1", new String[0]);
                d.a(this.f49140a, "cached_v2_1", new String[0]);
            } else {
                String a14 = n1.a(this.f49141b, this.f49142c);
                d.a(this.f49140a, "stat_v2_1", a14);
                d.a(this.f49140a, "cached_v2_1", a14);
            }
            if (a11) {
                v.c("hmsSdk", "refresh local key");
                o0.d().b();
            }
        } catch (IllegalArgumentException e11) {
            v.e("hmsSdk", "readEventRecords handData IllegalArgumentException:" + e11.getMessage());
            if ("alltype".equals(this.f49142c)) {
                d.a(this.f49140a, "stat_v2_1", new String[0]);
                d.a(this.f49140a, "cached_v2_1", new String[0]);
            } else {
                String a15 = n1.a(this.f49141b, this.f49142c);
                d.a(this.f49140a, "stat_v2_1", a15);
                d.a(this.f49140a, "cached_v2_1", a15);
            }
        } catch (Exception e12) {
            v.e("hmsSdk", "readEventRecords handData Exception:" + e12.getMessage());
            if ("alltype".equals(this.f49142c)) {
                d.a(this.f49140a, "stat_v2_1", new String[0]);
                d.a(this.f49140a, "cached_v2_1", new String[0]);
            } else {
                String a16 = n1.a(this.f49141b, this.f49142c);
                d.a(this.f49140a, "stat_v2_1", a16);
                d.a(this.f49140a, "cached_v2_1", a16);
            }
        } catch (Throwable th2) {
            if ("alltype".equals(this.f49142c)) {
                d.a(this.f49140a, "stat_v2_1", new String[0]);
                d.a(this.f49140a, "cached_v2_1", new String[0]);
            } else {
                String a17 = n1.a(this.f49141b, this.f49142c);
                d.a(this.f49140a, "stat_v2_1", a17);
                d.a(this.f49140a, "cached_v2_1", a17);
            }
            throw th2;
        }
    }
}
