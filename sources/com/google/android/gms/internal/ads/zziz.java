package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class zziz extends BroadcastReceiver {
    final /* synthetic */ zzja zza;

    public /* synthetic */ zziz(zzja zzja, zziy zziy) {
        this.zza = zzja;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zza.zzb.post(new zzix(this.zza));
    }
}
