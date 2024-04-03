package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzglv;
import java.security.GeneralSecurityException;

final class zzfyb<KeyFormatProtoT extends zzglv, KeyProtoT extends zzglv> {
    final zzfyg<KeyFormatProtoT, KeyProtoT> zza;

    public zzfyb(zzfyg<KeyFormatProtoT, KeyProtoT> zzfyg) {
        this.zza = zzfyg;
    }

    public final KeyProtoT zza(zzgjf zzgjf) throws GeneralSecurityException, zzgkx {
        KeyFormatProtoT zza2 = this.zza.zza(zzgjf);
        this.zza.zze(zza2);
        return this.zza.zzc(zza2);
    }
}
