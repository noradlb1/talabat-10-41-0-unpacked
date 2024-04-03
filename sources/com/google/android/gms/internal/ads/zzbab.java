package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;

public final class zzbab {
    private zzbhk zza;
    private final Context zzb;
    private final String zzc;
    private final zzbjg zzd;
    @AppOpenAd.AppOpenAdOrientation
    private final int zze;
    private final AppOpenAd.AppOpenAdLoadCallback zzf;
    private final zzbxe zzg = new zzbxe();
    private final zzbfh zzh;

    public zzbab(Context context, String str, zzbjg zzbjg, @AppOpenAd.AppOpenAdOrientation int i11, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.zzb = context;
        this.zzc = str;
        this.zzd = zzbjg;
        this.zze = i11;
        this.zzf = appOpenAdLoadCallback;
        this.zzh = zzbfh.zza;
    }

    public final void zza() {
        try {
            this.zza = zzbgo.zza().zzd(this.zzb, zzbfi.zzb(), this.zzc, this.zzg);
            zzbfo zzbfo = new zzbfo(this.zze);
            zzbhk zzbhk = this.zza;
            if (zzbhk != null) {
                zzbhk.zzI(zzbfo);
                this.zza.zzH(new zzazo(this.zzf, this.zzc));
                this.zza.zzaa(this.zzh.zza(this.zzb, this.zzd));
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }
}
