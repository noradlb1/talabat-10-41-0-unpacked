package com.google.android.gms.internal.ads;

import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;

public final class zzcxx {
    private final zzfio zza;
    private final zzdyz zzb;
    private final zzfdz zzc;

    public zzcxx(zzdyz zzdyz, zzfdz zzfdz, zzfio zzfio) {
        this.zza = zzfio;
        this.zzb = zzdyz;
        this.zzc = zzfdz;
    }

    private static String zzb(int i11) {
        int i12 = i11 - 1;
        return i12 != 0 ? i12 != 1 ? i12 != 2 ? i12 != 3 ? i12 != 4 ? "u" : "ac" : "cb" : "cc" : "bb" : "h";
    }

    public final void zza(long j11, int i11) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgq)).booleanValue()) {
            zzfio zzfio = this.zza;
            zzfin zzb2 = zzfin.zzb("ad_closed");
            zzb2.zzg(this.zzc.zzb.zzb);
            zzb2.zza("show_time", String.valueOf(j11));
            zzb2.zza(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad");
            zzb2.zza("acr", zzb(i11));
            zzfio.zzb(zzb2);
            return;
        }
        zzdyy zza2 = this.zzb.zza();
        zza2.zzd(this.zzc.zzb.zzb);
        zza2.zzb(NativeProtocol.WEB_DIALOG_ACTION, "ad_closed");
        zza2.zzb("show_time", String.valueOf(j11));
        zza2.zzb(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad");
        zza2.zzb("acr", zzb(i11));
        zza2.zzf();
    }
}
