package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

final class zzdsj implements zzfpv<zzago, Bitmap> {
    final /* synthetic */ double zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzdsk zzc;

    public zzdsj(zzdsk zzdsk, double d11, boolean z11) {
        this.zzc = zzdsk;
        this.zza = d11;
        this.zzb = z11;
    }

    public final /* bridge */ /* synthetic */ Object apply(Object obj) {
        return zzdsk.zza(this.zzc, ((zzago) obj).zzb, this.zza, this.zzb);
    }
}
