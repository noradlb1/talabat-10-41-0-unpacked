package com.huawei.agconnect.credential.obs;

import com.huawei.agconnect.datastore.annotation.DefaultCrypto;
import com.huawei.agconnect.datastore.core.SharedPrefUtil;

public class s {

    /* renamed from: a  reason: collision with root package name */
    private static s f47612a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPrefUtil f47613b = SharedPrefUtil.getInstance();

    private s() {
    }

    public static synchronized s a() {
        s sVar;
        synchronized (s.class) {
            if (f47612a == null) {
                f47612a = new s();
            }
            sVar = f47612a;
        }
        return sVar;
    }

    public void a(r rVar, String str) {
        if (rVar != null && str != null) {
            SharedPrefUtil sharedPrefUtil = this.f47613b;
            sharedPrefUtil.put("agc_site", "main_" + str, String.class, rVar.mainUrl, DefaultCrypto.class);
        }
    }

    public void a(String str) {
        SharedPrefUtil sharedPrefUtil = this.f47613b;
        sharedPrefUtil.remove("agc_site", "main_" + str);
    }

    public void b(r rVar, String str) {
        if (rVar != null && str != null) {
            SharedPrefUtil sharedPrefUtil = this.f47613b;
            sharedPrefUtil.put("agc_site", "backup_" + str, String.class, rVar.backUrl, DefaultCrypto.class);
        }
    }

    public void b(String str) {
        SharedPrefUtil sharedPrefUtil = this.f47613b;
        sharedPrefUtil.remove("agc_site", "backup_" + str);
    }

    public void c(r rVar, String str) {
        if (rVar != null && str != null) {
            SharedPrefUtil sharedPrefUtil = this.f47613b;
            sharedPrefUtil.put("agc_site", "validTime_" + str, Long.class, Long.valueOf(rVar.validTime), DefaultCrypto.class);
        }
    }

    public void d(r rVar, String str) {
        if (rVar != null && str != null) {
            SharedPrefUtil sharedPrefUtil = this.f47613b;
            rVar.mainUrl = (String) sharedPrefUtil.get("agc_site", "main_" + str, String.class, (Object) null, DefaultCrypto.class);
        }
    }

    public void e(r rVar, String str) {
        if (rVar != null && str != null) {
            SharedPrefUtil sharedPrefUtil = this.f47613b;
            rVar.backUrl = (String) sharedPrefUtil.get("agc_site", "backup_" + str, String.class, (Object) null, DefaultCrypto.class);
        }
    }

    public void f(r rVar, String str) {
        if (rVar != null && str != null) {
            SharedPrefUtil sharedPrefUtil = this.f47613b;
            rVar.validTime = ((Long) sharedPrefUtil.get("agc_site", "validTime_" + str, Long.class, (Object) null, DefaultCrypto.class)).longValue();
        }
    }
}
