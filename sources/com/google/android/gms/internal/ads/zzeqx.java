package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;

public final class zzeqx implements zzevm<Bundle> {
    private final zzbfo zza;
    private final zzcjf zzb;
    private final boolean zzc;

    public zzeqx(zzbfo zzbfo, zzcjf zzcjf, boolean z11) {
        this.zza = zzbfo;
        this.zzb = zzcjf;
        this.zzc = z11;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.zzb.zzc >= ((Integer) zzbgq.zzc().zzb(zzblj.zzdJ)).intValue()) {
            bundle.putString("app_open_version", ExifInterface.GPS_MEASUREMENT_2D);
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzdK)).booleanValue()) {
            bundle.putBoolean("app_switched", this.zzc);
        }
        zzbfo zzbfo = this.zza;
        if (zzbfo != null) {
            int i11 = zzbfo.zza;
            if (i11 == 1) {
                bundle.putString("avo", "p");
            } else if (i11 == 2) {
                bundle.putString("avo", "l");
            }
        }
    }
}
