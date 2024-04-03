package com.instabug.bug.model;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import androidx.annotation.Nullable;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private int f45677a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f45678b;

    /* renamed from: c  reason: collision with root package name */
    private String f45679c;

    /* renamed from: d  reason: collision with root package name */
    private String f45680d;

    /* renamed from: e  reason: collision with root package name */
    private Bitmap f45681e;

    public f(int i11, @Nullable String str, String str2, String str3, Bitmap bitmap) {
        this.f45677a = i11;
        this.f45678b = str;
        this.f45679c = str2;
        this.f45680d = str3;
        this.f45681e = bitmap;
    }

    @Nullable
    public String a() {
        return this.f45678b;
    }

    public int b() {
        return this.f45677a;
    }

    public Bitmap c() {
        return this.f45681e;
    }

    public String d() {
        return this.f45679c;
    }

    public String e() {
        return this.f45680d;
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return b() == fVar.b() && d().equals(fVar.d());
    }

    public int hashCode() {
        return 88;
    }
}
