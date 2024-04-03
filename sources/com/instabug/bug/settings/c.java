package com.instabug.bug.settings;

import android.annotation.SuppressLint;
import android.text.Spanned;
import androidx.annotation.Nullable;
import com.instabug.bug.extendedbugreport.a;
import com.instabug.library.Feature;
import com.instabug.library.OnSdkDismissCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class c {
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private static c f45768o;

    /* renamed from: a  reason: collision with root package name */
    private a f45769a = new a();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private List f45770b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f45771c = false;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Spanned f45772d;

    /* renamed from: e  reason: collision with root package name */
    private List f45773e = new ArrayList();
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private a f45774f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f45775g = false;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private OnSdkDismissCallback f45776h;

    /* renamed from: i  reason: collision with root package name */
    private Feature.State f45777i = Feature.State.ENABLED;

    /* renamed from: j  reason: collision with root package name */
    private boolean f45778j = true;

    /* renamed from: k  reason: collision with root package name */
    private boolean f45779k = true;

    /* renamed from: l  reason: collision with root package name */
    private boolean f45780l = true;

    /* renamed from: m  reason: collision with root package name */
    private e f45781m = e.a();

    /* renamed from: n  reason: collision with root package name */
    private final Map f45782n = new HashMap();

    private c() {
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public static synchronized c e() {
        c cVar;
        synchronized (c.class) {
            if (f45768o == null) {
                h();
            }
            cVar = f45768o;
        }
        return cVar;
    }

    private static void h() {
        f45768o = new c();
    }

    public int a(String str) {
        Integer num = (Integer) this.f45782n.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public a a() {
        return this.f45769a;
    }

    public c a(a aVar) {
        this.f45769a = aVar;
        return this;
    }

    public void a(@Nullable Spanned spanned) {
        this.f45772d = spanned;
    }

    public void a(Feature.State state) {
        this.f45777i = state;
    }

    public void a(@Nullable OnSdkDismissCallback onSdkDismissCallback) {
        this.f45776h = onSdkDismissCallback;
    }

    public void a(String str, int i11) {
        this.f45782n.put(str, Integer.valueOf(i11));
    }

    public void a(String str, boolean z11) {
        this.f45781m.a(str, z11);
    }

    public void a(boolean z11) {
        this.f45771c = z11;
    }

    @Nullable
    public Spanned b() {
        return this.f45772d;
    }

    public void b(@Nullable a aVar) {
        this.f45774f = aVar;
    }

    public void b(boolean z11) {
        this.f45779k = z11;
    }

    public boolean b(String str) {
        return this.f45781m.a(str);
    }

    public a c() {
        a aVar = this.f45774f;
        return aVar == null ? a.DISABLED : aVar;
    }

    public void c(boolean z11) {
        this.f45778j = z11;
    }

    public List d() {
        return this.f45773e;
    }

    public void e(boolean z11) {
        this.f45780l = z11;
    }

    @Nullable
    public OnSdkDismissCallback f() {
        return this.f45776h;
    }

    public void f(boolean z11) {
        this.f45775g = z11;
    }

    @Nullable
    public List g() {
        return this.f45770b;
    }

    public boolean i() {
        return this.f45777i == Feature.State.ENABLED;
    }

    public boolean j() {
        return this.f45771c;
    }

    public boolean k() {
        return this.f45779k;
    }

    public boolean l() {
        return this.f45778j;
    }

    public boolean m() {
        return this.f45775g;
    }

    public boolean n() {
        return this.f45780l;
    }
}
