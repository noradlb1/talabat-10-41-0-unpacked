package com.instabug.bug.settings;

import android.content.Context;
import android.text.Spanned;
import androidx.annotation.Nullable;
import com.instabug.bug.extendedbugreport.a;
import com.instabug.library.Feature;
import com.instabug.library.OnSdkDismissCallback;
import java.util.ArrayList;
import java.util.List;

public class b {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private static b f45767a;

    private b() {
    }

    public static void a(Context context) {
        f45767a = new b();
        d.a(context);
    }

    public static b f() {
        if (f45767a == null) {
            f45767a = new b();
        }
        return f45767a;
    }

    public int a(String str) {
        c e11 = c.e();
        if (e11 != null) {
            return e11.a(str);
        }
        return 0;
    }

    public a a() {
        c e11 = c.e();
        return e11 == null ? new a() : e11.a();
    }

    public void a(long j11) {
        d b11 = d.b();
        if (b11 != null) {
            b11.a(j11);
        }
    }

    public void a(@Nullable Spanned spanned) {
        c e11 = c.e();
        if (e11 != null) {
            e11.a(spanned);
        }
    }

    public void a(a aVar) {
        c e11 = c.e();
        if (e11 != null) {
            e11.b(aVar);
        }
    }

    public void a(a aVar) {
        c e11 = c.e();
        if (e11 != null) {
            e11.a(aVar);
        }
    }

    public void a(Feature.State state) {
        c e11 = c.e();
        if (e11 != null) {
            e11.a(state);
        }
    }

    public void a(OnSdkDismissCallback onSdkDismissCallback) {
        c e11 = c.e();
        if (e11 != null) {
            e11.a(onSdkDismissCallback);
        }
    }

    public void a(String str, int i11) {
        c e11 = c.e();
        if (e11 != null) {
            e11.a(str, i11);
        }
    }

    public void a(String str, boolean z11) {
        if (c.e() != null) {
            c.e().a(str, z11);
        }
    }

    public void a(boolean z11) {
        c e11 = c.e();
        if (e11 != null) {
            e11.a(z11);
        }
    }

    public void b(long j11) {
        d b11 = d.b();
        if (b11 != null) {
            b11.b(j11);
        }
    }

    public void b(boolean z11) {
        if (d.b() != null) {
            d.b().a(z11);
        }
    }

    public boolean b() {
        if (d.b() == null) {
            return true;
        }
        return d.b().a();
    }

    public boolean b(String str) {
        c e11 = c.e();
        if (e11 == null) {
            return false;
        }
        return e11.b(str);
    }

    @Nullable
    public Spanned c() {
        c e11 = c.e();
        if (e11 == null) {
            return null;
        }
        return e11.b();
    }

    public void c(@Nullable String str) {
        if (d.b() != null) {
            d.b().a(str);
        }
    }

    public void c(boolean z11) {
        c e11 = c.e();
        if (e11 != null) {
            e11.b(z11);
        }
    }

    public a d() {
        c e11 = c.e();
        return e11 == null ? a.DISABLED : e11.c();
    }

    public void d(@Nullable String str) {
        d b11 = d.b();
        if (b11 != null) {
            b11.b(str);
        }
    }

    public void d(boolean z11) {
        c e11 = c.e();
        if (e11 != null) {
            e11.c(z11);
        }
    }

    public List e() {
        c e11 = c.e();
        return e11 == null ? new ArrayList() : e11.d();
    }

    public void e(boolean z11) {
        if (d.b() != null) {
            d.b().b(z11);
        }
    }

    public void f(boolean z11) {
        c e11 = c.e();
        if (e11 != null) {
            e11.f(z11);
        }
    }

    public long g() {
        d b11 = d.b();
        if (b11 == null) {
            return 0;
        }
        return b11.c();
    }

    public void g(boolean z11) {
        c e11 = c.e();
        if (e11 != null) {
            e11.e(z11);
        }
    }

    @Nullable
    public OnSdkDismissCallback h() {
        c e11 = c.e();
        if (e11 == null) {
            return null;
        }
        return e11.f();
    }

    @Nullable
    public String i() {
        if (d.b() == null) {
            return null;
        }
        return d.b().d();
    }

    @Nullable
    public String j() {
        d b11 = d.b();
        if (b11 == null) {
            return null;
        }
        return b11.e();
    }

    @Nullable
    public List k() {
        c e11 = c.e();
        if (e11 == null) {
            return null;
        }
        return e11.g();
    }

    public long l() {
        d b11 = d.b();
        if (b11 != null) {
            return b11.f();
        }
        return 0;
    }

    public boolean m() {
        c e11 = c.e();
        return e11 == null || e11.a().c() || e11.a().a() || e11.a().b();
    }

    public boolean n() {
        c e11 = c.e();
        if (e11 == null) {
            return false;
        }
        return e11.i();
    }

    public boolean o() {
        c e11 = c.e();
        if (e11 == null) {
            return false;
        }
        return e11.j();
    }

    public boolean p() {
        c e11 = c.e();
        if (e11 == null) {
            return true;
        }
        return e11.k();
    }

    public boolean q() {
        c e11 = c.e();
        if (e11 == null) {
            return true;
        }
        return e11.l();
    }

    public boolean r() {
        if (d.b() == null) {
            return true;
        }
        return d.b().g();
    }

    public boolean s() {
        c e11 = c.e();
        if (e11 == null) {
            return false;
        }
        return e11.m();
    }

    public boolean t() {
        c e11 = c.e();
        if (e11 == null) {
            return true;
        }
        return e11.n();
    }
}
