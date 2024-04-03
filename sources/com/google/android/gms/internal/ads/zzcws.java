package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import java.util.List;

final class zzcws implements zzfwm<String> {
    final /* synthetic */ zzcwu zza;

    public zzcws(zzcwu zzcwu) {
        this.zza = zzcwu;
    }

    public final void zza(Throwable th2) {
    }

    public final /* bridge */ /* synthetic */ void zzb(@Nullable Object obj) {
        zzfeo zzd = this.zza.zzh;
        List<String> zzb = this.zza.zzg.zzb(this.zza.zze, this.zza.zzf, false, "", (String) obj, this.zza.zzf.zzc);
        zzt.zzp();
        int i11 = 1;
        if (true == com.google.android.gms.ads.internal.util.zzt.zzJ(this.zza.zza)) {
            i11 = 2;
        }
        zzd.zzc(zzb, i11);
    }
}
