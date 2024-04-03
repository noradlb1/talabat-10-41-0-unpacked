package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzcp extends zzdu {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzbz zzc;
    final /* synthetic */ zzef zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzcp(zzef zzef, String str, String str2, zzbz zzbz) {
        super(zzef, true);
        this.zzd = zzef;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzbz;
    }

    public final void zza() throws RemoteException {
        ((zzcc) Preconditions.checkNotNull(this.zzd.zzj)).getConditionalUserProperties(this.zza, this.zzb, this.zzc);
    }

    public final void zzb() {
        this.zzc.zze((Bundle) null);
    }
}
