package com.huawei.hms.dtm.core;

import android.os.Bundle;
import com.huawei.hms.dtm.core.safe.SafeBundle;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.wa  reason: case insensitive filesystem */
public class C0453wa extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || x11 == null) {
            throw new V("__getbundle#wrong  params");
        }
        HashMap hashMap = new HashMap();
        Bundle b11 = x11.b();
        if (b11 != null) {
            SafeBundle safeBundle = new SafeBundle(b11);
            for (String next : safeBundle.keySet()) {
                hashMap.put(next, safeBundle.get(next));
            }
            return new C0465yc(hashMap);
        } else if (list.size() == 0) {
            return new C0465yc(hashMap);
        } else {
            if (list.size() == 1) {
                C0435sc<?> scVar = list.get(0);
                if (scVar instanceof C0465yc) {
                    return scVar;
                }
            }
            throw new V("__getbundle#wrong  params type");
        }
    }

    public String a() {
        return "__getbundle";
    }
}
