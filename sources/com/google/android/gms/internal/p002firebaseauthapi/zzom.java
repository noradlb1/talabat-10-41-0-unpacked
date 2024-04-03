package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzom  reason: invalid package */
public final class zzom {
    private final zzbt zza;
    private final int zzb;
    private final String zzc;
    private final String zzd;

    public /* synthetic */ zzom(zzbt zzbt, int i11, String str, String str2, zzol zzol) {
        this.zza = zzbt;
        this.zzb = i11;
        this.zzc = str;
        this.zzd = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzom)) {
            return false;
        }
        zzom zzom = (zzom) obj;
        if (this.zza != zzom.zza || this.zzb != zzom.zzb || !this.zzc.equals(zzom.zzc) || !this.zzd.equals(zzom.zzd)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public final String toString() {
        return String.format("(status=%s, keyId=%s, keyType='%s', keyPrefix='%s')", new Object[]{this.zza, Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public final int zza() {
        return this.zzb;
    }
}
