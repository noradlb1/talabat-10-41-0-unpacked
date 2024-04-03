package com.google.android.gms.internal.ads;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

final class zzfpp extends zzfpo {
    private final char zza;

    public zzfpp(char c11) {
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
        StringBuilder sb2 = new StringBuilder(String.valueOf(copyValueOf).length() + 18);
        sb2.append("CharMatcher.is('");
        sb2.append(copyValueOf);
        sb2.append("')");
        return sb2.toString();
    }

    public final boolean zza(char c11) {
        return c11 == this.zza;
    }
}
