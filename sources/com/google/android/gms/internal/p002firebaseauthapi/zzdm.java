package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdm  reason: invalid package */
public final class zzdm extends zzcw {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final zzdk zze;
    private final zzdj zzf;

    public /* synthetic */ zzdm(int i11, int i12, int i13, int i14, zzdk zzdk, zzdj zzdj, zzdl zzdl) {
        this.zza = i11;
        this.zzb = i12;
        this.zzc = i13;
        this.zzd = i14;
        this.zze = zzdk;
        this.zzf = zzdj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzdm)) {
            return false;
        }
        zzdm zzdm = (zzdm) obj;
        return zzdm.zza == this.zza && zzdm.zzb == this.zzb && zzdm.zzc == this.zzc && zzdm.zzd == this.zzd && zzdm.zze == this.zze && zzdm.zzf == this.zzf;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzdm.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zze);
        String valueOf2 = String.valueOf(this.zzf);
        int i11 = this.zzc;
        int i12 = this.zzd;
        int i13 = this.zza;
        int i14 = this.zzb;
        return "AesCtrHmacAead Parameters (variant: " + valueOf + ", hashType: " + valueOf2 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + i11 + "-byte IV, and " + i12 + "-byte tags, and " + i13 + "-byte AES key, and " + i14 + "-byte HMAC key)";
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return this.zzd;
    }

    public final zzdj zze() {
        return this.zzf;
    }

    public final zzdk zzf() {
        return this.zze;
    }

    public final boolean zzg() {
        return this.zze != zzdk.zzc;
    }
}
