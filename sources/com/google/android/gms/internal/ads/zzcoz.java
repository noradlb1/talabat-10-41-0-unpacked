package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzt;

public final /* synthetic */ class zzcoz implements zzfvw {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzalt zzb;
    public final /* synthetic */ zzcjf zzc;
    public final /* synthetic */ zza zzd;
    public final /* synthetic */ String zze;

    public /* synthetic */ zzcoz(Context context, zzalt zzalt, zzcjf zzcjf, zza zza2, String str) {
        this.zza = context;
        this.zzb = zzalt;
        this.zzc = zzcjf;
        this.zzd = zza2;
        this.zze = str;
    }

    public final zzfxa zza() {
        Context context = this.zza;
        zzalt zzalt = this.zzb;
        zzcjf zzcjf = this.zzc;
        zza zza2 = this.zzd;
        String str = this.zze;
        zzt.zzz();
        zzcop zza3 = zzcpb.zza(context, zzcqe.zza(), "", false, false, zzalt, (zzbmi) null, zzcjf, (zzbly) null, (zzl) null, zza2, zzbay.zza(), (zzfdn) null, (zzfdq) null);
        zzcjq zza4 = zzcjq.zza(zza3);
        zza3.zzP().zzz(new zzcox(zza4));
        zza3.loadUrl(str);
        return zza4;
    }
}
