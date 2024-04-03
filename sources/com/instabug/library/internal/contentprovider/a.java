package com.instabug.library.internal.contentprovider;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class a {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static a f50960b;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Application f50961a;

    private a(@NonNull Application application) {
        this.f50961a = application;
    }

    public static void b(Application application) {
        if (f50960b == null) {
            f50960b = new a(application);
        }
    }

    @NonNull
    public Application a() {
        return this.f50961a;
    }

    @Nullable
    public static a b() {
        return f50960b;
    }
}
