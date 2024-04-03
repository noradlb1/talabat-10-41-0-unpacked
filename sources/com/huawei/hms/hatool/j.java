package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.util.UUID;

public class j {

    /* renamed from: b  reason: collision with root package name */
    private static j f49039b;

    /* renamed from: a  reason: collision with root package name */
    private Context f49040a;

    public static class a extends e0 {

        /* renamed from: a  reason: collision with root package name */
        String f49041a;

        /* renamed from: b  reason: collision with root package name */
        String f49042b;

        public a(String str, String str2) {
            this.f49041a = str;
            this.f49042b = str2;
        }

        public String a() {
            return z.d(this.f49041a, this.f49042b);
        }

        public String a(String str) {
            return SHA.sha256Encrypt(str);
        }

        public String b() {
            return z.g(this.f49041a, this.f49042b);
        }

        public String c() {
            return z.j(this.f49041a, this.f49042b);
        }

        public int d() {
            char c11 = 0;
            boolean z11 = (z.k(this.f49041a, this.f49042b) ? (char) 4 : 0) | false;
            if (z.e(this.f49041a, this.f49042b)) {
                c11 = 2;
            }
            return (z11 | c11) | z.h(this.f49041a, this.f49042b) ? 1 : 0;
        }
    }

    public static j a() {
        j jVar;
        synchronized (j.class) {
            if (f49039b == null) {
                f49039b = new j();
            }
            jVar = f49039b;
        }
        return jVar;
    }

    public String a(String str, String str2) {
        return i0.a(this.f49040a, str, str2);
    }

    public String a(boolean z11) {
        if (!z11) {
            return "";
        }
        String e11 = q0.e();
        if (TextUtils.isEmpty(e11)) {
            e11 = d.a(this.f49040a, "global_v2", "uuid", "");
            if (TextUtils.isEmpty(e11)) {
                e11 = UUID.randomUUID().toString().replace(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE, "");
                d.b(this.f49040a, "global_v2", "uuid", e11);
            }
            q0.h(e11);
        }
        return e11;
    }

    public void a(Context context) {
        if (this.f49040a == null) {
            this.f49040a = context;
        }
    }

    public String b(String str, String str2) {
        return i0.b(this.f49040a, str, str2);
    }

    public i c(String str, String str2) {
        return new a(str, str2).a(this.f49040a);
    }

    public String d(String str, String str2) {
        return f1.b(str, str2);
    }

    public Pair<String, String> e(String str, String str2) {
        if (!z.f(str, str2)) {
            return new Pair<>("", "");
        }
        String p11 = s.c().b().p();
        String q11 = s.c().b().q();
        if (!TextUtils.isEmpty(p11) && !TextUtils.isEmpty(q11)) {
            return new Pair<>(p11, q11);
        }
        Pair<String, String> e11 = x0.e(this.f49040a);
        s.c().b().k((String) e11.first);
        s.c().b().l((String) e11.second);
        return e11;
    }

    public String f(String str, String str2) {
        return f1.a(str, str2);
    }
}
