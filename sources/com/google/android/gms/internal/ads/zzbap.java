package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.io.IOException;

public final /* synthetic */ class zzbap implements Runnable {
    public final /* synthetic */ zzbas zza;
    public final /* synthetic */ zzbaj zzb;
    public final /* synthetic */ zzbak zzc;
    public final /* synthetic */ zzcjr zzd;

    public /* synthetic */ zzbap(zzbas zzbas, zzbaj zzbaj, zzbak zzbak, zzcjr zzcjr) {
        this.zza = zzbas;
        this.zzb = zzbaj;
        this.zzc = zzbak;
        this.zzd = zzcjr;
    }

    public final void run() {
        zzbah zzbah;
        zzbas zzbas = this.zza;
        zzbaj zzbaj = this.zzb;
        zzbak zzbak = this.zzc;
        zzcjr zzcjr = this.zzd;
        try {
            zzbam zzq = zzbaj.zzq();
            if (zzbaj.zzp()) {
                zzbah = zzq.zzg(zzbak);
            } else {
                zzbah = zzq.zzf(zzbak);
            }
            if (!zzbah.zze()) {
                zzcjr.zze(new RuntimeException("No entry contents."));
                zzbau.zze(zzbas.zzc);
                return;
            }
            zzbar zzbar = new zzbar(zzbas, zzbah.zzc(), 1);
            int read = zzbar.read();
            if (read != -1) {
                zzbar.unread(read);
                zzcjr.zzd(zzbaw.zzb(zzbar, zzbah.zzd(), zzbah.zzg(), zzbah.zza(), zzbah.zzf()));
                return;
            }
            throw new IOException("Unable to read from cache.");
        } catch (RemoteException | IOException e11) {
            zzciz.zzh("Unable to obtain a cache service instance.", e11);
            zzcjr.zze(e11);
            zzbau.zze(zzbas.zzc);
        }
    }
}
