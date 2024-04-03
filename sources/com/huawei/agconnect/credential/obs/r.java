package com.huawei.agconnect.credential.obs;

import android.text.TextUtils;
import com.huawei.agconnect.datastore.annotation.SharedPreference;
import java.util.Arrays;

public class r {

    /* renamed from: a  reason: collision with root package name */
    private Boolean f47610a = Boolean.FALSE;

    /* renamed from: b  reason: collision with root package name */
    private String f47611b = null;
    @SharedPreference(fileName = "agc_site", isDynamic = true, key = "backup")
    String backUrl;
    @SharedPreference(fileName = "agc_site", isDynamic = true, key = "main")
    String mainUrl;
    @SharedPreference(fileName = "agc_site", isDynamic = true, key = "validTime")
    long validTime = 0;

    private r() {
    }

    public r(String str, String str2) {
        this.mainUrl = str;
        this.backUrl = str2;
        if (TextUtils.isEmpty(str)) {
            this.f47610a = Boolean.TRUE;
        }
    }

    private int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static void a(String str, long j11) {
        r rVar = new r();
        rVar.validTime = j11;
        s.a().c(rVar, str);
    }

    private boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static r b(String str) {
        r rVar = new r();
        s.a().d(rVar, str);
        s.a().e(rVar, str);
        s.a().f(rVar, str);
        return rVar;
    }

    public static void c(String str) {
        s.a().a(str);
        s.a().b(str);
    }

    public String a() {
        return this.mainUrl;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(this.mainUrl)) {
            s.a().a(this, str);
        }
        if (!TextUtils.isEmpty(this.backUrl)) {
            s.a().b(this, str);
        }
    }

    public void a(String str, boolean z11) {
        this.f47611b = str;
        this.f47610a = Boolean.valueOf(z11);
    }

    public String b() {
        return this.backUrl;
    }

    public String c() {
        return this.f47610a.booleanValue() ? this.backUrl : this.mainUrl;
    }

    public String d() {
        return this.f47611b;
    }

    public boolean e() {
        return !TextUtils.isEmpty(this.mainUrl) || !TextUtils.isEmpty(this.backUrl);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        return a((Object) this.mainUrl, (Object) rVar.mainUrl) && a((Object) this.backUrl, (Object) rVar.backUrl);
    }

    public int hashCode() {
        return a(this.mainUrl, this.backUrl);
    }
}
