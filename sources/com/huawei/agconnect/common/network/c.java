package com.huawei.agconnect.common.network;

import com.huawei.agconnect.datastore.annotation.DefaultCrypto;
import com.huawei.agconnect.datastore.core.SharedPrefUtil;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f47470a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPrefUtil f47471b = SharedPrefUtil.getInstance();

    private c() {
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (f47470a == null) {
                f47470a = new c();
            }
            cVar = f47470a;
        }
        return cVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.f47471b.put("AGConnectAccessNetwork", "enableAccessNetwork", Boolean.class, Boolean.valueOf(bVar.enableAccessNetwork), DefaultCrypto.class);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            bVar.enableAccessNetwork = ((Boolean) this.f47471b.get("AGConnectAccessNetwork", "enableAccessNetwork", Boolean.class, Boolean.valueOf(bVar.enableAccessNetwork), DefaultCrypto.class)).booleanValue();
        }
    }
}
