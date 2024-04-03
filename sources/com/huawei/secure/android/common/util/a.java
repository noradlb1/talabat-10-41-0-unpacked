package com.huawei.secure.android.common.util;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f34013a;

    /* renamed from: b  reason: collision with root package name */
    private Character f34014b;

    /* renamed from: c  reason: collision with root package name */
    private Character f34015c;

    /* renamed from: d  reason: collision with root package name */
    private int f34016d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f34017e = 0;

    public a(String str) {
        this.f34013a = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        r2 = r2.charValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean c(java.lang.Character r2) {
        /*
            r0 = 0
            if (r2 != 0) goto L_0x0004
            return r0
        L_0x0004:
            char r2 = r2.charValue()
            r1 = 48
            if (r2 < r1) goto L_0x0011
            r1 = 55
            if (r2 > r1) goto L_0x0011
            r0 = 1
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.a.c(java.lang.Character):boolean");
    }

    public void a(Character ch2) {
        this.f34014b = ch2;
    }

    public int b() {
        return this.f34016d;
    }

    public Character d() {
        Character ch2 = this.f34014b;
        if (ch2 != null) {
            this.f34014b = null;
            return ch2;
        }
        String str = this.f34013a;
        if (str == null || str.length() == 0 || this.f34016d >= this.f34013a.length()) {
            return null;
        }
        String str2 = this.f34013a;
        int i11 = this.f34016d;
        this.f34016d = i11 + 1;
        return Character.valueOf(str2.charAt(i11));
    }

    public Character e() {
        Character d11 = d();
        if (d11 != null && b(d11)) {
            return d11;
        }
        return null;
    }

    public Character f() {
        Character d11 = d();
        if (d11 != null && c(d11)) {
            return d11;
        }
        return null;
    }

    public Character g() {
        Character ch2 = this.f34014b;
        if (ch2 != null) {
            return ch2;
        }
        String str = this.f34013a;
        if (str == null || str.length() == 0 || this.f34016d >= this.f34013a.length()) {
            return null;
        }
        return Character.valueOf(this.f34013a.charAt(this.f34016d));
    }

    public void i() {
        this.f34014b = this.f34015c;
        this.f34016d = this.f34017e;
    }

    public static boolean b(Character ch2) {
        if (ch2 == null) {
            return false;
        }
        char charValue = ch2.charValue();
        return (charValue >= '0' && charValue <= '9') || (charValue >= 'a' && charValue <= 'f') || (charValue >= 'A' && charValue <= 'F');
    }

    public boolean a() {
        if (this.f34014b != null) {
            return true;
        }
        String str = this.f34013a;
        if (str == null || str.length() == 0 || this.f34016d >= this.f34013a.length()) {
            return false;
        }
        return true;
    }

    public void c() {
        this.f34015c = this.f34014b;
        this.f34017e = this.f34016d;
    }

    public boolean a(char c11) {
        Character ch2 = this.f34014b;
        if (ch2 != null && ch2.charValue() == c11) {
            return true;
        }
        String str = this.f34013a;
        if (str == null || str.length() == 0 || this.f34016d >= this.f34013a.length()) {
            return false;
        }
        if (this.f34013a.charAt(this.f34016d) == c11) {
            return true;
        }
        return false;
    }
}
