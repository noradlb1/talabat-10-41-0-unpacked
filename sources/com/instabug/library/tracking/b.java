package com.instabug.library.tracking;

import androidx.annotation.NonNull;

public class b {

    /* renamed from: d  reason: collision with root package name */
    private static b f51914d;

    /* renamed from: a  reason: collision with root package name */
    private String f51915a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f51916b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f51917c = "";

    private b() {
    }

    public static b c() {
        if (f51914d == null) {
            f51914d = new b();
        }
        return f51914d;
    }

    @NonNull
    public synchronized String a() {
        return this.f51917c;
    }

    public synchronized void b(@NonNull String str) {
        this.f51915a = str;
    }

    public synchronized void a(@NonNull String str) {
        this.f51917c = str;
    }

    public synchronized String b() {
        String str = this.f51916b;
        if (str == null || str.isEmpty()) {
            return this.f51915a;
        }
        return this.f51916b;
    }

    public void c(@NonNull String str) {
        this.f51916b = str;
    }
}
