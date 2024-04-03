package com.instabug.library.encryption;

import android.app.Application;
import android.content.SharedPreferences;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f34342a = new a();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static SharedPreferences f34343b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static SharedPreferences.Editor f34344c;

    static {
        Application a11;
        com.instabug.library.internal.contentprovider.a b11 = com.instabug.library.internal.contentprovider.a.b();
        if (b11 != null && (a11 = b11.a()) != null) {
            SharedPreferences sharedPreferences = a11.getSharedPreferences("IB_Encryption", 0);
            f34343b = sharedPreferences;
            Intrinsics.checkNotNull(sharedPreferences);
            f34344c = sharedPreferences.edit();
        }
    }

    private a() {
    }

    public final void a(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "iv");
        SharedPreferences.Editor editor = f34344c;
        if (editor != null) {
            editor.putString("ib_encryption_iv", str);
            editor.apply();
        }
    }

    public final void b(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        SharedPreferences.Editor editor = f34344c;
        if (editor != null) {
            editor.putString("ib_encryption_key", str);
            editor.apply();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r0 = r0.getString("ib_encryption_iv", "");
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a() {
        /*
            r3 = this;
            android.content.SharedPreferences r0 = f34343b
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0007
            goto L_0x0011
        L_0x0007:
            java.lang.String r2 = "ib_encryption_iv"
            java.lang.String r0 = r0.getString(r2, r1)
            if (r0 != 0) goto L_0x0010
            goto L_0x0011
        L_0x0010:
            r1 = r0
        L_0x0011:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.encryption.a.a():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r0 = r0.getString("ib_encryption_key", "");
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String b() {
        /*
            r3 = this;
            android.content.SharedPreferences r0 = f34343b
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0007
            goto L_0x0011
        L_0x0007:
            java.lang.String r2 = "ib_encryption_key"
            java.lang.String r0 = r0.getString(r2, r1)
            if (r0 != 0) goto L_0x0010
            goto L_0x0011
        L_0x0010:
            r1 = r0
        L_0x0011:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.encryption.a.b():java.lang.String");
    }
}
