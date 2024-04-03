package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

public class o0 {

    /* renamed from: c  reason: collision with root package name */
    private static o0 f49089c;

    /* renamed from: a  reason: collision with root package name */
    private String f49090a;

    /* renamed from: b  reason: collision with root package name */
    private String f49091b;

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003b, code lost:
        if (f() != false) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(java.lang.String r3) {
        /*
            r2 = this;
            boolean r0 = r2.f()
            if (r0 == 0) goto L_0x000d
            java.lang.String r0 = "analytics_keystore"
            java.lang.String r0 = com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.decrypt((java.lang.String) r0, (java.lang.String) r3)
            goto L_0x000f
        L_0x000d:
            java.lang.String r0 = ""
        L_0x000f:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x004f
            java.lang.String r0 = "hmsSdk"
            java.lang.String r1 = "deCrypt work key first"
            com.huawei.hms.hatool.v.c(r0, r1)
            java.lang.String r0 = r2.e()
            java.lang.String r0 = com.huawei.hms.hatool.n.a((java.lang.String) r3, (java.lang.String) r0)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L_0x0041
            r3 = 16
            java.lang.String r0 = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandomStr(r3)
            java.lang.String r3 = r2.b(r0)
            r2.c(r3)
            boolean r3 = r2.f()
            if (r3 == 0) goto L_0x004f
        L_0x003d:
            com.huawei.hms.hatool.x.c()
            goto L_0x004f
        L_0x0041:
            boolean r3 = r2.f()
            if (r3 == 0) goto L_0x004f
            java.lang.String r3 = r2.b(r0)
            r2.c(r3)
            goto L_0x003d
        L_0x004f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.o0.a(java.lang.String):java.lang.String");
    }

    private String b(String str) {
        return f() ? AesGcmKS.encrypt("analytics_keystore", str) : n.b(str, e());
    }

    private String c() {
        String a11 = d.a(q0.i(), "Privacy_MY", "PrivacyData", "");
        if (!TextUtils.isEmpty(a11)) {
            return a(a11);
        }
        String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
        c(b(generateSecureRandomStr));
        return generateSecureRandomStr;
    }

    private boolean c(String str) {
        v.c("hmsSdk", "refresh sp aes key");
        if (TextUtils.isEmpty(str)) {
            v.c("hmsSdk", "refreshLocalKey(): encrypted key is empty");
            return false;
        }
        d.b(q0.i(), "Privacy_MY", "PrivacyData", str);
        d.b(q0.i(), "Privacy_MY", "flashKeyTime", System.currentTimeMillis());
        return true;
    }

    public static o0 d() {
        if (f49089c == null) {
            g();
        }
        return f49089c;
    }

    private String e() {
        if (TextUtils.isEmpty(this.f49091b)) {
            this.f49091b = new x().a();
        }
        return this.f49091b;
    }

    private boolean f() {
        return true;
    }

    private static synchronized void g() {
        synchronized (o0.class) {
            if (f49089c == null) {
                f49089c = new o0();
            }
        }
    }

    public String a() {
        if (TextUtils.isEmpty(this.f49090a)) {
            this.f49090a = c();
        }
        return this.f49090a;
    }

    public void b() {
        String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
        if (c(b(generateSecureRandomStr))) {
            this.f49090a = generateSecureRandomStr;
        }
    }
}
