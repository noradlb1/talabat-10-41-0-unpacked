package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

final class zzgbo implements zzfym {
    private final zzfyr<zzfym> zza;
    private final byte[] zzb = {0};

    public /* synthetic */ zzgbo(zzfyr zzfyr, zzgbn zzgbn) {
        this.zza = zzfyr;
    }

    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        if (this.zza.zzb().zzd() == 4) {
            return zzghc.zzb(this.zza.zzb().zzb(), this.zza.zzb().zza().zza(zzghc.zzb(bArr, this.zzb)));
        }
        return zzghc.zzb(this.zza.zzb().zzb(), this.zza.zzb().zza().zza(bArr));
    }
}
