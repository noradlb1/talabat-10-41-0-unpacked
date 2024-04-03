package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.TrafficStats;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzt;

public final /* synthetic */ class zzcoy implements zzfqs {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzcqe zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ boolean zze;
    public final /* synthetic */ zzalt zzf;
    public final /* synthetic */ zzbmi zzg;
    public final /* synthetic */ zzcjf zzh;
    public final /* synthetic */ zzl zzi;
    public final /* synthetic */ zza zzj;
    public final /* synthetic */ zzbay zzk;
    public final /* synthetic */ zzfdn zzl;
    public final /* synthetic */ zzfdq zzm;

    public /* synthetic */ zzcoy(Context context, zzcqe zzcqe, String str, boolean z11, boolean z12, zzalt zzalt, zzbmi zzbmi, zzcjf zzcjf, zzbly zzbly, zzl zzl2, zza zza2, zzbay zzbay, zzfdn zzfdn, zzfdq zzfdq) {
        this.zza = context;
        this.zzb = zzcqe;
        this.zzc = str;
        this.zzd = z11;
        this.zze = z12;
        this.zzf = zzalt;
        this.zzg = zzbmi;
        this.zzh = zzcjf;
        this.zzi = zzl2;
        this.zzj = zza2;
        this.zzk = zzbay;
        this.zzl = zzfdn;
        this.zzm = zzfdq;
    }

    public final Object zza() {
        Context context = this.zza;
        zzcqe zzcqe = this.zzb;
        String str = this.zzc;
        boolean z11 = this.zzd;
        boolean z12 = this.zze;
        zzalt zzalt = this.zzf;
        zzbmi zzbmi = this.zzg;
        zzcjf zzcjf = this.zzh;
        zzl zzl2 = this.zzi;
        zza zza2 = this.zzj;
        zzbay zzbay = this.zzk;
        zzfdn zzfdn = this.zzl;
        zzfdq zzfdq = this.zzm;
        try {
            TrafficStats.setThreadStatsTag(264);
            int i11 = zzcpi.zza;
            zzcpe zzcpe = new zzcpe(new zzcpi(new zzcqd(context), zzcqe, str, z11, z12, zzalt, zzbmi, zzcjf, (zzbly) null, zzl2, zza2, zzbay, zzfdn, zzfdq));
            zzcpe.setWebViewClient(zzt.zzq().zzn(zzcpe, zzbay, z12));
            zzcpe.setWebChromeClient(new zzcoo(zzcpe));
            return zzcpe;
        } finally {
            TrafficStats.clearThreadStatsTag();
        }
    }
}
