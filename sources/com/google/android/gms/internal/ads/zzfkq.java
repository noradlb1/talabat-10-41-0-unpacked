package com.google.android.gms.internal.ads;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class zzfkq extends BroadcastReceiver {
    final /* synthetic */ zzfkr zza;

    public zzfkq(zzfkr zzfkr) {
        this.zza = zzfkr;
    }

    public final void onReceive(Context context, Intent intent) {
        KeyguardManager keyguardManager;
        if (intent != null) {
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                zzfkr.zzb(this.zza, true);
            } else if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                zzfkr.zzb(this.zza, false);
            } else if ("android.intent.action.SCREEN_ON".equals(intent.getAction()) && (keyguardManager = (KeyguardManager) context.getSystemService("keyguard")) != null && !keyguardManager.inKeyguardRestrictedInputMode()) {
                zzfkr.zzb(this.zza, false);
            }
        }
    }
}
