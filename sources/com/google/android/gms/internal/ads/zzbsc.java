package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzu;
import java.util.Map;

final class zzbsc implements zzu {
    boolean zza = false;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzbes zzc;
    final /* synthetic */ Map zzd;
    final /* synthetic */ Map zze;

    public zzbsc(zzbse zzbse, boolean z11, zzbes zzbes, Map map, Map map2) {
        this.zzb = z11;
        this.zzc = zzbes;
        this.zzd = map;
        this.zze = map2;
    }

    public final void zza(boolean z11) {
        if (!this.zza) {
            if (z11 && this.zzb) {
                ((zzdmd) this.zzc).zzq();
            }
            this.zza = true;
            this.zzd.put((String) this.zze.get("event_id"), Boolean.valueOf(z11));
            ((zzbuk) this.zzc).zzd("openIntentAsync", this.zzd);
        }
    }

    public final void zzb(int i11) {
    }
}
