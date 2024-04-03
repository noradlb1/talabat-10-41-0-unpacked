package com.google.android.gms.internal.ads;

import android.os.IBinder;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdError;

final class zzems implements zzdga {
    boolean zza = false;
    final /* synthetic */ zzehw zzb;
    final /* synthetic */ zzcjr zzc;
    final /* synthetic */ zzemt zzd;

    public zzems(zzemt zzemt, zzehw zzehw, zzcjr zzcjr) {
        this.zzd = zzemt;
        this.zzb = zzehw;
        this.zzc = zzcjr;
    }

    private final void zze(zzbew zzbew) {
        int i11 = 1;
        if (true == ((Boolean) zzbgq.zzc().zzb(zzblj.zzdT)).booleanValue()) {
            i11 = 3;
        }
        this.zzc.zze(new zzehx(i11, zzbew));
    }

    public final void zza(int i11) {
        if (!this.zza) {
            zze(new zzbew(i11, zzemt.zze(this.zzb.zza, i11), AdError.UNDEFINED_DOMAIN, (zzbew) null, (IBinder) null));
        }
    }

    public final synchronized void zzb(zzbew zzbew) {
        this.zza = true;
        zze(zzbew);
    }

    public final synchronized void zzc(int i11, @Nullable String str) {
        if (!this.zza) {
            this.zza = true;
            if (str == null) {
                str = zzemt.zze(this.zzb.zza, i11);
            }
            zze(new zzbew(i11, str, AdError.UNDEFINED_DOMAIN, (zzbew) null, (IBinder) null));
        }
    }

    public final synchronized void zzd() {
        this.zzc.zzd(null);
    }
}
