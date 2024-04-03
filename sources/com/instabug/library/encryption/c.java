package com.instabug.library.encryption;

import java.security.Key;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final c f34345a = new c();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static Key f34346b;

    private c() {
    }

    @JvmStatic
    @Nullable
    public static final Key a() {
        if (f34346b == null) {
            Key b11 = f.b();
            if (b11 == null) {
                b11 = StaticKeyProvider.a();
            }
            f34346b = b11;
        }
        return f34346b;
    }
}
