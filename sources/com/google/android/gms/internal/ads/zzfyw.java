package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Set;

final class zzfyw implements zzfyz {
    final /* synthetic */ zzfyi zza;

    public zzfyw(zzfyi zzfyi) {
        this.zza = zzfyi;
    }

    public final <Q> zzfya<Q> zza(Class<Q> cls) throws GeneralSecurityException {
        try {
            return new zzfyc(this.zza, cls);
        } catch (IllegalArgumentException e11) {
            throw new GeneralSecurityException("Primitive type not supported", e11);
        }
    }

    public final zzfya<?> zzb() {
        zzfyi zzfyi = this.zza;
        return new zzfyc(zzfyi, zzfyi.zzc());
    }

    public final Class<?> zzc() {
        return this.zza.getClass();
    }

    public final Class<?> zzd() {
        return null;
    }

    public final Set<Class<?>> zze() {
        return this.zza.zzg();
    }
}
