package com.google.android.gms.internal.icing;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzbp {
    public static <T> T zza(@NullableDecl T t11) {
        if (t11 != null) {
            return t11;
        }
        StringBuilder sb2 = new StringBuilder(29);
        sb2.append("expected a non-null reference", 0, 29);
        throw new zzbq(sb2.toString());
    }
}
