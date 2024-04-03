package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.graphics.Bitmap;
import com.google.android.gms.ads.internal.util.zzae;
import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzt;

final class zzk extends zzb {
    final /* synthetic */ zzl zza;

    public /* synthetic */ zzk(zzl zzl, zzj zzj) {
        this.zza = zzl;
    }

    public final void zza() {
        Bitmap zza2 = zzt.zzu().zza(Integer.valueOf(this.zza.zzc.zzo.zzf));
        if (zza2 != null) {
            zzae zzq = zzt.zzq();
            zzl zzl = this.zza;
            Activity activity = zzl.zzb;
            zzj zzj = zzl.zzc.zzo;
            com.google.android.gms.ads.internal.util.zzt.zza.post(new zzi(this, zzq.zzc(activity, zza2, zzj.zzd, zzj.zze)));
        }
    }
}
