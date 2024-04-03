package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmt  reason: invalid package */
public final class zzmt extends zzny {
    private final int zza;
    private final int zzb;
    private final zzmr zzc;

    public /* synthetic */ zzmt(int i11, int i12, zzmr zzmr, zzms zzms) {
        this.zza = i11;
        this.zzb = i12;
        this.zzc = zzmr;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzmt)) {
            return false;
        }
        zzmt zzmt = (zzmt) obj;
        if (zzmt.zza == this.zza && zzmt.zzc() == zzc() && zzmt.zzc == this.zzc) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzmt.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzc);
        int i11 = this.zzb;
        int i12 = this.zza;
        return "AES-CMAC Parameters (variant: " + valueOf + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + i11 + "-byte tags, and " + i12 + "-byte key)";
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zza;
    }

    public final int zzc() {
        zzmr zzmr = this.zzc;
        if (zzmr == zzmr.zzd) {
            return this.zzb;
        }
        if (zzmr == zzmr.zza || zzmr == zzmr.zzb || zzmr == zzmr.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzmr zzd() {
        return this.zzc;
    }

    public final boolean zze() {
        return this.zzc != zzmr.zzd;
    }
}
