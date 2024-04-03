package com.instabug.commons.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.instabug.library.Instabug;
import com.instabug.library.internal.servicelocator.CoreServiceLocator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final c f46365a = new c();

    private c() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0011, code lost:
        r4 = com.instabug.library.internal.servicelocator.CoreServiceLocator.getInstabugSharedPreferences(r0, r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(@org.jetbrains.annotations.NotNull java.lang.String r2, boolean r3, @org.jetbrains.annotations.NotNull java.lang.String r4) {
        /*
            r1 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "spFilename"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r0 = com.instabug.library.Instabug.getApplicationContext()
            if (r0 != 0) goto L_0x0011
            return r3
        L_0x0011:
            android.content.SharedPreferences r4 = com.instabug.library.internal.servicelocator.CoreServiceLocator.getInstabugSharedPreferences(r0, r4)
            if (r4 != 0) goto L_0x0018
            goto L_0x001c
        L_0x0018:
            boolean r3 = r4.getBoolean(r2, r3)
        L_0x001c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.commons.utils.c.a(java.lang.String, boolean, java.lang.String):boolean");
    }

    public final void b(@NotNull String str, boolean z11, @NotNull String str2) {
        SharedPreferences instabugSharedPreferences;
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "spFilename");
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext != null && (instabugSharedPreferences = CoreServiceLocator.getInstabugSharedPreferences(applicationContext, str2)) != null) {
            SharedPreferences.Editor edit = instabugSharedPreferences.edit();
            edit.putBoolean(str, z11);
            edit.apply();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0011, code lost:
        r5 = com.instabug.library.internal.servicelocator.CoreServiceLocator.getInstabugSharedPreferences(r0, r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long a(@org.jetbrains.annotations.NotNull java.lang.String r2, long r3, @org.jetbrains.annotations.NotNull java.lang.String r5) {
        /*
            r1 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "spFilename"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            android.content.Context r0 = com.instabug.library.Instabug.getApplicationContext()
            if (r0 != 0) goto L_0x0011
            return r3
        L_0x0011:
            android.content.SharedPreferences r5 = com.instabug.library.internal.servicelocator.CoreServiceLocator.getInstabugSharedPreferences(r0, r5)
            if (r5 != 0) goto L_0x0018
            goto L_0x001c
        L_0x0018:
            long r3 = r5.getLong(r2, r3)
        L_0x001c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.commons.utils.c.a(java.lang.String, long, java.lang.String):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0011, code lost:
        r4 = com.instabug.library.internal.servicelocator.CoreServiceLocator.getInstabugSharedPreferences(r0, r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final float a(@org.jetbrains.annotations.NotNull java.lang.String r2, float r3, @org.jetbrains.annotations.NotNull java.lang.String r4) {
        /*
            r1 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "spFilename"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r0 = com.instabug.library.Instabug.getApplicationContext()
            if (r0 != 0) goto L_0x0011
            return r3
        L_0x0011:
            android.content.SharedPreferences r4 = com.instabug.library.internal.servicelocator.CoreServiceLocator.getInstabugSharedPreferences(r0, r4)
            if (r4 != 0) goto L_0x0018
            goto L_0x001c
        L_0x0018:
            float r3 = r4.getFloat(r2, r3)
        L_0x001c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.commons.utils.c.a(java.lang.String, float, java.lang.String):float");
    }
}
