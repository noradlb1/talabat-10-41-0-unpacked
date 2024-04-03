package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public final class zzerp implements zzevn<zzerq> {
    private final zzfxb zza;
    private final Context zzb;

    public zzerp(zzfxb zzfxb, Context context) {
        this.zza = zzfxb;
        this.zzb = context;
    }

    public final /* synthetic */ zzerq zza() throws Exception {
        double d11;
        Intent registerReceiver = this.zzb.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z11 = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            d11 = ((double) registerReceiver.getIntExtra("level", -1)) / ((double) registerReceiver.getIntExtra("scale", -1));
            if (intExtra == 2 || intExtra == 5) {
                z11 = true;
            }
        } else {
            d11 = -1.0d;
        }
        return new zzerq(d11, z11);
    }

    public final zzfxa<zzerq> zzb() {
        return this.zza.zzb(new zzero(this));
    }
}
