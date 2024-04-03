package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhw  reason: invalid package */
public final class zzhw extends zzie {
    private final int zza;
    private final zzhu zzb;

    public /* synthetic */ zzhw(int i11, zzhu zzhu, zzhv zzhv) {
        this.zza = i11;
        this.zzb = zzhu;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhw)) {
            return false;
        }
        zzhw zzhw = (zzhw) obj;
        return zzhw.zza == this.zza && zzhw.zzb == this.zzb;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzhw.class, Integer.valueOf(this.zza), this.zzb});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzb);
        int i11 = this.zza;
        return "AesSiv Parameters (variant: " + valueOf + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + i11 + "-byte key)";
    }

    public final int zza() {
        return this.zza;
    }

    public final zzhu zzb() {
        return this.zzb;
    }

    public final boolean zzc() {
        return this.zzb != zzhu.zzc;
    }
}
