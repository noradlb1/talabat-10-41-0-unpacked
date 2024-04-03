package com.huawei.hms.hatool;

import java.util.List;
import java.util.Map;

public class f implements g {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f48997a;

    /* renamed from: b  reason: collision with root package name */
    private String f48998b;

    /* renamed from: c  reason: collision with root package name */
    private String f48999c;

    /* renamed from: d  reason: collision with root package name */
    private String f49000d;

    /* renamed from: e  reason: collision with root package name */
    private String f49001e;

    /* renamed from: f  reason: collision with root package name */
    private List<b1> f49002f;

    public f(byte[] bArr, String str, String str2, String str3, String str4, List<b1> list) {
        this.f48997a = (byte[]) bArr.clone();
        this.f48998b = str;
        this.f48999c = str2;
        this.f49001e = str3;
        this.f49000d = str4;
        this.f49002f = list;
    }

    private n0 a(Map<String, String> map) {
        return w.a(this.f48998b, this.f48997a, map);
    }

    private Map<String, String> a() {
        return k.b(this.f48999c, this.f49001e, this.f49000d);
    }

    private void b() {
        b0.c().a(new d1(this.f49002f, this.f48999c, this.f49000d, this.f49001e));
    }

    public void run() {
        v.c("hmsSdk", "send data running");
        int b11 = a(a()).b();
        if (b11 != 200) {
            b();
            return;
        }
        v.b("hmsSdk", "events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:" + this.f49000d, this.f49001e, this.f48999c, Integer.valueOf(b11));
    }
}
