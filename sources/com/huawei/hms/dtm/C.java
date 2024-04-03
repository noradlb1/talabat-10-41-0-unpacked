package com.huawei.hms.dtm;

import com.huawei.hms.dtm.core.DynamicTagManager;

public class C {

    /* renamed from: a  reason: collision with root package name */
    public static Boolean f48245a;

    static {
        f48245a = Boolean.FALSE;
        try {
            int i11 = DynamicTagManager.f48276m;
            f48245a = Boolean.TRUE;
            B.c("HMS-DTM", "dtm-core sdk exist");
        } catch (ClassNotFoundException unused) {
            B.d("HMS-DTM", "dtm-core sdk not exist");
        }
    }

    public static boolean a() {
        return f48245a.booleanValue();
    }
}
