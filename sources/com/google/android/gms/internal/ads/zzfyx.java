package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Set;

final class zzfyx implements zzfyz {
    final /* synthetic */ zzfyu zza;
    final /* synthetic */ zzfyi zzb;

    public zzfyx(zzfyu zzfyu, zzfyi zzfyi) {
        this.zza = zzfyu;
        this.zzb = zzfyi;
    }

    public final <Q> zzfya<Q> zza(Class<Q> cls) throws GeneralSecurityException {
        try {
            return new zzfyt(this.zza, this.zzb, cls);
        } catch (IllegalArgumentException e11) {
            throw new GeneralSecurityException("Primitive type not supported", e11);
        }
    }

    public final zzfya<?> zzb() {
        zzfyu zzfyu = this.zza;
        return new zzfyt(zzfyu, this.zzb, zzfyu.zzc());
    }

    public final Class<?> zzc() {
        return this.zza.getClass();
    }

    public final Class<?> zzd() {
        return this.zzb.getClass();
    }

    public final Set<Class<?>> zze() {
        return this.zza.zzg();
    }
}
