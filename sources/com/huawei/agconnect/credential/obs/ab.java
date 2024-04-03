package com.huawei.agconnect.credential.obs;

import com.huawei.agconnect.common.api.AgcCrypto;
import com.huawei.agconnect.datastore.core.SharedPrefUtil;

public class ab {

    /* renamed from: a  reason: collision with root package name */
    private static ab f47545a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPrefUtil f47546b = SharedPrefUtil.getInstance();

    private ab() {
    }

    public static synchronized ab a() {
        ab abVar;
        synchronized (ab.class) {
            if (f47545a == null) {
                f47545a = new ab();
            }
            abVar = f47545a;
        }
        return abVar;
    }

    public void a(aa aaVar, String str) {
        if (aaVar != null && str != null) {
            SharedPrefUtil sharedPrefUtil = this.f47546b;
            sharedPrefUtil.put("com.huawei.agconnect", "tokenString_" + str, String.class, aaVar.tokenString, AgcCrypto.class);
        }
    }

    public void b(aa aaVar, String str) {
        if (aaVar != null && str != null) {
            SharedPrefUtil sharedPrefUtil = this.f47546b;
            sharedPrefUtil.put("com.huawei.agconnect", "expires_" + str, Long.class, Long.valueOf(aaVar.expires), AgcCrypto.class);
        }
    }

    public void c(aa aaVar, String str) {
        if (aaVar != null && str != null) {
            SharedPrefUtil sharedPrefUtil = this.f47546b;
            sharedPrefUtil.put("com.huawei.agconnect", "validTime_" + str, Long.class, Long.valueOf(aaVar.validTime), AgcCrypto.class);
        }
    }

    public void d(aa aaVar, String str) {
        if (aaVar != null && str != null) {
            SharedPrefUtil sharedPrefUtil = this.f47546b;
            aaVar.tokenString = (String) sharedPrefUtil.get("com.huawei.agconnect", "tokenString_" + str, String.class, (Object) null, AgcCrypto.class);
        }
    }

    public void e(aa aaVar, String str) {
        if (aaVar != null && str != null) {
            SharedPrefUtil sharedPrefUtil = this.f47546b;
            aaVar.expires = ((Long) sharedPrefUtil.get("com.huawei.agconnect", "expires_" + str, Long.class, (Object) null, AgcCrypto.class)).longValue();
        }
    }

    public void f(aa aaVar, String str) {
        if (aaVar != null && str != null) {
            SharedPrefUtil sharedPrefUtil = this.f47546b;
            aaVar.validTime = ((Long) sharedPrefUtil.get("com.huawei.agconnect", "validTime_" + str, Long.class, (Object) null, AgcCrypto.class)).longValue();
        }
    }
}
