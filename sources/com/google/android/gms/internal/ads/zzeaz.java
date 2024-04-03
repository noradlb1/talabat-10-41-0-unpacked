package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import javax.annotation.Nullable;

final class zzeaz implements zzfwm<String> {
    final /* synthetic */ zzebb zza;

    public zzeaz(zzebb zzebb) {
        this.zza = zzebb;
    }

    public final void zza(Throwable th2) {
        synchronized (this) {
            this.zza.zzc = true;
            this.zza.zzu("com.google.android.gms.ads.MobileAds", false, "Internal Error.", (int) (zzt.zzA().elapsedRealtime() - this.zza.zzd));
            this.zza.zze.zze(new Exception());
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(@Nullable Object obj) {
        String str = (String) obj;
        synchronized (this) {
            this.zza.zzc = true;
            this.zza.zzu("com.google.android.gms.ads.MobileAds", true, "", (int) (zzt.zzA().elapsedRealtime() - this.zza.zzd));
            this.zza.zzi.execute(new zzeay(this, str));
        }
    }
}
