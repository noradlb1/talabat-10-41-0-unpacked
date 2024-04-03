package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafm  reason: invalid package */
final class zzafm extends zzafo {
    final /* synthetic */ zzafv zza;
    private int zzb = 0;
    private final int zzc;

    public zzafm(zzafv zzafv) {
        this.zza = zzafv;
        this.zzc = zzafv.zzd();
    }

    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    public final byte zza() {
        int i11 = this.zzb;
        if (i11 < this.zzc) {
            this.zzb = i11 + 1;
            return this.zza.zzb(i11);
        }
        throw new NoSuchElementException();
    }
}
