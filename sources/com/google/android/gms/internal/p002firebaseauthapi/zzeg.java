package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeg  reason: invalid package */
public final class zzeg extends zzcw {
    private final int zza;
    private final int zzb;
    private final int zzc = 16;
    private final zzee zzd;

    public /* synthetic */ zzeg(int i11, int i12, int i13, zzee zzee, zzef zzef) {
        this.zza = i11;
        this.zzb = i12;
        this.zzd = zzee;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzeg)) {
            return false;
        }
        zzeg zzeg = (zzeg) obj;
        return zzeg.zza == this.zza && zzeg.zzb == this.zzb && zzeg.zzd == this.zzd;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzeg.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), 16, this.zzd});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzd);
        int i11 = this.zzb;
        int i12 = this.zza;
        return "AesEax Parameters (variant: " + valueOf + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + i11 + "-byte IV, " + 16 + "-byte tag, and " + i12 + "-byte key)";
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zzee zzc() {
        return this.zzd;
    }

    public final boolean zzd() {
        return this.zzd != zzee.zzc;
    }
}
