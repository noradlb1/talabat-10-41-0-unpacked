package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbq  reason: invalid package */
final class zzbq implements zzbr {
    final /* synthetic */ zzls zza;
    final /* synthetic */ zzkl zzb;

    public zzbq(zzls zzls, zzkl zzkl) {
        this.zza = zzls;
        this.zzb = zzkl;
    }

    public final zzbn zza(Class cls) throws GeneralSecurityException {
        try {
            return new zzco(this.zza, this.zzb, cls);
        } catch (IllegalArgumentException e11) {
            throw new GeneralSecurityException("Primitive type not supported", e11);
        }
    }

    public final zzbn zzb() {
        zzls zzls = this.zza;
        return new zzco(zzls, this.zzb, zzls.zzj());
    }

    public final Class zzc() {
        return this.zza.getClass();
    }

    public final Class zzd() {
        return this.zzb.getClass();
    }

    public final Set zze() {
        return this.zza.zzm();
    }
}
