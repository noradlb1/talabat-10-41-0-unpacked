package com.instabug.library.settings;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.Feature;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.OnSdkDismissCallback;
import com.instabug.library.OnSdkInvokedCallback;
import com.instabug.library.Platform;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.internal.video.customencoding.VideoEncoderConfig;
import com.instabug.library.invocation.OnInvokeCallback;
import com.instabug.library.model.Report;
import com.instabug.library.ui.onboarding.WelcomeMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.WeakHashMap;

public class e {
    @Nullable
    private static e L;
    private boolean A = false;
    private Feature.State B = Feature.State.DISABLED;
    private final Collection C = Collections.newSetFromMap(new WeakHashMap());
    private boolean D = true;
    @Nullable
    private String E = null;
    @Platform
    private int F = 2;
    private boolean G = false;
    public int H = 1;
    private boolean I = false;
    private boolean J = false;
    @Nullable
    private VideoEncoderConfig K;

    /* renamed from: a  reason: collision with root package name */
    private int f51885a = -15893761;

    /* renamed from: b  reason: collision with root package name */
    private int f51886b = -3815737;

    /* renamed from: c  reason: collision with root package name */
    private long f51887c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f51888d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private Locale f51889e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Locale f51890f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private ArrayList f51891g = new ArrayList();
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private InstabugCustomTextPlaceHolder f51892h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final LinkedHashMap f51893i = new LinkedHashMap(3);
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private OnInvokeCallback f51894j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private OnSdkDismissCallback f51895k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private OnSdkInvokedCallback f51896l;

    /* renamed from: m  reason: collision with root package name */
    private InstabugColorTheme f51897m = InstabugColorTheme.InstabugColorThemeLight;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private Bitmap f51898n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private Bitmap f51899o;

    /* renamed from: p  reason: collision with root package name */
    private WelcomeMessage.State f51900p = WelcomeMessage.State.LIVE;

    /* renamed from: q  reason: collision with root package name */
    private boolean f51901q = true;

    /* renamed from: r  reason: collision with root package name */
    private int f51902r = -2;

    /* renamed from: s  reason: collision with root package name */
    private boolean f51903s = false;

    /* renamed from: t  reason: collision with root package name */
    private boolean f51904t = false;

    /* renamed from: u  reason: collision with root package name */
    private boolean f51905u = false;

    /* renamed from: v  reason: collision with root package name */
    private boolean f51906v = false;

    /* renamed from: w  reason: collision with root package name */
    private boolean f51907w = true;

    /* renamed from: x  reason: collision with root package name */
    private boolean f51908x = false;

    /* renamed from: y  reason: collision with root package name */
    private boolean f51909y = false;
    @Nullable

    /* renamed from: z  reason: collision with root package name */
    private Report.OnReportCreatedListener f51910z;

    private e() {
    }

    public static synchronized void N() {
        synchronized (e.class) {
            L = null;
        }
    }

    public static synchronized e j() {
        e eVar;
        synchronized (e.class) {
            eVar = L;
            if (eVar == null) {
                eVar = new e();
                L = eVar;
            }
        }
        return eVar;
    }

    public boolean A() {
        return this.f51904t;
    }

    public boolean B() {
        return this.f51906v;
    }

    public boolean C() {
        return this.G;
    }

    public boolean D() {
        return this.f51901q;
    }

    public boolean E() {
        return this.D;
    }

    public boolean F() {
        return this.J;
    }

    public boolean G() {
        return this.f51909y;
    }

    public boolean H() {
        return this.A;
    }

    public boolean I() {
        return this.f51907w;
    }

    public boolean J() {
        return this.f51905u;
    }

    public void K(@Nullable Report.OnReportCreatedListener onReportCreatedListener) {
        this.f51910z = onReportCreatedListener;
    }

    public boolean L() {
        return this.f51903s;
    }

    public boolean M() {
        return this.f51908x;
    }

    public void O() {
        this.f51902r = -2;
    }

    public void P() {
        this.f51891g = new ArrayList();
    }

    public boolean Q() {
        return this.I;
    }

    public void R(boolean z11) {
        this.f51888d = z11;
    }

    public void S(boolean z11) {
        this.f51907w = z11;
    }

    public void T(boolean z11) {
        this.f51905u = z11;
    }

    @Nullable
    public Report.OnReportCreatedListener U() {
        return this.f51910z;
    }

    public void a(@Nullable OnInvokeCallback onInvokeCallback) {
        this.f51894j = onInvokeCallback;
    }

    public int b() {
        return 30000;
    }

    public void b(@Nullable Locale locale) {
        this.f51889e = locale;
    }

    public void c() {
        LinkedHashMap linkedHashMap = this.f51893i;
        if (linkedHashMap != null) {
            linkedHashMap.clear();
        }
    }

    @Nullable
    public Locale d() {
        return this.f51890f;
    }

    public void e(int i11) {
        this.f51886b = i11;
    }

    @Nullable
    public InstabugCustomTextPlaceHolder f() {
        return this.f51892h;
    }

