package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.util.zzbc;
import com.google.android.gms.ads.internal.util.zzbd;

public final class zzedq extends zzcdl {
    final /* synthetic */ zzedr zza;

    public zzedq(zzedr zzedr) {
        this.zza = zzedr;
    }

    public final void zze(zzbd zzbd) {
        this.zza.zza.zze(new zzbc(zzbd.zza, zzbd.zzb));
    }

    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zza.zzd(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
    }
}
