package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;

public final class zzfkr {
    @SuppressLint({"StaticFieldLeak"})
    private static final zzfkr zza = new zzfkr();
    private Context zzb;
    private BroadcastReceiver zzc;
    private boolean zzd;
    private boolean zze;
    private zzfkw zzf;

    private zzfkr() {
    }

    public static zzfkr zza() {
        return zza;
    }

    public static /* bridge */ /* synthetic */ void zzb(zzfkr zzfkr, boolean z11) {
        if (zzfkr.zze != z11) {
            zzfkr.zze = z11;
            if (zzfkr.zzd) {
                zzfkr.zzh();
                if (zzfkr.zzf == null) {
                    return;
                }
                if (zzfkr.zzf()) {
                    zzfls.zzd().zzi();
                } else {
                    zzfls.zzd().zzh();
                }
            }
        }
    }

    private final void zzh() {
        String str;
        boolean z11 = this.zze;
        for (zzfke zzg : zzfkp.zza().zzc()) {
            zzflc zzg2 = zzg.zzg();
            if (zzg2.zzk()) {
                if (true != z11) {
                    str = "foregrounded";
                } else {
                    str = "backgrounded";
                }
                zzfkv.zza().zzb(zzg2.zza(), "setState", str);
            }
        }
    }

    public final void zzc(@NonNull Context context) {
        this.zzb = context.getApplicationContext();
    }

    public final void zzd() {
        this.zzc = new zzfkq(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.zzb.registerReceiver(this.zzc, intentFilter);
        this.zzd = true;
        zzh();
    }

    public final void zze() {
        BroadcastReceiver broadcastReceiver;
        Context context = this.zzb;
        if (!(context == null || (broadcastReceiver = this.zzc) == null)) {
            context.unregisterReceiver(broadcastReceiver);
            this.zzc = null;
        }
        this.zzd = false;
        this.zze = false;
        this.zzf = null;
    }

    public final boolean zzf() {
        return !this.zze;
    }

    public final void zzg(zzfkw zzfkw) {
        this.zzf = zzfkw;
    }
}