    @Nullable
    public Bitmap g() {
        return this.f51899o;
    }

    @Nullable
    public LinkedHashMap h() {
        return this.f51893i;
    }

    public void i(boolean z11) {
        this.A = z11;
    }

    @Nullable
    public Bitmap k() {
        return this.f51898n;
    }

    public int l() {
        return this.H;
    }

    @Nullable
    public OnInvokeCallback m() {
        return this.f51894j;
    }

    public boolean n() {
        return this.f51888d;
    }

    @Nullable
    public OnSdkDismissCallback o() {
        return this.f51895k;
    }

    @Nullable
    public OnSdkInvokedCallback p() {
        return this.f51896l;
    }

    @Platform
    public int q() {
        return this.F;
    }

    public int r() {
        return this.f51885a;
    }

    @NonNull
    public Collection s() {
        return this.C;
    }

    public int t() {
        return this.f51902r;
    }

    public long u() {
        return this.f51887c;
    }

    public int v() {
        return this.f51886b;
    }

    @Nullable
    public ArrayList w() {
        return this.f51891g;
    }

    public InstabugColorTheme x() {
        return this.f51897m;
    }

    @Nullable
    public VideoEncoderConfig y() {
        return this.K;
    }

    public WelcomeMessage.State z() {
        return this.f51900p;
    }

    public void a(@Nullable OnSdkInvokedCallback onSdkInvokedCallback) {
        this.f51896l = onSdkInvokedCallback;
    }

    public void b(boolean z11) {
        this.f51906v = z11;
    }

    public void d(int i11) {
        this.f51902r = i11;
    }

    public Feature.State e() {
        return this.B;
    }

    public void f(boolean z11) {
        this.D = z11;
    }

    public void g(boolean z11) {
        this.J = z11;
    }

    public void h(boolean z11) {
        this.f51909y = z11;
    }

    @Nullable
    public String i() {
        return this.E;
    }

    public void m(boolean z11) {
        this.f51903s = z11;
    }

    public void n(boolean z11) {
        this.f51908x = z11;
    }

    @NonNull
    public Locale a(@Nullable Context context) {
        Locale locale = this.f51889e;
        if (locale != null) {
            return locale;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            if (context != null) {
                return context.getResources().getConfiguration().getLocales().get(0);
            }
        } else if (context != null) {
            return context.getResources().getConfiguration().locale;
        }
        return Locale.getDefault();
    }

    public void b(View... viewArr) {
        Collection collection = this.C;
        if (viewArr == null) {
            viewArr = new View[0];
        }
        collection.removeAll(Arrays.asList(viewArr));
    }

    public void c(@ColorInt int i11) {
        this.f51885a = i11;
    }

    public void d(boolean z11) {
        this.I = z11;
    }

    public void e(boolean z11) {
        this.f51901q = z11;
    }

    public void b(@Nullable Bitmap bitmap) {
        this.f51898n = bitmap;
    }

    public void c(boolean z11) {
        this.G = z11;
    }

    public void b(int i11) {
        this.H = i11;
    }

    public void a(@Nullable Locale locale) {
        this.f51890f = locale;
    }

    public void a(Uri uri, String str) {
        if (this.f51893i != null && AttachmentsUtility.validateFileSize(uri, 5.0d)) {
            if (this.f51893i.size() == 3 && !this.f51893i.containsKey(uri)) {
                this.f51893i.remove((Uri) this.f51893i.keySet().iterator().next());
            }
            this.f51893i.put(uri, str);
        }
    }

    public void a(String... strArr) {
        if (this.f51891g != null && strArr != null) {
            for (String str : strArr) {
                if (str != null && !str.equals("null")) {
                    this.f51891g.add(str);
                }
            }
        }
    }

    public void a(long j11) {
        this.f51887c = j11;
    }

    public void a(InstabugCustomTextPlaceHolder instabugCustomTextPlaceHolder) {
        this.f51892h = instabugCustomTextPlaceHolder;
    }

    public void a(@Nullable OnSdkDismissCallback onSdkDismissCallback) {
        this.f51895k = onSdkDismissCallback;
    }

    public void a(boolean z11) {
        this.f51904t = z11;
    }

    public boolean a() {
        return this.f51906v;
    }

    public void a(Feature.State state) {
        this.B = state;
    }

    public void a(View... viewArr) {
        Collection collection = this.C;
        if (viewArr == null) {
            viewArr = new View[0];
        }
        collection.addAll(Arrays.asList(viewArr));
    }

    public void a(@Nullable String str) {
        this.E = str;
    }

    public void a(int i11) {
        this.F = i11;
    }

    public void a(InstabugColorTheme instabugColorTheme) {
        this.f51897m = instabugColorTheme;
    }

    public void a(@Nullable Bitmap bitmap) {
        this.f51899o = bitmap;
    }

    public void a(WelcomeMessage.State state) {
        this.f51900p = state;
    }

    public void a(@NonNull VideoEncoderConfig videoEncoderConfig) {
        this.K = videoEncoderConfig;
    }
}
