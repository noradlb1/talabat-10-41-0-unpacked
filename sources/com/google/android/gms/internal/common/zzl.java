package com.google.android.gms.internal.common;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

final class zzl extends zzk {
    private final char zza;

    public zzl(char c11) {
        this.zza = c11;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CharMatcher.is('");
        int i11 = this.zza;
        char[] cArr = {'\\', AbstractJsonLexerKt.UNICODE_ESC, 0, 0, 0, 0};
        for (int i12 = 0; i12 < 4; i12++) {
            cArr[5 - i12] = "0123456789ABCDEF".charAt(i11 & 15);
            i11 >>= 4;
        }
        sb2.append(String.copyValueOf(cArr));
        sb2.append("')");
        return sb2.toString();
    }

    public final boolean zza(char c11) {
        return c11 == this.zza;
    }
}
