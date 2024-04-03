package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public abstract class zzfyh<PrimitiveT, KeyT> {
    private final Class<PrimitiveT> zza;

    public zzfyh(Class<PrimitiveT> cls) {
        this.zza = cls;
    }

    public final Class<PrimitiveT> zza() {
        return this.zza;
    }

    public abstract PrimitiveT zzb(KeyT keyt) throws GeneralSecurityException;
}
