package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class zzs extends BroadcastReceiver {
    final /* synthetic */ zzt zza;

    public /* synthetic */ zzs(zzt zzt, zzr zzr) {
        this.zza = zzt;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            this.zza.zze = true;
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.zza.zze = false;
        }
    }
}
