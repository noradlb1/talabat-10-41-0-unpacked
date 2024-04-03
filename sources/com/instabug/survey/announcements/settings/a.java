package com.instabug.survey.announcements.settings;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f52268a;

    @Nullable
    public static String a() {
        if (b.b() == null) {
            return null;
        }
        return b.b().a();
    }

    public static void a(long j11) {
        if (b.b() != null) {
            b.b().a(j11);
        }
    }

    public static void a(String str) {
        if (b.b() != null) {
            b.b().c(str);
        }
    }

    @NonNull
    public static a b() {
        if (f52268a == null) {
            f52268a = new a();
        }
        return f52268a;
    }

    public static void b(String str) {
        if (b.b() != null) {
            b.b().a(str);
        }
    }

    public void a(int i11) {
    }

    public void b(int i11) {
    }

    public void b(long j11) {
        if (b.b() != null) {
            b.b().c(j11);
        }
    }

    public long c() {
        if (b.b() == null) {
            return -1;
        }
        return b.b().c();
    }
}
