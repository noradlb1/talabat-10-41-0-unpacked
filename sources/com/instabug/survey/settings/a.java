package com.instabug.survey.settings;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.survey.callbacks.OnDismissCallback;
import com.instabug.survey.callbacks.OnFinishCallback;
import com.instabug.survey.callbacks.OnShowCallback;

public class a {

    /* renamed from: k  reason: collision with root package name */
    private static a f52419k;

    /* renamed from: a  reason: collision with root package name */
    private boolean f52420a = true;

    /* renamed from: b  reason: collision with root package name */
    private boolean f52421b = false;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private OnShowCallback f52422c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private OnDismissCallback f52423d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private OnFinishCallback f52424e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f52425f = false;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private String f52426g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private Boolean f52427h = null;

    /* renamed from: i  reason: collision with root package name */
    private boolean f52428i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f52429j = false;

    private a() {
    }

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            if (f52419k == null) {
                g();
            }
            aVar = f52419k;
        }
        return aVar;
    }

    @VisibleForTesting
    public static synchronized void g() {
        synchronized (a.class) {
            if (f52419k == null) {
                f52419k = new a();
            }
        }
    }

    @SuppressLint({"ERADICATE_FIELD_NOT_NULLABLE"})
    public static synchronized void m() {
        synchronized (a.class) {
            f52419k = null;
        }
    }

    public void a() {
        this.f52428i = true;
    }

    public void a(@Nullable OnDismissCallback onDismissCallback) {
        this.f52423d = onDismissCallback;
    }

    public void a(@Nullable OnFinishCallback onFinishCallback) {
        this.f52424e = onFinishCallback;
    }

    public void a(@Nullable OnShowCallback onShowCallback) {
        this.f52422c = onShowCallback;
    }

    public void a(@Nullable String str) {
        this.f52426g = str;
    }

    public void b(boolean z11) {
        this.f52427h = Boolean.valueOf(z11);
    }

    @Nullable
    public String c() {
        return this.f52426g;
    }

    public void c(boolean z11) {
        this.f52421b = z11;
    }

    @Nullable
    public OnDismissCallback d() {
        return this.f52423d;
    }

    public void d(boolean z11) {
        this.f52420a = z11;
    }

    @Nullable
    public OnFinishCallback e() {
        return this.f52424e;
    }

    public void e(boolean z11) {
        this.f52425f = z11;
    }

    @Nullable
    public OnShowCallback f() {
        return this.f52422c;
    }

    public boolean h() {
        Boolean bool = this.f52427h;
        return bool != null ? bool.booleanValue() : this.f52425f;
    }

    @Nullable
    public Boolean i() {
        return this.f52427h;
    }

    public boolean j() {
        return this.f52428i;
    }

    public boolean k() {
        return this.f52429j;
    }

    public boolean l() {
        return this.f52420a;
    }

    public void n() {
        this.f52429j = true;
    }

    public boolean o() {
        return this.f52421b;
    }
}
