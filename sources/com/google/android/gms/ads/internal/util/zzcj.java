package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class zzcj extends BroadcastReceiver {
    final /* synthetic */ zzck zza;

    public zzcj(zzck zzck) {
        this.zza = zzck;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zza.zze(context, intent);
    }
}
