package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Set;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbp  reason: invalid package */
final class zzbp implements zzbr {
    final /* synthetic */ zzkl zza;

    public zzbp(zzkl zzkl) {
        this.zza = zzkl;
    }

    public final zzbn zza(Class cls) throws GeneralSecurityException {
        try {
            return new zzbo(this.zza, cls);
        } catch (IllegalArgumentException e11) {
            throw new GeneralSecurityException("Primitive type not supported", e11);
        }
    }

    public final zzbn zzb() {
        zzkl zzkl = this.zza;
        return new zzbo(zzkl, zzkl.zzj());
    }

    public final Class zzc() {
        return this.zza.getClass();
    }

    @Nullable
    public final Class zzd() {
        return null;
    }

    public final Set zze() {
        return this.zza.zzm();
    }
}
