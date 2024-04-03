package com.google.android.gms.internal.p002firebaseauthapi;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzg  reason: invalid package */
final class zzg extends zzf {
    private final char zza;

    public zzg(char c11) {
        this.zza = c11;
    }

    public final String toString() {
        int i11 = this.zza;
        char[] cArr = {'\\', AbstractJsonLexerKt.UNICODE_ESC, 0, 0, 0, 0};
        for (int i12 = 0; i12 < 4; i12++) {
            cArr[5 - i12] = "0123456789ABCDEF".charAt(i11 & 15);
            i11 >>= 4;
        }
        String copyValueOf = String.copyValueOf(cArr);
        return "CharMatcher.is('" + copyValueOf + "')";
    }

    public final boolean zza(char c11) {
        return c11 == this.zza;
    }
}
