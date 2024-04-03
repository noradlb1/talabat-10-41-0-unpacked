package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzbas implements BaseGmsClient.BaseConnectionCallbacks {
    public static final /* synthetic */ int zzd = 0;
    final /* synthetic */ zzbak zza;
    final /* synthetic */ zzcjr zzb;
    final /* synthetic */ zzbau zzc;

    public zzbas(zzbau zzbau, zzbak zzbak, zzcjr zzcjr) {
        this.zzc = zzbau;
        this.zza = zzbak;
        this.zzb = zzcjr;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.zzc.zzd) {
            if (!this.zzc.zzb) {
                this.zzc.zzb = true;
                zzbaj zza2 = this.zzc.zza;
                if (zza2 != null) {
                    zzfxa<?> zza3 = zzcjm.zza.zza(new zzbap(this, zza2, this.zza, this.zzb));
                    zzcjr zzcjr = this.zzb;
                    zzcjr.zzc(new zzbaq(zzcjr, zza3), zzcjm.zzf);
                }
            }
        }
    }

    public final void onConnectionSuspended(int i11) {
    }
}
