package com.instabug.chat.settings;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import com.instabug.library.Feature;
import com.instabug.library.OnSdkDismissCallback;

public class b {

    /* renamed from: f  reason: collision with root package name */
    private static b f46157f;

    /* renamed from: a  reason: collision with root package name */
    private AttachmentTypesState f46158a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private Runnable f46159b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f46160c = false;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private String f46161d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private OnSdkDismissCallback f46162e;

    private b() {
        Feature.State state = Feature.State.ENABLED;
        this.f46158a = new AttachmentTypesState();
    }

    public static synchronized b e() {
        b bVar;
        synchronized (b.class) {
            if (f46157f == null) {
                f();
            }
            bVar = f46157f;
        }
        return bVar;
    }

    private static void f() {
        f46157f = new b();
    }

    @SuppressLint({"ERADICATE_FIELD_NOT_NULLABLE"})
    public static synchronized void g() {
        synchronized (b.class) {
            f46157f = null;
        }
    }

    public AttachmentTypesState a() {
        return this.f46158a;
    }

    public void a(@Nullable OnSdkDismissCallback onSdkDismissCallback) {
        this.f46162e = onSdkDismissCallback;
    }

    public void a(boolean z11) {
        this.f46160c = z11;
    }

    public b b(AttachmentTypesState attachmentTypesState) {
        this.f46158a = attachmentTypesState;
        return this;
    }

    public void c(@Nullable Runnable runnable) {
        this.f46159b = runnable;
    }

    @Nullable
    public OnSdkDismissCallback d() {
        return this.f46162e;
    }

    public void d(@Nullable String str) {
        this.f46161d = str;
    }

    public boolean h() {
        return this.f46160c;
    }

    @Nullable
    public Runnable i() {
        return this.f46159b;
    }

    @Nullable
    public String j() {
        return this.f46161d;
    }
}
