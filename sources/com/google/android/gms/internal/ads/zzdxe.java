package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzdxe implements zzbax {
    public final /* synthetic */ zzbbg zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzbdw zzc;
    public final /* synthetic */ String zzd;

    public /* synthetic */ zzdxe(zzbbg zzbbg, String str, zzbdw zzbdw, String str2) {
        this.zza = zzbbg;
        this.zzb = str;
        this.zzc = zzbdw;
        this.zzd = str2;
    }

    public final void zza(zzbcl zzbcl) {
        zzbbg zzbbg = this.zza;
        String str = this.zzb;
        zzbdw zzbdw = this.zzc;
        String str2 = this.zzd;
        zzbbh zzbbh = (zzbbh) zzbcl.zza().zzau();
        zzbbh.zza(zzbbg);
        zzbcl.zze(zzbbh);
        zzbcd zzbcd = (zzbcd) zzbcl.zzb().zzau();
        zzbcd.zza(str);
        zzbcd.zzb(zzbdw);
        zzbcl.zzg(zzbcd);
        zzbcl.zzh(str2);
    }
}
