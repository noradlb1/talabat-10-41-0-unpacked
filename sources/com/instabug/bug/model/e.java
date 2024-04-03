package com.instabug.bug.model;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

public class e {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f45671a;

    /* renamed from: b  reason: collision with root package name */
    private CharSequence f45672b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private CharSequence f45673c;
    @StringRes

    /* renamed from: d  reason: collision with root package name */
    public int f45674d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private String f45675e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f45676f;

    public e(CharSequence charSequence, @Nullable CharSequence charSequence2, boolean z11, @Nullable String str) {
        this.f45672b = charSequence;
        this.f45673c = charSequence2;
        this.f45676f = z11;
        this.f45671a = str;
    }

    @StringRes
    public int a() {
        return this.f45674d;
    }

    public void a(@StringRes int i11) {
        this.f45674d = i11;
    }

    public void a(@Nullable String str) {
        this.f45675e = str;
    }

    public CharSequence b() {
        return this.f45672b;
    }

    @Nullable
    public String c() {
        return this.f45671a;
    }

    @Nullable
    public CharSequence d() {
        return this.f45673c;
    }

    @Nullable
    public String e() {
        return this.f45675e;
    }

    public boolean f() {
        return this.f45676f;
    }
}
