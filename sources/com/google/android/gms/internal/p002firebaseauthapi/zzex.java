package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzex  reason: invalid package */
public final class zzex extends zzcw {
    private final int zza;
    private final int zzb = 12;
    private final int zzc = 16;
    private final zzev zzd;

    public /* synthetic */ zzex(int i11, int i12, int i13, zzev zzev, zzew zzew) {
        this.zza = i11;
        this.zzd = zzev;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzex)) {
            return false;
        }
        zzex zzex = (zzex) obj;
        return zzex.zza == this.zza && zzex.zzd == this.zzd;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzex.class, Integer.valueOf(this.zza), 12, 16, this.zzd});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzd);
        int i11 = this.zza;
        return "AesGcm Parameters (variant: " + valueOf + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + 12 + "-byte IV, " + 16 + "-byte tag, and " + i11 + "-byte key)";
    }

    public final int zza() {
        return this.zza;
    }

    public final zzev zzb() {
        return this.zzd;
    }

    public final boolean zzc() {
        return this.zzd != zzev.zzc;
    }
}
