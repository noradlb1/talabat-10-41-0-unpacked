package com.huawei.hms.analytics.framework.a;

import com.huawei.hms.analytics.core.storage.IStorageHandler;
import com.huawei.hms.analytics.framework.b.b;
import com.huawei.hms.analytics.framework.b.c;
import com.huawei.hms.analytics.framework.policy.IStoragePolicy;

public final class a {
    public static IStorageHandler a(String str) {
        c b11 = b.a().b(str);
        if (b11 != null) {
            return b11.f47927b;
        }
        return null;
    }

    public static IStoragePolicy b(String str) {
        com.huawei.hms.analytics.framework.b.a aVar = b.a().f47925b.get(str);
        if (aVar != null) {
            return aVar.f47921b;
        }
        return null;
    }
}
