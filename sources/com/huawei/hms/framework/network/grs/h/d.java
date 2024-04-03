package com.huawei.hms.framework.network.grs.h;

import android.os.SystemClock;
import com.huawei.hms.framework.common.Logger;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, a> f48943a = new ConcurrentHashMap(16);

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final long f48944a;

        /* renamed from: b  reason: collision with root package name */
        private final long f48945b;

        public a(long j11, long j12) {
            this.f48944a = j11;
            this.f48945b = j12;
        }

        public boolean a() {
            return SystemClock.elapsedRealtime() - this.f48945b <= this.f48944a;
        }
    }

    public static a a(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("map size of get is before: ");
        Map<String, a> map = f48943a;
        sb2.append(map.size());
        Logger.v("RequestUtil", sb2.toString());
        a aVar = map.get(str);
        Logger.v("RequestUtil", "map size of get is after: " + map.size());
        return aVar;
    }

    public static void a(String str, a aVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("map size of put is before: ");
        Map<String, a> map = f48943a;
        sb2.append(map.size());
        Logger.v("RequestUtil", sb2.toString());
        map.put(str, aVar);
        Logger.v("RequestUtil", "map size of put is after: " + map.size());
    }
}
