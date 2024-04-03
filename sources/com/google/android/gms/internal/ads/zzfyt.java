package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzglv;

public final class zzfyt<PrimitiveT, KeyProtoT extends zzglv, PublicKeyProtoT extends zzglv> extends zzfyc<PrimitiveT, KeyProtoT> {
    private final zzfyu<KeyProtoT, PublicKeyProtoT> zza;
    private final zzfyi<PublicKeyProtoT> zzb;

    public zzfyt(zzfyu<KeyProtoT, PublicKeyProtoT> zzfyu, zzfyi<PublicKeyProtoT> zzfyi, Class<PrimitiveT> cls) {
        super(zzfyu, cls);
        this.zza = zzfyu;
        this.zzb = zzfyi;
    }
}
