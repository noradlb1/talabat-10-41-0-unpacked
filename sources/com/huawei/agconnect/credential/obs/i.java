package com.huawei.agconnect.credential.obs;

import com.huawei.agconnect.datastore.annotation.DefaultCrypto;
import com.huawei.agconnect.datastore.core.SharedPrefUtil;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private static i f47578a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPrefUtil f47579b = SharedPrefUtil.getInstance();

    private i() {
    }

    public static synchronized i a() {
        i iVar;
        synchronized (i.class) {
            if (f47578a == null) {
                f47578a = new i();
            }
            iVar = f47578a;
        }
        return iVar;
    }

    public void a(h hVar) {
        if (hVar != null) {
            this.f47579b.put("com.huawei.appgallery.datastore", "key", String.class, hVar.randmonKey, DefaultCrypto.class);
        }
    }

    public void b(h hVar) {
        if (hVar != null) {
            this.f47579b.put("com.huawei.agconnect.internal", "jerry", String.class, hVar.jerry, DefaultCrypto.class);
        }
    }

    public void c(h hVar) {
        if (hVar != null) {
            this.f47579b.put("com.huawei.appgallery.datastore", "fish", String.class, hVar.fish, DefaultCrypto.class);
        }
    }

    public void d(h hVar) {
        if (hVar != null) {
            hVar.randmonKey = (String) this.f47579b.get("com.huawei.appgallery.datastore", "key", String.class, hVar.randmonKey, DefaultCrypto.class);
        }
    }

    public void e(h hVar) {
        if (hVar != null) {
            hVar.jerry = (String) this.f47579b.get("com.huawei.agconnect.internal", "jerry", String.class, hVar.jerry, DefaultCrypto.class);
        }
    }

    public void f(h hVar) {
        if (hVar != null) {
            hVar.fish = (String) this.f47579b.get("com.huawei.appgallery.datastore", "fish", String.class, hVar.fish, DefaultCrypto.class);
        }
    }
}
