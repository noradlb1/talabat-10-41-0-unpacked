package com.instabug.library.model;

import androidx.annotation.Nullable;

public class d {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f51514a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f51515b;

    /* renamed from: c  reason: collision with root package name */
    private long f51516c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private String f51517d;

    public d a(String str) {
        this.f51517d = str;
        return this;
    }

    public d b(String str) {
        this.f51515b = str;
        return this;
    }

    public d c(String str) {
        this.f51514a = str;
        return this;
    }

    public d a(long j11) {
        this.f51516c = j11;
        return this;
    }

    public e a() {
        return new e(this.f51514a, this.f51515b, this.f51516c, this.f51517d);
    }
}
