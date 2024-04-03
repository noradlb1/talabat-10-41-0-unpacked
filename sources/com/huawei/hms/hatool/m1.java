package com.huawei.hms.hatool;

import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

public class m1 {

    /* renamed from: b  reason: collision with root package name */
    private static m1 f49080b = new m1();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f49081a = new a();

    public class a {

        /* renamed from: a  reason: collision with root package name */
        String f49082a;

        /* renamed from: b  reason: collision with root package name */
        String f49083b;

        /* renamed from: c  reason: collision with root package name */
        long f49084c = 0;

        public a() {
        }

        public void a(long j11) {
            m1.this.f49081a.f49084c = j11;
        }

        public void a(String str) {
            m1.this.f49081a.f49083b = str;
        }

        public void b(String str) {
            m1.this.f49081a.f49082a = str;
        }
    }

    public static m1 d() {
        return f49080b;
    }

    public String a() {
        return this.f49081a.f49083b;
    }

    public void a(String str, String str2) {
        long b11 = b();
        String c11 = w0.c(str, str2);
        if (c11 == null || c11.isEmpty()) {
            v.e("WorkKeyHandler", "get rsa pubkey config error");
            return;
        }
        if (b11 == 0) {
            b11 = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - b11 <= 43200000) {
            return;
        }
        String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
        String a11 = h0.a(c11, generateSecureRandomStr);
        this.f49081a.a(b11);
        this.f49081a.b(generateSecureRandomStr);
        this.f49081a.a(a11);
    }

    public long b() {
        return this.f49081a.f49084c;
    }

    public String c() {
        return this.f49081a.f49082a;
    }
}
