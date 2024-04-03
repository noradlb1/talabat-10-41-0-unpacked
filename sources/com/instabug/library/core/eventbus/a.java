package com.instabug.library.core.eventbus;

import android.content.res.Configuration;
import androidx.annotation.Nullable;

public class a extends EventBus {

    /* renamed from: b  reason: collision with root package name */
    private static a f34185b;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private Configuration f34186a;

    public static a a() {
        if (f34185b == null) {
            f34185b = new a();
        }
        return f34185b;
    }

    @Nullable
    public Configuration b() {
        return this.f34186a;
    }

    public void a(@Nullable Configuration configuration) {
        this.f34186a = configuration;
    }
}
