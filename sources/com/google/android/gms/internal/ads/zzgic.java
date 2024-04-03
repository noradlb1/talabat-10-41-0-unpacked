package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;

final class zzgic extends ThreadLocal<Mac> {
    final /* synthetic */ zzgid zza;

    public zzgic(zzgid zzgid) {
        this.zza = zzgid;
    }

    /* renamed from: zza */
    public final Mac initialValue() {
        try {
            Mac zza2 = zzghp.zzb.zza(this.zza.zzb);
            zza2.init(this.zza.zzc);
            return zza2;
        } catch (GeneralSecurityException e11) {
            throw new IllegalStateException(e11);
        }
    }
}
