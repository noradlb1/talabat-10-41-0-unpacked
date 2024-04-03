package com.huawei.agconnect.credential.obs;

import com.huawei.agconnect.common.api.AgcCrypto;
import com.huawei.agconnect.datastore.core.SharedPrefUtil;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f47570a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPrefUtil f47571b = SharedPrefUtil.getInstance();

    private b() {
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f47570a == null) {
                f47570a = new b();
            }
            bVar = f47570a;
        }
        return bVar;
    }

    public void a(a aVar) {
        b(aVar);
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.f47571b.put("com.huawei.agconnect", "aaid", String.class, aVar.aaidString, AgcCrypto.class);
        }
    }

    public void c(a aVar) {
        if (aVar != null) {
            aVar.aaidString = (String) this.f47571b.get("com.huawei.agconnect", "aaid", String.class, aVar.aaidString, AgcCrypto.class);
        }
    }
}
