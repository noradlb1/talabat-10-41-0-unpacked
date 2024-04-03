package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznq  reason: invalid package */
public final class zznq extends zzny {
    private final int zza;
    private final int zzb;
    private final zzno zzc;
    private final zznn zzd;

    public /* synthetic */ zznq(int i11, int i12, zzno zzno, zznn zznn, zznp zznp) {
        this.zza = i11;
        this.zzb = i12;
        this.zzc = zzno;
        this.zzd = zznn;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zznq)) {
            return false;
        }
        zznq zznq = (zznq) obj;
        if (zznq.zza == this.zza && zznq.zzc() == zzc() && zznq.zzc == this.zzc && zznq.zzd == this.zzd) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zznq.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzc);
        String valueOf2 = String.valueOf(this.zzd);
        int i11 = this.zzb;
        int i12 = this.zza;
        return "HMAC Parameters (variant: " + valueOf + ", hashType: " + valueOf2 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + i11 + "-byte tags, and " + i12 + "-byte key)";
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zza;
    }

    public final int zzc() {
        zzno zzno = this.zzc;
        if (zzno == zzno.zzd) {
            return this.zzb;
        }
        if (zzno == zzno.zza || zzno == zzno.zzb || zzno == zzno.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zznn zzd() {
        return this.zzd;
    }

    public final zzno zze() {
        return this.zzc;
    }

    public final boolean zzf() {
        return this.zzc != zzno.zzd;
    }
}
