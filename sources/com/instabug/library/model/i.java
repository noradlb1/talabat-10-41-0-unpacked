package com.instabug.library.model;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class i {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final int f51543a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f51544b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Throwable f51545c;

    public i(@NonNull int i11, @Nullable Bitmap bitmap) {
        this.f51543a = i11;
        this.f51544b = bitmap;
    }

    @Nullable
    public Bitmap a() {
        return this.f51544b;
    }

    @NonNull
    public int b() {
        return this.f51543a;
    }

    @Nullable
    public Throwable c() {
        return this.f51545c;
    }

    public i(@NonNull int i11, @Nullable Throwable th2) {
        this.f51543a = i11;
        this.f51545c = th2;
    }
}
