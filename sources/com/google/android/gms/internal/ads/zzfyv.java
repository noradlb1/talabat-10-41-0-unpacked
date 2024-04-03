package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Set;

final class zzfyv implements zzfyz {
    final /* synthetic */ zzfya zza;

    public zzfyv(zzfya zzfya) {
        this.zza = zzfya;
    }

    public final <Q> zzfya<Q> zza(Class<Q> cls) throws GeneralSecurityException {
        if (this.zza.zzc().equals(cls)) {
            return this.zza;
        }
        throw new InternalError("This should never be called, as we always first check supportedPrimitives.");
    }

    public final zzfya<?> zzb() {
        return this.zza;
    }

    public final Class<?> zzc() {
        return this.zza.getClass();
    }

    public final Class<?> zzd() {
        return null;
    }

    public final Set<Class<?>> zze() {
        return Collections.singleton(this.zza.zzc());
    }
}
