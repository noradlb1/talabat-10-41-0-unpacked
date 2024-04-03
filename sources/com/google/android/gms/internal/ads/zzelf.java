package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MobileAds;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

final class zzelf implements zzfwm {
    final /* synthetic */ long zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzfdn zzc;
    final /* synthetic */ zzfdq zzd;
    final /* synthetic */ zzfjp zze;
    final /* synthetic */ zzfdz zzf;
    final /* synthetic */ zzelg zzg;

    public zzelf(zzelg zzelg, long j11, String str, zzfdn zzfdn, zzfdq zzfdq, zzfjp zzfjp, zzfdz zzfdz) {
        this.zzg = zzelg;
        this.zza = j11;
        this.zzb = str;
        this.zzc = zzfdn;
        this.zzd = zzfdq;
        this.zze = zzfjp;
        this.zzf = zzfdz;
    }

    public final void zza(Throwable th2) {
        int i11;
        zzbew zzbew;
        zzehx zzehx;
        long elapsedRealtime = this.zzg.zza.elapsedRealtime() - this.zza;
        if (th2 instanceof TimeoutException) {
            i11 = 2;
        } else if (th2 instanceof zzekv) {
            i11 = 3;
        } else if (th2 instanceof CancellationException) {
            i11 = 4;
        } else if (th2 instanceof zzfek) {
            i11 = 5;
        } else if (!(th2 instanceof zzecd) || zzfey.zza(th2).zza != 3) {
            i11 = 6;
        } else {
            i11 = 1;
        }
        zzelg.zzg(this.zzg, this.zzb, i11, elapsedRealtime, this.zzc.zzad);
        if (this.zzg.zze) {
            zzelh zzb2 = this.zzg.zzb;
            zzfdq zzfdq = this.zzd;
            zzfdn zzfdn = this.zzc;
            if (th2 instanceof zzehx) {
                zzehx = (zzehx) th2;
            } else {
                zzehx = null;
            }
            zzb2.zza(zzfdq, zzfdn, i11, zzehx, elapsedRealtime);
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgg)).booleanValue()) {
            zzfjs zzc2 = this.zzg.zzc;
            zzfjp zzfjp = this.zze;
            zzfdz zzfdz = this.zzf;
            zzfdn zzfdn2 = this.zzc;
            zzc2.zzc(zzfjp.zza(zzfdz, zzfdn2, zzfdn2.zzo));
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzge)).booleanValue()) {
            zzbew zza2 = zzfey.zza(th2);
            int i12 = zza2.zza;
            if ((i12 == 3 || i12 == 0) && (zzbew = zza2.zzd) != null && !zzbew.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                zza2 = zzfey.zza(new zzehx(13, zza2.zzd));
            }
            this.zzg.zzf.zzd(this.zzc, elapsedRealtime, zza2);
        }
    }

    public final void zzb(Object obj) {
        long elapsedRealtime = this.zzg.zza.elapsedRealtime() - this.zza;
        zzelg.zzg(this.zzg, this.zzb, 0, elapsedRealtime, this.zzc.zzad);
        if (this.zzg.zze) {
            this.zzg.zzb.zza(this.zzd, this.zzc, 0, (zzehx) null, elapsedRealtime);
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzge)).booleanValue()) {
            this.zzg.zzf.zzd(this.zzc, elapsedRealtime, (zzbew) null);
        }
    }
}
