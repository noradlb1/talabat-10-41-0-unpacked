package com.huawei.hms.analytics.framework.b;

import com.huawei.hms.analytics.core.storage.IStorageHandler;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f47926a = false;

    /* renamed from: b  reason: collision with root package name */
    public IStorageHandler f47927b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Long> f47928c = new ConcurrentHashMap();

    public final long a(String str) {
        Long l11 = this.f47928c.get(str);
        if (l11 != null) {
            return l11.longValue();
        }
        return 0;
    }

    public final void a(String str, long j11) {
        this.f47928c.put(str, Long.valueOf(j11));
    }
}
