package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

public final class zzio extends zzid {
    private static final Set<zzhi<?>> zza;
    private static final zzhv zzb;
    private final String zzc;
    private final Level zzd;

    static {
        Set<zzhi<?>> unmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(new zzhi[]{zzhe.zza, zzhk.zza})));
        zza = unmodifiableSet;
        zzb = zzhy.zza(unmodifiableSet).zzd();
    }

    public /* synthetic */ zzio(String str, String str2, boolean z11, boolean z12, Level level, zzin zzin) {
        super(str2);
        String str3;
        if (str2.length() > 23) {
            int i11 = -1;
            int length = str2.length() - 1;
            while (true) {
                if (length < 0) {
                    break;
                }
                char charAt = str2.charAt(length);
                if (charAt == '.' || charAt == '$') {
                    i11 = length;
                } else {
                    length--;
                }
            }
            i11 = length;
            str2 = str2.substring(i11 + 1);
        }
        String valueOf = String.valueOf(str2);
        if (valueOf.length() != 0) {
            str3 = "".concat(valueOf);
        } else {
            str3 = new String("");
        }
        this.zzc = str3.substring(0, Math.min(str3.length(), 23));
        this.zzd = level;
    }
}
