package com.instabug.library.encryption.iv;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f34354a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f34355b;

    private a() {
    }

    public final void a(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<set-?>");
        f34355b = bArr;
    }

    @NotNull
    public final byte[] b() {
        byte[] bArr = f34355b;
        if (bArr != null) {
            return bArr;
        }
        Intrinsics.throwUninitializedPropertyAccessException("iv");
        return null;
    }

    @JvmStatic
    @NotNull
    public static final byte[] a() {
        if (f34355b == null) {
            a aVar = f34354a;
            byte[] c11 = b.c();
            if (c11 == null) {
                c11 = StaticIVProvider.a();
            }
            aVar.a(c11);
        }
        return f34354a.b();
    }
}
