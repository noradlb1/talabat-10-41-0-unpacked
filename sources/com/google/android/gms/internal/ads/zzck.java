package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import java.util.Locale;

public class zzck {
    /* access modifiers changed from: private */
    public int zza;
    /* access modifiers changed from: private */
    public int zzb;
    /* access modifiers changed from: private */
    public boolean zzc;
    /* access modifiers changed from: private */
    public final zzfss<String> zzd;
    /* access modifiers changed from: private */
    public final zzfss<String> zze;
    /* access modifiers changed from: private */
    public final zzfss<String> zzf;
    /* access modifiers changed from: private */
    public zzfss<String> zzg;
    /* access modifiers changed from: private */
    public int zzh;
    /* access modifiers changed from: private */
    public final zzfsw<zzcf, zzcm> zzi;
    /* access modifiers changed from: private */
    public final zzftc<Integer> zzj;

    @Deprecated
    public zzck() {
        this.zza = Integer.MAX_VALUE;
        this.zzb = Integer.MAX_VALUE;
        this.zzc = true;
        this.zzd = zzfss.zzo();
        this.zze = zzfss.zzo();
        this.zzf = zzfss.zzo();
        this.zzg = zzfss.zzo();
        this.zzh = 0;
        this.zzi = zzfsw.zzd();
        this.zzj = zzftc.zzl();
    }

    public zzck(zzcn zzcn) {
        this.zza = zzcn.zzl;
        this.zzb = zzcn.zzm;
        this.zzc = zzcn.zzn;
        this.zzd = zzcn.zzo;
        this.zze = zzcn.zzp;
        this.zzf = zzcn.zzt;
        this.zzg = zzcn.zzu;
        this.zzh = zzcn.zzv;
        this.zzi = zzcn.zzz;
        this.zzj = zzcn.zzA;
    }

    public final zzck zzd(Context context) {
        CaptioningManager captioningManager;
        int i11 = zzfn.zza;
        if (i11 >= 19 && ((i11 >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled())) {
            this.zzh = 1088;
            Locale locale = captioningManager.getLocale();
            if (locale != null) {
                this.zzg = zzfss.zzp(zzfn.zzI(locale));
            }
        }
        return this;
    }

    public zzck zze(int i11, int i12, boolean z11) {
        this.zza = i11;
        this.zzb = i12;
        this.zzc = true;
        return this;
    }
}
