package com.instabug.survey.ui.popup;

import android.app.Activity;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f52534a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f52535b;
    @LayoutRes

    /* renamed from: c  reason: collision with root package name */
    private int f52536c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private String f52537d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private String f52538e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private f f52539f;

    public e(Activity activity) {
        this.f52534a = new WeakReference(activity);
    }

    public e a(@LayoutRes int i11) {
        this.f52536c = i11;
        return this;
    }

    public e a(f fVar) {
        this.f52539f = fVar;
        return this;
    }

    public e a(@Nullable String str) {
        this.f52535b = str;
        return this;
    }

    public void a() {
        Activity activity = (Activity) this.f52534a.get();
        if (activity != null) {
            g.b(activity, this.f52536c, this.f52535b, this.f52538e, this.f52537d, this.f52539f);
        }
    }

    public e b(String str) {
        this.f52537d = str;
        return this;
    }

    public e c(String str) {
        this.f52538e = str;
        return this;
    }
}
