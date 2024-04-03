package com.google.android.recaptcha.internal;

import kotlin.UInt;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class zzbz {
    @NotNull
    public static String zza(zzca zzca, @NotNull String str, byte b11) {
        StringBuilder sb2 = new StringBuilder(str.length());
        for (int i11 = 0; i11 < str.length(); i11++) {
            sb2.append((char) UInt.m6423constructorimpl(UInt.m6423constructorimpl(str.charAt(i11)) ^ UInt.m6423constructorimpl(b11)));
        }
        return sb2.toString();
    }

    public static void zzb(zzca zzca, int i11, int i12) throws zzs {
        if (i11 != i12) {
            throw new zzs(4, 24, (Throwable) null);
        }
    }
}
