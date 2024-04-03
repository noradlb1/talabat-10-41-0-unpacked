package com.instabug.library.model;

import androidx.annotation.Nullable;

public class f {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f51522a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f51523b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f51524c;

    /* renamed from: d  reason: collision with root package name */
    private long f51525d;

    public f a(String str) {
        this.f51522a = str;
        return this;
    }

    public f b(String str) {
        this.f51523b = str;
        return this;
    }

    public f c(String str) {
        this.f51524c = str;
        return this;
    }

    public f a(long j11) {
        this.f51525d = j11;
        return this;
    }

    public g a() {
        return new g(this.f51522a, this.f51523b, this.f51524c, this.f51525d);
    }
}
