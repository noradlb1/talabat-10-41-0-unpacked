package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Build;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public final class zzfjg implements Runnable {
    @VisibleForTesting
    @GuardedBy("CuiMonitor.class")
    static Boolean zza;
    private final Context zzb;
    private final zzcjf zzc;
    private final zzfjl zzd = zzfjo.zzc();
    private String zze;
    private int zzf;
    @GuardedBy("this")
    private boolean zzg = false;
    private final zzefm zzh;
    private final zzcec zzi;

    public zzfjg(Context context, zzcjf zzcjf, zzefm zzefm, zzcec zzcec, byte[] bArr) {
        this.zzb = context;
        this.zzc = zzcjf;
        this.zzh = zzefm;
        this.zzi = zzcec;
    }

    public static synchronized boolean zzb() {
        boolean booleanValue;
        boolean z11;
        synchronized (zzfjg.class) {
            if (zza == null) {
                if (!zzbmr.zzb.zze().booleanValue()) {
                    zza = Boolean.FALSE;
                } else {
                    if (Math.random() < zzbmr.zza.zze().doubleValue()) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    zza = Boolean.valueOf(z11);
                }
            }
            booleanValue = zza.booleanValue();
        }
        return booleanValue;
    }

    private final synchronized void zzc() {
        if (!this.zzg) {
            this.zzg = true;
            if (zzb()) {
                zzt.zzp();
                this.zze = com.google.android.gms.ads.internal.util.zzt.zzv(this.zzb);
                this.zzf = GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzb);
                long intValue = (long) ((Integer) zzbgq.zzc().zzb(zzblj.zzgv)).intValue();
                zzcjm.zzd.scheduleAtFixedRate(this, intValue, intValue, TimeUnit.MILLISECONDS);
            }
        }
    }

    private final synchronized void zzd() {
        try {
            new zzefl(this.zzb, this.zzc.zza, this.zzi, Binder.getCallingUid(), (byte[]) null).zza(new zzefj((String) zzbgq.zzc().zzb(zzblj.zzgu), 60000, new HashMap(), ((zzfjo) this.zzd.zzah()).zzar(), "application/x-protobuf"));
        } catch (Exception e11) {
            if (!(e11 instanceof zzecd) || ((zzecd) e11).zza() != 3) {
                zzt.zzo().zzr(e11, "CuiMonitor.sendCuiPing");
            } else {
                this.zzd.zzc();
            }
        }
    }

    public final synchronized void run() {
        if (zzb()) {
            if (this.zzd.zza() != 0) {
                zzd();
            }
        }
    }

    public final synchronized void zza(@Nullable zzfjf zzfjf) {
        if (!this.zzg) {
            zzc();
        }
        if (zzb()) {
            if (zzfjf != null) {
                zzfjl zzfjl = this.zzd;
                zzfjm zza2 = zzfjn.zza();
                zzfji zza3 = zzfjj.zza();
                zza3.zzo(7);
                zza3.zzl(zzfjf.zzh());
                zza3.zze(zzfjf.zzb());
                zza3.zzq(3);
                zza3.zzk(this.zzc.zza);
                zza3.zza(this.zze);
                zza3.zzi(Build.VERSION.RELEASE);
                zza3.zzm(Build.VERSION.SDK_INT);
                zza3.zzp(zzfjf.zzj());
                zza3.zzh(zzfjf.zza());
                zza3.zzc((long) this.zzf);
                zza3.zzn(zzfjf.zzi());
                zza3.zzb(zzfjf.zzc());
                zza3.zzd(zzfjf.zzd());
                zza3.zzf(zzfjf.zze());
                zza3.zzg(zzfjf.zzf());
                zza3.zzj(zzfjf.zzg());
                zza2.zza(zza3);
                zzfjl.zzb(zza2);
            }
        }
    }
}
