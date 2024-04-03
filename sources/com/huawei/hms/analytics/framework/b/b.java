package com.huawei.hms.analytics.framework.b;

import com.huawei.hms.analytics.framework.config.ICollectorConfig;
import com.huawei.hms.analytics.framework.config.IMandatoryParameters;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public final class b {

    /* renamed from: c  reason: collision with root package name */
    private static final b f47923c = new b();

    /* renamed from: a  reason: collision with root package name */
    public IMandatoryParameters f47924a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, a> f47925b = new ConcurrentHashMap();

    public static b a() {
        return f47923c;
    }

    public final ICollectorConfig a(String str) {
        a aVar = this.f47925b.get(str);
        if (aVar != null) {
            return aVar.f47920a;
        }
        return null;
    }

    public final synchronized void a(String str, IMandatoryParameters iMandatoryParameters, a aVar) {
        this.f47925b.put(str, aVar);
        if (this.f47924a == null && iMandatoryParameters != null) {
            this.f47924a = iMandatoryParameters;
        }
    }

    public final c b(String str) {
        a aVar = this.f47925b.get(str);
        if (aVar != null) {
            return aVar.f47922c;
        }
        return null;
    }
}
